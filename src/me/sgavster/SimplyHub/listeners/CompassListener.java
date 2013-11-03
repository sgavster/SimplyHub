package me.sgavster.SimplyHub.listeners;

import java.util.Arrays;

import me.sgavster.SimplyHub.SimplyHub;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
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
		ItemStack is = new ItemStack(Material.ENDER_PEARL);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_1")));
		im.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_lore_1"))));
		is.setItemMeta(im);
		return is;
	}
	public ItemStack compassItem2()
	{
		ItemStack is = new ItemStack(Material.ENDER_PEARL);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_2")));
		im.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_lore_2"))));
		is.setItemMeta(im);
		return is;
	}
	public ItemStack compassItem3()
	{
		ItemStack is = new ItemStack(Material.ENDER_PEARL);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_3")));
		im.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_lore_3"))));
		is.setItemMeta(im);
		return is;
	}
	public ItemStack compassItem4()
	{
		ItemStack is = new ItemStack(Material.ENDER_PEARL);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_4")));
		im.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_lore_4"))));
		is.setItemMeta(im);
		return is;
	}
	public ItemStack compassItem5()
	{
		ItemStack is = new ItemStack(Material.ENDER_PEARL);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_5")));
		im.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_lore_5"))));
		is.setItemMeta(im);
		return is;
	}
	public ItemStack compassItem6()
	{
		ItemStack is = new ItemStack(Material.ENDER_PEARL);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_6")));
		im.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_lore_6"))));
		is.setItemMeta(im);
		return is;
	}
	public ItemStack compassItem7()
	{
		ItemStack is = new ItemStack(Material.ENDER_PEARL);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_7")));
		im.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_lore_7"))));
		is.setItemMeta(im);
		return is;
	}
	public ItemStack compassItem8()
	{
		ItemStack is = new ItemStack(Material.ENDER_PEARL);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_8")));
		im.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_lore_8"))));
		is.setItemMeta(im);
		return is;
	}
	public ItemStack compassItem9()
	{
		ItemStack is = new ItemStack(Material.ENDER_PEARL);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_name_9")));
		im.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_item_lore_9"))));
		is.setItemMeta(im);
		return is;
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

					compass = Bukkit.createInventory(p, 9, ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("compass_name")));

					compass.setItem(0, compassItem1());
					compass.setItem(1, compassItem2());
					compass.setItem(2, compassItem3());
					compass.setItem(3, compassItem4());
					compass.setItem(4, compassItem5());
					compass.setItem(5, compassItem6());
					compass.setItem(6, compassItem7());
					compass.setItem(7, compassItem8());
					compass.setItem(8, compassItem9());

					p.openInventory(compass);
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
				}
			}
		}
	}
}