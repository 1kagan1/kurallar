package kagan0ft.kurallar;

import kagan0ft.kurallar.commands.GUICommand;
import kagan0ft.kurallar.events.GUIEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Kurallar extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("Kurallar").setExecutor(new GUICommand());
        getServer().getPluginManager().registerEvents(new GUIEvent(), this);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Kurallar getInstance() {
        return getPlugin(Kurallar.class);
    }
}
