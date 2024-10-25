package me.acid.trollPlugin.listeners;

import me.acid.trollPlugin.commands.CommandsManager;
import me.acid.trollPlugin.gui.SpawnGUI;
import me.acid.trollPlugin.gui.TrollGui;
import me.acid.trollPlugin.modules.KillPlayer;
import me.acid.trollPlugin.modules.SpawnSilverFish;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class MenuListener implements Listener {

    private final JavaPlugin plugin;

    public MenuListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void manageInv(InventoryClickEvent event) {

        if(event.getView().getTitle().equalsIgnoreCase(TrollGui.menuTitle)) {
            event.setCancelled(true);

            String targetName = ChatColor.stripColor(event.getView().getItem(22).getItemMeta().getDisplayName());

            Player target = Bukkit.getPlayer(targetName);
            Player player = (Player) event.getWhoClicked();

            if(target == null) {
                player.sendMessage(CommandsManager.prefix + "Le joueur n'est plus en ligne");
                return;
            }

            ItemStack clickedItem = event.getCurrentItem();

            switch (clickedItem.getItemMeta().getDisplayName()) {

                case "§cKill":
                    KillPlayer.kill(target);
                    player.sendMessage(CommandsManager.prefix + "§e" + targetName + " §fa été tué");
                    break;

                case "§2Spawn":
                    new SpawnGUI(target, player, plugin);
                    break;

            }

        }

    }

}
