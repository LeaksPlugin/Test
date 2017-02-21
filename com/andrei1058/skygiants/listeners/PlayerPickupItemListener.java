package com.andrei1058.skygiants.listeners;

import org.bukkit.event.player.*;
import com.andrei1058.skygiants.*;
import org.bukkit.event.*;

public class PlayerPickupItemListener implements Listener
{
    @EventHandler
    public void pickup(final PlayerPickupItemEvent playerPickupItemEvent) {
        if (Main.spectators.contains(playerPickupItemEvent.getPlayer())) {
            playerPickupItemEvent.setCancelled(true);
        }
    }
}
