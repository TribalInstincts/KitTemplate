package com.tribalinstincts.minecraft.nexus.modules.kit;

import com.tribalinstincts.minecraft.nexus.core.NexusCore;
/**
 * 
 * Manages the timer tick for kits, and the countdowns.
 *
 */
public class KitTimeManager {

	final KitManager manager;
	final NexusCore core;
	
	int tid = -1;
	/**
	 * Initializes the KitTimeManager.
	 * @param manager {@link KitManager} of the plugin.
	 */
	public KitTimeManager(KitManager manager){
		this.manager = manager;
		this.core = manager.core;
		this.startTimer();
	}
	
	/**
	 * Starts the timer that runs every 1 second.
	 */
	private void startTimer(){
		tid = core.getPlugin().getServer().getScheduler().scheduleSyncRepeatingTask(core.getPlugin(), new Runnable() {
			@Override
			public void run() {
				timerTick();
			}
		}, 0L, 20L);
	}
	
	/**
	 * Calls the processKitTimers() method of {@link KitManager}.
	 */
	private void timerTick(){
		manager.processKitTimers();
	}
}
