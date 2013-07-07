package com.tribalinstincts.minecraft.nexus.core;

import org.bukkit.entity.Player;

import com.tribalinstincts.minecraft.nexus.modules.kit.kits.Kit;

public class NexusPlayer {

	NexusCore core;
	Player player;
	Kit kit;

	/**
	 * Initializes the NexusPlayer.
	 * @param core The core of the plugin {@link NexusCore}.
	 * @param player The player {@link Player}.
	 */
	NexusPlayer(NexusCore core, Player player){
		this.core = core;
		this.player = player;
		core.getKitManager().addKitToPlayer(this);
	}
	
	/**
	 * Sets the {@link Kit} of the NexusPlayer.
	 * @param kit The Kit to set the player to.
	 */
	public void setKit(Kit kit){
		this.kit = kit;
	}

	/**
	 * Get the {@link NexusCore} of the plugin.
	 * @return The NexusCore.
	 */
	public NexusCore getCore(){
		return this.core;
	}
	
	/**
	 * Gets the {@link Player} stored as a Nexus Player.
	 * @return The player.
	 */
	public Player getPlayer(){
		return this.player;
	}

	NexusPlayer lastDamageBy;
	
	/**
	 * Set the player this player last took damage from.
	 * @param nPlayer The player that last damaged this player.
	 */
	public void damageTakenFromPlayer(NexusPlayer nPlayer) {
		this.lastDamageBy = nPlayer;
		
	}
	
	/**
	 * Get the player that last damaged this player.
	 * @return The player that last damaged this player.
	 */
	public NexusPlayer getLastDamageBy() {
		return this.lastDamageBy;
	}
}
