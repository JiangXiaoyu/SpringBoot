package com.bbbbb.pay.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name="t_bbbbb_upload_idcard_log")
public class UploadIdCardLog implements Serializable {
	
	private static final long serialVersionUID = -5609818920499183263L;

	@Id
	@GeneratedValue
	private Integer id;
	
	private Integer idCardNo;        //身份证号码
	
	private String name;             //身份证姓名
	
	private String idpno;            //身份证照片验证凭证号
	
	private String code;             //银行返回码
	
	private String message;          //银行返回信息
	
	private String channelJnlno;    //渠道请求流水号
	
	private String status;          //流水状态
	
	private String reason;          //银行返回失败原因
	
	private Date createTime;        //上传身份证照片时间
	
}
