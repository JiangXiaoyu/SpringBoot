package com.bbbbb.pay.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;
@Data
public class ChangeInfo implements Serializable{

	private static final long serialVersionUID = -4488282021310245452L;
	@NotBlank
	private String eProtocolAcNo;				//电子账户协议编号
	@NotBlank
	private String messageTaskId;				//短信验证码Id
	@NotBlank
	private String messageCode;					//短信验证码
	@NotBlank
	private String oldPwdResult;				//电子账户原交易密码密文
	@NotBlank
	private String oldRandJnlNo;				//原密码随机流水号   
	@NotBlank
	private String oldRandom;					//原密码随机数      
	@NotBlank
	private String newPwdResult;				//电子账户新交易密码密文
	@NotBlank
	private String newPwdResultConfirm;			//电子账户新交易密码密文确认
	@NotBlank
	private String newRandJnlNo;				//新密码随机流水号   
	@NotBlank
	private String newRandom;					//新密码随机数      

	
}
