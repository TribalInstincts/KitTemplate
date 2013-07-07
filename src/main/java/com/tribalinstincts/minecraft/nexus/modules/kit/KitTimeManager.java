package com.tribalinstincts.minecraft.nexus.modules.kit;

import com.tribalinstincts.minecraft.nexus.core.NexusCore;

public class KitTimeManager {

	final KitManager manager;
	final NexusCore core;
	
	int tid = -1;
	public KitTimeManager(KitManager manager){
		this.manager = manager;
		this.core = manager.core;
		this.startTimer();
	}
	
	private void startTimer(){
		tid = core.getPlugin().getServer().getScheduler().scheduleSyncRepeatingTask(core.getPlugin(), new Runnable() {
			@Override
			public void run() {
				timerTick();
			}
		}, 0L, 20L);
	}
	
	private void timerTick(){
		manager.processKitTimers();
	}
}
