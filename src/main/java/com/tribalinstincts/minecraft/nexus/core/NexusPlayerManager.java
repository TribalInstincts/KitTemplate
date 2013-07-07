package com.tribalinstincts.minecraft.nexus.core;

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

public class NexusPlayerManager implements Listener{

	NexusCore core;
	Map<String, NexusPlayer> players = new HashMap<String, NexusPlayer>();
	
	public NexusPlayerManager(NexusCore core) {
		this.core = core;
		this.core.getPluginManager().registerEvents(this, core.getPlugin());
	}

	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent event){
		this.players.put(event.getPlayer().getName(), new NexusPlayer(core, event.getPlayer()));
	}
	
	@EventHandler
	public void onPlayerQuitEvent(PlayerQuitEvent event){
		this.players.remove(event.getPlayer().getName());
	}
	
	public NexusPlayer getNPlayer(Player player){
		return this.getNPlayer(player.getName());
	}
	public NexusPlayer getNPlayer(String playerName){
		return this.players.get(playerName);
	}
	
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
}
