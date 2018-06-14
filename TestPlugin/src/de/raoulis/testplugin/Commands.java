package de.raoulis.testplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.raoulis.testplugin.PlayerInfo.PlayerStats;
import de.raoulis.testplugin.util.Logger;

public class Commands implements CommandExecutor {
	
	public Commands() {
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] arg) {
		if (cmd.getName().equalsIgnoreCase("ustats")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				
							
				sender.sendMessage("Dein Username ist " + PlayerStats.getUsername(player));
				sender.sendMessage("Deine UUID ist " + PlayerStats.getUUID(player));
				sender.sendMessage("Deine Spielzeit ist " + PlayerStats.getPlaytime(player));
				try {
					sender.sendMessage("Erster Join: " + PlayerStats.getFirstJoin(player, 1) + " um " + PlayerStats.getFirstJoin(player, 2) + " Uhr");
				} catch (Exception e) {
					e.printStackTrace();
				}
				sender.sendMessage("Du bist " + PlayerStats.getWalked(player) + " Meter gelaufen");
				sender.sendMessage("Du hast " + PlayerStats.getKilledMobs(player) + " Kreaturen get\u00f6tet");
				return true;
			}
			Logger.log("Dieser Befehl ist nicht als Konsole nutzbar.");
		}
		return false;
	}

}
