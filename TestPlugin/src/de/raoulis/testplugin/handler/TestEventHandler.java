package de.raoulis.testplugin.handler;

import org.bukkit.entity.Player;
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
	public static void onPlayerJoin(PlayerJoinEvent e) throws Exception {
		// Register Player in Datafile if not exist
		Player player = e.getPlayer();
		if (!player.hasPlayedBefore()) {
			PlayerDataHandler.registerPlayerInFile(e.getPlayer());
		}
		PlayerDataHandler.updateLastJoin(player);
		
	}

	@EventHandler
	public static void onPlayerLeave(PlayerQuitEvent e) throws NumberFormatException, Exception {
		Player player = e.getPlayer();
		PlayerDataHandler.updateLastleave(player);
		PlayerDataHandler.updatePlaytime(player);
	}

}
