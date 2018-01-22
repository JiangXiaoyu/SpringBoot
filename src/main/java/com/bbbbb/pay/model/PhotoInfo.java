package com.bbbbb.pay.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * 民生银行返回对象
 * @ClassName: Result 
 * @author wuzf 
 * @date 2017年11月11日 下午4:08:41
 */
@Data
public class PhotoInfo implements Serializable {

	private static final long serialVersionUID = -4581204933662200955L;
	@NotNull
	private String eProtocolAcNo;				//电子账户协议编号
	@NotNull
	private String idPASide;					//身份证正面照片   身份证正面照片Base64字符串，照片文件不能超过1M原始图片格式为jpg/jpeg		
	
	private String idPbSide;					//身份证反面照片
	@NotNull /** 电子账户协议编号可能为空，统一传姓名和身份证号 */
	private String idNo;						//身份证号码
	@NotNull
	private String cifName;						//客户姓名
	
}
