package de.raoulis.testplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.raoulis.testplugin.commands.Party;
import de.raoulis.testplugin.commands.Ttp;
import de.raoulis.testplugin.commands.Ustats;

public class Commands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] arg) {
		if (cmd.getName().equalsIgnoreCase("ustats")) {
			Ustats.userstats(sender);
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("party")) {
			Party.partyCommand(sender, arg);
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("ttp")) {
			Ttp.testTeleport();
			return true;
		}
		
		return false;
	}

}
