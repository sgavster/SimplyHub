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
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PopHandler implements Listener
{

	public static SimplyHub plugin;

	public PopHandler(SimplyHub instance)
	{
		plugin = instance; 
	}

	private World w;
	FireworkEffectPlayer f = new FireworkEffectPlayer();

	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e)
	{
		if(plugin.getConfig().getBoolean("allow_player_pop"))
		{
			if(e.getEntity() instanceof Player && e.getDamager() instanceof Player)
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
				Player d = (Player) e.getDamager();
				Player p = (Player) e.getEntity();
				if(p.getWorld().equals(w))
				{
					try 
					{
						f.playFirework(d.getWorld(), d.getLocation(), FireworkEffect.builder().flicker(false).trail(false).with(Type.BURST).withColor(Color.ORANGE).withFade(Color.GREEN).build());
					} 
					catch (Exception e1) 
					{
						e1.printStackTrace();
					}
					d.getWorld().playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 1);
					d.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
					d.getWorld().playEffect(p.getLocation(), Effect.SMOKE, 1);
					d.getWorld().playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 10);
					d.hidePlayer(p);
					d.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("pop_player_message")));
				}
			}
		}
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e)
	{
		for(Player p : Bukkit.getOnlinePlayers())
		{
			e.getPlayer().showPlayer(p);
		}
	}
}