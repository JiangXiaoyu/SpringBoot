package com.bwoil.pay.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwoil.pay.dao.UploadIdCardDao;
import com.bwoil.pay.dao.UploadIdCardLogDao;
import com.bwoil.pay.entity.UploadIdCard;
import com.bwoil.pay.entity.UploadIdCardLog;
import com.bwoil.pay.model.PhotoInfo;
import com.bwoil.pay.service.ICommonService;
import com.bwoil.pay.service.IUploadBankCardService;
import com.bwoil.pay.service.IUploadService;
import com.bwoil.pay.utils.CommonUtil;

@Service
@Transactional
public class UploadServiceImpl implements IUploadService {
	
	@Autowired
	UploadIdCardDao uploadIdCardDao;
	
	@Autowired
	UploadIdCardLogDao uploadIdCardLogDao;
	
	@Autowired
	ICommonService commonService;
	
	@Autowired
	IUploadBankCardService uploadBankCardService;
	
	@Override
	public Map<String, Object> idCardImage(PhotoInfo photoInfo) {
		
		// 先请求民生银行
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("EProtocolAcNo", photoInfo.getEProtocolAcNo()); // 电子账户协议编号
		dataMap.put("IdPASide", photoInfo.getIdPASide()); // 证件正面照片  身份证正面照片Base64字符串，照片文件不能超过1M原始图片格式为jpg/jpeg
		dataMap.put("IdPBSide", photoInfo.getIdPbSide()); // 证件反面照片  身份证正面照片Base64字符串，照片文件不能超过1M原始图片格式为jpg/jpeg
		dataMap.put("IdNo", photoInfo.getIdNo()); //身份证号码     当EprotocolAcNo为空时必输
		dataMap.put("CifName", photoInfo.getCifName()); //客户姓名  当EprotocolAcNo为空时必输
		dataMap = CommonUtil.postMSBank("MELEIdPhotoUpload", dataMap, null);
		
		// 再写入t_bwoil_upload_idcard表
		UploadIdCard uploadIdCard = new UploadIdCard();
		uploadIdCard.setIdCardNo(Integer.parseInt(photoInfo.getIdNo()));
		uploadIdCard.setName(photoInfo.getCifName());
		if(null != dataMap && dataMap.get("code").equals("DS00000")){
			uploadIdCard.setIdpno(String.valueOf(dataMap.get("IdPNo")));
		}
		uploadIdCard = this.uploadIdCardDao.save(uploadIdCard);
		
		// 再写入t_bwoil_upload_idcard_log 上传日志表
		UploadIdCardLog idCardLog = new UploadIdCardLog();
		idCardLog.setIdCardNo(uploadIdCard.getIdCardNo());
		idCardLog.setName(uploadIdCard.getName());
		idCardLog.setIdpno(uploadIdCard.getIdpno());
		
		// 根据请求民生结果填充
		idCardLog.setChannelJnlno(String.valueOf(dataMap.get("ChannelJnlNo")));
		idCardLog.setCode(String.valueOf(dataMap.get("code")));
		idCardLog.setMessage(String.valueOf(dataMap.get("message")));
		idCardLog.setReason(String.valueOf(dataMap.get("Reason")));
		idCardLog.setStatus(String.valueOf(dataMap.get("Status")));
		idCardLog.setCreateTime(new Date());
		idCardLog = this.uploadIdCardLogDao.save(idCardLog);
		return dataMap;
	}

	@Override
	public Map<String, String> bankCardImage(String cardNo, String cardImgData, String eProtocolAcNo) {
		
		Map<String, String> res = commonService.uploadBankCardImage(cardNo, cardImgData, eProtocolAcNo);		
		String code = res.get("code"); 
		String message = res.get("message");
		String imageSeq = res.get("ImgSeq");		
		//写日志表 t_bwoil_upload_bankcard_log  
		uploadBankCardService.save(cardNo, eProtocolAcNo, code, message, imageSeq);	
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("code", code);
		map.put("message", message);
		
		return map;
	}

}
