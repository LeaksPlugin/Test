package com.andrei1058.skygiants.listeners;

import com.andrei1058.skygiants.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.util.*;
import java.util.*;
import org.bukkit.plugin.*;

class EntityDamageByEntityListener$5$1$1$1 implements Runnable {
    @Override
    public void run() {
        Runnable.this.this$2.this$1.val$e.getEntity().teleport(new Location(Runnable.this.this$2.this$1.val$e.getEntity().getWorld(), Runnable.this.this$2.this$1.val$e.getEntity().getLocation().getX(), Runnable.this.this$2.this$1.val$e.getEntity().getLocation().getY() - 3.0, Runnable.this.this$2.this$1.val$e.getEntity().getLocation().getZ()));
        Bukkit.getScheduler().runTaskLater((Plugin)Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                Runnable.this.this$2.this$1.val$e.getEntity().teleport(new Location(Runnable.this.this$2.this$1.val$e.getEntity().getWorld(), Runnable.this.this$2.this$1.val$e.getEntity().getLocation().getX(), Runnable.this.this$2.this$1.val$e.getEntity().getLocation().getY() - 3.0, Runnable.this.this$2.this$1.val$e.getEntity().getLocation().getZ()));
                final Location location = Runnable.this.this$2.this$1.val$e.getEntity().getLocation();
                for (int i = 0; i < 360; i += 3) {
                    final Location location2 = location;
                    location2.setZ(location2.getZ() + Math.cos(i) * 3.0);
                    location2.setX(location2.getX() + Math.cos(i) * 3.0);
                    location.getWorld().playEffect(location2, Effect.CLOUD, 60);
                    location.getWorld().playEffect(location2, Effect.CLOUD, 60);
                    location.getWorld().playEffect(location2, Effect.CLOUD, 60);
                }
                for (final Entity entity : Runnable.this.this$2.this$1.val$e.getEntity().getNearbyEntities(4.0, 4.0, 4.0)) {
                    if (entity instanceof Player && !Main.magentaPlayers.contains(entity)) {
                        if (Main.spectators.contains(entity)) {
                            return;
                        }
                        ((Player)entity).damage(1.0);
                        entity.setVelocity(new Vector(1.0, 0.5, 1.0));
                        ((Player)entity).playSound(entity.getLocation(), Main.nmsH.giantHurt(), 1.0f, 1.0f);
                    }
                }
            }
        }, 4L);
    }
}