package com.andrei1058.skygiants.commands;

import org.bukkit.entity.*;
import com.andrei1058.skygiants.locations.*;
import org.bukkit.*;

class SetupCmds$3 implements Runnable {
    final /* synthetic */ String[] val$args;
    final /* synthetic */ Player val$p;
    
    @Override
    public void run() {
        if (Spectate.getSpect(this.val$args[1]) != null) {
            this.val$p.teleport(Spectate.getSpect(this.val$args[1]));
        }
        else {
            this.val$p.teleport(Bukkit.getWorld(this.val$args[1]).getSpawnLocation());
        }
    }
}