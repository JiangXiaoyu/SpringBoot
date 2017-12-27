package com.bwoil.pay.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwoil.pay.dao.UploadBankCardDao;
import com.bwoil.pay.entity.UploadBankCard;
import com.bwoil.pay.service.IUploadBankCardService;

@Service
public class UploadBankCardServiceImpl implements IUploadBankCardService {
	
	@Autowired
	UploadBankCardDao uploadBankCardDao;

	@Override
	public void save(String cardNo, String eProtocolAcNo, String code, String message, String imageSeq) {
		 UploadBankCard upload = new UploadBankCard();
		 upload.setBankCardNo(cardNo);
		 upload.setEProtocolAcNo(eProtocolAcNo);
		 upload.setCode(code);
		 upload.setMessage(message);
		 upload.setImageSeq(imageSeq);
		 upload.setCreateTime(new Date());
		 uploadBankCardDao.save(upload);
	}

}
