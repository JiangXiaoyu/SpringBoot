package com.bwoil.pay.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bwoil.common.framework.result.ActionResult;
import com.bwoil.pay.model.BusinessInfo;
import com.bwoil.pay.model.ChargeInfo;
import com.bwoil.pay.service.IMoneyService;

@RestController
@RequestMapping(value = "/money")
public class MoneyController {
	
	@Autowired
	public IMoneyService moneyService;
	
	/**
	 * 充值
	 * @param chargeInfo
	 * @return
	 */
	@RequestMapping(value = "/charge", method = RequestMethod.POST)
	@ResponseBody
	public ActionResult<Map<String, String>> charge(@Valid ChargeInfo chargeInfo){			
		Map<String, String> res =  moneyService.charge(chargeInfo);		
		
		return ActionResult.ok(res);		
	}
	
	/**
	 * 电子账户交易明细查询
	 * @param busi
	 * @return
	 */
	@RequestMapping(value = "/getBusiness", method = RequestMethod.POST)
	@ResponseBody
	public ActionResult<Map<String, Object>> getBusiness(@Valid BusinessInfo busi){
		Map<String, Object> res = moneyService.businessDetail(busi);		
		
		return ActionResult.ok(res);
	}

}
