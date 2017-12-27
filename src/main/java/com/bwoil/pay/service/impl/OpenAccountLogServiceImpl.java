package com.bwoil.pay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwoil.pay.dao.OpenAccountLogDao;
import com.bwoil.pay.entity.OpenAccountLog;
import com.bwoil.pay.service.IOpenAccountLogService;

@Service
public class OpenAccountLogServiceImpl implements IOpenAccountLogService {

	@Autowired
	private OpenAccountLogDao openAccountLogDao;
	
	@Override
	public OpenAccountLog insert(OpenAccountLog openAccountLog) {
		return this.openAccountLogDao.save(openAccountLog);
	}

}
