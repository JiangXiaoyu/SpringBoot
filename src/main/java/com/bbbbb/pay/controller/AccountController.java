package com.bbbbb.pay.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bbbbb.common.framework.result.ActionResult;
import com.bbbbb.pay.model.AccountInfo;
import com.bbbbb.pay.model.ChangeInfo;
import com.bbbbb.pay.model.EAccountInfo;
import com.bbbbb.pay.model.UnlockPwdInfo;
import com.bbbbb.pay.service.ICommonService;
import com.bbbbb.pay.service.IOpenAccountService;

/**
 * 电子账户控制器
 * @ClassName: OpenAccountController 
 * @author wuzf 
 * @date 2017年11月8日 下午2:39:03
 */
@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private IOpenAccountService openAccountService;
	
	@Autowired
	private ICommonService commonService;
	
	/**
	 * 开户
	 * @Title: open 
	 * @param payAccount
	 * @return ActionResult<Object>
	 */
	@RequestMapping(value = "/open", method = RequestMethod.POST)
	@ResponseBody
	public ActionResult<Object> open(@Valid AccountInfo accountInfo) {		
		Map<String, String> result = this.openAccountService.open(accountInfo);
		
		return ActionResult.ok(result);
	}
	
	/**
	 * 光汇云付卡信息展示
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/getInfo", method = RequestMethod.POST)
	@ResponseBody
	public ActionResult<EAccountInfo> getInfo(@RequestParam("userId") String userId){		
		EAccountInfo acc = openAccountService.query(userId);
		
		return ActionResult.ok(acc);
	}
	
	/**
	 * 电子账户解锁
	 * @Title: unLock 
	 * @param accountInfo
	 * @return Map<String,Object>
	 */
	@RequestMapping(value = "/unLock", method = RequestMethod.POST)
	@ResponseBody
	public ActionResult<Map<String, String>> unLock(@Valid AccountInfo accountInfo) {
		Map<String, String> dataMap = commonService.unLock(accountInfo);//建议ActionResult.code改为String，民生的code带字母
		
		return ActionResult.ok(dataMap);
	}
	
	/**
	 * 交易密码变更
	 * @Title: tradePwdChange 
	 * @param changeInfo
	 * @return Map<String,Object>
	 */
	@RequestMapping(value = "/tradePwdChange", method = RequestMethod.POST)
	@ResponseBody
	public ActionResult<Map<String, String>> tradePwdChange(@Valid ChangeInfo changeInfo){
		Map<String, String> dataMap = commonService.tradePwdChange(changeInfo);
		
		return ActionResult.ok(dataMap);
	}
	
	/**
	 * 交易密码解锁
	 * @Title: tradePwdUnlock 
	 * @param accountInfo
	 * @return Map<String,Object>
	 */
	@RequestMapping(value = "/tradePwdUnlock", method = RequestMethod.POST)
	@ResponseBody
	public ActionResult<Map<String, String>> tradePwdUnlock(@Valid UnlockPwdInfo unlockPwd){
		Map<String, String> dataMap = commonService.tradePwdUnlock(unlockPwd);
		
		return ActionResult.ok(dataMap);
	}
	
}
