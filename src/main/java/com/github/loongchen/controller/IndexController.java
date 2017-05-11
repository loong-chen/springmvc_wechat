package com.github.loongchen.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.loongchen.config.WeChatConfig;
import com.github.loongchen.service.IWxService;


/**
 * 微信公众号入口  在公众号	url服务器上填写改地址：http://xxxx.xxxx.xx(域名)/springMVC_WeChat/msg
 * @author loong
 *
 */
@Controller
public class IndexController {
	
	@Autowired
	private IWxService wxService;
	
	@RequestMapping(value="/msg")
	public void index(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String signature = request.getParameter("signature");
		System.out.println(signature);
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		boolean isSignature = wxService.checkSignature(signature, timestamp, nonce);
		System.out.println(isSignature);
		if(isSignature){
			if(!StringUtils.isEmpty(echostr)){
				String echoStrOut = String.copyValueOf(echostr.toCharArray());
	            response.getWriter().println(echoStrOut);
	            return;
			}
		}else{
			 response.getWriter().println("非法请求");
		}
	}
	
}
