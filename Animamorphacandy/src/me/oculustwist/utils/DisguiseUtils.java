package me.oculustwist.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.DisguiseType;
import me.libraryaddict.disguise.disguisetypes.MobDisguise;

public class DisguiseUtils {
	
	public static void disguisePlayer(Player p, PlayerItemConsumeEvent e, FileConfiguration f, String itemName, Material item){
		if (e.getItem().getType() == item) {

			String animal = f.getString(itemName + ".animal");

			for (String s : f.getStringList(itemName + ".effects")) {

				PotionEffectType effect = null;
				
				String[] values = s.toString().split(",");

				try {
					effect = PotionEffectType.getByName(values[0]);
				} catch (Exception ex) {
					ex.printStackTrace();
					break;
				}

				p.addPotionEffect(new PotionEffect(effect, Integer.parseInt(values[1]) * 20, Integer.parseInt(values[2])));

			}

			DisguiseType entity = DisguiseType.valueOf(animal.toUpperCase());

			MobDisguise mobDisguise = new MobDisguise(entity);
			DisguiseAPI.disguiseEntity(p, mobDisguise);
			
			p.sendMessage(ChatColor.AQUA + "[AMC]" + ChatColor.GRAY + " After eating that Animamorphacandy, you have morphed into a " + animal);

			return;
		}
	}

}
