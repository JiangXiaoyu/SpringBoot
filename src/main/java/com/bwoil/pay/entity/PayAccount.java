package com.bwoil.pay.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity(name="t_bwoil_pay_account")
public class PayAccount implements Serializable {
	
	private static final long serialVersionUID = 5808770870367199363L;

	@Id
	@GeneratedValue
	private int id;

	private String userId;                    // 云油用户标识

	private String acountName;                // 账户姓名

	private String mobilePhone;               // 用户手机号码
	
	private String idCardNo;                  // 身份证号码

	private String bankCardNo;                // 绑定一类卡账号
	
	private String firstCardBank;             // 一类卡开户银行

	private String eCardNo;                   // 电子账户

	private String eCardBank;				  // 电子账户开户行

	private String openDate;				  // 电子账户开户日期
	
	private String eProtocolAcNo;             // 电子账户协议编号
	
	private String eAcNoStatus;               // 民行处理状态
	
	private String balance;                   // 账户余额

	private String nopasswordLittlemoney;     // 是否开通小额免密,0-开通 1-未开通
	
	private String status;                    // 账户户状态(0-可用 1-不可用)

	private Date createTime;                  // 创建时间

	private Date updateTime;				  // 修改时间

}