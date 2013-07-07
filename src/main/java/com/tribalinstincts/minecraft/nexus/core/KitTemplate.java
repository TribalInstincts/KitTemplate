package com.tribalinstincts.minecraft.nexus.core;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class KitTemplate extends JavaPlugin {
	
	NexusCore core;
	
	@Override
	public void onEnable() {
		this.core = new NexusCore(this);
		Bukkit.getLogger().info("KitTemplate loaded!");
	}

	@Override
	public void onDisable() {

	}
}
