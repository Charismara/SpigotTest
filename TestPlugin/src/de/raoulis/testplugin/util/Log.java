package de.raoulis.testplugin.util;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;

import de.raoulis.testplugin.Main;

public class Log {
	private static ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
	private static Main PLUGIN = Main.getPlugin(Main.class);
	private static Logger LOGGER = PLUGIN.getLogger();

	public Log() {
		
	}
	public static void log(String msg) {
		console.sendMessage(msg);
	}
	public static void logInfo(String msg) {
		LOGGER.info(msg);
	}
}
