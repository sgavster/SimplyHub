package me.sgavster.SimplyHub.listeners;

import java.util.Arrays;

import me.sgavster.SimplyHub.SimplyHub;

import org.bukkit.ChatColor;
import org.bukkit.Material;
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
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e)
	{
		Player p = e.getPlayer();
		if(plugin.getConfig().getBoolean("compass_on_spawn"))
		{
			p.getInventory().clear();
			p.getInventory().setItem(0, compassItem());
		}
		if(plugin.getConfig().getBoolean("torch_on_spawn"))
		{
			p.getInventory().setItem(1, onTorch());
		}
	}
}
