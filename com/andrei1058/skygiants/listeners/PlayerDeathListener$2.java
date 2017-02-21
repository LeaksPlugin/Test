package com.andrei1058.skygiants.listeners;

import org.bukkit.scheduler.*;
import org.bukkit.event.entity.*;
import com.andrei1058.skygiants.*;
import com.andrei1058.skygiants.game.*;
import com.andrei1058.skygiants.configuration.*;
import com.andrei1058.skygiants.utils.*;
import com.andrei1058.skygiants.locations.*;
import com.andrei1058.skygiants.protocolLib.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import java.util.*;

class PlayerDeathListener$2 extends BukkitRunnable {
    int i = Main.respawningVoid.get(this.val$e.getEntity());
    final /* synthetic */ PlayerDeathEvent val$e;
    
    public void run() {
        if (this.i != 0) {
            --this.i;
        }
        if (!Main.respawning.contains(this.val$e.getEntity())) {
            this.cancel();
            Spectate.setSpectator(this.val$e.getEntity());
        }
        if (this.i == 15 || this.i == 14 || this.i == 13 || this.i == 12 || this.i == 11 || this.i == 10 || this.i == 9 || this.i == 8 || this.i == 7 || this.i == 6 || this.i == 5 || this.i == 4) {
            Titles.sendTitle(this.val$e.getEntity(), 0, 14, 0, " ", Messages.getMsg().getString("respawning-in").replace("{time}", String.valueOf(this.i)).replace('&', '?'));
        }
        if (this.i == 3) {
            Titles.sendTitle(this.val$e.getEntity(), 0, 14, 0, " ", Messages.getMsg().getString("respawning-in").replace("{time}", "\u278c").replace('&', '?'));
        }
        if (this.i == 2) {
            Titles.sendTitle(this.val$e.getEntity(), 0, 14, 0, " ", Messages.getMsg().getString("respawning-in").replace("{time}", "\u278b").replace('&', '?'));
        }
        if (this.i == 1) {
            Titles.sendTitle(this.val$e.getEntity(), 0, 14, 0, " ", Messages.getMsg().getString("respawning-in").replace("{time}", "\u278a").replace('&', '?'));
        }
        if (this.i == 0) {
            this.cancel();
            Titles.fightTitle(this.val$e.getEntity());
            Main.respawning.remove(this.val$e.getEntity());
            if (Main.respBeac.containsValue(this.val$e.getEntity())) {
                this.val$e.getEntity().teleport((Location)Main.respOwn.get(this.val$e.getEntity().getName()));
            }
            else if (Main.goldPlayers.contains(this.val$e.getEntity())) {
                this.val$e.getEntity().teleport(Spawns.getSpawn("Gold"));
                if (Main.warmup) {
                    Borders.goldBorders(this.val$e.getEntity());
                }
            }
            else if (Main.magentaPlayers.contains(this.val$e.getEntity())) {
                this.val$e.getEntity().teleport(Spawns.getSpawn("Magenta"));
                if (Main.warmup) {
                    Borders.magentaBorders(this.val$e.getEntity());
                }
            }
            else if (Main.greenPlayers.contains(this.val$e.getEntity())) {
                this.val$e.getEntity().teleport(Spawns.getSpawn("Green"));
                if (Main.warmup) {
                    Borders.greenBorders(this.val$e.getEntity());
                }
            }
            else if (Main.bluePlayers.contains(this.val$e.getEntity())) {
                this.val$e.getEntity().teleport(Spawns.getSpawn("Blue"));
                if (Main.warmup) {
                    Borders.blueBorders(this.val$e.getEntity());
                }
            }
            final Iterator<Player> iterator = Bukkit.getOnlinePlayers().iterator();
            while (iterator.hasNext()) {
                iterator.next().showPlayer(this.val$e.getEntity());
            }
            this.val$e.getEntity().setAllowFlight(false);
        }
    }
}