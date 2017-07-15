package me.oculustwist.main;

import org.bukkit.plugin.java.JavaPlugin;

import me.oculustwist.commands.CommandManager;
import me.oculustwist.events.EventManager;
import me.oculustwist.permissions.PermissionSetup;
import me.oculustwist.utils.ConfigUtils;

public class Animamorphacandy extends JavaPlugin{
	
	private static Animamorphacandy instance;
	static double version = 1.0;
	
	@Override
	public void onEnable(){
		ConfigUtils.writeMessages();
		ConfigUtils.writeConfig();
		setupPermissions();
		
		new EventManager(this);
		new CommandManager(this);
		instance = this;
	}
	
	@Override
	public void onDisable(){
		
	}
	
	public static Animamorphacandy getInstance(){
		return instance;
	}
	
	public static void setupPermissions(){
		PermissionSetup.setup();
	}
	
	public static double getVersion(){
		return version;
	}

}
