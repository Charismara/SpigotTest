package de.raoulis.testplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	@Override
	public void onEnable(){
		this.getLogger().info("Lade Plugin...");
		
		this.getLogger().info("Plugin geladen.");
	}
	
	@Override
	public void onDisable() {
		this.getLogger().info("Plugin ist deaktiviert.");
	}
}
