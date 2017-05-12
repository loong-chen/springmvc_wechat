package com.github.loongchen.service;

public interface IWxApiService {

	/**
	 * 创建菜单
	 * @param jsonPram
	 * @return
	 */
	public String createMenu(String jsonPram);
	
	/**
	 * 获取菜单
	 * @return
	 */
	public String getMenu();
}
