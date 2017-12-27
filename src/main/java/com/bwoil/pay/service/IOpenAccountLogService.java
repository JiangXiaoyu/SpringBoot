package com.bwoil.pay.service;

import com.bwoil.pay.entity.OpenAccountLog;
/**
 * 开户日志表接口
 * @ClassName: IOpenAccountLogService 
 * @author wuzf 
 * @date 2017年11月14日 上午10:00:37
 */
public interface IOpenAccountLogService {

	/**
	 * 新增
	 * @Title: insert 
	 * @param openAccountLog
	 * @return OpenAccountLog
	 */
	public OpenAccountLog insert(OpenAccountLog openAccountLog);
	
}
