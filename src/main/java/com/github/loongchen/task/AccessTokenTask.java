package com.github.loongchen.task;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.github.loongchen.utils.accesstoken.AccessTokenUtils;

@Component
@EnableScheduling
public class AccessTokenTask {
   
	@Scheduled(fixedRate = 7190*1000)
	public void getAccessToken(){
		AccessTokenUtils.refreshAccessToken();
	}
}
