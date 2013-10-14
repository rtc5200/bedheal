package bukkitlittleplugins.rtc5200.bedheal;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class events extends JavaPlugin implements Listener  {
	public static String msg;
	public static int hi;
	public static int fi;
	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerBedEnter(PlayerBedEnterEvent event){
		hi = getConfig().getInt("health-value");
		fi = getConfig().getInt("food-value");
		Player player = event.getPlayer();
		if (hi == 0)
		{
			hi = 20;
		}
		if (fi == 0)
		{
			fi = 20;
		}
		if (player.hasPermission("bedheal.on")) 
		{
			player.setHealth(20);
			player.setFoodLevel(20);
		}else if (player.isOp() == true)
		{
			player.setHealth(20);
			player.setFoodLevel(20);
		}
		return;
		
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerBedLeave(PlayerBedLeaveEvent event)
	{
		msg = getConfig().getString("message");
		if (msg == null)
		{
			msg = "[BedHeal]Healed.";
		}
		Player player = event.getPlayer();
		if (player.hasPermission("bedheal.on"))
		{
			player.sendMessage(ChatColor.GREEN + msg);
		}else if (player.isOp())
		{
			player.sendMessage(ChatColor.GREEN + msg);
		}
		
	}
}