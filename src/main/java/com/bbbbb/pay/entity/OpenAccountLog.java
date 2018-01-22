package com.bbbbb.pay.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.util.Date;

@Entity(name="t_bbbbb_open_account_log")
@Data
public class OpenAccountLog implements Serializable {
	
	private static final long serialVersionUID = -4306870206054203943L;

	@Id
	@GeneratedValue
	private int id;

	private String userId;                    // 云油用户标识

	private String acountName;                // 账户姓名

	private String idCardNo;                  // 身份证号码
	
	private String mobilePhone;               // 用户手机号码
	
	private String openBank;				  // 开户银行

	private String bankCardNo;                // 绑定银行卡账号

	private String code;                      // 民行返回码

	private String message;                   // 民行返回信息
	
	private String channelJnlNo;              // 渠道请求流水号
	
	private String eAccountOpenJnlNo;         // 预开户号
	
	private String eAcNoStatus;               // 民行处理状态
	
	private String eProtocolAcNo;             // 电子账户协议编号
	
	private String eCardNo;                   // 电子账户
	
	private String openDate;                  // 开户日期
	
	private String bankInnerFlag;             // 绑定卡行内行外标识

	private Date createTime;                  // 创建时间

	private Date updateTime;				  // 修改时间

}