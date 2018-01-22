package com.bbbbb.pay.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class AccountInfo implements Serializable{

	private static final long serialVersionUID = -4488282021310245453L;
	
	private boolean isOn;		                //是否开通光汇云支付(民生)

	private String userId;						//云油账户Id *
	@NotBlank
	private String cifName;						//客户姓名 *
	@NotBlank
	private String idNo;						//身份证号码 *
	@NotBlank
	private String mobilePhone;					//手机号 *
	
	private String balance;				    	//光汇账户余额  *
	@NotBlank
	private String tacNo;						//绑定卡卡号 *
	
	private String firstCardBank;				//一类卡开户行 *
	
	private String eCardNo;						//民生电子账户卡号
	
	private String pwdResult;					//电子账户交易密码密文
	
	private String pwdResultConfirm;			//电子账户交易密码密文确认
	
	private String randJnlNo;					//密码随机流水号   和电子账户交易密码密文一同上送
	
	private String random;						//密码随机数           交易密码上送的话，本字段必须上送
	
	private String isSignFund;					//是否如意宝签约  	0-签约  1-不签约 *
	
	private String prodSubId;					//产品编码
	
	private String messageTaskId;				//短信验证码Id
	
	private String messageCode;					//短信验证码
	
	private String isAgreeProtocol;				//是否同意开户协议 	 0-同意 1-不同意 *
	
	private String terminalType;				//终端类型  		 M-手机 V-微信 E-PC端 默认E
	
	private String bankDeptCode;				//业绩归属机构
	
	private String subDeptCode;					//业绩便民机构
	
	private String extensionEmployee;			//业绩客户经理号
	
	private String verifyJnlNo;					//快捷认证流水号
	
	private String isStaff;						//是否内部员工   		 Y:是内部员工   其他或空：非内部员工
	
	private String idPNo;						//身份证照片凭证号
	
	private String lockType;					//解锁类型
	
	private String eProtocolAcNo;				//电子账户协议编号
	
	private String openDate;                    //开户日期

}
