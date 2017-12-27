package com.bwoil.pay.service;

import com.bwoil.pay.entity.BalanceChangeLog;

public interface IBalanceChangeLogSerivce {


	public BalanceChangeLog save(String amount, String eProtocolAcNo, String remark, String code, String message);
	
}
