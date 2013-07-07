package com.tribalinstincts.minecraft.nexus.core;

import org.bukkit.entity.Player;

import com.tribalinstincts.minecraft.nexus.modules.kit.kits.Kit;

public class NexusPlayer {

	NexusCore core;
	Player player;
	Kit kit;
	
	NexusPlayer(NexusCore core, Player player){
		this.core = core;
		this.player = player;
		core.getKitManager().addKitToPlayer(this);
	}
	
	public void setKit(Kit kit){
		this.kit = kit;
	}
	
	public NexusCore getCore(){
		return this.core;
	}
	
	public Player getPlayer(){
		return this.player;
	}

	NexusPlayer lastDamageBy;
	public void damageTakenFromPlayer(NexusPlayer nPlayer) {
		this.lastDamageBy = nPlayer;
		
	}

	public NexusPlayer getLastDamageBy() {
		return this.lastDamageBy;
	}
}
