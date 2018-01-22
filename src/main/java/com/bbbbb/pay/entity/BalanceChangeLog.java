package com.bbbbb.pay.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "t_bbbbb_balance_change_log")
@Data
public class BalanceChangeLog implements Serializable {

	private static final long serialVersionUID = -1480111519542679182L;

	@Id
	@GeneratedValue
	private int id;
//	/** 账户Id */
//	private int accountId;
	/** 交易金额 */
	private String amount;		
	/** 电子账户协议编号 */
	private String eProtocolAcNo;	
//	/** 手机号码 */
//	private String mobilePhone;
	/** 汇款方式(用于出金交易) */
	private String payPath;	
	/** 交易类型(0-出金|1-入金) */
	private String tradeType;
	/** 转账用途 */
	private String remark;
	/** 民生返回码 */
	private String code;
	/** 民生返回信息 */
	private String message;
	/** 创建时间 */
	private Date createTime;
	
	
	public BalanceChangeLog(String amount, String eProtocolAcNo, String tradeType, String remark, 
			String code, String message, Date createTime) {
		super();
		this.amount = amount;
		this.eProtocolAcNo = eProtocolAcNo;
		this.remark = remark;
		this.tradeType = tradeType;
		this.code = code;
		this.message = message;
		this.createTime = createTime;
	}
	
	
}