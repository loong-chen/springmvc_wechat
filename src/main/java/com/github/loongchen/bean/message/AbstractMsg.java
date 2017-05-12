package com.github.loongchen.bean.message;


public abstract class AbstractMsg {
	// 开发者微信号
	private String ToUserName;

	// 发送方帐号（一个OpenID）
	private String FromUserName;

	// 消息创建时间 （整型）
	private Integer CreateTime;

	/**
	 * 消息类型 1：text 文本消息 2：image 图片消息 3：voice 语音消息 4：video 视频消息 5：location 地址位置消息
	 * 6：link 链接消息 7：event 事件k
	 */
	private String MsgType;

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public Integer getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(Integer createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	

}
