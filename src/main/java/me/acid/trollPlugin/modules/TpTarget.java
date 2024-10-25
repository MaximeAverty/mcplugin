package me.acid.trollPlugin.modules;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class TpTarget {

    public static void tp(Player target) {

        if(target != null) {

            Location currentLoc = target.getLocation();
            Location newLocation = new Location(currentLoc.getWorld(), currentLoc.getX(), 255, currentLoc.getZ());
            target.teleport(newLocation);

        }

    }

}
