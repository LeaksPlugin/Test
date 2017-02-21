package com.andrei1058.skygiants.listeners;

import org.bukkit.event.entity.*;
import com.andrei1058.skygiants.*;
import com.andrei1058.skygiants.game.*;
import org.bukkit.event.*;

public class FoodLevelChangeListener implements Listener
{
    @EventHandler
    public void food(final FoodLevelChangeEvent foodLevelChangeEvent) {
        if (Main.STATUS != GameState.PLAYING) {
            foodLevelChangeEvent.setCancelled(true);
        }
        if (Main.spectators.contains(foodLevelChangeEvent.getEntity())) {
            foodLevelChangeEvent.setCancelled(true);
        }
    }
}
