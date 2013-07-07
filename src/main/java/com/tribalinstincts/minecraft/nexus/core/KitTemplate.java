package com.tribalinstincts.minecraft.nexus.core;

import org.bukkit.Bukkit;

import org.bukkit.plugin.java.JavaPlugin;
/**
 * 
 * Main class of the plugin.
 *
 */
public class KitTemplate extends JavaPlugin {
	
	NexusCore core;

	/**
	 * Called when the plugin enables.
	 */
	@Override
	public void onEnable() {
		this.core = new NexusCore(this);
		Bukkit.getLogger().info("KitTemplate loaded!");
	}

	/**
	 * Called when the plugin disables.
	 */
	@Override
	public void onDisable() {

	}
}
