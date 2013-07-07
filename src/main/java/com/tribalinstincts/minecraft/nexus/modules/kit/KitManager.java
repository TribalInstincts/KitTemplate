package com.tribalinstincts.minecraft.nexus.modules.kit;

import com.tribalinstincts.minecraft.nexus.core.NexusCore;
import com.tribalinstincts.minecraft.nexus.core.NexusPlayer;
import com.tribalinstincts.minecraft.nexus.modules.kit.kits.Kit;
import com.tribalinstincts.minecraft.nexus.modules.kit.kits.Tier2ExampleKit;

public class KitManager {

	NexusCore core;
	public KitManager(NexusCore core) {
		this.core = core;
	}

	public void addKitToPlayer(NexusPlayer np){
		Kit kit = new Tier2ExampleKit(this, np);
		
		np.setKit(kit);
	}
}
