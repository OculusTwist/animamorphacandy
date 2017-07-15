package me.oculustwist.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.oculustwist.config.Config;
import me.oculustwist.config.MessagesConfig;
import me.oculustwist.main.Animamorphacandy;
import me.oculustwist.utils.ConfigUtils;
import me.oculustwist.utils.Messages;

public class CommandAMC implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		//Check if the sender is a player
		if(sender instanceof Player){
			
			//Check if the command is equal to amc
			if(cmd.getName().equalsIgnoreCase("amc")){
				
				Player p = (Player) sender;
				int length = args.length;
				String usage = "/amc toggle/version/reload";
				
				//Check if the length is 1 argument
				if(length == 1){
					
					//Check if the first argument is toggle
					if(args[0].toString().equalsIgnoreCase("toggle")){
						
						if(p.hasPermission("amc.toggle")){
						Config c = new Config("config.yml");
						
						//Check if this config exists
						if(c.exists()){
							
							FileConfiguration f = c.getConfig();
							
							//If Animamorphacandy is enabled then disable (toggle)
							if(f.getBoolean("enabled")){
								f.set("enabled", false);
								c.saveConfig();
								p.sendMessage(ChatColor.AQUA + "[AMC] " + ChatColor.GRAY + "Animamorphacandy has been disabled!");
							}else{
							//If Animamorphacandy is disabled then enable (toggle)
								f.set("enabled", true);
								c.saveConfig();
								p.sendMessage(ChatColor.AQUA + "[AMC] " + ChatColor.GRAY + "Animamorphacandy has been enabled!");
							}
							
							
						}else{
							ConfigUtils.writeConfig();
						}
						}else{
							Messages.insufficientPerms(p);
						}
						
					}else if(args[0].toString().equalsIgnoreCase("version")){
						p.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "--------------------");
						p.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "Author: " + ChatColor.WHITE + "OculusTwist");
						p.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "Version: " + ChatColor.WHITE + Animamorphacandy.getVersion());
						p.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "--------------------");
					}else if(args[0].toString().equalsIgnoreCase("reload")){
						
						Config c = new Config("config.yml");
						MessagesConfig mc = new MessagesConfig("messages.yml");
						
						if(c.exists() && mc.exists()){
						
						c.reload();
						mc.reload();
						}else{
							p.sendMessage(ChatColor.AQUA + "[AMC] " + ChatColor.GRAY + "Configuration files do not exist. Try reinstalling the plugin!");
						}
						
						p.sendMessage(ChatColor.AQUA + "[AMC]" + ChatColor.GRAY + " Configuration files successfully reloaded.");
						
					}else{
						Messages.invalidUsage(p, usage);
					}
					
				}else{
					//If the length is not equal to 1 argument
					Messages.invalidUsage(p, usage);
				}
				
				return true;
				
			}
			
		}else{
			//If the sender is not a player, execute this
			Messages.invalidSender(sender);
		}
		
		return false;
	}
	
	

}
