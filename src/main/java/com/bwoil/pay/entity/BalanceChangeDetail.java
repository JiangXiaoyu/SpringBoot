package com.bwoil.pay.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "t_bwoil_balance_change_detail")
@Data
public class BalanceChangeDetail implements Serializable {
	
	private static final long serialVersionUID = 8163024000800720187L;

	@Id
	@GeneratedValue
	private int id;

	private BigDecimal amount;

	private String channelJnlNo;

	private Date createTime;

	private String eProtocolAcNo;

	private String remark;
	
}