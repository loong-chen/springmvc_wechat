package com.github.loongchen.utils.msg;

import org.junit.Ignore;
import org.junit.Test;

import com.github.loongchen.bean.message.in.TextMsg;

import junit.framework.TestCase;

public class MessageParseUtilsTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testToNormalObjectStringClassOfT() {
		String xml = "<xml><ToUserName><![CDATA[gh_1594b108998e]]></ToUserName><FromUserName><![CDATA[oAdFis7s3jScpWHlEKDeR8Nu_Rks]]></FromUserName><CreateTime>1494574943</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[你好]]></Content><MsgId>6419150502029242875</MsgId></xml>";
		TextMsg obj = MessageParseUtils.xmlToObject(xml, TextMsg.class);
		obj.getCreateTime();
		obj.getContent();
	}
	
	@Ignore
	public void testToNormalXml() {
		//String xml = "<ToUserName><![CDATA[gh_1594b108998e]]></ToUserName><FromUserName><![CDATA[oAdFis7s3jScpWHlEKDeR8Nu_Rks]]></FromUserName><CreateTime>1494574943</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[你好]]></Content><MsgId>6419150502029242875</MsgId>";
		TextMsg obj = new TextMsg();
		obj.setToUserName("gh_1594b108998e");
		obj.setFromUserName("oAdFis7s3jScpWHlEKDeR8Nu_Rks");
		obj.setMsgId("6419150502029242875");
		obj.setContent("你好");
		obj.setCreateTime(1494574943);
		obj.setMsgType("text");
		String byteXml = MessageParseUtils.objectToXml(obj);
		System.out.println(byteXml);
		long d = 1234567890123456L;
	}

}
