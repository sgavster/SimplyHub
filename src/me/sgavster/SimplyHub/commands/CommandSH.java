package me.sgavster.SimplyHub.commands;

import me.sgavster.SimplyHub.SimplyHub;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandSH implements CommandExecutor
{

	private final SimplyHub plugin;
	public CommandSH(SimplyHub i)
	{
		plugin = i;
	}
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		if(cmd.getName().equalsIgnoreCase("sh") || cmd.getName().equalsIgnoreCase("simplyhub"))
		{
			if(args.length == 0)
			{
				sender.sendMessage("§6§l==========< §2§lSimplyHub by Sgavster §6§l>==========");
				sender.sendMessage("/simplyhub reload");
			} 
			else if(args.length == 1)
			{
				if(sender.hasPermission("simplyhub.reload"))
				{
					if(args[0].equalsIgnoreCase("reload"))
					{
						plugin.reloadConfig();
						sender.sendMessage("§aConfig reloaded!");
					}
					else
					{
						sender.sendMessage("/simplyhub reload");
					}
				}
				else
				{
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("no_perms_message")));
				}
			}
			else
			{
				sender.sendMessage("/simplyhub reload");
			}
		}
		return false;
	}
}
