package com.bbbbb.pay.model;

import java.io.Serializable;

import lombok.Data;
@Data
public class ChannelHeadRequest implements Serializable {

	private static final long serialVersionUID = -7953699100982170940L;
	
	private String ChannelId;			//渠道ID
	
	private String ChannelDate;			//渠道日期		
	
	private String ChannelJnlNo;		//渠道流水号
	
}
