package com.tribalinstincts.minecraft.nexus.modules.kit.kits;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

import com.tribalinstincts.minecraft.nexus.core.NexusPlayer;
import com.tribalinstincts.minecraft.nexus.modules.kit.KitManager;

/**
 * 
 * The Kit class to be extended to for a kit.
 *
 */
public class Kit implements Listener{
	
	NexusPlayer np;
	KitManager manager;
	public static String Name = "NotAssigned";
	public static int Tier = -1;
	public static String Description = "This is not a kit!";
	
	/**
	 * Gets the name of the kit.
	 * @return name of the kit.
	 */
	public String getName(){
		try {
			return (String)this.getClass().getDeclaredField("Name").get(null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Gets the tier of the kit.
	 * @return tier of the kit.
	 */
	public int getTier(){
		try {
			return (int)this.getClass().getDeclaredField("Tier").get(null);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	/**
	 * Gets the description of the kit.
	 * @return description of the kit.
	 */
	public String getDescription(){
		try {
			return (String)this.getClass().getDeclaredField("Description").get(null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * Initializes the kit for the player.
	 * @param manager The {@link KitManager} of the plugin.
	 * @param np The {@link NexusPlayer} to initialize the kit for.
	 */
	public Kit(KitManager manager, NexusPlayer np){
		this.manager = manager;
		this.np = np;
	}
	
	/**
	 * Unregisters this listener to the plugin.
	 */
	public void unregisterListener(){
		HandlerList.unregisterAll(this);
	}
	
	public void timerTick(){ }
	public void giveStartingItems(){ }
	
	/**
	 * Is the entity the {@link NexusPlayer} using the kit.
	 * @param entity An entity.
	 * @return true if the entity is the NexusPlayer, if not, false.
	 */
	boolean isEntityThisPlayer(Entity entity){
		return (entity instanceof Player && ((Player)entity) == this.np.getPlayer()) ? true : false;
	}
}
