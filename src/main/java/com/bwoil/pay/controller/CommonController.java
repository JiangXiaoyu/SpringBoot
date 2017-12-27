package com.bwoil.pay.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bwoil.common.framework.result.ActionResult;
import com.bwoil.pay.service.ICommonService;

/**
 * 短信验证码控制器
 * @ClassName: MessageController 
 * @author wuzf 
 * @date 2017年11月22日 下午5:07:09
 */
@RestController
@RequestMapping("/common")
public class CommonController {

	@Autowired
	private ICommonService commonService;
	
	/**
	 * 获取民生银行随机数
	 * @Title: getRandom 
	 * @param eProtocolAcNo 电子账户协议编号(非必输)
	 * @param randType      类型(	1-电子账户交易密码;2-查询密码;3-登录密码;4-混合密码)
	 * @return Map<String,Object>
	 */
	@RequestMapping(value = "/getRandom", method = RequestMethod.POST)
	@ResponseBody
	public ActionResult<Map<String, String>> getRandom(String eProtocolAcNo, @RequestParam("randType") String randType) {
		Map<String, String> dataMap = this.commonService.getRandom(eProtocolAcNo, randType);

		return ActionResult.ok(dataMap);
	}
	
	/**
	 * 获取短信验证码接口
	 * @Title: getPhoneCode 
	 * @param eProtocolAcNo
	 * @param mobilePhone
	 * @param templateId
	 * @return Map<String,Object>
	 */
	@RequestMapping(value = "/getPhoneCode", method = RequestMethod.POST)
	@ResponseBody
	public ActionResult<Map<String, String>> getPhoneCode(@RequestParam("eProtocolAcNo") String eProtocolAcNo, @RequestParam("mobilePhone") String mobilePhone, @RequestParam("templateId") String templateId) {
		Map<String, String> dataMap = this.commonService.getPhoneCode(eProtocolAcNo, mobilePhone, templateId);

		return ActionResult.ok(dataMap);
	}
}
