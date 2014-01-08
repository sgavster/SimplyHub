package me.sgavster.SimplyHub.commands;

import java.util.Arrays;
import java.util.logging.Level;
import me.sgavster.SimplyHub.SimplyHub;
import me.sgavster.SimplyHub.listeners.TogglePlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandSH implements CommandExecutor
{
	public static SimplyHub plugin;
	TogglePlayerListener tpl = new TogglePlayerListener(plugin);

	public CommandSH(SimplyHub i)
	{
		plugin = i;
	}

	public ItemStack compass()
	{
		Material m = Material.getMaterial(plugin.getConfig().getString("compass_item").toUpperCase());
		if (m == null)
		{
			Bukkit.getLogger().log(Level.SEVERE, "§cThe compass item is not correct! Going to default compass!");
			ItemStack i = new ItemStack(Material.COMPASS);
			ItemMeta t = i.getItemMeta();
			t.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_name")));
			i.setItemMeta(t);
			return i;
		}

		ItemStack i = new ItemStack(m);
		ItemMeta t = i.getItemMeta();
		t.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_name")));
		i.setItemMeta(t);
		return i;
	}

	public ItemStack offTorch()
	{
		Material m = Material.getMaterial(plugin.getConfig().getString("toggle_players_item_off").toUpperCase());
		if (m == null)
		{
			Bukkit.getLogger().log(Level.SEVERE, "§cThe toggle players item off item is wrong! Going to default REDSTONE_TORCH_OFF");
			ItemStack t = new ItemStack(Material.REDSTONE_TORCH_OFF);
			ItemMeta i = t.getItemMeta();
			i.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("toggle_players_item_off_name")));
			i.setLore(Arrays.asList(new String[] { ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("toggle_players_item_off_lore")) }));
			t.setItemMeta(i);
			return t;
		}

		ItemStack t = new ItemStack(m);
		ItemMeta i = t.getItemMeta();
		i.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("toggle_players_item_off_name")));
		i.setLore(Arrays.asList(new String[] { ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("toggle_players_item_off_lore")) }));
		t.setItemMeta(i);
		return t;
	}

	public ItemStack onTorch()
	{
		Material m = Material.getMaterial(plugin.getConfig().getString("toggle_players_item_on").toUpperCase());
		if (m == null)
		{
			Bukkit.getLogger().log(Level.SEVERE, "§cThe toggle players item on item is wrong! Going to default REDSTONE_TORCH_ON");
			ItemStack t = new ItemStack(Material.REDSTONE_TORCH_ON);
			ItemMeta i = t.getItemMeta();
			i.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("toggle_players_item_on_name")));
			i.setLore(Arrays.asList(new String[] { ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("toggle_players_item_on_lore")) }));
			t.setItemMeta(i);
			return t;
		}

		ItemStack t = new ItemStack(m);
		ItemMeta i = t.getItemMeta();
		i.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("toggle_players_item_on_name")));
		i.setLore(Arrays.asList(new String[] { ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("toggle_players_item_on_lore")) }));
		t.setItemMeta(i);
		return t;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		if ((cmd.getName().equalsIgnoreCase("sh")) || (cmd.getName().equalsIgnoreCase("simplyhub")))
		{
			if (args.length == 0)
			{
				sender.sendMessage("§6§l==========< §2§lSimplyHub by Sgavster §6§l>==========");
				sender.sendMessage("/simplyhub reload");
				sender.sendMessage("/simplyhub give <player> compass|toggleplayeron|toggleplayeroff");
				sender.sendMessage("/simplyhub showplayers");
				sender.sendMessage("/simplyhub sethub");
				sender.sendMessage("/simplhhub hub");
			}
			else if (args[0].equalsIgnoreCase("reload"))
			{
				if (sender.hasPermission("simplyhub.reload"))
				{
					plugin.reloadConfig();
					sender.sendMessage("§aConfig reloaded!");
				}
				else
				{
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("no_perms_message")));
				}
			}
			else if (args[0].equalsIgnoreCase("give"))
			{
				if (sender.hasPermission("simplyhub.give"))
				{
					switch (args.length)
					{
					case 1:
					case 2:
						sender.sendMessage("/simplyhub give <player> compass|toggleplayeron|toggleplayeroff");
						break;
					case 3:
						Player t = Bukkit.getPlayer(args[1]);
						if (t == null)
						{
							sender.sendMessage("§2" + args[1] + " §6is not online!");
						}
						else if (args[2].equalsIgnoreCase("compass"))
						{
							t.getInventory().addItem(new ItemStack[] { compass() });
							Material m = Material.getMaterial(plugin.getConfig().getString("compass_item"));
							sender.sendMessage("§6You gave §2" + args[1] + " §6a(n) §2" + m.toString().toLowerCase().replace("_", "") + "§6!");
							t.sendMessage("§6You were given a(n) §2" + m.toString().toLowerCase().replace("_", "") + "§6!");
						}
						else if (args[2].equalsIgnoreCase("toggleplayeron"))
						{
							t.getInventory().addItem(new ItemStack[] { onTorch() });
							Material m = Material.getMaterial(plugin.getConfig().getString("toggle_players_item_on"));
							sender.sendMessage("§6You gave §2" + args[1] + " §6a(n) §2" + m.toString().toLowerCase().replace("_", "") + "§6!");
							t.sendMessage("§6You were given a(n) §2" + m.toString().toLowerCase().replace("_", "") + "§6!");
						}
						else if (args[2].equalsIgnoreCase("toggleplayeroff"))
						{
							t.getInventory().addItem(new ItemStack[] { offTorch() });
							Material m = Material.getMaterial(plugin.getConfig().getString("toggle_players_item_off"));
							sender.sendMessage("§6You gave §2" + args[1] + " §6a(n) §2" + m.toString().toLowerCase().replace("_", "") + "§6!");
							t.sendMessage("§6You were given a(n) §2" + m.toString().toLowerCase().replace("_", "") + "§6!");
						}
						else
						{
							sender.sendMessage("/simplyhub give <player> compass|toggleplayeron|toggleplayeroff");
						}

						break;
					default:
						break;
					}
				}
				else sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("no_perms_message")));

			}
			else if (args[0].equalsIgnoreCase("showplayers"))
			{
				Player p = (Player)sender;
				if (!this.tpl.h.contains(p.getName()))
				{
					for (Player o : Bukkit.getOnlinePlayers())
					{
						p.showPlayer(o);
					}
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("show_players_message")));
				}
			}
			else if (args[0].equalsIgnoreCase("sethub"))
			{
				Player p = (Player)sender;
				if (p.hasPermission("simplyhub.sethub"))
				{
					plugin.getConfig().set("login_tp_location.world", p.getLocation().getWorld().getName());
					plugin.getConfig().set("login_tp_location.x", Integer.valueOf(p.getLocation().getBlockX()));
					plugin.getConfig().set("login_tp_location.y", Integer.valueOf(p.getLocation().getBlockY()));
					plugin.getConfig().set("login_tp_location.z", Integer.valueOf(p.getLocation().getBlockZ()));
					plugin.saveConfig();
					p.sendMessage("§6You set the hub.");
				}
				else
				{
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("no_perms_message")));
				}
			}
			else if (args[0].equalsIgnoreCase("hub"))
			{
				Player p = (Player)sender;
				if (p.hasPermission("simplyhub.hub"))
				{
					String w = plugin.getConfig().getString("login_tp_location.world");
					int x = plugin.getConfig().getInt("login_tp_location.x");
					int y = plugin.getConfig().getInt("login_tp_location.y");
					int z = plugin.getConfig().getInt("login_tp_location.z");
					p.teleport(new Location(Bukkit.getWorld(w), x, y, z));
				}
				else
				{
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("no_perms_message")));
				}
			}
			else
			{
				sender.sendMessage("§6§l==========< §2§lSimplyHub by Sgavster §6§l>==========");
				sender.sendMessage("/simplyhub reload");
				sender.sendMessage("/simplyhub give <player> compass|toggleplayeron|toggleplayeroff");
				sender.sendMessage("/simplyhub showplayers");
			}
		}

		return false;
	}
}
