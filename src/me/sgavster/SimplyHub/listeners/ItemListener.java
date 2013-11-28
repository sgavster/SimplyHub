package me.sgavster.SimplyHub.listeners;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import me.sgavster.SimplyHub.SimplyHub;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemListener implements Listener
{

	public static SimplyHub plugin;

	public ItemListener(SimplyHub instance)
	{
		plugin = instance;
	}

	public ItemStack compassItem()
	{
		ItemStack i = new ItemStack(Material.COMPASS);
		ItemMeta m = i.getItemMeta();
		m.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_name")));
		i.setItemMeta(m);
		return i;
	}

	public ItemStack onTorch()
	{
		ItemStack t = new ItemStack(Material.REDSTONE_TORCH_ON);
		ItemMeta i = t.getItemMeta();
		i.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("toggle_players_torch_on_name")));
		i.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("toggle_players_torch_on_lore"))));
		t.setItemMeta(i);
		return t;
	}
	
	private World w;

	@EventHandler
	public void onJoin(PlayerJoinEvent e)
	{
		Player p = e.getPlayer();
		List<String> list = plugin.getConfig().getStringList("Enabled_Worlds");
		for(String s : list)
		{
			try
			{
				w = Bukkit.getWorld(s);
			}
			catch (Exception ex)
			{
				Bukkit.getLogger().log(Level.SEVERE, "§c[SimplyHub] the config list Enabled_Worlds is wrong!");
			}
		}
		if(p.getWorld().equals(w))
		{
			if(plugin.getConfig().getBoolean("compass_on_spawn"))
			{
				p.getInventory().clear();
				p.getInventory().addItem(compassItem());
			}
			if(plugin.getConfig().getBoolean("torch_on_spawn"))
			{
				p.getInventory().clear();
				p.getInventory().addItem(onTorch());
			}
		}
	}
}