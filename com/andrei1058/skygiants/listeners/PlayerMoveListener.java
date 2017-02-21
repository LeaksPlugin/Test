package com.andrei1058.skygiants.listeners;

import org.bukkit.event.*;
import org.bukkit.event.player.*;
import com.andrei1058.skygiants.*;
import com.andrei1058.skygiants.configuration.*;

public class PlayerMoveListener implements Listener
{
    public void move(final PlayerMoveEvent playerMoveEvent) {
        if (Main.recall.contains(playerMoveEvent.getPlayer())) {
            Main.recall.remove(playerMoveEvent.getPlayer());
            playerMoveEvent.getPlayer().sendMessage(Main.PREFIX + Messages.getMsg().getString("recall-cancelled").replace('&', '?'));
        }
    }
}
