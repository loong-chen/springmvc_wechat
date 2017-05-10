package com.github.loongchen.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration("wechatConfig")
public class WeChatConfig {

	
	public static String token;
	
	
	public static String appId;
	
	
	public static String appSecret;

	@Value("${token}")
	public void setToken(String token) {
		this.token = token;
	}

	@Value("${appId}")
	public void setAppId(String appId) {
		this.appId = appId;
	}

	@Value("${appSecret}")
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	
	
}
