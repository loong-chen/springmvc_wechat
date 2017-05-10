package com.github.loongchen.service;

public interface IWxService {

	/**
	 * 校验签名
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param token
	 * @return
	 */
	public boolean checkSignature(String signature,String timestamp,String nonce);
}
