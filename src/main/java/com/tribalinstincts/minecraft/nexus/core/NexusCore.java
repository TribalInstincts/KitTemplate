package com.tribalinstincts.minecraft.nexus.core;

import org.bukkit.plugin.PluginManager;

import com.tribalinstincts.minecraft.nexus.modules.kit.KitManager;

/**
 * 
 * The core of the plugin.
 *
 */
public class NexusCore {
	
	KitTemplate plugin;
	PluginManager pluginManager;
	
	NexusPlayerManager playerManager;
	KitManager kitManager;

	/**
	 * Initializes the core.
	 * @param plugin Main class of the plugin ({@link KitTemplate}).
	 * @see NexusPlayerManager
	 * @see KitManager
	 */
	public NexusCore(KitTemplate plugin){
		this.plugin = plugin;
		this.pluginManager = plugin.getServer().getPluginManager();
		this.playerManager = new NexusPlayerManager(this);
		this.kitManager = new KitManager(this);
	}

	/**
	 * Gets the {@link PluginManager} of the plugin.
	 * @return The plugin's PluginManager.
	 */
	public PluginManager getPluginManager(){
		return this.pluginManager;
	}

	/**
	 * Gets the {@link NexusPlayerManager} of the plugin.
	 * @return The plugin's NexusPlayerManager.
	 */
	public NexusPlayerManager getPlayerManager(){
		return this.playerManager;
	}

	/**
	 * Gets the {@link KitTemplate} (Main plugin class).
	 * @return The plugin.
	 */
	public KitTemplate getPlugin() {
		return this.plugin;
	}

	/**
	 * Gets the {@link KitManager} of the plugin.
	 * @return The KitManager.
	 */
	public KitManager getKitManager() {
		return this.kitManager;
	}
}
