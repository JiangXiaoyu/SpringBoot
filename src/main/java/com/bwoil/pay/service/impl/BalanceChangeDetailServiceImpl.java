package com.bwoil.pay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwoil.pay.dao.BalanceChangeDetailDao;
import com.bwoil.pay.entity.BalanceChangeDetail;
import com.bwoil.pay.service.IBalanceChangeDetailService;

@Service("balanceChangeDetailService")
public class BalanceChangeDetailServiceImpl implements IBalanceChangeDetailService{

	@Autowired
	private BalanceChangeDetailDao balanceChangeDetailDao;
	
	@Override
	public BalanceChangeDetail insert(BalanceChangeDetail balanceChangeDetail) {
		return this.balanceChangeDetailDao.save(balanceChangeDetail);
	}

}
