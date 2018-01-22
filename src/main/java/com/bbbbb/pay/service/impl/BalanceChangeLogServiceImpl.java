package com.bbbbb.pay.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbbbb.pay.dao.BalanceChangeLogDao;
import com.bbbbb.pay.entity.BalanceChangeLog;
import com.bbbbb.pay.service.IBalanceChangeLogSerivce;
import com.bbbbb.pay.utils.FinalString;

@Service("balanceChangeLogSerivce")
public class BalanceChangeLogServiceImpl implements IBalanceChangeLogSerivce{

	@Autowired
	private BalanceChangeLogDao balanceChangeLogDao;
	
	@Override
	public BalanceChangeLog save(String amount, String eProtocolAcNo, String remark, String code, String message) {
		Date now = new Date();
		BalanceChangeLog log = new BalanceChangeLog(amount, eProtocolAcNo, FinalString.TRADE_TYPE_IN, remark, code, message, now);
				
		return this.balanceChangeLogDao.save(log);
	}

}
