package com.andrei1058.skygiants.game;

import org.bukkit.entity.*;
import com.andrei1058.skygiants.*;
import com.andrei1058.skygiants.locations.*;

static final class Spectate$1 implements Runnable {
    final /* synthetic */ Player val$p;
    
    @Override
    public void run() {
        this.val$p.teleport(com.andrei1058.skygiants.locations.Spectate.getSpect(Main.choosenMap));
        Spectate.access$000(this.val$p);
    }
}