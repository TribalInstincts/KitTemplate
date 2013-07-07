package com.tribalinstincts.minecraft.nexus.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * 
 * Manages all the NexusPlayers.
 *
 */
public class NexusPlayerManager implements Listener{

	NexusCore core;
	Map<String, NexusPlayer> players = new HashMap<String, NexusPlayer>();
	
	/**
	 * Initializes the NexusPlayerManager.
	 * @param core The {@link NexusCore} of the plugin.
	 */
	public NexusPlayerManager(NexusCore core) {
		this.core = core;
		this.core.getPluginManager().registerEvents(this, core.getPlugin());
	}

	/**
     * On player join game add player to the "players" Map.
     * @param event Event passed to the method.
     */
	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent event){
		this.players.put(event.getPlayer().getName(), new NexusPlayer(core, event.getPlayer()));
	}
	
	/**
     * On player quit game remove player from the "players" Map.
     * @param event Event passed to the method.
     */
	@EventHandler
	public void onPlayerQuitEvent(PlayerQuitEvent event){
		this.players.remove(event.getPlayer().getName());
	}
	
	/**
	 * Gets the {@link NexusPlayer} object attached to this player.
	 * @param player The player to get the NexusPlayer object from.
	 * @return The NexusPlayer.
	 */
	public NexusPlayer getNPlayer(Player player){
		return this.getNPlayer(player.getName());
	}
	
	/**
	 * Gets the {@link NexusPlayer} object attached to this player's name.
	 * @param playerName The player's name to get the NexusPlayer object from.
	 * @return The NexusPlayer.
	 */
	public NexusPlayer getNPlayer(String playerName){
		return this.players.get(playerName);
	}
	
	/**
	 * Sets the lastDamageBy in the {@link NexusPlayer}.
	 * @param event Event passed to this method.
	 * @return If entity is not a player or if the {@link NexusPlayer} is null.
	 */
	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
	void onEntityDamageEvent(EntityDamageByEntityEvent event){
		if(event.getEntity() instanceof Player == false) return;
		NexusPlayer np = this.getNPlayer((Player)event.getEntity());
		if(np == null) return;
		Entity damager = event.getDamager();
		if(damager instanceof Player){
			np.damageTakenFromPlayer(this.getNPlayer(((Player)damager)));
		} else if (damager instanceof Arrow){
			if(((Arrow)damager).getShooter() instanceof Player){
				np.damageTakenFromPlayer(this.getNPlayer((Player)((Arrow)damager).getShooter()));
			}
		} 
	}

	public Collection<NexusPlayer> getPlayers() {
		return this.players.values();
	}
}
