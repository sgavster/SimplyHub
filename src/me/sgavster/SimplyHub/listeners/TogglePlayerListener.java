package me.sgavster.SimplyHub.listeners;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import me.sgavster.SimplyHub.SimplyHub;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TogglePlayerListener implements Listener
{

	public static SimplyHub plugin;

	public TogglePlayerListener(SimplyHub instance)
	{
		plugin = instance;
	}

	public ArrayList<String> h = new ArrayList<String>();
	public ArrayList<String> c = new ArrayList<String>();

	public ItemStack offTorch()
	{
		ItemStack t = new ItemStack(Material.REDSTONE_TORCH_OFF);
		ItemMeta i = t.getItemMeta();
		i.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("toggle_players_torch_off_name")));
		i.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("toggle_players_torch_off_lore"))));
		t.setItemMeta(i);
		return t;
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
	public void onToggle(PlayerInteractEvent e)
	{
		final Player p = e.getPlayer();
		if(plugin.getConfig().getBoolean("torch_enabled"))
		{
			if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
			{
				if(p.getItemInHand().getType() == Material.REDSTONE_TORCH_ON)
				{
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
						if(!h.contains(p.getName()))
						{
							h.add(p.getName());
						}
						e.setCancelled(true);
						if(!c.contains(p.getName()))
						{
							for(Player o : Bukkit.getOnlinePlayers())
							{
								p.hidePlayer(o);
								p.setItemInHand(offTorch());
								p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("hide_players_message")));
								c.add(p.getName());
								p.getWorld().playSound(p.getLocation(), Sound.FIZZ, 1.0F, 10F);
								Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
								{
									public void run()
									{
										c.remove(p.getName());
									}
								}, plugin.getConfig().getInt("torch_delay"));
							}
						}
						else
						{
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("torch_on_cooldown_message")));
						}
					}
					else if(p.getItemInHand().getType() == Material.REDSTONE_TORCH_OFF)
					{
						if(!h.contains(p.getName()))
						{
							h.add(p.getName());
						}
						e.setCancelled(true);
						if(!c.contains(p.getName()))
						{
							for(Player o : Bukkit.getOnlinePlayers())
							{
								p.showPlayer(o);
								p.setItemInHand(onTorch());
								p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("show_players_message")));
								c.add(p.getName());
								p.getWorld().playSound(p.getLocation(), Sound.FIZZ, 1.0F, 10F);
								Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
								{
									public void run()
									{
										c.remove(p.getName());
									}
								}, plugin.getConfig().getInt("torch_delay"));
							}
						}
						else
						{
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("torch_on_cooldown_message")));
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent e)
	{
		if(h.contains(e.getPlayer().getName()))
		{
			h.remove(e.getPlayer().getName());
		}
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e)
	{
		for(Player p : Bukkit.getOnlinePlayers())
		{
			if(h.contains(p.getName()))
			{
				p.hidePlayer(e.getPlayer());
			}
		}
	}

	@EventHandler
	public void unHide(PlayerJoinEvent e)
	{
		if(h.contains(e.getPlayer().getName()))
		{
			for(Player p : Bukkit.getOnlinePlayers())
			{
				e.getPlayer().showPlayer(p);
			}
		}
	}
}