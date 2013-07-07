package com.tribalinstincts.minecraft.nexus.modules.kit.kits;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import com.tribalinstincts.minecraft.nexus.core.NexusPlayer;
import com.tribalinstincts.minecraft.nexus.modules.kit.KitManager;
/**
 * A tier two kit example.
 *
 * @see Kit
 */
public class Tier2ExampleKit extends Kit {
	
	public static String Name = "Tier2";
	public static int Tier = 2;
	public static String Description = "Something crazy happens!!";
	
	/**
	 * Initializes the kit for the player.
	 * @param manager The {@link KitManager} of the plugin.
	 * @param np The {@link NexusPlayer} to initialize the kit for.
	 */
    public Tier2ExampleKit(KitManager manager, NexusPlayer np) {
    	super(manager, np);
		np.getCore().getPluginManager().registerEvents(this, np.getCore().getPlugin());
    }

    /**
     * On player toggle sneak shoots them in the direction they are looking at.
     * @param event Event passed to the method.
     */
	@EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
	public void onPlayerToggleSneakEvent(PlayerToggleSneakEvent event) {
		if(!isEntityThisPlayer(event.getPlayer())) return;
		if(event.isSneaking()){
			event.getPlayer().setVelocity(event.getPlayer().getLocation().getDirection().multiply(7));
			event.getPlayer().setFallDistance(0);
		}
	}
	
	/**
	 * On entity damage if the cause is fall damage, then create a crater.
	 * @param event Event passed to the method.
	 */
	@EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
	public void onEntityDamageEvent(EntityDamageEvent event) {
		if(!isEntityThisPlayer(event.getEntity())) return;
		if(event.getCause() == DamageCause.FALL){
			createCrater(event.getEntity().getFallDistance());
		}
		event.setCancelled(true);
	}
	
	/**
	 * Creates a crater.
	 * @param strength Explosion strength.
	 * @return If explosion strength is less than 1.
	 */
	private void createCrater(float strength){
		float explosionStrength = (strength / 3) /2;
		if(explosionStrength <= 1) return;
		Location explosionLocation = np.getPlayer().getLocation().clone();
		np.getPlayer().getWorld().createExplosion(explosionLocation, explosionStrength);
	}
}
