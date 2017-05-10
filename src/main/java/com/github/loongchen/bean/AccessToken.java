package com.github.loongchen.bean;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AccessToken {

	private String access_token;  //获取到的凭证
	private Integer expires_in;    //凭证有效时间，单位：秒
	private Integer errcode;       //错误返回码
	private String errmsg;        //错误信息
	
	private Long expiredTime;		// 正确获取到 access_token 时有值，存放过期时间
	private String json;
	
	public AccessToken(String jsonStr) {
		this.json = jsonStr;
		ObjectMapper mapper = new ObjectMapper();
		try {
			Map<String, Object> temp = mapper.readValue(jsonStr, Map.class);
			access_token = (String) temp.get("access_token");
			expires_in = getInt(temp, "expires_in");
			errcode = getInt(temp, "errcode");
			errmsg = (String) temp.get("errmsg");

			if (expires_in != null)
				expiredTime = System.currentTimeMillis() + ((expires_in -5) * 1000);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public Integer getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}
	public Integer getErrcode() {
		return errcode;
	}
	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public Long getExpiredTime() {
		return expiredTime;
	}
	public void setExpiredTime(Long expiredTime) {
		this.expiredTime = expiredTime;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
	public boolean isAvailable(){
		if (expiredTime == null)
			return false;
		if (errcode != 0)
			return false;
		if (expiredTime < System.currentTimeMillis())
			return false;
		return access_token != null;
	}
	
	private Integer getInt(Map<String, Object> temp, String key) {
		Number number = (Number) temp.get(key);
		return number == null ? null : number.intValue();
	}
	
}
