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

	public ItemStack toggleOff()
	{
		Material m = Material.getMaterial(plugin.getConfig().getString("toggle_players_item_off").toUpperCase());
		if(m == null)
		{
			Bukkit.getLogger().log(Level.SEVERE, "�cThe toggle players item off item is wrong! Going to default MAGMA_CREAM");
			ItemStack t = new ItemStack(Material.MAGMA_CREAM);
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

	public ItemStack toggleOn()
	{
		Material m = Material.getMaterial(plugin.getConfig().getString("toggle_players_item_on").toUpperCase());
		if(m == null)
		{
			Bukkit.getLogger().log(Level.SEVERE, "�cThe toggle players item on item is wrong! Going to default SLIME_BALL");
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

	public Material item()
	{
		Material m = Material.getMaterial(plugin.getConfig().getString("toggle_players_item_on").toUpperCase());
		if(m == null)
		{
			Bukkit.getLogger().log(Level.SEVERE, "�cThe toggle players item on item is wrong! Going to default SLIME_BALL");
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
			Bukkit.getLogger().log(Level.SEVERE, "�cThe toggle players item off item is wrong! Going to default MAGMA_CREAM");
			Material mat = Material.MAGMA_CREAM;
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
				List<String> list = plugin.getConfig().getStringList("Toggle_Players_Allowed_Worlds");
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
									p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("hide_players_message")));
									p.playSound(p.getLocation(), Sound.FIZZ, 1.0F, 10F);
									for(Player o : Bukkit.getOnlinePlayers())
									{
										if(!o.hasPermission("simplyhub.hide.exempt"))
										{
											p.hidePlayer(o);
											p.setItemInHand(toggleOff());
											if(!p.hasPermission("simplyhub.cooldown.exempt"))
											{
												c.add(p.getName());
											}
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
								}
								else
								{
									p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("torch_on_cooldown_message")));
								}
							}
							else if(p.getItemInHand().getType().equals(item2()))
							{
								if(h.contains(p.getName()))
								{
									h.remove(p.getName());
								}
								e.setCancelled(true);
								if(!c.contains(p.getName()))
								{
									p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("show_players_message")));
									p.playSound(p.getLocation(), Sound.FIZZ, 1.0F, 10F);
									for(Player o : Bukkit.getOnlinePlayers())
									{
										p.showPlayer(o);
										p.setItemInHand(toggleOn());
										if(!p.hasPermission("simplyhub.cooldown.exempt"))
										{
											c.add(p.getName());
										}
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
						Bukkit.getLogger().log(Level.SEVERE, "�c[SimplyHub] the config list Toggle_Players_Allowed_Worlds is wrong!");
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
			for(Player p : Bukkit.getOnlinePlayers())
			{
				e.getPlayer().showPlayer(p);
			}
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
				h.remove(e.getPlayer().getName());
			}
		}
	}
	@EventHandler
	public void update(PlayerJoinEvent e)
	{
		for(Player p : Bukkit.getOnlinePlayers())
		{
			if(!h.contains(p.getName()))
			{
				p.showPlayer(e.getPlayer());
			}
		}
	}
}