package de.raoulis.testplugin;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import de.raoulis.testplugin.handler.TestEventHandler;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable(){
		final long start = System.currentTimeMillis();
		this.getLogger().info("Lade Plugin...");
		
		load();
		
		final long end = System.currentTimeMillis();
		final long dauer = end - start;
		this.getLogger().info("Plugin innerhalb von "+ dauer + "ms geladen.");
	}
	
	@Override
	public void onDisable() {
		TestEventHandler.onServerStop();
		this.getLogger().info("Plugin ist deaktiviert.");
	}
	
	
	public void load() {
		TestEventHandler.onServerStart();
		getServer().getPluginManager().registerEvents(new TestEventHandler(), this);
		getCommand("ustats").setExecutor(new Commands());
	}
	
	public Plugin getPlugin() {
		Plugin plugin = this.getPlugin();
		return plugin;
	}
}
