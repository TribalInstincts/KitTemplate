package com.tribalinstincts.minecraft.nexus.modules.kit.kits;


import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

import com.tribalinstincts.minecraft.nexus.core.NexusPlayer;
import com.tribalinstincts.minecraft.nexus.core.chat.Comms;
import com.tribalinstincts.minecraft.nexus.modules.kit.KitManager;

/**
 * The kit Flash from sr-sg
 * 
 * @see Kit
 */
public class FlashKit extends Kit {
	
	public static String Name = "Flash";
	public static int Tier = 1;
	public static String Description = "Receive a Speed I potion 30 seconds after start\\n" +
			"and a Speed II potion 90 seconds after start.";
	
	/**
	 * Initializes the kit for the player.
	 * @param manager The {@link KitManager} of the plugin.
	 * @param np The {@link NexusPlayer} to initialize the kit for.
	 */
	public FlashKit(KitManager manager, NexusPlayer np) {
    	super(manager, np);
	}

	int delayedItemStart = 30;
	int delayedItem2Start = 90;
	
	/**
	 * No starting items to give the player, so messages with the time until getting their items.
	 * @see Comms
	 */
	@Override
	public void giveStartingItems() {
		Comms.msg(np, "Your Flash Kit items will appear in: " + this.delayedItemStart + " seconds");
	}

	/**
	 * Gives the player their first delayed items
	 */
	public void giveDelayedItems() {
		ItemStack[] item = new ItemStack[1];
		Potion potion = new Potion(PotionType.SPEED, 1);
		potion.setSplash(false);
		item[0] = potion.toItemStack(1);
		np.getPlayer().getInventory().addItem(item);
		return;
	}
	
	/**
	 * Gives the player their second delayed items
	 */
	public void giveDelayedItems2() {
		ItemStack[] item = new ItemStack[1];
		Potion potion = new Potion(PotionType.SPEED, 2);
		potion.setSplash(false);
		item[0] = potion.toItemStack(1);
		np.getPlayer().getInventory().addItem(item);
		return;
	}

	/**
	 * Every second the timer ticks down, and when the time is up, the items are given to the players
	 * @see Comms
	 */
	@Override
	public void timerTick() {
		if(delayedItem2Start < 0) return;
		delayedItemStart--;
		delayedItem2Start--;
		if(delayedItem2Start == 0){
			giveDelayedItems2();
			Comms.msg(np, "Your second "+ Name +" item appear in your pack.");
		}
		if(delayedItemStart == 0) {
			giveDelayedItems();
			Comms.msg(np, "Your "+ Name +" item appear in your pack.");
		}
	}
}
