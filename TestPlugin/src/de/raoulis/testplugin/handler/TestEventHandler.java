package de.raoulis.testplugin.handler;

import java.io.IOException;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class TestEventHandler implements Listener {

	public static void onServerStart() {
	}

	public static void onServerStop() {
	}

	@EventHandler
	public static void onPlayerJoin(PlayerJoinEvent e) throws IOException {
		// Register Player in Datafile if not exist
		if (!e.getPlayer().hasPlayedBefore()) {
			PlayerDataHandler.registerPlayerInFile(e.getPlayer());
		}
		
	}

	@EventHandler
	public static void onPlayerLeave(PlayerQuitEvent e) throws IOException {
	}

}
