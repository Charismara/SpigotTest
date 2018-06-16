package de.raoulis.testplugin.PlayerInfo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.bukkit.Statistic;
import org.bukkit.entity.Player;

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

	public static String getPlaytime(Player player) throws Exception {
		
		String playtime = PlayerDataHandler.getDataFromFile(player, "playtime", PlayerDataHandler.USERDATA);
		//old playtime
		long t0 = Long.parseLong(playtime);
		//last join
		long t1 = Long.parseLong(PlayerDataHandler.getDataFromFile(player, "join", PlayerDataHandler.USERDATA));
		//current  time
		long t2 = System.currentTimeMillis();
		//current playtime 
		long t3 = t2 - t1;
		//new playtime
		long t = t0 + t3;
		
		//convert into a HH:mm:ss format
		Date d = new Date(t - TimeUnit.HOURS.toMillis(1));
		
		DateFormat formatter = new SimpleDateFormat("HH:mm:ss:SSS");		
		String ptime = formatter.format(d);
		
		return ptime.substring(0, 8);
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

	public static String getFirstJoin(Player player, int type) throws Exception {
		String date_time = PlayerDataHandler.getDataFromFile(player, "firstjoin", PlayerDataHandler.USERDATA);

		if (type == 1) {
			// return Date
			String date = date_time.substring(0, 10);
			return date;
		}
		if (type == 2) {
			// return time
			String time = date_time.substring(11, 19);
			return time;
		} else {
			// return "date" + "T" + "time"
			return date_time;
		}
	}
}
