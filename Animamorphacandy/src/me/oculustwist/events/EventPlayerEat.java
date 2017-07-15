package me.oculustwist.events;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

import me.oculustwist.config.Config;
import me.oculustwist.utils.ConfigUtils;
import me.oculustwist.utils.DisguiseUtils;

public class EventPlayerEat implements Listener {

	// private Animamorphacandy main = Animamorphacandy.getInstance();

	@EventHandler
	public void onEat(PlayerItemConsumeEvent e) {

		Player p = e.getPlayer();
		Config c = new Config("config.yml");

		// Check if the config file exists
		if (c.exists()) {
			FileConfiguration f = c.getConfig();

			// Check if Animamorphacandy is enabled
			if (f.getBoolean("enabled")) {

				DisguiseUtils.disguisePlayer(p, e, f, "cooked_beef", Material.COOKED_BEEF);
				DisguiseUtils.disguisePlayer(p, e, f, "cooked_chicken", Material.COOKED_CHICKEN);
				DisguiseUtils.disguisePlayer(p, e, f, "grilled_pork", Material.GRILLED_PORK);
				DisguiseUtils.disguisePlayer(p, e, f, "cooked_fish", Material.COOKED_FISH);
				DisguiseUtils.disguisePlayer(p, e, f, "raw_beef", Material.RAW_BEEF);
				DisguiseUtils.disguisePlayer(p, e, f, "raw_chicken", Material.RAW_CHICKEN);
				DisguiseUtils.disguisePlayer(p, e, f, "pork", Material.PORK);
				DisguiseUtils.disguisePlayer(p, e, f, "raw_fish", Material.RAW_FISH);
				DisguiseUtils.disguisePlayer(p, e, f, "golden_apple", Material.GOLDEN_APPLE);
				DisguiseUtils.disguisePlayer(p, e, f, "golden_carrot", Material.GOLDEN_CARROT);
				DisguiseUtils.disguisePlayer(p, e, f, "bread", Material.BREAD);
				DisguiseUtils.disguisePlayer(p, e, f, "apple", Material.APPLE);

			} else {
				// If Animamorphacandy is disabled
				return;
			}

		}else{
			//If config does not exist then write it
			ConfigUtils.writeConfig();
		}

	}

}
