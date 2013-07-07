package com.tribalinstincts.minecraft.nexus.core;

import org.bukkit.plugin.PluginManager;

import com.tribalinstincts.minecraft.nexus.modules.kit.KitManager;

public class NexusCore {
	
	KitTemplate plugin;
	PluginManager pluginManager;
	
	NexusPlayerManager playerManager;
	KitManager kitManager;
	
	
	public NexusCore(KitTemplate plugin){
		this.plugin = plugin;
		this.pluginManager = plugin.getServer().getPluginManager();
		this.playerManager = new NexusPlayerManager(this);
		this.kitManager = new KitManager(this);
	}
	
	public PluginManager getPluginManager(){
		return this.pluginManager;
	}
	
	public NexusPlayerManager getPlayerManager(){
		return this.playerManager;
	}

	public KitTemplate getPlugin() {
		return this.plugin;
	}

	public KitManager getKitManager() {
		return this.kitManager;
	}
}
