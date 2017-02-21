package com.andrei1058.skygiants.configuration;

import java.io.*;
import com.andrei1058.skygiants.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import com.andrei1058.skygiants.game.*;
import java.util.*;

static final class Settings$1 implements Runnable {
    @Override
    public void run() {
        if (!new File("plugins/SkyGiants1058/messages_" + Settings.getCfg().getString("language") + ".yml").exists()) {
            Main.Language = "en";
        }
        else {
            Main.Language = Settings.getCfg().getString("language");
        }
        if (Settings.getCfg().getBoolean("setup")) {
            Main.MAINTENANCE = true;
        }
        else {
            Main.MAINTENANCE = false;
            Main.STATUS = GameState.LOBBY;
        }
        if (!Settings.getCfg().getBoolean("skygiants-mini")) {
            if (Messages.getMsg().get("prefix") != null) {
                Main.PREFIX = Messages.getMsg().getString("prefix");
            }
            else {
                Main.PREFIX = "?8\u258e ?3?lSky?b?lGiants?8 \u258f ";
            }
            Main.miniSG = false;
            Main.sbtitle = Messages.getMsg().getString("scoreboard.title1").replace('&', '?');
            Main.BeastHealth = 350;
        }
        else {
            Main.miniSG = true;
            if (Messages.getMsg().get("mini-prefix") != null) {
                Main.PREFIX = Messages.getMsg().getString("mini-prefix");
            }
            else {
                Main.PREFIX = "?8\u258e ?3?lSky?b?lGiants?a?l:Mini?8 \u258f ";
            }
            Main.MaxInTeam = 2;
            Main.GiantHealth = 510;
            Main.sbtitle = Messages.getMsg().getString("scoreboard.title2").replace('&', '?');
            Main.BeastHealth = 210;
        }
        if (Settings.getCfg().get("Database.enable") != null) {
            Main.DatabaseB = Settings.getCfg().getBoolean("Database.enable");
        }
        if (Settings.getCfg().get("MainLobby") != null) {
            for (final Entity entity : Bukkit.getWorld(Settings.getCfg().getString("MainLobby.World")).getEntities()) {
                if (entity.getType() != EntityType.PLAYER) {
                    entity.remove();
                }
            }
        }
        if (Settings.getCfg().get("allow-spectate") != null) {
            Main.allowSpectate = Settings.getCfg().getBoolean("allow-spectate");
        }
        Scoreboard.goldEntry = Messages.getMsg().getString("scoreboard.gold").replace('&', '?');
        Scoreboard.magentaEntry = Messages.getMsg().getString("scoreboard.magenta").replace('&', '?');
        Scoreboard.blueEntry = Messages.getMsg().getString("scoreboard.blue").replace('&', '?');
        Scoreboard.greenEntry = Messages.getMsg().getString("scoreboard.green").replace('&', '?');
        Main.LobbyCountdown = Settings.getCfg().getInt("countdowns.lobby.empty");
        Main.GameCountdown = Settings.getCfg().getInt("countdowns.game");
        Main.WarmupCountdown = Settings.getCfg().getInt("countdowns.warmup");
        Main.RestartCountdown = Settings.getCfg().getInt("countdowns.restart");
        Main.loaded = true;
    }
}