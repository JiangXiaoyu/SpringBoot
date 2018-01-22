package com.bbbbb.pay.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bbbbb.common.framework.result.QueryResult;
import com.bbbbb.pay.dao.OpenAccountLogDao;
import com.bbbbb.pay.dao.PayAccountDao;
import com.bbbbb.pay.entity.OpenAccountLog;
import com.bbbbb.pay.entity.PayAccount;
import com.bbbbb.pay.form.PayAccountQueryForm;
import com.bbbbb.pay.model.AccountInfo;
import com.bbbbb.pay.model.EAccountInfo;
import com.bbbbb.pay.service.ICommonService;
import com.bbbbb.pay.service.IOpenAccountService;

/**
 * 开户接口实现类
 * @ClassName: OpenAccountLogServiceImpl 
 * @author wuzf 
 * @date 2017年11月8日 下午4:36:07
 */
@Service
public class OpenAccountServiceImpl implements IOpenAccountService {

	@Autowired
	private PayAccountDao payAccountDao;
	
	@Autowired
	private OpenAccountLogDao openAccountLogDao;
	
	@Autowired
	private ICommonService commonService;

	@Override
	@Transactional
	public Map<String, String> open(AccountInfo accountInfo) {
		
		Map<String, String> dataMap = new HashMap<String, String>();
		
		//假如没有传 isSignFund 和  isAgreeProtocol 便给默认值
		if(null == accountInfo.getIsSignFund() || "".equals(accountInfo.getIsSignFund())){
			accountInfo.setIsSignFund("1");
		}
		if(null == accountInfo.getIsAgreeProtocol() || "".equals(accountInfo.getIsAgreeProtocol())){
			accountInfo.setIsAgreeProtocol("0");
		}
		
		// 再请求民生银行开户接口
		dataMap = this.commonService.open(accountInfo);
		
		// 先写入t_bbbbb_pay_account 表
		if(null != dataMap && "DS00000".equals(dataMap.get("code").toString()) && !"01".equals(String.valueOf(dataMap.get("EAcNoStatus")))){
			PayAccount payAccount = new PayAccount();
			PayAccountQueryForm queryForm = new PayAccountQueryForm();
			queryForm.setUserId(accountInfo.getUserId());
			QueryResult<PayAccount> result = this.payAccountDao.query(queryForm);
			if(null != result && result.getData().size() > 0){
				//update 
				payAccount = result.getData().get(0);
				payAccount.setUpdateTime(new Date());
			}else{
				payAccount.setCreateTime(new Date());
				payAccount.setUpdateTime(payAccount.getCreateTime());
			}
			payAccount.setUserId(accountInfo.getUserId());//云油账号Id
			payAccount.setAcountName(accountInfo.getCifName());//客户姓名
			payAccount.setMobilePhone(accountInfo.getMobilePhone());//手机号
			payAccount.setIdCardNo(accountInfo.getIdNo());//身份证号码
			payAccount.setBankCardNo(accountInfo.getTacNo());//绑定卡卡号
			payAccount.setECardBank("");//开户银行
			payAccount.setBalance(accountInfo.getBalance());//光汇账户余额
			payAccount.setEProtocolAcNo(String.valueOf(dataMap.get("EProtocolAcNo")));//电子账户协议编号
			payAccount.setECardNo(String.valueOf(dataMap.get("EAcNo")));//电子账户
			payAccount.setEAcNoStatus(String.valueOf(dataMap.get("EAcNoStatus")));//银行处理状态
			payAccount.setOpenDate(String.valueOf(dataMap.get("OpenDate")));//开户日期
			payAccount.setBalance(null);//账户余额
			payAccount.setNopasswordLittlemoney("");//是否开通小额免密
			payAccount.setStatus("0");
			payAccount = this.payAccountDao.save(payAccount);
		}
		
		// 写入开户日志表
		OpenAccountLog openAccountLog = new OpenAccountLog();
		openAccountLog.setUserId(accountInfo.getUserId());//云油账号Id
		openAccountLog.setAcountName(accountInfo.getCifName());//客户姓名
		openAccountLog.setMobilePhone(accountInfo.getMobilePhone());//手机号
		openAccountLog.setBankCardNo(accountInfo.getTacNo());//绑定卡卡号
		openAccountLog.setIdCardNo(accountInfo.getIdNo());//身份证号码
		openAccountLog.setOpenBank("");//开户行
		openAccountLog.setCode(String.valueOf(dataMap.get("code")));//银行返回码
		openAccountLog.setMessage(String.valueOf(dataMap.get("message")));//银行返回信息
		openAccountLog.setChannelJnlNo(String.valueOf(dataMap.get("ChannelJnlNo")));//渠道请求流水号
		openAccountLog.setEAccountOpenJnlNo(String.valueOf(dataMap.get("(EAccountOpenJnlNo")));//预开户号
		openAccountLog.setEAcNoStatus(String.valueOf(dataMap.get("EAcNoStatus")));//银行处理状态
		openAccountLog.setEProtocolAcNo(String.valueOf(dataMap.get("EProtocolAcNo")));//电子账户协议编号
		openAccountLog.setECardNo(String.valueOf(dataMap.get("EAcNo")));//电子账户
		openAccountLog.setOpenDate(String.valueOf(dataMap.get("OpenDate")));//电子账户开户日期
		openAccountLog.setBankInnerFlag(String.valueOf(dataMap.get("BankInnerFlag")));//绑定卡行内行外标识
		openAccountLog.setCreateTime(new Date());
		openAccountLog.setUpdateTime(new Date());
		openAccountLog = this.openAccountLogDao.save(openAccountLog);
		return dataMap;
	}

	@Override
	public EAccountInfo query(String userId) {
		Map<String, String> dataMap = new HashMap<String, String>();
	    PayAccountQueryForm queryForm = new PayAccountQueryForm();
	    queryForm.setUserId(userId);
		QueryResult<PayAccount> result = this.payAccountDao.query(queryForm);
		EAccountInfo acc = new EAccountInfo();
		if(result.getData().size() > 0) {
			System.out.println(result.getData().get(0));
			//from DB
			PayAccount account = result.getData().get(0);
			String eProtocolAcNo = account.getEProtocolAcNo();
			//from MSBank			
			dataMap = commonService.query(eProtocolAcNo);				
			
			acc.setOn(true);
			acc.setBalance(dataMap.get("AvailableBalance"));
			acc.setECardNo(account.getECardNo());
			acc.setTacNo(account.getBankCardNo());
			acc.setFirstCardBank(account.getFirstCardBank());
			acc.setOpenDate(account.getOpenDate());
			acc.setEProtocolAcNo(eProtocolAcNo);
		} else {
			acc.setOn(false);
		}
		
		return acc;
	}
	
	
}
