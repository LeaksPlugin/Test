package com.andrei1058.skygiants.runnables;

import org.bukkit.scheduler.*;
import com.andrei1058.skygiants.*;
import com.andrei1058.skygiants.game.*;
import org.bukkit.entity.*;
import com.andrei1058.skygiants.configuration.*;
import com.andrei1058.skygiants.locations.*;
import com.andrei1058.skygiants.protocolLib.*;
import org.bukkit.plugin.*;
import org.bukkit.*;
import com.andrei1058.skygiants.utils.*;
import java.util.*;

public class Warmup extends BukkitRunnable
{
    public void run() {
        if (Main.WarmupCountdown != 0) {
            --Main.WarmupCountdown;
        }
        Scoreboard.updateScoreboard();
        for (final Player player : Main.players) {
            if (!Main.money.containsKey(player)) {
                Main.money.put(player, 2);
            }
            Main.money.replace(player, Main.money.get(player) + 2);
            Main.nmsH.actionMsg(player, Messages.getMsg().getString("action-bar").replace("{gold}", String.valueOf(Main.money.get(player))).replace("{region}", Region.getRegion(player)).replace("{kills}", String.valueOf(Main.kills.get(player))).replace('&', '?'));
        }
        if (Main.WarmupCountdown == 0) {
            Borders.removeBorder();
            Main.warmup = false;
            new Game().runTaskTimer((Plugin)Main.plugin, 20L, 20L);
            this.cancel();
            Main.GameMilis = 1800000L;
            final Iterator<Player> iterator2 = Bukkit.getOnlinePlayers().iterator();
            while (iterator2.hasNext()) {
                Titles.fightTitle(iterator2.next());
            }
        }
    }
}
