package com.bwoil.pay.service;

import com.bwoil.pay.entity.BalanceChangeDetail;

/**
 * 民生银行出入金交易流水接口
 * @ClassName: IBalanceChangeDetailService 
 * @author wuzf 
 * @date 2017年11月14日 上午10:05:20
 */
public interface IBalanceChangeDetailService {

	/**
	 * 新增
	 * @Title: insert 
	 * @param  balanceChangeDetail
	 * @return BalanceChangeDetail
	 */
	public BalanceChangeDetail insert(BalanceChangeDetail balanceChangeDetail);
}
