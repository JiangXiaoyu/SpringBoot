package com.bwoil.pay.model;

import java.util.List;
import java.util.Map;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;
@Data
public class BusinessInfo {
	
	/**	电子账户协议编号	*/
	@NotBlank
	private String eProtocolAcNo;
	/**	开始日期	*/
	@NotBlank
	private String beginDate;
	/**	结束日期	*/
	@NotBlank
	private String endDate;
	/**	开始笔数	*/
	@NotBlank
	private String beginNumber;
	/**	查询笔数	*/
	@NotBlank
	private String queryNumber;
	/**	交易数量	*/
	private String totalCount;
	/**	电子账户协议编号	*/
	private List<Map<String, String>> business;
	

}
