package me.oculustwist.permissions;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class PermissionSetup extends Permissions{
	
	public static void setup(){
		PluginManager pm = Bukkit.getPluginManager();
		
		pm.addPermission(pm1);
		pm.addPermission(pm2);
		pm.addPermission(pm3);
	}

}
