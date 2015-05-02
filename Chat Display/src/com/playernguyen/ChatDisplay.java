package com.playernguyen;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.playernguyen.listener.PlayerChatEvent;
import com.playernguyen.utils.LogConsole;

public class ChatDisplay extends JavaPlugin {

	private LogConsole log = new LogConsole();
	
	public void onEnable(){
		log.log("====== [ChatDisplay] ======");
		log.log("[ChatDisplay] Loading ChatDisplay......");
		/*
		 * Check HolographicDisplays enable.
		 */
		if(Bukkit.getServer().getPluginManager().getPlugin("HolographicDisplays") == null){
			log.logError("[ChatDisplay] Please install Holographic Displays!");
			log.logError("[ChatDisplay] Link: http://dev.bukkit.org/bukkit-plugins/holographic-displays/");
			log.logError("[ChatDisplay] Disable this plugin.");
			Bukkit.getServer().getPluginManager().disablePlugin(this);
			return;
		} else {
			log.logInfo("[ChatDisplay] Hook with Holographic Display.");
		}
		
		
		log.logInfo("[ChatDisplay] Save config.yml.");
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
		
		
		// Set Listener
		getServer().getPluginManager().registerEvents(new PlayerChatEvent(), this);
	}

	public static Plugin getChatDisplay()
	{
		return Bukkit.getServer().getPluginManager().getPlugin("ChatDisplay");
	}
	
}
