package com.bwoil.pay.service;

import java.util.Map;

import com.bwoil.pay.model.BusinessInfo;
import com.bwoil.pay.model.ChargeInfo;

/**
 * 民生出入金，交易查询
 * @author zhangze
 *
 */
public interface IMoneyService {
	
	/**
	 * 充值
	 * @param chargeInfo
	 * @return
	 */
	public Map<String, String> charge(ChargeInfo chargeInfo);	
	
	/**
	 * 获取民生交易明细
	 * @return
	 */
	public Map<String, Object> businessDetail(BusinessInfo busi);

}
