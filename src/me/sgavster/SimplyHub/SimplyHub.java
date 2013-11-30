package me.sgavster.SimplyHub;

import java.util.logging.Logger;

import me.sgavster.SimplyHub.listeners.CompassListener;
import me.sgavster.SimplyHub.listeners.ItemListener;
import me.sgavster.SimplyHub.listeners.PopHandler;
import me.sgavster.SimplyHub.listeners.TogglePlayerListener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class SimplyHub extends JavaPlugin
{

	private final Logger l = Logger.getLogger("Minecraft");
	
	/**
	 * [IDEAS:]
	 * 
	 * 1. Pop players (config)                            = done =
	 * 
	 * 2. Torch (Config)                                  = done =
	 * 
	 * 3. Compass (to switch servers) (config)            = done = 
	 * 
	 * 4. Hats (config)
	 * 
	 * 5. More soon!
	 * 
	 * [/IDEAS:]
	 */

	public void onEnable()
	{
		l.info("[SimplyHub] Enabled. Registering events.");
		
		Bukkit.getPluginManager().registerEvents(new CompassListener(this), this);
		Bukkit.getPluginManager().registerEvents(new PopHandler(this), this);
		Bukkit.getPluginManager().registerEvents(new TogglePlayerListener(this), this);
		Bukkit.getPluginManager().registerEvents(new ItemListener(this), this);
		
		l.info("[SimplyHub] Events registered. Loading config.");
		
		this.saveDefaultConfig();
		
		l.info("[SimplyHub] Enabled. Thank you for using SimplyHub!");
		
	}
	
	public void onDisable()
	{
		l.info("[SimplyHub] Thank you for using SimplyHub! Disabling...");
		l.info("[SimplyHub] ...Disabled.");
	}
}
