package com.andrei1058.skygiants.runnables;

import org.bukkit.scheduler.*;
import com.andrei1058.skygiants.*;
import com.andrei1058.skygiants.configuration.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import com.andrei1058.skygiants.locations.*;
import com.andrei1058.skygiants.game.*;
import org.bukkit.plugin.*;
import java.util.*;

public class Game extends BukkitRunnable
{
    public void run() {
        if (Main.GameCountdown != 0) {
            --Main.GameCountdown;
        }
        if (Main.GameCountdown == 1320) {
            Bukkit.broadcastMessage(Main.PREFIX + Messages.getMsg().getString("double-damage").replace("{time}", "2").replace('&', '?'));
        }
        if (Main.GameCountdown == 1260) {
            Bukkit.broadcastMessage(Main.PREFIX + Messages.getMsg().getString("double-damage").replace("{time}", "1").replace('&', '?'));
        }
        if (Main.GameCountdown == 1200) {
            Bukkit.broadcastMessage(Main.PREFIX + Messages.getMsg().getString("double-giant-damage").replace('&', '?'));
            Main.doubleDamage = true;
        }
        Scoreboard.updateScoreboard();
        for (final Player player : Main.players) {
            Main.money.put(player, Main.money.get(player) + 2);
            Main.nmsH.actionMsg(player, Messages.getMsg().getString("action-bar").replace("{gold}", String.valueOf(Main.money.get(player))).replace("{region}", Region.getRegion(player)).replace("{kills}", String.valueOf(Main.kills.get(player))).replace('&', '?'));
        }
        if (Main.GameCountdown == 0) {
            this.cancel();
            Winner.getWinner();
            new Restarting().runTaskTimer((Plugin)Main.plugin, 20L, 20L);
        }
    }
}
