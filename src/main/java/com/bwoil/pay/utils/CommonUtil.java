package com.bwoil.pay.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.bwoil.pay.model.ChannelHeadRequest;
import com.cmbc.connect.IMesseageSender;
import com.cmbc.connect.impl.DBankMessageSender;

import lombok.extern.slf4j.Slf4j;

/**
 * 公共模块工具类
 * @ClassName: CommonUtil 
 * @author wuzf 
 * @date 2017年11月9日 下午3:21:00
 */
@Slf4j
public class CommonUtil {
	
	/**	渠道前缀标识	 */
	public static final String PREFIX = "621692"; 	
	/**	渠道号/商户号	 */
	public static final String CHANNEL_NO = "99257"; 																			
	/**	渠道后缀标识	 */
	public static final String SUFFIX = "0000";																					
	/**	银行pin码	*/
	public static final String PIN_CODE = "111111";																	
	/**	银行接口地址	 */
	public static final String URL = "http://111.205.207.142:10150/webgateway/dtconnect.do";										
	/**	民生公钥	 */
	public static final String PUBLIC_KEY_NAME = "cmbc.cer";
	/**	民生私钥	 */
	public static final String PRIVATE_KEY_NAME = "99045.sm2";
	/**  公钥绝对地址	 */
	public static final String PUBLIC_KEY_PATH = new File("src/main/resources/" + PUBLIC_KEY_NAME).getAbsolutePath(); 
	/**	私钥绝对地址	 */
	public static final String PRIVATE_KEY_PATH = new File("src/main/resources/" + PRIVATE_KEY_NAME).getAbsolutePath(); 
	
	private static SimpleDateFormat ymdFormat = new SimpleDateFormat("yyyyMMdd");  
	private static SimpleDateFormat hmsFormat = new SimpleDateFormat("HHmmssSSS");
	
	/**
	 * 银行渠道流水号生成规则
	 * @Title: generateChannelJnlNo 
	 * @param prefix 渠道前缀标识
	 * @param channelId 商户渠道号 (银行给我们分配的商户号)
	 * @param suffix 渠道后缀标识
	 * @return String
	 */
	public static String generateChannelJnlNo(String prefix, String channelId, String suffix) {
		Date current = new Date();
		StringBuffer sb = new StringBuffer(prefix); //渠道前缀标识
		sb.append(ymdFormat.format(current));		// 8 位日期 -- YYYYMMDD
		sb.append(hmsFormat.format(current));		// 9 位时间 -- HHmmssSSS
		sb.append(channelId);                		// 商户渠道号        
		sb.append(suffix);                   		// 渠道后缀标识
		try {
			Thread.sleep(1);						// 保证同一毫秒时间内不会出现相同的流水号	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	/**
	 * 请求民生银行接口
	 * @Title: postMSBank 
	 * @param tradeCode 交易码
	 * @param dataMap	业务数据
	 * @param isNeedHeader	是否需要请求头
	 * @return Map<String,Object>
	 */
	public static Map<String, Object> postMSBank(String tradeCode, Map<String, Object> dataMap, String isNeedHeader){	
		Map<String, Object> map = new HashMap<String, Object>();
		/** 流水号是否重复 */
		boolean flag = false;
		do {
		  map = sendMessage(tradeCode, dataMap, isNeedHeader);
		  flag = "DS00099".equals(map.get("code"));  //TODO  根据民生流水号重复返回结果处理，重复则重送
		} while(flag);
			
		return map;
	}
	
	public static Map<String, Object> sendMessage(String tradeCode, Map<String, Object> dataMap, String isNeedHeader){	
		String channelJnlNo = generateChannelJnlNo(PREFIX, CHANNEL_NO, SUFFIX);
		if("Y".equals(isNeedHeader)){
			ChannelHeadRequest channelHeadRequest =  new ChannelHeadRequest();
			channelHeadRequest.setChannelId(CHANNEL_NO);
			channelHeadRequest.setChannelDate(ymdFormat.format(new Date()));
			channelHeadRequest.setChannelJnlNo(channelJnlNo);
			dataMap.put("ChannelHeadRequest", channelHeadRequest);
		}
		IMesseageSender messeageSender = new DBankMessageSender(PRIVATE_KEY_PATH, PIN_CODE, PUBLIC_KEY_PATH, URL, CHANNEL_NO);
		return messeageSender.sendMessage(tradeCode, dataMap, channelJnlNo);
	}
	    
	public static void main(String[] args) {
		log.debug("---------------- 以下是民生银行渠道号生成结果  -----------------");
		log.debug(generateChannelJnlNo("621692","99257","0000"));
	}
}
