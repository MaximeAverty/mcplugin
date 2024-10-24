package me.acid.trollPlugin.commands;

import me.acid.trollPlugin.gui.TrollGui;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TrollCommand implements CommandExecutor {

    private String prefix = CommandsManager.prefix;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) {
            return true;
        }

        Player player = ( Player ) sender;

        if(args.length != 1) {
            player.sendMessage(prefix + "Vous devez préciser un joueur");
            return true;
        }

        Player target = Bukkit.getServer().getPlayer(args[0]);

        if(target == null) {
            player.sendMessage(prefix + "Le joueur " + ChatColor.YELLOW + args[0] + " §fn'est pas en ligne");
            return true;
        }


        new TrollGui(target);

        return true;
    }
}
