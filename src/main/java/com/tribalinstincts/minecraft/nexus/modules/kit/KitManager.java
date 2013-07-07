package com.tribalinstincts.minecraft.nexus.modules.kit;

import com.tribalinstincts.minecraft.nexus.core.NexusCore;
import com.tribalinstincts.minecraft.nexus.core.NexusPlayer;
import com.tribalinstincts.minecraft.nexus.modules.kit.kits.Kit;
import com.tribalinstincts.minecraft.nexus.modules.kit.kits.Tier2ExampleKit;
/**
 * 
 * The KitManager for the plugin, handles all kit interaction.
 *
 */
public class KitManager {

	NexusCore core;
	final KitTimeManager timeManager;
	
	/**
	 * Initialize the KitManager
	 * @param core The {@link NexusCore} of the plugin
	 */
	public KitManager(NexusCore core) {
		this.core = core;
		this.timeManager = new KitTimeManager(this);
	}

	/**
	 * Adds a kit to a NexusPlayer, Construct a new kit Object of your kit and add it. (this an example of {@link Tier2ExampleKit})
	 * @param np The {@link NexusPlayer} to add the kit to.
	 */
	public void addKitToPlayer(NexusPlayer np){
		Kit kit = new Tier2ExampleKit(this, np);
		np.setKit(kit);
	}
	
	
	public void processKitTimers(){
		for(NexusPlayer np : core.getPlayerManager().getPlayers()){
			np.getKit().timerTick();
		}
	}
}
