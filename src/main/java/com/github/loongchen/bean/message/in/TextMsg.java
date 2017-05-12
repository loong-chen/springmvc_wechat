package com.github.loongchen.bean.message.in;

import com.github.loongchen.bean.message.AbstractMsg;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class TextMsg extends AbstractMsg{

	private String Content;
	private String MsgId;
	
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getMsgId() {
		return MsgId;
	}
	public void setMsgId(String msgId) {
		MsgId = msgId;
	}
	
}
