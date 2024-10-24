package me.acid.trollPlugin.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrollGui {

    public static final String menuTitle = "§3Troll menu";


    public TrollGui(Player target) {

        Inventory inv = Bukkit.createInventory(null, 27, menuTitle);

        ItemStack targetHead = new ItemStack(Material.PLAYER_HEAD, 1);
        ItemMeta targetHeadMeta = targetHead.getItemMeta();
        assert targetHeadMeta != null;
        targetHeadMeta.setDisplayName(ChatColor.YELLOW + target.getDisplayName());
        targetHead.setItemMeta(targetHeadMeta);

        inv.setItem(22, targetHead);

        ItemStack killSword = new ItemStack(Material.NETHERITE_SWORD, 1);
        ItemMeta killSwordMeta = killSword.getItemMeta();
        killSwordMeta.setDisplayName("§cKill");
        killSwordMeta.setLore(List.of("§fTuer le jouer"));
        killSwordMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        killSword.setItemMeta(killSwordMeta);

        inv.setItem(10, killSword);

        ItemStack zombieHead = new ItemStack(Material.ZOMBIE_HEAD);
        ItemMeta zombieHeadMeat = zombieHead.getItemMeta();
        zombieHeadMeat.setDisplayName("§2Spawn");
        zombieHeadMeat.setLore(List.of("§fSpawn un zombie sur le joueur"));
        zombieHead.setItemMeta(zombieHeadMeat);

        inv.setItem(12, zombieHead);

        ItemStack lightningRode = new ItemStack(Material.LIGHTNING_ROD, 1);
        ItemMeta lightningRodeMeta = lightningRode.getItemMeta();
        lightningRodeMeta.setDisplayName("§bStrike");
        lightningRodeMeta.setLore(List.of("§fEnvoie un éclaire sur le joueur"));
        lightningRode.setItemMeta(lightningRodeMeta);

        inv.setItem(14, lightningRode);

        ItemStack feather = new ItemStack(Material.FEATHER, 1);
        ItemMeta featherMeta = feather.getItemMeta();
        featherMeta.setDisplayName("§9Lift");
        featherMeta.setLore(List.of("§fTp le joueur en l'air"));
        feather.setItemMeta(featherMeta);

        inv.setItem(16, feather);

        for(int i = 0; i < inv.getSize(); i++) {
            if(inv.getItem(i) == null) {
                ItemStack glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
                ItemMeta glassMeta = glass.getItemMeta();
                glassMeta.setDisplayName(" ");
                glass.setItemMeta(glassMeta);
                inv.setItem(i, glass);
            }
        }

        target.openInventory(inv);

    }

}
