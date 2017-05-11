package com.github.loongchen.bean.menu;

public class ParentButton extends Button {

	private Button[] sub_button;
	
	public ParentButton(){}
	public ParentButton(String name){
		super(name);
	}

	public Button[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(Button[] sub_button) {
		this.sub_button = sub_button;
	}
	
	
}
