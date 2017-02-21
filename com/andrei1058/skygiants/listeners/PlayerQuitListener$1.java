package com.andrei1058.skygiants.listeners;

import com.andrei1058.skygiants.*;
import org.bukkit.*;
import org.bukkit.plugin.*;
import com.andrei1058.skygiants.game.*;

class PlayerQuitListener$1 implements Runnable {
    @Override
    public void run() {
        if (Main.miniSG) {
            if (Bukkit.getOnlinePlayers().size() < Main.MaxInTeam * 2) {
                Main.plugin.getServer().getScheduler().cancelTasks((Plugin)Main.plugin);
                Main.LobbyCountdown = 300;
                Main.STATUS = GameState.LOBBY;
            }
        }
        else if (Bukkit.getOnlinePlayers().size() < Main.MaxInTeam) {
            Main.plugin.getServer().getScheduler().cancelTasks((Plugin)Main.plugin);
            Main.LobbyCountdown = 300;
            Main.STATUS = GameState.LOBBY;
        }
    }
}