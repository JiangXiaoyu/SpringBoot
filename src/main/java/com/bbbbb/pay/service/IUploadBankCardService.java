package com.bbbbb.pay.service;

public interface IUploadBankCardService {
	
	/**
	 * 上传银行卡照片，保存民生返回信息
	 * @param cardNo
	 * @param eProtocolAcNo
	 * @param code
	 * @param message
	 * @param imageSeq
	 */
	public void save(String cardNo, String eProtocolAcNo, String code, String message, String imageSeq);
}
