package com.andrei1058.skygiants.commands;

import org.bukkit.entity.*;
import org.bukkit.*;

class SetupCmds$2 implements Runnable {
    final /* synthetic */ Player val$p;
    
    @Override
    public void run() {
        if (SetupCmds.access$000().containsKey(this.val$p)) {
            Bukkit.getServer().unloadWorld((String)SetupCmds.access$000().get(this.val$p), true);
        }
        else if (SetupCmds.access$100().containsKey(this.val$p)) {
            Bukkit.getServer().unloadWorld((String)SetupCmds.access$100().get(this.val$p), true);
        }
    }
}