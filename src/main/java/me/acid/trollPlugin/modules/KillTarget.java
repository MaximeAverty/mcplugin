package me.acid.trollPlugin.modules;

import org.bukkit.entity.Player;

public class KillTarget {

    public static void kill(Player target) {

        if(!(target == null)) {
            target.setHealth(0);
        }

    }

}
