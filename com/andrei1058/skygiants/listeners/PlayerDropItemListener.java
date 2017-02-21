package com.andrei1058.skygiants.listeners;

import org.bukkit.event.player.*;
import com.andrei1058.skygiants.*;
import com.andrei1058.skygiants.game.*;
import org.bukkit.event.*;

public class PlayerDropItemListener implements Listener
{
    @EventHandler
    public void drop(final PlayerDropItemEvent playerDropItemEvent) {
        if (Main.spectators.contains(playerDropItemEvent.getPlayer())) {
            playerDropItemEvent.setCancelled(true);
        }
        if (Main.STATUS == GameState.STARTING || Main.STATUS == GameState.LOBBY) {
            playerDropItemEvent.setCancelled(true);
        }
    }
}
