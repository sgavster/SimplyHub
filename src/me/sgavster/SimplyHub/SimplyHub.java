package me.sgavster.SimplyHub;

import java.util.logging.Logger;

import me.sgavster.SimplyHub.commands.CommandSH;
import me.sgavster.SimplyHub.listeners.CompassListener;
import me.sgavster.SimplyHub.listeners.ItemListener;
import me.sgavster.SimplyHub.listeners.PopHandler;
import me.sgavster.SimplyHub.listeners.TogglePlayerListener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class SimplyHub extends JavaPlugin
{
	private final Logger l = Logger.getLogger("Minecraft");

	public void onEnable()
	{
		this.l.info("[SimplyHub] Enabled. Registering events & commands.");

		Bukkit.getPluginManager().registerEvents(new CompassListener(this), this);
		Bukkit.getPluginManager().registerEvents(new PopHandler(this), this);
		Bukkit.getPluginManager().registerEvents(new TogglePlayerListener(this), this);
		Bukkit.getPluginManager().registerEvents(new ItemListener(this), this);
		CommandSH s = new CommandSH(this);
		getCommand("simplyhub").setExecutor(s);
		getCommand("sh").setExecutor(s);

		this.l.info("[SimplyHub] Events & commands registered. Loading config.");

		saveDefaultConfig();

		this.l.info("[SimplyHub] Enabled. Thank you for using SimplyHub!");
	}

	public void onDisable()
	{
		this.l.info("[SimplyHub] Thank you for using SimplyHub! Disabling...");
		this.l.info("[SimplyHub] ...Disabled.");
	}
}
