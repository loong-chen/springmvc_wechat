package com.github.loongchen.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.loongchen.config.WeChatConfig;
import com.github.loongchen.service.IWxService;
import com.github.loongchen.utils.crypto.SHA1;

@Service("wxService")
public class WxServiceImpl implements IWxService{
	@Autowired
	private WeChatConfig wechatConfig;
	
	public boolean checkSignature(String signature, String timestamp, String nonce) {
		String token = wechatConfig.token;
		Map<String,String> paramers = new HashMap<String, String>();
		paramers.put("timestamp", timestamp);
		paramers.put("nonce", nonce);
		paramers.put("token", token);
		String encodeString = SHA1.encode(paramers);
		System.out.println(encodeString);
		if(signature.equalsIgnoreCase(encodeString)){
			return true;
		}
		return false;
	}

}
