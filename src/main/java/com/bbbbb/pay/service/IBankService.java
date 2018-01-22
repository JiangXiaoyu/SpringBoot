package com.bbbbb.pay.service;

import com.bbbbb.common.framework.result.PaginationResult;
import com.bbbbb.common.framework.result.QueryResult;
import com.bbbbb.pay.entity.Bank;
import com.bbbbb.pay.form.BankSearchForm;
import com.bbbbb.pay.form.BankSerchPageForm;

public interface IBankService {
	
  public Bank insert(Bank bank);
  
  public Bank findById(Integer id);
  
  public QueryResult<Bank> search(BankSearchForm form);
  
  public PaginationResult<Bank> searchPage(BankSerchPageForm form);


}
