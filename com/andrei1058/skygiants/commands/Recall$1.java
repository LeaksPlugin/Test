package com.andrei1058.skygiants.commands;

import org.bukkit.scheduler.*;
import org.bukkit.entity.*;
import com.andrei1058.skygiants.*;
import org.bukkit.*;
import com.andrei1058.skygiants.locations.*;

class Recall$1 extends BukkitRunnable {
    int i = 40;
    final /* synthetic */ Player val$p;
    
    public void run() {
        if (this.i != 0) {
            --this.i;
        }
        if (Main.recall.contains(this.val$p)) {
            this.val$p.getWorld().playEffect(this.val$p.getLocation(), Effect.CLOUD, 1, 0);
            this.val$p.getWorld().playEffect(this.val$p.getLocation(), Effect.CLOUD, 1, 0);
            this.val$p.getWorld().playEffect(this.val$p.getLocation(), Effect.CLOUD, 1, 0);
            this.val$p.getWorld().playEffect(this.val$p.getLocation().add(0.0, 1.0, 0.0), Effect.CLOUD, 1, 0);
            this.val$p.getWorld().playEffect(this.val$p.getLocation().add(0.0, 1.0, 0.0), Effect.CLOUD, 1, 0);
            this.val$p.getWorld().playEffect(this.val$p.getLocation().add(0.0, 1.0, 0.0), Effect.CLOUD, 1, 0);
            this.val$p.getWorld().playEffect(this.val$p.getLocation().add(0.0, 1.8, 0.0), Effect.CLOUD, 1, 0);
            this.val$p.getWorld().playEffect(this.val$p.getLocation().add(0.0, 1.8, 0.0), Effect.CLOUD, 1, 0);
            this.val$p.getWorld().playEffect(this.val$p.getLocation().add(0.0, 1.8, 0.0), Effect.CLOUD, 1, 0);
            this.val$p.getWorld().playEffect(this.val$p.getLocation().add(0.0, 1.8, 0.0), Effect.CLOUD, 1, 0);
        }
        else {
            this.cancel();
        }
        if (this.i == 0) {
            this.cancel();
            if (Main.magentaPlayers.contains(this.val$p)) {
                this.val$p.teleport(Spawns.getSpawn("Magenta"));
            }
            else if (Main.goldPlayers.contains(this.val$p)) {
                this.val$p.teleport(Spawns.getSpawn("Gold"));
            }
            else if (Main.greenPlayers.contains(this.val$p)) {
                this.val$p.teleport(Spawns.getSpawn("Green"));
            }
            else if (Main.bluePlayers.contains(this.val$p)) {
                this.val$p.teleport(Spawns.getSpawn("Blue"));
            }
            Main.recall.remove(this.val$p);
        }
    }
}