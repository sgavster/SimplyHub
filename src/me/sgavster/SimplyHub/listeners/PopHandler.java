package me.sgavster.SimplyHub.listeners;

import java.util.List;
import java.util.logging.Level;

import me.sgavster.SimplyHub.FireworkEffectPlayer;
import me.sgavster.SimplyHub.SimplyHub;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.FireworkEffect;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.meta.FireworkMeta;

public class PopHandler implements Listener
{
	public static SimplyHub plugin;
	FireworkEffectPlayer f = new FireworkEffectPlayer();

	public PopHandler(SimplyHub instance)
	{
		plugin = instance;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e)
	{
		if (plugin.getConfig().getBoolean("allow_player_pop"))
		{
			if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
			{
				List<String> list = plugin.getConfig().getStringList("Toggle_Players_Allowed_Worlds");
				for (String s : list)
				{
					try
					{
						World w = Bukkit.getWorld(s);
						Player d = (Player)e.getDamager();
						Player p = (Player)e.getEntity();
						if (p.getWorld().equals(w))
						{
							e.setCancelled(true);
							try
							{
								if (p.hasPermission("simplyhub.hide.exempt"))
								{
									d.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("no_pop_message")));
								}
								else
								{
									if (plugin.getConfig().getBoolean("firework_pop"))
									{
										Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
										FireworkMeta data = firework.getFireworkMeta();
										data.addEffects(new FireworkEffect[] { FireworkEffect.builder().flicker(false).trail(false).with(FireworkEffect.Type.BURST).withColor(Color.BLUE).withFade(Color.WHITE).build() });
										firework.setFireworkMeta(data);
										firework.detonate();
									}
									d.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 1);
									d.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
									d.playEffect(p.getLocation(), Effect.SMOKE, 1);
									d.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1.0F, 10.0F);
									d.hidePlayer(p);
									d.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("pop_player_message").replace("%p%", p.getName())));
								}
							}
							catch (Exception ex)
							{
								Bukkit.getLogger().log(Level.SEVERE, "§c[SimplyHub] Could not play firework!");
							}
						}
					}
					catch (Exception ex)
					{
						Bukkit.getLogger().log(Level.SEVERE, "§c[SimplyHub] the config list Toggle_Players_Allowed_Worlds is wrong!");
					}
				}
			}
		}
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e)
	{
		for (Player p : Bukkit.getOnlinePlayers())
		{
			e.getPlayer().showPlayer(p);
		}
	}
}