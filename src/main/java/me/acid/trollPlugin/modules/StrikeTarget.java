package me.acid.trollPlugin.modules;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class StrikeTarget {

    public static void strike(Player target) {

        if(target != null) {

            Location targetLoc = target.getLocation();

            target.getWorld().strikeLightning(targetLoc);

        }

    }

}
