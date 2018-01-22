package com.bbbbb.pay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bbbbb.common.framework.result.ActionResult;
import com.bbbbb.common.framework.result.QueryResult;
import com.bbbbb.pay.entity.Bank;
import com.bbbbb.pay.form.BankSearchForm;
import com.bbbbb.pay.form.BankSerchPageForm;
import com.bbbbb.pay.service.IBankService;

@RestController
@RequestMapping(value = "/bank")
public class BankController {
	
	@Autowired
	private IBankService bankService;
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public ActionResult<Integer> insertBank(Bank bank) {
		Bank result = bankService.insert(bank);
		
		return ActionResult.ok(result.getId());
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.POST)
	@ResponseBody
	public ActionResult<Bank> findById(Integer id) {
		Bank bank = bankService.findById(id);
		
		return ActionResult.ok(bank);
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public QueryResult<Bank> search(BankSearchForm form){

        return  bankService.search(form);
    }
	
	@RequestMapping(value = "/searchPage", method = RequestMethod.POST)
    @ResponseBody
    public QueryResult<Bank> searchPage(BankSerchPageForm form){

        return  bankService.searchPage(form);

    }

}
