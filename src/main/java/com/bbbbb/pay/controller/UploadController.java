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
import com.bbbbb.pay.model.PhotoInfo;
import com.bbbbb.pay.service.IUploadService;

@RestController
@RequestMapping("/upload")
public class UploadController {

	@Autowired
	private IUploadService uploadService;
	
	/**
	 * 身份证上传
	 * @param photoInfo
	 * @return
	 */
	@RequestMapping(value = "/idCardImage", method = RequestMethod.POST)
	@ResponseBody
	public ActionResult<Object> photoUpload(@Valid PhotoInfo photoInfo) {
		Map<String, Object> result = uploadService.idCardImage(photoInfo);
		
		return ActionResult.ok(result);
	}
	
	/**
	 * 上传银行卡照片
	 * @param cardNo
	 * @param cardImgData
	 * @return
	 */
	@RequestMapping(value = "/bankCardImage", method = RequestMethod.POST)
	@ResponseBody
	public ActionResult<Object> bankCardImage(@RequestParam("cardNo") String cardNo, @RequestParam("cardImgData")
		String cardImgData, String eProtocolAcNo) {
		Map<String, String> result = uploadService.bankCardImage(cardNo, cardImgData, eProtocolAcNo);
		
		return ActionResult.ok(result);
	}
	
	
}
