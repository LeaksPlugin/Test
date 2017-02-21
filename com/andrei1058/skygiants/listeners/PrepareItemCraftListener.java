package com.andrei1058.skygiants.listeners;

import org.bukkit.event.inventory.*;
import com.andrei1058.skygiants.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.event.*;

public class PrepareItemCraftListener implements Listener
{
    @EventHandler
    public void craft(final PrepareItemCraftEvent prepareItemCraftEvent) {
        final Main plugin = Main.plugin;
        if (Main.nmsH.getboats()) {
            if (prepareItemCraftEvent.getRecipe().getResult().getType() == Material.BOAT || prepareItemCraftEvent.getRecipe().getResult().getType() == Material.BOAT_ACACIA || prepareItemCraftEvent.getRecipe().getResult().getType() == Material.BOAT_BIRCH || prepareItemCraftEvent.getRecipe().getResult().getType() == Material.BOAT_DARK_OAK || prepareItemCraftEvent.getRecipe().getResult().getType() == Material.BOAT_JUNGLE || prepareItemCraftEvent.getRecipe().getResult().getType() == Material.BOAT_SPRUCE) {
                prepareItemCraftEvent.getInventory().setResult(new ItemStack(Material.AIR));
            }
        }
        else if (prepareItemCraftEvent.getRecipe().getResult().getType() == Material.BOAT) {
            prepareItemCraftEvent.getInventory().setResult(new ItemStack(Material.AIR));
        }
    }
}
