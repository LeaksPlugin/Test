package com.andrei1058.skygiants.commands;

import org.bukkit.entity.*;
import org.bukkit.*;
import com.andrei1058.skygiants.*;
import com.andrei1058.skygiants.configuration.*;
import java.io.*;
import java.util.*;

class SetupCmds$1 implements Runnable {
    final /* synthetic */ Player val$p;
    final /* synthetic */ String[] val$args;
    
    @Override
    public void run() {
        this.val$p.teleport(Bukkit.getWorld(this.val$args[1]).getSpawnLocation());
        this.val$p.setGameMode(GameMode.CREATIVE);
        Bukkit.getWorld(this.val$args[1]).setAutoSave(true);
        SetupCmds.access$000().put(this.val$p, this.val$p.getLocation().getWorld().getName());
        this.val$p.sendMessage(Main.PREFIX + "?aYou were teleported to the " + this.val$p.getWorld().getName() + "'s spawn.");
        if (Settings.getCfg().get("Arenas") != null) {
            final List stringList = Settings.getCfg().getStringList("Arenas");
            stringList.add(this.val$p.getLocation().getWorld().getName());
            Settings.getCfg().set("Arenas", (Object)stringList);
            try {
                Settings.getCfg().save(Settings.getCfgFile());
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else {
            Settings.addArenaToList(this.val$p);
        }
    }
}