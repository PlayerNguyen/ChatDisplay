package com.playernguyen.utils;

import com.playernguyen.SettingManager;

public class SettingConfig {

	private SettingManager setting = new SettingManager();
	
	public int getTimeToHide(){
		int time = setting.getConfig().getInt("display-time");
		return (time*20);
	}
	
	public boolean getDebugMode(){
		boolean debugmode = setting.getConfig().getBoolean("debug-mode");
		return debugmode;
	}
	
	
}
