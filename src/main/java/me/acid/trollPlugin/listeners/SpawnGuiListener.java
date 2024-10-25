package me.acid.trollPlugin.listeners;

import me.acid.trollPlugin.commands.CommandsManager;
import me.acid.trollPlugin.gui.SpawnGUI;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.Location;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.Map;

public class SpawnGuiListener implements Listener {

    Player player;
    Player target;

    public SpawnGuiListener(Player player, Player target) {
        this.player = player;
        this.target = target;
    }

    @EventHandler
    public void invListener(InventoryClickEvent event) {

        if(!(event.getView().getTitle().equalsIgnoreCase(SpawnGUI.title))) {
            return;
        }

        if(target == null) {
            return;
        }

        event.setCancelled(true);

        Location targetPos = target.getLocation();


        ItemMeta eggMeta = event.getCurrentItem().getItemMeta();

        if(eggMeta != null && eggMeta.hasDisplayName()) {

            String displayName = eggMeta.getDisplayName();
            String[] parts = displayName.split(" ");

            if(parts.length > 0) {
                try {
                    int number = Integer.parseInt(parts[0].replace("§4", ""));

                    for(int i = 0; i < number; i++) {
                        target.getWorld().spawnEntity(targetPos, EntityType.SILVERFISH);
                    }

                    player.sendMessage(CommandsManager.prefix + number + " silverfish spawn sur " + ChatColor.YELLOW + target.getDisplayName());
                    player.closeInventory();
                } catch (NumberFormatException err) {
                    event.getWhoClicked().sendMessage(CommandsManager.prefix + "&cErreur lors de la récupération du nombre");
                }
            }
        }

    }

    @EventHandler
    public void removeListener(InventoryCloseEvent event) {

        if(event.getView().getTitle().equalsIgnoreCase(SpawnGUI.title)) {
            HandlerList.unregisterAll(this);
        }

    }


}
