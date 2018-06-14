package de.raoulis.testplugin.util;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;

public class Logger {
	private static ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

	public Logger() {
		
	}
	public static void log(String msg) {
		console.sendMessage(msg);
	}
}
