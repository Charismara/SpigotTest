package de.raoulis.testplugin.handler;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import de.raoulis.testplugin.Main;
import de.raoulis.testplugin.party.GroupParty;
import de.raoulis.testplugin.util.Log;

@SuppressWarnings("deprecation")
public class TestEventHandler implements Listener {
	public static JavaPlugin plugin = Main.getPlugin(Main.class);

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
		// Update last join date
		PlayerDataHandler.updateLastJoin(player);
	}

	@EventHandler
	public static void onPlayerLeave(PlayerQuitEvent e) throws NumberFormatException, Exception {
		Player player = e.getPlayer();
		// update last leave date
		PlayerDataHandler.updateLastleave(player);
		// update total playtime
		PlayerDataHandler.updatePlaytime(player);
	}

	@EventHandler
	public static void onPlayerDmg(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player player = (Player) e.getEntity();
			GroupParty.updateScoreboard(player);
		}
	}

	@EventHandler
	public static void onPlayerHeal(EntityRegainHealthEvent e) {
		if (e.getEntity() instanceof Player) {
			Player player = (Player) e.getEntity();
			if (player.getScoreboard() != null) {
				GroupParty.updateScoreboard(player);
			}
		}
	}

	@EventHandler
	public static void onPlayerChat(PlayerChatEvent e) {
		Log.logInfo(e.getPlayer().toString() + " hat " + e.getMessage() + " geschrieben.");
	}
}
