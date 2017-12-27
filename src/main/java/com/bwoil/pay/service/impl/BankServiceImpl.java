package com.bwoil.pay.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwoil.common.framework.result.PaginationResult;
import com.bwoil.common.framework.result.QueryResult;
import com.bwoil.pay.dao.BankDao;
import com.bwoil.pay.entity.Bank;
import com.bwoil.pay.form.BankSearchForm;
import com.bwoil.pay.form.BankSerchPageForm;
import com.bwoil.pay.service.IBankService;

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
