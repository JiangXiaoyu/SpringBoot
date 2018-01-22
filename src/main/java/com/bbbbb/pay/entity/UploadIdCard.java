package com.bbbbb.pay.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name="t_bbbbb_upload_idcard")
public class UploadIdCard implements Serializable {
	
	private static final long serialVersionUID = 9173023741618082979L;

	@Id
	@GeneratedValue
	private Integer id;
	
	private Integer idCardNo;        //身份证号码
	
	private String name;             //身份证姓名
	
	private String idpno;            //身份证照片验证凭证号
	
}
