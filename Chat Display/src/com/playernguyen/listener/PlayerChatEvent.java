package com.playernguyen.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import com.playernguyen.ChatDisplay;
import com.playernguyen.utils.SettingConfig;

public class PlayerChatEvent implements Listener {

	private SettingConfig settingCf = new SettingConfig(); 
	
	@EventHandler
	public void onPlayerChatEvent(final AsyncPlayerChatEvent e){
		
		final Player p = e.getPlayer();
		
		final Hologram holo = HologramsAPI.createHologram(ChatDisplay.getChatDisplay(), p.getLocation().add(0, 2, 0));
		holo.appendTextLine(e.getMessage());
		
		new BukkitRunnable() {
			
			int tick;
			
			@Override
			public void run() {
				// Method
				tick++;
				holo.teleport(p.getLocation());
				
				// hide
				if(tick > settingCf.getTimeToHide()){
					holo.delete();
					cancel();
				}
			}
		}.runTaskTimer(ChatDisplay.getChatDisplay(), 1L, 1L);
	}
	
}
