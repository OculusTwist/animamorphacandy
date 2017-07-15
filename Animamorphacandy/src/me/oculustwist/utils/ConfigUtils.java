package me.oculustwist.utils;

import java.util.ArrayList;

import org.bukkit.configuration.file.FileConfiguration;

import me.oculustwist.config.Config;
import me.oculustwist.config.MessagesConfig;

public class ConfigUtils {
	
	public static void writeMessages(){
		
		MessagesConfig mc = new MessagesConfig("messages.yml");
		
		if(!mc.exists()){
			
			FileConfiguration f = mc.getConfig();
			
			f.set("insufficientPermissions", "&c&lERROR &r&e> &r&4Insufficient permissions!");
			f.set("invalidSender", "&c&lERROR &r&e> &r&4You must be a player to execute this command!");
			f.set("invalidUsage", "&c&lERROR &r&e> &r&4Invalid usage! Usage: %usage%");
			
			mc.saveConfig();
			
			return;
		}else{
			return;
		}
	}
	
	public static void writeConfig(){
		
		Config cc = new Config("config.yml");
		
		if(!cc.exists()){
			ArrayList<String> a = new ArrayList<String>();
			ArrayList<String> b = new ArrayList<String>();
			ArrayList<String> c = new ArrayList<String>();
			ArrayList<String> d = new ArrayList<String>();
			ArrayList<String> e = new ArrayList<String>();
			ArrayList<String> f = new ArrayList<String>();
			ArrayList<String> g = new ArrayList<String>();
			ArrayList<String> h = new ArrayList<String>();
			ArrayList<String> i = new ArrayList<String>();
			ArrayList<String> j = new ArrayList<String>();
			ArrayList<String> k = new ArrayList<String>();
			ArrayList<String> l = new ArrayList<String>();
			
			setupArrayList(a);
			setupArrayList(b);
			setupArrayList(c);
			setupArrayList(d);
			setupArrayList(e);
			setupArrayList(f);
			setupArrayList(g);
			setupArrayList(h);
			setupArrayList(i);
			setupArrayList(j);
			setupArrayList(k);
			setupArrayList(l);
			
			FileConfiguration fc = cc.getConfig();
			
			fc.set("enabled", true);
			
			//COOKED FOOD
			fc.set("cooked_beef.animal", "cow");
			fc.set("cooked_beef.effects", a);
			
			fc.set("cooked_chicken.animal", "chicken");
			fc.set("cooked_chicken.effects", b);
		
			fc.set("grilled_pork.animal", "pig");
			fc.set("grilled_pork.effects", c);
			
			fc.set("cooked_fish.animal", "silverfish");
			fc.set("cooked_fish.effects", d);

			//RAW FOOD
			fc.set("raw_beef.animal", "cow");
			fc.set("raw_beef.effects", e);
			
			fc.set("raw_chicken.animal", "chicken");
			fc.set("raw_chicken.effects", f);
		
			fc.set("pork.animal", "pig");
			fc.set("pork.effects", g);
			
			fc.set("raw_fish.animal", "silverfish");
			fc.set("raw_fish.effects", h);
			
			//GOLDEN FOOD
			fc.set("golden_apple.animal", "blaze");
			fc.set("golden_apple.effects", i);
			
			fc.set("golden_carrot.animal", "horse");
			fc.set("golden_carrot.effects", j);
			
			//OTHER
			fc.set("bread.animal", "sheep");
			fc.set("bread.effects", k);
			
			fc.set("apple.animal", "bat");
			fc.set("apple.effects", l);
		
			
			cc.saveConfig();
			a.clear();
			
			return;
		}else{
			return;
		}
	}
	
	public static void setupArrayList(ArrayList<String> id){
		id.add("CONFUSION,5,0");
		id.add("SPEED,5,0");	
	}

}
