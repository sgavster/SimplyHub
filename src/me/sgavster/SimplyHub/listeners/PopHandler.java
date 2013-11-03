package me.sgavster.SimplyHub.listeners;

import me.sgavster.SimplyHub.SimplyHub;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.FireworkEffect;
import org.bukkit.Sound;
import org.bukkit.FireworkEffect.Type;
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

	public PopHandler(SimplyHub instance)
	{
		plugin = instance; 
	}
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e)
	{
		if(plugin.getConfig().getBoolean("allow_player_pop"))
		{
			if(e.getEntity() instanceof Player && e.getDamager() instanceof Player)
			{
				Player d = (Player) e.getDamager();
				Player p = (Player) e.getEntity();
				Firework f = (Firework) p.getWorld().spawn(p.getLocation(), Firework.class);
	            FireworkMeta fm = f.getFireworkMeta();
	            fm.addEffect(FireworkEffect.builder().flicker(false).trail(false).with(Type.BURST).withColor(Color.GREEN).withFade(Color.BLUE).build());
	            f.setFireworkMeta(fm);
				d.getWorld().playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 1);
				d.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
				d.getWorld().playEffect(p.getLocation(), Effect.SMOKE, 1);
				d.getWorld().playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 10);
				d.hidePlayer(p);
				d.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("pop_player_message")));
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