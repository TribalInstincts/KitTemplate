package com.tribalinstincts.minecraft.nexus.modules.kit.kits;

import java.util.Date;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.tribalinstincts.minecraft.nexus.core.NexusPlayer;
import com.tribalinstincts.minecraft.nexus.modules.kit.KitManager;

public class Tier2ExampleKit extends Kit {
	
	public static String Name = "Tier2";
	public static int Tier = 2;
	public static String Description = "Something crazy happens!!";
	
    public Tier2ExampleKit(KitManager manager, NexusPlayer np) {
    	super(manager, np);
		np.getCore().getPluginManager().registerEvents(this, np.getCore().getPlugin());
    }


	@EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
	public void onPlayerToggleSneakEvent(PlayerToggleSneakEvent event) {
		if(event.isSneaking()){
			event.getPlayer().setVelocity(event.getPlayer().getLocation().getDirection().multiply(7));
			event.getPlayer().setFallDistance(0);
		}
	}
	
	@EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
	public void onEntityDamageEvent(EntityDamageEvent event) {
		if(event.getCause() == DamageCause.FALL){
			createCrater(event.getEntity().getFallDistance());
		}
		event.setCancelled(true);
	}
	
	private void createCrater(float strength){
		float explosionStrength = (strength / 3) /2;
		if(explosionStrength <= 1) return;
		Location explosionLocation = np.getPlayer().getLocation().clone();
		np.getPlayer().getWorld().createExplosion(explosionLocation, explosionStrength);
	}
}
