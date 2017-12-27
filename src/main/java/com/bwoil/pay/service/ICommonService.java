package com.bwoil.pay.service;

import java.util.Map;

import com.bwoil.pay.model.AccountInfo;
import com.bwoil.pay.model.ChangeInfo;
import com.bwoil.pay.model.UnlockPwdInfo;

/**
 * 民生银行接口
 * @ClassName: IMessageService 
 * @author wuzf 
 * @date 2017年11月8日 下午6:26:07
 */
public interface ICommonService {
	
	/**
	 * 开户
	 * @Title: open 
	 * @param accountInfo
	 * @return Map<String,Object>
	 */
	public Map<String, String> open(AccountInfo accountInfo);
	
	/**
	 * 获取民生银行随机数
	 * @Title: getRandom 
	 * @param eProtocolAcNo 电子协议编号
	 * @param randType		类型(	1-电子账户交易密码;2-查询密码;3-登录密码;4-混合密码)
	 * @return Map<String,String>
	 */
	public Map<String, String> getRandom(String eProtocolAcNo, String randType);
	
	/**
	 * 获取民生银行短信验证码
	 * @Title: getPhoneCode 
	 * @param eProtocolAcNo
	 * @param mobilePhone
	 * @param templateId
	 * @return Map<String,Object>
	 */
	public Map<String, String> getPhoneCode(String eProtocolAcNo, String mobilePhone, String templateId);
	
	/**
	 * 电子账户信息查询
	 * @Title: query 
	 * @param eProtocolAcNo
	 * @return Map<String,Object>
	 */
	public Map<String, String> query(String eProtocolAcNo);
	
	/**
	 * 电子账户解锁
	 * @Title: unLock 
	 * @param accountInfo
	 * @return Map<String,Object>
	 */
	public Map<String, String> unLock(AccountInfo accountInfo);
	
	/**
	 * 交易密码变更
	 * @Title: tradePwdChange 
	 * @param changeInfo
	 * @return Map<String,Object>
	 */
	public Map<String, String> tradePwdChange(ChangeInfo changeInfo);
	
	/**
	 * 交易密码解锁
	 * @Title: tradePwdUnlock 
	 * @param unlockPwd
	 * @return Map<String,Object>
	 */
	public Map<String, String> tradePwdUnlock(UnlockPwdInfo unlockPwd);
	
	/**
	 * 入金到电子账户
	 * @param amount	金额
	 * @param eProtocolAcNo		电子账户协议编号
	 * @param pwdResult		电子账户交易密码密文
	 * @param randJnlNo		密码随机数流水号
	 * @param random		随机数
	 * @param remark		随机数
	 * @return
	 */
    public Map<String, String> charge(String amount, String eProtocolAcNo, String pwdResult, String randJnlNo, String random, String remark);
    
    /**
	 * 获取token
	 * @param eProtocolAcNo  电子账户协议编号
	 * @return
	 */
    public Map<String, String> getToken(String eProtocolAcNo);
    
    /**
     * 获取电子账户交易明细
     * @param eProtocolAcNo
     * @param beginDate
     * @param endDate
     * @param beginNumber
     * @param queryNumber
     * @return
     */
    public Map<String, Object> getBusinessDetail(String eProtocolAcNo, String beginDate, String endDate, String beginNumber, String queryNumber);

    /**
     * 获取电子账户信息
     * @param eProtocolAcNo
     * @return
     */
    public Map<String, String> getEAccountInfo(String eProtocolAcNo);
    
    /**
     * 上传银行卡照片
     * @param cardNo
     * @param cardImgData
     * @param eProtocolAcNo
     * @return
     */
    public Map<String, String> uploadBankCardImage(String cardNo, String cardImgData, String eProtocolAcNo);
}
