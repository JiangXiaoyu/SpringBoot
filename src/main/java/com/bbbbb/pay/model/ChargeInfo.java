package com.bbbbb.pay.model;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class ChargeInfo {     
     
	 /** 充值金额 */
	 @NotBlank
     public String amount;
     /** 电子账户协议编号 */
	 @NotBlank
     public String eProtocolAcNo;
     /** 电子账户交易密码密文	 */
	 @NotBlank
     public String PwdResult;
     /** 随机数 */
	 @NotBlank
     public String Random;
     /** 密码随机数流水号 */
	 @NotBlank
     public String RandJnlNo;
     /** 转账用途 */
     public String Remark;	

}
