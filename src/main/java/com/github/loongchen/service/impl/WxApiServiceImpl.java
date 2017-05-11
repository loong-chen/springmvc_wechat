package com.github.loongchen.service.impl;

import org.springframework.stereotype.Service;

import com.github.loongchen.bean.AccessToken;
import com.github.loongchen.service.IWxApiService;
import com.github.loongchen.utils.accesstoken.AccessTokenUtils;
import com.github.loongchen.utils.http.HttpUtils;

@Service("wxApiServiceImpl")
public class WxApiServiceImpl implements IWxApiService{

	private final String CREATE_MUNU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
     	
	@Override
	public String createMenu(String jsonPram) {
		AccessToken access_token = AccessTokenUtils.getAccessToken();
		String url = CREATE_MUNU_URL.replace("ACCESS_TOKEN", access_token.getAccess_token());
		return HttpUtils.post(url, jsonPram);
	}

}
