package de.raoulis.testplugin.handler;

import java.io.File;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.entity.Player;

import de.raoulis.testplugin.Main;
import de.raoulis.testplugin.PlayerInfo.PlayerStats;

public class PlayerDataHandler {
	private static Main PLUGIN = Main.getPlugin(Main.class);
	public static File USERDATA = new File(PLUGIN.getDataFolder() + "/userdata.bin");
	@SuppressWarnings("unused")
	public static Logger LOGGER = PLUGIN.getLogger();
	
	//Register Player on First Join in DataFile
	public static void registerPlayerInFile(Player player) {
		//Get Player UUID
		String uuid = PlayerStats.getUUID(player);
		//Data with Player UUID
		Map<String, Map<String,String>> data_full = new HashMap<String, Map<String,String>>();
		//Data only
		Map<String, String> data = new HashMap<String, String>();
		
		String date = LocalDateTime.now().toString();
		
		
		//add Data
		data.put("first_join", date);
		
		//add Data to Data with Player UUID
		data_full.put(uuid, data);
		
		try {
			//write Data with Player UUID into file
			FileHandler.save(data_full, USERDATA);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
