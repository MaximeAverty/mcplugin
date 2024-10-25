package me.acid.trollPlugin.gui;

import me.acid.trollPlugin.listeners.SpawnGuiListener;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class SpawnGUI {

    public static String title = "§3Combien de silverfish";

    public SpawnGUI(Player target, Player player, JavaPlugin plugin) {

        Inventory inv = Bukkit.createInventory(null, 9, title);

        for(int i = 0; i < inv.getSize(); i++) {

            ItemStack egg = new ItemStack(Material.SILVERFISH_SPAWN_EGG);
            ItemMeta eggMeta = egg.getItemMeta();
            eggMeta.setDisplayName("§4" + (i + 1) + " §3Silverfish");
            egg.setItemMeta(eggMeta);

            inv.setItem(i, egg);

        }

        Bukkit.getServer().getPluginManager().registerEvents(new SpawnGuiListener(player, target), plugin);
        player.openInventory(inv);

    }

}
