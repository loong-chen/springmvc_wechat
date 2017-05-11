package com.github.loongchen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.loongchen.bean.menu.Menu;
import com.github.loongchen.service.impl.WxApiServiceImpl;

@Controller
public class WxApiController {

	@Autowired
	private WxApiServiceImpl wxApiServiceImpl;
	
	@RequestMapping(value="/API/createMenu",method=RequestMethod.POST)
	@ResponseBody
	public String createMenu(@RequestBody Menu menu){
		ObjectMapper mapper = new ObjectMapper();
		String menuJson="";
		try {
			menuJson = mapper.writeValueAsString(menu);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wxApiServiceImpl.createMenu(menuJson);
	}
}
