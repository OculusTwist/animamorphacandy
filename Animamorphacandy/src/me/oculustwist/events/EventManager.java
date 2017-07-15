package me.oculustwist.events;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import me.oculustwist.main.Animamorphacandy;

public class EventManager {
	
	private static Animamorphacandy main;
	
	public EventManager(Animamorphacandy main){
		EventManager.main = main;
		EventManager.setup();
	}
	
	public static void setup(){
		PluginManager pm = Bukkit.getPluginManager();
		
		pm.registerEvents(new EventPlayerJoin(), main);
		pm.registerEvents(new EventPlayerEat(), main);
	}

}
