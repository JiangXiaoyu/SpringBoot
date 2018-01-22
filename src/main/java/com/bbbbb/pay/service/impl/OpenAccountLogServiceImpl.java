package com.bbbbb.pay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbbbb.pay.dao.OpenAccountLogDao;
import com.bbbbb.pay.entity.OpenAccountLog;
import com.bbbbb.pay.service.IOpenAccountLogService;

@Service
public class OpenAccountLogServiceImpl implements IOpenAccountLogService {

	@Autowired
	private OpenAccountLogDao openAccountLogDao;
	
	@Override
	public OpenAccountLog insert(OpenAccountLog openAccountLog) {
		return this.openAccountLogDao.save(openAccountLog);
	}

}
