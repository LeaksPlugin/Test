package com.andrei1058.skygiants.utils;

import org.bukkit.scheduler.*;
import org.bukkit.entity.*;
import com.andrei1058.skygiants.configuration.*;

static final class Titles$1 extends BukkitRunnable {
    int countdown = Messages.getMsg().getStringList("fight").size();
    int string = 0;
    final /* synthetic */ Player val$player;
    
    public void run() {
        if (this.countdown != 0) {
            --this.countdown;
        }
        Titles.sendTitle(this.val$player, 1, 5, 1, Messages.getMsg().getStringList("fight").get(this.string).replace('&', '?'), Messages.getMsg().getString("good-luck").replace("{player}", this.val$player.getName()).replace('&', '?'));
        ++this.string;
        if (this.countdown == 0) {
            this.cancel();
        }
    }
}