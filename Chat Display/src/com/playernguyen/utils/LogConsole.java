package com.playernguyen.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class LogConsole {

	public void log(String msg){
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+msg);
	}
	
	public void logError(String msg){
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED+msg);
	}
	
	public void logInfo(String msg){
		Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW+msg);
	}
}
