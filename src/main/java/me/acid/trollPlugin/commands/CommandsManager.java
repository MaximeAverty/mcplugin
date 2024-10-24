package me.acid.trollPlugin.commands;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public abstract class CommandsManager {

    public static String prefix = "§3[Troll] §f";

    public static void registerCommand(JavaPlugin plugin) {
        Objects.requireNonNull(plugin.getCommand("troll")).setExecutor(new TrollCommand());
    }

}
