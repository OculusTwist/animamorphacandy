package me.oculustwist.utils;

import org.bukkit.Bukkit;

public class ConsoleUtils {
	
	public static void sendConsoleCommand(String cmd){
		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), cmd);
	}

}
