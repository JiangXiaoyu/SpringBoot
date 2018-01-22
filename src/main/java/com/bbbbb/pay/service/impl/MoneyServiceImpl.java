package com.bbbbb.pay.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbbbb.pay.model.BusinessInfo;
import com.bbbbb.pay.model.ChargeInfo;
import com.bbbbb.pay.service.IBalanceChangeLogSerivce;
import com.bbbbb.pay.service.ICommonService;
import com.bbbbb.pay.service.IMoneyService;
import com.bbbbb.pay.utils.StringUtil;

@Service
public class MoneyServiceImpl implements IMoneyService {
	
	@Autowired
	public ICommonService commonservice;
	
	@Autowired
	public IBalanceChangeLogSerivce balancechangelogservice;

	@Override
	public Map<String, String> charge(ChargeInfo chargeInfo) {
		Map<String, String> res = commonservice.charge(chargeInfo.getAmount(), chargeInfo.getEProtocolAcNo(), 
				chargeInfo.getPwdResult(), chargeInfo.getRandJnlNo(), chargeInfo.getRandom(), chargeInfo.getRemark());
		Map<String, String> map = new HashMap<String, String>();
		String code = res.get("code");
		String message = res.get("message");	
		//写日志表
		balancechangelogservice.save(chargeInfo.getAmount(), chargeInfo.getEProtocolAcNo(), chargeInfo.getRemark(), code, message);
						
		map.put("code", code);
		map.put("message", message);
		
		return map;
	}

	@Override
	public Map<String, Object> businessDetail(BusinessInfo busi) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> res = commonservice.getBusinessDetail(busi.getEProtocolAcNo(), busi.getBeginDate(), busi.getEndDate(), busi.getBeginNumber(), busi.getQueryNumber());
		//解析返回交易明细
        String code = (String) res.get("code");
        map.put("code", code);
        map.put("message", res.get("message"));
        if("DS00000".equals(code)) {
        	map.put("channelJnlNo", res.get("ChannelJnlNo"));
        	map.put("totalCount", res.get("TotalCount"));
			Object resList = res.get("List");		
			List<Map<String, String>> list = StringUtil.parseToList(resList);
			busi.setTotalCount((String) res.get("TotalCount"));
			busi.setBusiness(list);
			map.put("business", busi);
        }
		
		return map;
	}
}
