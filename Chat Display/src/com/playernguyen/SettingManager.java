package com.playernguyen;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import com.playernguyen.utils.LogConsole;

public class SettingManager {

	private Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("ChatDisplay");
	
	private File file = new File(plugin.getDataFolder(), "config.yml");
	
	private FileConfiguration cf = YamlConfiguration.loadConfiguration(file);
	
	private LogConsole log = new LogConsole();
	
	public FileConfiguration getConfig(){
		return cf;
	}
	
	public void save(){		
		try {
			cf.save(file);
		} catch (IOException e) {
			log.logError("[ChatDisplay] Error to save file config.yml.");
		}
	}
	
	
	
}
