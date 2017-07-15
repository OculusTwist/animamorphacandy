package me.oculustwist.commands;

import me.oculustwist.main.Animamorphacandy;

public class CommandManager {
	
	private static Animamorphacandy main;
	
	public CommandManager(Animamorphacandy main){
		this.setMain(main);
		CommandManager.setup();
	}
	
	public static void setup(){
		
		main.getCommand("amc").setExecutor(new CommandAMC());
		
	}

	public Animamorphacandy getMain() {
		return main;
	}

	public void setMain(Animamorphacandy main) {
		CommandManager.main = main;
	}

}
