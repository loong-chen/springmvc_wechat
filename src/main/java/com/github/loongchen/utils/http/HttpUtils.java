package com.github.loongchen.utils.http;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpUtils {
	public static String get(String url){
		OkHttpClient okHttpClient = new OkHttpClient();
		String result = "";
		Request request = new Request.Builder()
		    .url(url)
		    .build();
		Call call = okHttpClient.newCall(request);
		try {
		    Response response = call.execute();
		    result = response.body().string();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		return result;
	}
	
	public static String post(String url,String jsonPram){
		OkHttpClient okHttpClient = new OkHttpClient();
		String result = "";
		MediaType JSON = MediaType.parse("application/json; charset=utf-8");
		RequestBody body = RequestBody.create(JSON, jsonPram);
		Request request = new Request.Builder()
		    .url(url)
		    .post(body)
		    .build();

		Call call = okHttpClient.newCall(request);
		try {
		    Response response = call.execute();
		    result = response.body().string();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		return result;
	}
}
