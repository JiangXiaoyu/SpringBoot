package com.bbbbb.pay.model;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;
@Data
public class UnlockPwdInfo {

	/**	电子账户协议编号	*/
	@NotBlank
	private String eProtocolAcNo;
	/**	短信验证码Id	*/
	@NotBlank
	private String messageTaskId;
	/**	短信验证码 */
	@NotBlank
	private String messageCode;
	/**	电子账户交易密码密文	*/
	@NotBlank
	private String pwdResult;
	/**	密码随机数流水号	*/
	@NotBlank
	private String randJnlNo;
	/**	密码随机数 */
	@NotBlank
	private String random;
		
}
