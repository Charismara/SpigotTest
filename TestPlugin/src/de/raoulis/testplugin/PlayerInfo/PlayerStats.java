package de.raoulis.testplugin.PlayerInfo;

import java.util.Map;

import org.bukkit.Statistic;
import org.bukkit.entity.Player;

import de.raoulis.testplugin.handler.FileHandler;
import de.raoulis.testplugin.handler.PlayerDataHandler;

public class PlayerStats {

	public static String getUsername(Player player) {
		String name = player.getName().toString();
		return name;
	}

	public static String getUUID(Player player) {
		String uuid = player.getUniqueId().toString();
		return uuid;
	}

	public static String getPlaytime(Player player) {

		String playtime = String.valueOf(player.getStatistic(Statistic.RECORD_PLAYED));
		;
		return playtime;
	}

	public static String getWalked(Player player) {

		int cm_walked = player.getStatistic(Statistic.WALK_ONE_CM);
		// cm --> m
		int m_walked = cm_walked / 100;
		// int to String
		String blocks_walked = String.valueOf(m_walked);

		return blocks_walked;
	}

	public static String getKilledMobs(Player player) {
		String mobs = String.valueOf(player.getStatistic(Statistic.MOB_KILLS));
		return mobs;
	}

	@SuppressWarnings("unchecked")
	public static String getFirstJoin(Player player, int type) throws Exception {
		String uuid = getUUID(player);
		// Get Data with UUID
		Map<String, Map<String, String>> data_full = (Map<String, Map<String, String>>) FileHandler
				.load(PlayerDataHandler.USERDATA);
		// Get Data from UUID
		Map<String, String> data = data_full.get(uuid);

		String date_time = data.get("frist_join");
		
		if(date_time == null) {
			PlayerDataHandler.LOGGER.info(data_full.toString());
			PlayerDataHandler.LOGGER.info(data.toString());
			PlayerDataHandler.LOGGER.info(date_time);
			return null;
		}
		if (type == 1) {
			//return Date
			String date = date_time.substring(0, 13);
			return date;
		} if (type == 2) {
			//return time
			String time = date_time.substring(11);
			return time;
		} else {
			//return "date" + "T" + "time"
			return date_time;
		}
	}
}
