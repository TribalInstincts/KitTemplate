package com.tribalinstincts.minecraft.nexus.modules.kit.kits;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

import com.tribalinstincts.minecraft.nexus.core.NexusPlayer;
import com.tribalinstincts.minecraft.nexus.modules.kit.KitManager;

public class Kit implements Listener{
	
	NexusPlayer np;
	KitManager manager;
	public static String Name = "NotAssigned";
	public static int Tier = -1;
	public static String Description = "This is not a kit!";
	
	public String getName(){
		try {
			return (String)this.getClass().getDeclaredField("Name").get(null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int getTier(){
		try {
			return (int)this.getClass().getDeclaredField("Tier").get(null);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public String getDescription(){
		try {
			return (String)this.getClass().getDeclaredField("Description").get(null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Kit(KitManager manager, NexusPlayer np){
		this.manager = manager;
		this.np = np;
	}
	
	public void unregisterListener(){
		HandlerList.unregisterAll(this);
	}
	
	public void timerTick(){ }
	public void giveStartingItems(){ }
	
	boolean isEntityThisPlayer(Entity entity){
		if(entity instanceof Player && ((Player)entity) == this.np.getPlayer()) return true;
		return false;
	}
	
}
