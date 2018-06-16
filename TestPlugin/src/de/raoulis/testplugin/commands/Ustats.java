package de.raoulis.testplugin.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.raoulis.testplugin.PlayerInfo.PlayerStats;
import de.raoulis.testplugin.util.Log;

public class Ustats {
	public static void userstats(CommandSender sender) {
		if (sender instanceof Player) {
			Player player = (Player) sender;

			sender.sendMessage("Dein Username ist " + PlayerStats.getUsername(player));
			sender.sendMessage("Deine UUID ist " + PlayerStats.getUUID(player));
			try {
				sender.sendMessage("Deine Spielzeit ist " + PlayerStats.getPlaytime(player));
				sender.sendMessage("Erster Join: " + PlayerStats.getFirstJoin(player, 1) + " um "
						+ PlayerStats.getFirstJoin(player, 2) + " Uhr");

			} catch (Exception e1) {
				e1.printStackTrace();
			}
			sender.sendMessage("Du bist " + PlayerStats.getWalked(player) + " Meter gelaufen");
			sender.sendMessage("Du hast " + PlayerStats.getKilledMobs(player) + " Kreaturen get\u00f6tet");
		} else {
			Log.log("Dieser Befehl ist nicht als Konsole nutzbar.");				
		}
	}

}
