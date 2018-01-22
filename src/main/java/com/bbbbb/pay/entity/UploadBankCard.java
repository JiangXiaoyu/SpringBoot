package com.bbbbb.pay.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name="t_bbbbb_upload_bankcard_log")
public class UploadBankCard implements Serializable {
	
	private static final long serialVersionUID = 1786450171786864103L;

	@Id
	@GeneratedValue
	private Integer id;
	/** 银行卡号 */
	private String bankCardNo;
	/** 电子账户协议编码 */
	private String eProtocolAcNo;
	/** 民生返回码 */
	private String code;
	/** 民生返回信息 */
	private String message;
	/** 银行卡照片序号 */
	private String imageSeq;
	/** 上传时间 */
	private Date createTime;

}
