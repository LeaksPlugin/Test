package com.andrei1058.skygiants.configuration;

import org.bukkit.entity.*;
import com.andrei1058.skygiants.*;
import java.util.*;

static final class ArenaCfg$1 implements Runnable {
    final /* synthetic */ Player val$p;
    
    @Override
    public void run() {
        this.val$p.sendMessage(Main.PREFIX + Messages.getMsg().getString("vote-map").replace('&', '?'));
        this.val$p.sendMessage(Main.PREFIX + Messages.getMsg().getString("vote-map2").replace('&', '?'));
        int n = 0;
        for (final String s : Settings.getCfg().getStringList("Arenas")) {
            this.val$p.sendMessage(Main.PREFIX + Messages.getMsg().getString("map-choices").replace("{number}", String.valueOf(++n)).replace("{map}", s).replace("{votes}", String.valueOf(Main.mapsVoting.get(s))).replace('&', '?'));
        }
    }
}