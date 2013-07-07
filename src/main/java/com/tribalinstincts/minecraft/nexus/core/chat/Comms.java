package com.tribalinstincts.minecraft.nexus.core.chat;

import org.bukkit.ChatColor;

import com.tribalinstincts.minecraft.nexus.core.NexusPlayer;
/**
 * 
 * Communication class for sending mesages to {@link NexusPlayer}s.
 *
 */
public class Comms {
	
	public static final String TAG = ChatColor.translateAlternateColorCodes('&', "&7[&4KitTemplate&7] ");
	
	/**
	 * Send a message to a {@link NexusPlayer}.
	 * @param np The NexusPlayer to send the message to.
	 * @param message The message to send.
	 * @return False If player is offline, or message is null, if else, returns true.
	 */
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
