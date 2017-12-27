package com.bwoil.pay.service;

import com.bwoil.common.framework.result.PaginationResult;
import com.bwoil.common.framework.result.QueryResult;
import com.bwoil.pay.entity.Bank;
import com.bwoil.pay.form.BankSearchForm;
import com.bwoil.pay.form.BankSerchPageForm;

public interface IBankService {
	
  public Bank insert(Bank bank);
  
  public Bank findById(Integer id);
  
  public QueryResult<Bank> search(BankSearchForm form);
  
  public PaginationResult<Bank> searchPage(BankSerchPageForm form);


}
