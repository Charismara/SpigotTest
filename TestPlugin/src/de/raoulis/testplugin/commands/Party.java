package de.raoulis.testplugin.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.raoulis.testplugin.party.GroupParty;
import de.raoulis.testplugin.util.Log;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class Party {
	
	public static void partyCommand(CommandSender sender, String[] arg) {
		if (sender instanceof Player) {
			if (arg.length == 0) {
				//Create Text Messages
				TextComponent t0 = new TextComponent("M\u00f6chtest du ");
				TextComponent t1 = new TextComponent(" oder ");
				TextComponent create = new TextComponent("[Erstellen] ");
				TextComponent invite = new TextComponent("[Einladen]");
				TextComponent leave = new TextComponent("[Verlassen]");
				
				//set Click events
				create.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/party create"));
				invite.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/party invite"));
				leave.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/party leave"));
				
				//combine all Messages to one
				t0.addExtra(create);
				t0.addExtra(invite);
				t0.addExtra(t1);
				t0.addExtra(leave);
				
				//send Message
				sender.spigot().sendMessage(t0);
			} else {
				
				if (arg[0].equalsIgnoreCase("create")) {
					Player player = (Player) sender;
					GroupParty.createParty(player);
					sender.sendMessage("Team erstellt.");
				}
				if (arg[0].equalsIgnoreCase("invite")) {

				}
				if (arg[0].equalsIgnoreCase("leave")) {

				}
			}
		} else {
			Log.log("Dieser Befehl ist nicht als Konsole nutzbar.");
		}
	}
}
