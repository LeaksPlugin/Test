package com.andrei1058.skygiants.listeners;

import org.bukkit.event.player.*;
import org.bukkit.entity.*;
import com.andrei1058.skygiants.configuration.*;
import com.andrei1058.skygiants.*;
import com.andrei1058.skygiants.game.*;
import org.bukkit.event.*;

public class PlayerInteractEntityListener implements Listener
{
    @EventHandler
    public void shop(final PlayerInteractEntityEvent playerInteractEntityEvent) {
        if (playerInteractEntityEvent.getRightClicked().getType() == EntityType.VILLAGER && ((Villager)playerInteractEntityEvent.getRightClicked()).getCustomName().equalsIgnoreCase(Messages.getMsg().getString("merchant").replace('&', '?'))) {
            if (Main.spectators.contains(playerInteractEntityEvent.getPlayer())) {
                playerInteractEntityEvent.setCancelled(true);
                return;
            }
            playerInteractEntityEvent.setCancelled(true);
            playerInteractEntityEvent.getPlayer().openInventory(Shop.mainShop());
        }
    }
}
