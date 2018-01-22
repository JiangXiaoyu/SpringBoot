package com.bbbbb.pay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbbbb.pay.dao.BalanceChangeDetailDao;
import com.bbbbb.pay.entity.BalanceChangeDetail;
import com.bbbbb.pay.service.IBalanceChangeDetailService;

@Service("balanceChangeDetailService")
public class BalanceChangeDetailServiceImpl implements IBalanceChangeDetailService{

	@Autowired
	private BalanceChangeDetailDao balanceChangeDetailDao;
	
	@Override
	public BalanceChangeDetail insert(BalanceChangeDetail balanceChangeDetail) {
		return this.balanceChangeDetailDao.save(balanceChangeDetail);
	}

}
