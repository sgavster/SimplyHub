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
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CompassListener implements Listener
{

	public static Inventory compass;

	public static SimplyHub plugin;

	public CompassListener(SimplyHub instance)
	{
		plugin = instance; 
	}

	public ItemStack compassItem1()
	{
		Material m = Material.getMaterial(plugin.getConfig().getString("compass_item_1").toUpperCase());
		if(m == null)
		{
			Bukkit.getLogger().log(Level.SEVERE, "§cThe compass item #1 is not correct! Going to default enderpearl!");
			ItemStack is = new ItemStack(Material.ENDER_PEARL);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_1")));
			im.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_lore_1"))));
			is.setItemMeta(im);
			return is;
		}
		else
		{
			ItemStack is = new ItemStack(m);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_1")));
			im.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_lore_1"))));
			is.setItemMeta(im);
			return is;
		}
	}
	public ItemStack compassItem2()
	{
		Material m = Material.getMaterial(plugin.getConfig().getString("compass_item_2").toUpperCase());
		if(m == null)
		{
			Bukkit.getLogger().log(Level.SEVERE, "§cThe compass item #2 is not correct! Going to default enderpearl!");
			ItemStack is = new ItemStack(Material.ENDER_PEARL);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_2")));
			im.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_lore_2"))));
			is.setItemMeta(im);
			return is;
		}
		else
		{
			ItemStack is = new ItemStack(m);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_2")));
			im.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_lore_2"))));
			is.setItemMeta(im);
			return is;
		}
	}
	public ItemStack compassItem3()
	{
		Material m = Material.getMaterial(plugin.getConfig().getString("compass_item_3").toUpperCase());
		if(m == null)
		{
			Bukkit.getLogger().log(Level.SEVERE, "§cThe compass item #3 is not correct! Going to default enderpearl!");
			ItemStack is = new ItemStack(Material.ENDER_PEARL);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_3")));
			im.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_lore_3"))));
			is.setItemMeta(im);
			return is;
		}
		else
		{
			ItemStack is = new ItemStack(m);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_3")));
			im.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_lore_3"))));
			is.setItemMeta(im);
			return is;
		}
	}
	public ItemStack compassItem4()
	{
		Material m = Material.getMaterial(plugin.getConfig().getString("compass_item_4").toUpperCase());
		if(m == null)
		{
			Bukkit.getLogger().log(Level.SEVERE, "§cThe compass item #4 is not correct! Going to default enderpearl!");
			ItemStack is = new ItemStack(Material.ENDER_PEARL);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_4")));
			im.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_lore_4"))));
			is.setItemMeta(im);
			return is;
		}
		else
		{
			ItemStack is = new ItemStack(m);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_4")));
			im.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_lore_4"))));
			is.setItemMeta(im);
			return is;
		}
	}
	public ItemStack compassItem5()
	{
		Material m = Material.getMaterial(plugin.getConfig().getString("compass_item_5").toUpperCase());
		if(m == null)
		{
			Bukkit.getLogger().log(Level.SEVERE, "§cThe compass item #5 is not correct! Going to default enderpearl!");
			ItemStack is = new ItemStack(Material.ENDER_PEARL);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_5")));
			im.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_lore_5"))));
			is.setItemMeta(im);
			return is;
		}
		else
		{
			ItemStack is = new ItemStack(m);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_5")));
			im.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_lore_5"))));
			is.setItemMeta(im);
			return is;
		}
	}
	public ItemStack compassItem6()
	{
		Material m = Material.getMaterial(plugin.getConfig().getString("compass_item_6").toUpperCase());
		if(m == null)
		{
			Bukkit.getLogger().log(Level.SEVERE, "§cThe compass item #6 is not correct! Going to default enderpearl!");
			ItemStack is = new ItemStack(Material.ENDER_PEARL);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_6")));
			im.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_lore_6"))));
			is.setItemMeta(im);
			return is;
		}
		else
		{
			ItemStack is = new ItemStack(m);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_6")));
			im.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_lore_6"))));
			is.setItemMeta(im);
			return is;
		}
	}
	public ItemStack compassItem7()
	{
		Material m = Material.getMaterial(plugin.getConfig().getString("compass_item_7").toUpperCase());
		if(m == null)
		{
			Bukkit.getLogger().log(Level.SEVERE, "§cThe compass item #7 is not correct! Going to default enderpearl!");
			ItemStack is = new ItemStack(Material.ENDER_PEARL);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_7")));
			im.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_lore_7"))));
			is.setItemMeta(im);
			return is;
		}
		else
		{
			ItemStack is = new ItemStack(m);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_7")));
			im.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_lore_7"))));
			is.setItemMeta(im);
			return is;
		}
	}
	public ItemStack compassItem8()
	{
		Material m = Material.getMaterial(plugin.getConfig().getString("compass_item_8").toUpperCase());
		if(m == null)
		{
			Bukkit.getLogger().log(Level.SEVERE, "§cThe compass item #8 is not correct! Going to default enderpearl!");
			ItemStack is = new ItemStack(Material.ENDER_PEARL);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_8")));
			im.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_lore_8"))));
			is.setItemMeta(im);
			return is;
		}
		else
		{
			ItemStack is = new ItemStack(m);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_8")));
			im.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_lore_8"))));
			is.setItemMeta(im);
			return is;
		}
	}
	public ItemStack compassItem9()
	{
		Material m = Material.getMaterial(plugin.getConfig().getString("compass_item_9").toUpperCase());
		if(m == null)
		{
			Bukkit.getLogger().log(Level.SEVERE, "§cThe compass item #9 is not correct! Going to default enderpearl!");
			ItemStack is = new ItemStack(Material.ENDER_PEARL);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_9")));
			im.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_lore_9"))));
			is.setItemMeta(im);
			return is;
		}
		else
		{
			ItemStack is = new ItemStack(m);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_9")));
			im.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_lore_9"))));
			is.setItemMeta(im);
			return is;
		}
	}


	@EventHandler
	public void onInteract(PlayerInteractEvent e)
	{
		if(plugin.getConfig().getBoolean("compass_enabled"))
		{
			if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
			{
				Player p = e.getPlayer();
				if(p.getItemInHand().getType() == Material.COMPASS)
				{

					List<String> list = plugin.getConfig().getStringList("Enabled_Worlds");
					for(String s : list)
					{
						try
						{
							World w = Bukkit.getWorld(s);
							if(p.getWorld().equals(w))
							{

								compass = Bukkit.createInventory(p, 9, ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_name")));

								if(plugin.getConfig().getBoolean("compass_item_1_enabled"))
								{
									compass.setItem(0, compassItem1());
								}
								if(plugin.getConfig().getBoolean("compass_item_2_enabled"))
								{
									compass.setItem(1, compassItem2());
								}
								if(plugin.getConfig().getBoolean("compass_item_3_enabled"))
								{
									compass.setItem(2, compassItem3());
								}
								if(plugin.getConfig().getBoolean("compass_item_4_enabled"))
								{
									compass.setItem(3, compassItem4());
								}
								if(plugin.getConfig().getBoolean("compass_item_5_enabled"))
								{
									compass.setItem(4, compassItem5());
								}
								if(plugin.getConfig().getBoolean("compass_item_6_enabled"))
								{
									compass.setItem(5, compassItem6());
								}
								if(plugin.getConfig().getBoolean("compass_item_7_enabled"))
								{
									compass.setItem(6, compassItem7());
								}
								if(plugin.getConfig().getBoolean("compass_item_8_enabled"))
								{
									compass.setItem(7, compassItem8());
								}
								if(plugin.getConfig().getBoolean("compass_item_9_enabled"))
								{
									compass.setItem(8, compassItem9());
								}
								p.openInventory(compass);
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
	}
	@EventHandler
	public void onClick(InventoryClickEvent e)
	{
		Player p = (Player) e.getWhoClicked();
		if(e.getCurrentItem() != null)
		{
			Material m = e.getCurrentItem().getType();
			if(e.getInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_name"))))
			{
				if(m != null)
				{
					if(e.getCurrentItem().hasItemMeta())
					{
						if(e.getCurrentItem().getItemMeta().hasDisplayName())
						{
							List<String> list = plugin.getConfig().getStringList("Enabled_Worlds");
							for(String s : list)
							{
								try
								{
									World w = Bukkit.getWorld(s);
									if(p.getWorld().equals(w))
									{
										e.setCancelled(true);
										if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_1"))))
										{
											p.chat("/" + plugin.getConfig().getString("compass_item_command_1"));
										}
										else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_2"))))
										{
											p.chat("/" + plugin.getConfig().getString("compass_item_command_2"));
										}
										else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_3"))))
										{
											p.chat("/" + plugin.getConfig().getString("compass_item_command_3"));
										}
										else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_4"))))
										{
											p.chat("/" + plugin.getConfig().getString("compass_item_command_4"));
										}
										else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_5"))))
										{
											p.chat("/" + plugin.getConfig().getString("compass_item_command_5"));
										}
										else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_6"))))
										{
											p.chat("/" + plugin.getConfig().getString("compass_item_command_6"));
										}
										else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_7"))))
										{
											p.chat("/" + plugin.getConfig().getString("compass_item_command_7"));
										}
										else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_8"))))
										{
											p.chat("/" + plugin.getConfig().getString("compass_item_command_8"));
										}
										else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_9"))))
										{
											p.chat("/" + plugin.getConfig().getString("compass_item_command_9"));
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
			}
		}
	}
}