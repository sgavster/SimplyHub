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

	public final SimplyHub plugin;

	public TogglePlayerListener(SimplyHub instance)
	{
		plugin = instance;
	}

	public ArrayList<String> h = new ArrayList<String>();
	public ArrayList<String> c = new ArrayList<String>();

	public ItemStack offTorch()
	{
		Material m = Material.getMaterial(plugin.getConfig().getString("toggle_players_item_off").toUpperCase());
		if(m == null)
		{
			Bukkit.getLogger().log(Level.SEVERE, "§cThe toggle players item off item is wrong! Going to default REDSTONE_TORCH_OFF");
			ItemStack t = new ItemStack(Material.REDSTONE_TORCH_OFF);
			ItemMeta i = t.getItemMeta();
			i.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("toggle_players_item_off_name")));
			i.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("toggle_players_item_off_lore"))));
			t.setItemMeta(i);
			return t;
		}
		else
		{
			ItemStack t = new ItemStack(m);
			ItemMeta i = t.getItemMeta();
			i.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("toggle_players_item_off_name")));
			i.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("toggle_players_item_off_lore"))));
			t.setItemMeta(i);
			return t;
		}
	}

	public ItemStack onTorch()
	{
		Material m = Material.getMaterial(plugin.getConfig().getString("toggle_players_item_on").toUpperCase());
		if(m == null)
		{
			Bukkit.getLogger().log(Level.SEVERE, "§cThe toggle players item on item is wrong! Going to default REDSTONE_TORCH_ON");
			ItemStack t = new ItemStack(Material.REDSTONE_TORCH_ON);
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

	public Material item()
	{
		Material m = Material.getMaterial(plugin.getConfig().getString("toggle_players_item_on").toUpperCase());
		if(m == null)
		{
			Bukkit.getLogger().log(Level.SEVERE, "§cThe toggle players item on item is wrong! Going to default REDSTONE_TORCH_ON");
			Material mat = Material.REDSTONE_TORCH_ON;
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
			Bukkit.getLogger().log(Level.SEVERE, "§cThe toggle players item off item is wrong! Going to default REDSTONE_TORCH_OFF");
			Material mat = Material.REDSTONE_TORCH_OFF;
			return mat;
		}
		else
		{
			Material mat = m;
			return mat;
		}
	}

	@EventHandler
	public void onToggle(PlayerInteractEvent e)
	{
		final Player p = e.getPlayer();
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
		{
			if(plugin.getConfig().getBoolean("torch_enabled"))
			{
				List<String> list = plugin.getConfig().getStringList("Enabled_Worlds");
				for(String s : list)
				{
					try
					{
						World w = Bukkit.getWorld(s);
						if(p.getWorld().equals(w))
						{
							if(p.getItemInHand().getType().equals(item()))
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
										if(!p.hasPermission("simplyhub.cooldown.exempt"))
										{
											c.add(p.getName());
										}
										p.getWorld().playSound(p.getLocation(), Sound.FIZZ, 1.0F, 10F);
										Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
										{
											public void run()
											{
												if(c.contains(p.getName()))
												{
													c.remove(p.getName());
												}
											}
										}, plugin.getConfig().getInt("torch_delay") * 20);
									}
								}
								else
								{
									p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("torch_on_cooldown_message")));
								}
							}
							else if(p.getItemInHand().getType().equals(item2()))
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
										if(!p.hasPermission("simplyhub.cooldown.exempt"))
										{
											c.add(p.getName());
										}
										p.getWorld().playSound(p.getLocation(), Sound.FIZZ, 1.0F, 10F);
										Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
										{
											public void run()
											{
												if(c.contains(p.getName()))
												{
													c.remove(p.getName());
												}
											}
										}, plugin.getConfig().getInt("torch_delay") * 20);
									}
								}
								else
								{
									p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("torch_on_cooldown_message")));
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