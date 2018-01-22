package com.bbbbb.pay.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bbbbb.common.framework.result.PaginationResult;
import com.bbbbb.common.framework.result.QueryResult;
import com.bbbbb.pay.dao.BankDao;
import com.bbbbb.pay.entity.Bank;
import com.bbbbb.pay.form.BankSearchForm;
import com.bbbbb.pay.form.BankSerchPageForm;
import com.bbbbb.pay.service.IBankService;

@Service
public class BankServiceImpl implements IBankService {
	
	@Autowired
	BankDao bankDao;

	
	@Override
	@Transactional
	public Bank insert(Bank bank) {
		bank.setCreateTime(new Date());
		Bank bankR = bankDao.save(bank);		
		return bankR;
	}

	@Override
	public Bank findById(Integer id) {
		Bank bank = bankDao.findById(id);	
		return bank;
	}
	
	@Override
    public QueryResult<Bank> search(BankSearchForm form) {
        return bankDao.query(form);
    }
	
	@Override
    public PaginationResult<Bank> searchPage(BankSerchPageForm form) {
        return bankDao.paging(form);
    }
	

}
