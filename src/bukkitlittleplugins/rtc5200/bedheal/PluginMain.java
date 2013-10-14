package bukkitlittleplugins.rtc5200.bedheal;

import java.util.logging.Logger;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginMain extends JavaPlugin implements Listener {
	Logger log = Logger.getLogger("Minecraft");
	public final events PlayerListener = new events();
	public void onEnable() {
		log.info("[BedHeal]Enabled.");
		PluginManager  pm = getServer().getPluginManager();
		pm.registerEvents(this.PlayerListener , this);
		this.saveDefaultConfig();
	}
	public void onDisable() {
		log.info("[BedHeal]Disabled.");
	}
	
}
