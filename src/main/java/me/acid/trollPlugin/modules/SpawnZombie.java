package me.acid.trollPlugin.modules;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class SpawnZombie {

    public static void spawn(Player target) {

        Location targetPos = target.getLocation();
        target.getWorld().spawnEntity(targetPos, EntityType.ZOMBIE);

    }

}
