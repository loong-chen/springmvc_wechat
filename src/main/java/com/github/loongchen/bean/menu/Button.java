package com.github.loongchen.bean.menu;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS,include=JsonTypeInfo.As.PROPERTY,property="@class")  
public class Button {

	private String name;
	
	
	public Button(){}
	public Button(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
