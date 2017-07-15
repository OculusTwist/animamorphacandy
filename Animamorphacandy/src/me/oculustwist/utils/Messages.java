package me.oculustwist.utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.oculustwist.config.MessagesConfig;

public class Messages {
	
	static MessagesConfig mc = new MessagesConfig("messages.yml");
	
	public static void insufficientPerms(Player p){
		if(mc.exists()){
			FileConfiguration f = mc.getConfig();
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', f.getString("insufficientPermissions")));
			return;
		}else{
			p.sendMessage(ChatColor.RED + "An unexpected error has occured. Try relogging.");
			return;
		}
	}
	
	public static void invalidSender(CommandSender sender){
		if(mc.exists()){
			FileConfiguration f = mc.getConfig();
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', f.getString("invalidSender")));
			return;
		}else{
			sender.sendMessage(ChatColor.RED + "An unexpected error has occured. Try relogging.");
			return;
		}
	}
	
	public static void invalidUsage(Player p, String usage){
		if(mc.exists()){
			FileConfiguration f = mc.getConfig();
			
			if(!f.getString("invalidUsage").contains("%usage%")){
				p.sendMessage("An unexpected error has occured. Configuration incorrect!");
				return;
			}
			
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', f.getString("invalidUsage").replace("%usage%", usage)));
			return;
		}else{
			p.sendMessage(ChatColor.RED + "An unexpected error has occured. Try relogging.");
			return;
		}
	}

}
