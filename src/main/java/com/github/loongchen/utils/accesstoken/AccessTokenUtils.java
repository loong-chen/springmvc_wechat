package com.github.loongchen.utils.accesstoken;

import org.springframework.util.ObjectUtils;

import com.github.loongchen.bean.AccessToken;
import com.github.loongchen.config.WeChatConfig;
import com.github.loongchen.utils.http.HttpUtils;

public class AccessTokenUtils {
	
	private static AccessToken accessToken;
	private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=${APPID}&secret=${APPSECRET}";

	public static AccessToken getAccessToken() {
		if (accessToken==null||!accessToken.isAvailable()) {
			refreshAccessToken();
		}
		return accessToken;
	}

	public static void setAccessToken(AccessToken accessToken) {
		AccessTokenUtils.accessToken = accessToken;
	}

	public static void refreshAccessToken() {
		String url = ACCESS_TOKEN_URL.replace("${APPID}", WeChatConfig.appId).replace("${APPSECRET}",
				WeChatConfig.appSecret);
		String result = HttpUtils.get(url);
		if (!ObjectUtils.isEmpty(result)) {
			AccessTokenUtils.setAccessToken(new AccessToken(result));
		}
	}
}
