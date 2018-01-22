package com.bbbbb.pay.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bbbbb.pay.model.AccountInfo;
import com.bbbbb.pay.model.ChangeInfo;
import com.bbbbb.pay.model.UnlockPwdInfo;
import com.bbbbb.pay.service.ICommonService;
import com.bbbbb.pay.utils.CommonUtil;
import com.bbbbb.pay.utils.StringUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CommonServiceImpl implements ICommonService {

	@Override
	public Map<String, String> open(AccountInfo accountInfo) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("CifName", accountInfo.getCifName()); 						//客户姓名
		dataMap.put("IdNo", accountInfo.getIdNo()); 							//身份证号码
		dataMap.put("MobilePhone", accountInfo.getMobilePhone()); 				//手机号码
		dataMap.put("TAcNo", accountInfo.getTacNo()); 							//绑定卡卡号
		dataMap.put("PwdResult", accountInfo.getPwdResult()); 					//电子账户交易密码密文
		dataMap.put("PwdResultConfirm", accountInfo.getPwdResultConfirm()); 	//电子账户交易密码密文确认
		dataMap.put("IsSignFund", accountInfo.getIsSignFund()); 				//是否如意宝签约
		dataMap.put("ProdSubId", accountInfo.getProdSubId()); 					//产品编码
		dataMap.put("RandJnlNo", accountInfo.getRandJnlNo()); 					//密码随机数流水号
		dataMap.put("Random", accountInfo.getRandom()); 						//密码随机数
		dataMap.put("IsAgreeProtocol", accountInfo.getIsAgreeProtocol()); 		//是否同意开户协议
		dataMap.put("TerminalType", accountInfo.getTerminalType()); 			//终端类型
		dataMap.put("BankDeptCode", accountInfo.getBankDeptCode()); 			//业绩归属机构
		dataMap.put("SubDeptCode", accountInfo.getSubDeptCode()); 				//业绩便民机构
		dataMap.put("ExtensionEmployee", accountInfo.getExtensionEmployee()); 	//业绩客户经理号
		dataMap.put("VerifyJnlNo", accountInfo.getVerifyJnlNo()); 				//快捷认证流水号
		dataMap.put("IsStaff", accountInfo.getIsStaff()); 						//是否内部员工
		dataMap.put("IdPNo", accountInfo.getIdPNo()); 							//身份证照片验证凭证号
		dataMap = CommonUtil.postMSBank("MEAccountOpen", dataMap, null);
		
		log.info("开户结果：" + dataMap.toString());
		
		return StringUtil.parse(dataMap);
	}
	
	@Override
	public Map<String, String> getRandom(String eProtocolAcNo, String randType) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("EProtocolAcNo", eProtocolAcNo);
		dataMap.put("RandType", randType);
		dataMap = CommonUtil.postMSBank("MELEGenerateRand", dataMap, null);
		
		log.info("获取随机数结果：" + dataMap.toString());
		return StringUtil.parse(dataMap);
	}

	@Override
	public Map<String, String> getPhoneCode(String eProtocolAcNo, String mobilePhone, String templateId) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("EProtocolAcNo", eProtocolAcNo);
		dataMap.put("MobilePhone", mobilePhone);
		dataMap.put("TemplateId", templateId);
		dataMap = CommonUtil.postMSBank("MELEGetPhoneCode", dataMap, null);
		
		log.info("获取短信验证码结果：" + dataMap.toString());
		return StringUtil.parse(dataMap);
	}
	
	@Override
	public Map<String, String> query(String eProtocolAcNo) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("EProtocolAcNo", eProtocolAcNo);
		dataMap = CommonUtil.postMSBank("MEAccountQuery", dataMap, null);

		log.info("电子账户信息查询：" + dataMap.toString());		
		return StringUtil.parse(dataMap);
	}

	@Override
	public Map<String, String> unLock(AccountInfo accountInfo) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("CifName", accountInfo.getCifName()); 						//客户姓名
		dataMap.put("IdNo", accountInfo.getIdNo()); 							//身份证号码
		dataMap.put("MobilePhone", accountInfo.getMobilePhone()); 				//手机号码
		dataMap.put("TAcNo", accountInfo.getTacNo()); 							//绑定卡卡号
		dataMap.put("PwdResult", accountInfo.getPwdResult()); 					//电子账户交易密码密文
		dataMap.put("RandJnlNo", accountInfo.getRandJnlNo()); 					//密码随机数流水号
		dataMap.put("Random", accountInfo.getRandom()); 						//密码随机数
		dataMap.put("MessageTaskId", accountInfo.getMessageTaskId()); 			//短信验证码Id
		dataMap.put("MessageCode", accountInfo.getMessageCode()); 				//短信验证码
		dataMap.put("EProtocolAcNo", accountInfo.getEProtocolAcNo()); 			//电子账户协议编号
		dataMap.put("LockType", accountInfo.getLockType()); 					//解锁类型
		dataMap = CommonUtil.postMSBank("MEAccountOpen", dataMap, null);
		
		log.info("电子账户解锁结果：" + dataMap.toString());
		return StringUtil.parse(dataMap);
	}

	@Override
	public Map<String, String> tradePwdChange(ChangeInfo changeInfo) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("EProtocolAcNo", changeInfo.getEProtocolAcNo()); 			//电子账户协议编号
		dataMap.put("MessageTaskId", changeInfo.getMessageTaskId()); 			//短信验证码Id
		dataMap.put("MessageCode", changeInfo.getMessageCode()); 				//短信验证码
		dataMap.put("OldPwdResult", changeInfo.getOldPwdResult()); 				//电子账户原交易密码密文
		dataMap.put("OldRandJnlNo", changeInfo.getOldRandJnlNo()); 				//原密码随机数流水号
		dataMap.put("OldRandom", changeInfo.getOldRandom()); 					//原密码随机数
		dataMap.put("NewPwdResult", changeInfo.getNewPwdResult()); 				//电子账户新交易密码密文
		dataMap.put("NewPwdResultConfirm", changeInfo.getNewPwdResultConfirm());//电子账户新交易密码密文确认
		dataMap.put("NewRandJnlNo", changeInfo.getNewRandJnlNo()); 				//新密码随机数流水号
		dataMap.put("NewRandom", changeInfo.getNewRandom()); 					//新密码随机数
		dataMap = CommonUtil.postMSBank("METransPasswordChange", dataMap, null);
		
		log.info("交易密码变更结果：" + dataMap.toString());
		return StringUtil.parse(dataMap);
	}
	
	@Override
	public Map<String, String> tradePwdUnlock(UnlockPwdInfo unlockPwd) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("EProtocolAcNo", unlockPwd.getEProtocolAcNo()); 			//电子账户协议编号
		dataMap.put("MessageTaskId", unlockPwd.getMessageTaskId()); 			//短信验证码Id
		dataMap.put("MessageCode", unlockPwd.getMessageCode()); 				//短信验证码
		dataMap.put("PwdResult", unlockPwd.getPwdResult()); 					//电子账户交易密码密文
		dataMap.put("RandJnlNo", unlockPwd.getRandJnlNo()); 					//密码随机数流水号
		dataMap.put("Random", unlockPwd.getRandom()); 						//密码随机数
		dataMap = CommonUtil.postMSBank("METransPasswordChange", dataMap, null);
		
		log.info("交易密码解锁结果：" + dataMap.toString());
		return StringUtil.parse(dataMap);
	}
	
	@Override
    public Map<String, String> charge(String amount, String eProtocolAcNo, String pwdResult, 
    		String randJnlNo, String random, String remark){
         Map<String, Object> dataMap = new HashMap<String, Object>();
         dataMap.put("Amount", amount); 
         dataMap.put("EProtocolAcNo", eProtocolAcNo);   
         dataMap.put("PwdResult", pwdResult); 
         dataMap.put("RandJnlNo", randJnlNo); 
         dataMap.put("Random", random); 
         dataMap.put("Remark", remark);
         
         Map<String, String> tokenMap = getToken(eProtocolAcNo);
         String token = tokenMap.get("Token");
         dataMap.put("Token", token);
         Map<String, Object> res = CommonUtil.postMSBank("MELEBankInnnerTransfer", dataMap, null);
        
         log.info("充值结果：" + res.toString());
         return StringUtil.parse(res);
    }   
    
	@Override
    public Map<String, String> getToken(String eProtocolAcNo){
         Map<String, Object> dataMap = new HashMap<String, Object>();
         dataMap.put("EProtocolAcNo", eProtocolAcNo);                  
         Map<String, Object> res = CommonUtil.postMSBank("METokenGenerate", dataMap, null);
               
         log.info("获取token：" + res.toString());
         return StringUtil.parse(res);
    }    
    
	@Override
    public Map<String, Object> getBusinessDetail(String eProtocolAcNo, String beginDate, String endDate, String beginNumber, String queryNumber){
    	Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("EProtocolAcNo", eProtocolAcNo);                  
        dataMap.put("BeginDate", beginDate);                  
        dataMap.put("EndDate", endDate);                  
        dataMap.put("BeginNumber", beginNumber);                  
        dataMap.put("QueryNumber", queryNumber);                  
        Map<String, Object> res = CommonUtil.postMSBank("MEEAcnoTrsJnlQuery", dataMap, null);
             
        log.info("获取交易明细：" + res.toString());
        return res;
    }
    
	@Override
    public Map<String, String> getEAccountInfo(String eProtocolAcNo){
    	Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("EProtocolAcNo", eProtocolAcNo);                                  
        Map<String, Object> res = CommonUtil.postMSBank("MEAccountQuery", dataMap, null);
                 
        log.info("获取账户信息：" + res.toString());
        return StringUtil.parse(res);
    }   
	
	@Override
    public Map<String, String> uploadBankCardImage(String tAcNo, String cardImgData, String eProtocolAcNo){
    	Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("TAcNo", tAcNo);                                  
        dataMap.put("CardImgData", cardImgData);                                  
        dataMap.put("EProtocolAcNo", eProtocolAcNo);                                  
        Map<String, Object> res = CommonUtil.postMSBank("MECardImgUpload", dataMap, null);
                 
        log.info("上传银行卡照片：" + res.toString());
        return StringUtil.parse(res);
    }   
    
}
