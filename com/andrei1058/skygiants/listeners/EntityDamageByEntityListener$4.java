package com.andrei1058.skygiants.listeners;

import org.bukkit.entity.*;
import com.andrei1058.skygiants.*;

class EntityDamageByEntityListener$4 implements Runnable {
    final /* synthetic */ Player val$player;
    
    @Override
    public void run() {
        Main.cannotHitGiant.remove(this.val$player);
    }
}