package com.github.loongchen.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration("wechatConfig")
public class WeChatConfig {

	@Value("${token}")
	public String token;
}
