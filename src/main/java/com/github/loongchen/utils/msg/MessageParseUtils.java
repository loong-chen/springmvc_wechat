package com.github.loongchen.utils.msg;

import com.thoughtworks.xstream.XStream;

public class MessageParseUtils {

	/**
	 * 对象转xml
	 * @param obj
	 * @return
	 */
	public static <T> String objectToXml(T obj){
		XStream xStream = new XStream();
		xStream.setMode(XStream.NO_REFERENCES);
		xStream.processAnnotations(new Class[]{obj.getClass()});  
		String xml = xStream.toXML(obj);
		return xml;
	}
	
	/**
	 * xml 转 对象
	 * @param xml
	 * @param clazz
	 * @return
	 */
	public static <T> T xmlToObject(String xml,Class<T> clazz){
		XStream xStream = new XStream();
		xStream.setMode(XStream.NO_REFERENCES);
		xStream.processAnnotations(new Class[]{clazz});  
		T obj = (T) xStream.fromXML(xml);
		return obj;
	}
 }