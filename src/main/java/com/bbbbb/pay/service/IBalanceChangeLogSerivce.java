package com.bbbbb.pay.service;

import com.bbbbb.pay.entity.BalanceChangeLog;

public interface IBalanceChangeLogSerivce {


	public BalanceChangeLog save(String amount, String eProtocolAcNo, String remark, String code, String message);
	
}
