package me.acid.trollPlugin.listeners;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ListenersManager {

    public static void registerListener(JavaPlugin plugin) {

        PluginManager pm = plugin.getServer().getPluginManager();

        pm.registerEvents(new MenuListener(), plugin);

    }

}
