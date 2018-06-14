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
	public static Logger LOGGER = PLUGIN.getLogger();

	// Register Player on First Join in DataFile
	public static void registerPlayerInFile(Player player) throws Exception {
		String uuid = PlayerStats.getUUID(player);
		String date = LocalDateTime.now().toString();

		updateUserDataFile(uuid, "firstjoin", date);
		updateUserDataFile(uuid, "playtime", "0");
	}

	public static void updateLastJoin(Player player) throws Exception {
		String uuid = PlayerStats.getUUID(player);
		String time = String.valueOf(System.currentTimeMillis());

		updateUserDataFile(uuid, "join", time);
	}

	public static void updateLastleave(Player player) throws Exception {
		String uuid = PlayerStats.getUUID(player);
		String time = String.valueOf(System.currentTimeMillis());

		updateUserDataFile(uuid, "left", time);
	}

	public static void updatePlaytime(Player player) throws NumberFormatException, Exception {
		String uuid = PlayerStats.getUUID(player);
		long time0 = calcNewPlayTime(player);
		long time1 = Long.parseLong(getDataFromFile(player, "playtime", USERDATA));
		long time2 = time0 + time1;

		String value = String.valueOf(time2);

		updateUserDataFile(uuid, "playtime", value);
	}

	@SuppressWarnings("unchecked")
	private static void updateUserDataFile(String uuid, String key, String value) throws Exception {
		// Data with Player UUID
		Map<String, Map<String, String>> data_full;
		Map<String, String> data ;
		
		if (PlayerDataHandler.USERDATA.exists()) {
			data_full = (Map<String, Map<String, String>>) FileHandler.load(PlayerDataHandler.USERDATA);
			// Data only
			data = data_full.get(uuid);
		} else {
			data_full = new HashMap<String, Map<String, String>>();
			// Data only
			data = new HashMap<String, String>();
		}

		// insert key and value into data
		data.put(key, value);

		// insert uuid and data into data with uuid
		data_full.put(uuid, data);

		try {
			// write Data with Player UUID into file
			FileHandler.save(data_full, USERDATA);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static long calcNewPlayTime(Player player) throws NumberFormatException, Exception {
		long time1 = Long.parseLong(getDataFromFile(player, "left", USERDATA));
		long time2 = Long.parseLong(getDataFromFile(player, "join", USERDATA));
		long time = time1 - time2;
		return time;
	}

	@SuppressWarnings("unchecked")
	public static String getDataFromFile(Player player, String key, File file) throws Exception {
		String playeruuid = PlayerStats.getUUID(player);
		// Get Data with UUID
		Map<String, Map<String, String>> data_full = (Map<String, Map<String, String>>) FileHandler
				.load(PlayerDataHandler.USERDATA);
		// Get Data from UUID
		Map<String, String> data = data_full.get(playeruuid);
		// Get value of Key
		String returndata = data.get(key);

		if (returndata == null) {
			PlayerDataHandler.LOGGER.info("[ERROR] " + data_full.toString());
			PlayerDataHandler.LOGGER.info("[ERROR] " + data.toString());
			PlayerDataHandler.LOGGER.info("[ERROR] " + returndata);
			return null;
		} else {
			return returndata;
		}
	}
}
