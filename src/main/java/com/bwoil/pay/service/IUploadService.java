package com.bwoil.pay.service;

import java.util.Map;

import com.bwoil.pay.model.PhotoInfo;

public interface IUploadService {
	
  /**
   * 上传身份证照片
   * @param photoInfo
   * @return
   */
  public Map<String, Object> idCardImage(PhotoInfo photoInfo);
  
  /**
   * 上传银行卡照片
   * @param cardNo
   * @param cardImgData
   * @param eProtocolAcNo
   * @return
   */
  public Map<String, String> bankCardImage(String cardNo, String cardImgData, String eProtocolAcNo);
  
}
