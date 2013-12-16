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
import org.bukkit.event.player.PlayerDropItemEvent;
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

	public ItemStack compass()
	{
		Material m = Material.getMaterial(plugin.getConfig().getString("compass_item").toUpperCase());
		if(m == null)
		{
			Bukkit.getLogger().log(Level.SEVERE, "§cThe compass item is not correct! Going to default compass!");
			ItemStack i = new ItemStack(Material.COMPASS);
			ItemMeta t = i.getItemMeta();
			t.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_name")));
			i.setItemMeta(t);
			return i;
		}
		else
		{
			ItemStack i = new ItemStack(m);
			ItemMeta t = i.getItemMeta();
			t.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_name")));
			i.setItemMeta(t);
			return i;
		}
	}

	public ItemStack toggleOn()
	{
		Material m = Material.getMaterial(plugin.getConfig().getString("toggle_players_item_on").toUpperCase());
		if(m == null)
		{
			Bukkit.getLogger().log(Level.SEVERE, "§cThe toggle players item on item is wrong! Going to default SLIME_BALL");
			ItemStack t = new ItemStack(Material.SLIME_BALL);
			ItemMeta i = t.getItemMeta();
			i.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("toggle_players_item_on_name")));
			i.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("toggle_players_item_on_lore"))));
			t.setItemMeta(i);
			return t;
		}
		else
		{
			ItemStack t = new ItemStack(m);
			ItemMeta i = t.getItemMeta();
			i.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("toggle_players_item_on_name")));
			i.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("toggle_players_item_on_lore"))));
			t.setItemMeta(i);
			return t;	
		}
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e)
	{
		Player p = e.getPlayer();
		List<String> list = plugin.getConfig().getStringList("Spawn_Items_Allowed_Worlds");
		for(String s : list)
		{
			try
			{
				World w = Bukkit.getWorld(s);
				if(p.getWorld().equals(w))
				{
					if(plugin.getConfig().getBoolean("clear_inv_on_spawn") && !p.hasPermission("simplyhub.clearinv.exempt"))
					{
						p.getInventory().clear();
					}
					if(plugin.getConfig().getBoolean("compass_on_spawn") && !p.getInventory().contains(compass()))
					{
						p.getInventory().addItem(compass());
					}
					if(plugin.getConfig().getBoolean("torch_on_spawn") && !p.getInventory().contains(toggleOn()))
					{
						p.getInventory().addItem(toggleOn());
					}
				}
			}
			catch (Exception ex)
			{
				Bukkit.getLogger().log(Level.SEVERE, "§c[SimplyHub] the config list Spawn_Items_Allowed_Worlds is wrong!");
			}
		}
	}
	
	public Material item()
	{
		Material m = Material.getMaterial(plugin.getConfig().getString("toggle_players_item_on").toUpperCase());
		if(m == null)
		{
			Bukkit.getLogger().log(Level.SEVERE, "§cThe toggle players item on item is wrong! Going to default SLIME_BALL");
			Material mat = Material.SLIME_BALL;
			return mat;
		}
		else
		{
			Material mat = m;
			return mat;
		}
	}

	public Material item2()
	{
		Material m = Material.getMaterial(plugin.getConfig().getString("toggle_players_item_off").toUpperCase());
		if(m == null)
		{
			Bukkit.getLogger().log(Level.SEVERE, "§cThe toggle players item off item is wrong! Going to default MAGMA_CREAM");
			Material mat = Material.MAGMA_CREAM;
			return mat;
		}
		else
		{
			Material mat = m;
			return mat;
		}
	}
	
	public Material item3()
	{
		Material m = Material.getMaterial(plugin.getConfig().getString("compass_item").toUpperCase());
		if(m == null)
		{
			Material mat = Material.COMPASS;
			return mat;
		}
		else
		{
			Material mat = m;
			return mat;
		}
	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e)
	{
		Player p = e.getPlayer();
		List<String> list = plugin.getConfig().getStringList("Enabled_Worlds");
		for(String s : list)
		{
			try
			{
				World w = Bukkit.getWorld(s);
				if(p.getWorld().equals(w))
				{
					if(e.getItemDrop().getItemStack().getType().equals(item()))
					{
						if(!p.hasPermission("simplyhub.toggleplayerson.drop"))
						{
							e.setCancelled(true);
						}
					}
					else if(e.getItemDrop().getItemStack().getType().equals(item2()))
					{
						if(!p.hasPermission("simplyhub.toggleplayersoff.drop"))
						{
							e.setCancelled(true);
						}
					}
					else if(e.getItemDrop().getItemStack().getType().equals(item3()))
					{
						if(!p.hasPermission("simplyhub.compass.drop"))
						{
							e.setCancelled(true);
						}
					}
				}
			}
			catch (Exception ex)
			{
				Bukkit.getLogger().log(Level.SEVERE, "§c[SimplyHub] the config list Enabled_Worlds is wrong!");
			}
		}
	}
}