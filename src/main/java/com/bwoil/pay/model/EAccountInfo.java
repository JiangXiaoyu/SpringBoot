package com.bwoil.pay.model;

import java.io.Serializable;

import lombok.Data;

/**
 * 电子账户实体
 * @author zhangze
 *
 */
@Data
public class EAccountInfo implements Serializable{
	
	private static final long serialVersionUID = 5645348056906319415L;
	
	/**	是否开通光汇云支付(民生)	*/
	private boolean isOn;		                
	/**	光汇账户余额	*/
	private String balance;					//光汇账户余额  *
	/**	绑定卡卡号	*/
	private String tacNo;						//绑定卡卡号 *
	/**	一类卡开户行	*/
	private String firstCardBank;				//一类卡开户行 *
	/**	民生电子账户卡号	*/
	private String eCardNo;						//民生电子账户卡号
	/**	电子账户协议编号	*/
	private String eProtocolAcNo;				//电子账户协议编号
	/**	开户日期	*/
	private String openDate;                    //开户日期
	
}
