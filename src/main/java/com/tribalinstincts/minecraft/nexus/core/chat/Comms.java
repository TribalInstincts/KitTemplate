package com.tribalinstincts.minecraft.nexus.core.chat;

import org.bukkit.ChatColor;

import com.tribalinstincts.minecraft.nexus.core.NexusPlayer;

public class Comms {
	
	public static final String TAG = "§7[§4KitTemplate§7]";	
	public static boolean msg(NexusPlayer np, String message){
		if(message != null){
			String[] messageLines = message.split("\\\\n");
			for(String s : messageLines){
				np.getPlayer().sendMessage(TAG + ChatColor.YELLOW +  s);
			}
		}
		return true;
	}
}
