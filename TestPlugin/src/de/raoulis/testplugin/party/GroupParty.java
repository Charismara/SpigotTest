package de.raoulis.testplugin.party;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class GroupParty {
	private static Scoreboard board;
	private static Objective obj;
	public static Score score;
	@SuppressWarnings("deprecation")
	public static void createParty(Player player) {
		board = Bukkit.getServer().getScoreboardManager().getNewScoreboard();
		obj = board.registerNewObjective("hp", "dummy");
		obj.setDisplayName("Team");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		score = obj.getScore(Bukkit.getServer().getOfflinePlayer(player.getDisplayName() + ": "));
		int s = (int) player.getHealth();
		score.setScore(s);
		player.setScoreboard(board);
	}
	
	public static void inviteParty(Player sender, Player player) {
		
	}
	
	public static void updateScoreboard(Player player) {
		Scoreboard s = player.getScoreboard();
		Score score = (Score) s.getObjective("hp").getScore(player.getDisplayName() + ": ");
		
		double s0 = player.getHealth();
		int s1 = getHP(s0);
		
		score.setScore(s1);
	}
	
	private static int getHP(double hp) {
		if (hp >= 1.5) {
			if (hp >= 2.5) {
				if (hp >= 3.5) {
					if (hp >= 4.5) {
						if (hp >= 5.5) {
							if (hp >= 6.5) {
								if (hp >= 7.5) {
									if (hp >= 8.5) {
										if (hp >= 9.5) {
											if (hp >= 10.5) {
												if (hp >= 11.5) {
													if (hp >= 12.5) {
														if (hp >= 13.5) {
															if (hp >= 14.5) {
																if (hp >= 15.5) {
																	if (hp >= 16.5) {
																		if (hp >= 17.5) {
																			if (hp >= 18.5) {
																				if (hp >= 19.5) {
																					return 20;
																				}
																			} else {
																				return 19;
																			}
																		} else {
																			return 18;
																		}
																	} else {
																		return 17;
																	}
																} else {
																	return 16;
																}
															} else {
																return 15;
															}
														} else {
															return 14;
														}
													} else {
														return 13;
													}
												} else {
													return 12;
												}
											} else {
												return 11;
											}
										} else {
											return 10;
										}
									} else {
										return 9;
									}
								} else {
									return 8;
								}
							} else {
								return 7;
							}
						} else {
							return 6;
						}
					} else {
						return 5;
					}
				} else {
					return 4;
				}
			} else {
				return 3;
			}
		} else {
			return 2;
		}
		return 1;
	}
}
