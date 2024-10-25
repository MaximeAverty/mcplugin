package me.acid.trollPlugin;

import me.acid.trollPlugin.commands.CommandsManager;
import me.acid.trollPlugin.listeners.ListenersManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class TrollPlugin extends JavaPlugin {

    private static TrollPlugin plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("Troll plugin started.");

        CommandsManager.registerCommand(this);
        ListenersManager.registerListener(this);

        plugin = this;

    }

    public static TrollPlugin getPlugin() {
        return plugin;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("Troll plugin stoped.");
    }
}
