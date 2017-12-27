package com.bwoil.pay.service;

import java.util.Map;

import com.bwoil.pay.model.AccountInfo;
import com.bwoil.pay.model.EAccountInfo;

/**
 * 开户日志接口
 * @ClassName: IOpenAccountLog 

 * @author wuzf 
 * @date 2017年11月8日 下午4:05:34
 */
public interface IOpenAccountService {
	
	/**
	 * 开户
	 * @Title: open 
	 * @param accountInfo
	 * @return Map<String,Object>
	 */
	public Map<String, String> open(AccountInfo accountInfo);
	
	/**
	 * 电子账户信息查询
	 * @Title: query 
	 * @param userId
	 * @return Map<String,String>
	 */
	public EAccountInfo query(String userId);
}
