package com.andrei1058.skygiants.nms.v1_9_R2;

import com.andrei1058.skygiants.*;
import com.andrei1058.skygiants.configuration.*;
import org.bukkit.entity.*;
import org.bukkit.craftbukkit.v1_9_R2.entity.*;
import java.util.*;
import com.andrei1058.skygiants.locations.*;
import com.andrei1058.skygiants.nms.v1_9_R2.beasts.*;
import net.minecraft.server.v1_9_R2.*;
import org.bukkit.inventory.*;
import org.bukkit.*;
import org.bukkit.potion.*;
import org.bukkit.inventory.meta.*;

public class Main implements NMS
{
    public static GiantNMS GoldGiant;
    public static GiantNMS MagentaGiant;
    public static GiantNMS GreenGiant;
    public static GiantNMS BlueGiant;
    
    @Override
    public void registerGiant() {
        new RegisterEntity().registerEntity("Giant", 53, EntityGiantZombie.class, GiantNMS.class);
    }
    
    @Override
    public void registerVillager() {
        new RegisterEntity().registerEntity("Villager", 120, EntityVillager.class, VillagerNMS.class);
    }
    
    @Override
    public void spawnGiants() {
        if (!com.andrei1058.skygiants.Main.magentaPlayers.isEmpty()) {
            GiantNMS.spawnMagentaGiant(Giants.getGiant("Magenta"));
        }
        if (!com.andrei1058.skygiants.Main.goldPlayers.isEmpty()) {
            GiantNMS.spawnOrangeGiant(Giants.getGiant("Gold"));
        }
        if (!com.andrei1058.skygiants.Main.greenPlayers.isEmpty()) {
            GiantNMS.spawnGreenGiant(Giants.getGiant("Green"));
        }
        if (!com.andrei1058.skygiants.Main.bluePlayers.isEmpty()) {
            GiantNMS.spawnBlueGiant(Giants.getGiant("Blue"));
        }
    }
    
    @Override
    public String gGH(final String s) {
        if (s.equalsIgnoreCase("Gold")) {
            if (!com.andrei1058.skygiants.Main.aliveTeams.contains("GOLD")) {
                return Messages.getMsg().getString("scoreboard.dead").replace('&', '?');
            }
            return getGiantHealth(Main.GoldGiant);
        }
        else if (s.equalsIgnoreCase("Magenta")) {
            if (!com.andrei1058.skygiants.Main.aliveTeams.contains("MAGENTA")) {
                return Messages.getMsg().getString("scoreboard.dead").replace('&', '?');
            }
            return getGiantHealth(Main.MagentaGiant);
        }
        else if (s.equalsIgnoreCase("Green")) {
            if (!com.andrei1058.skygiants.Main.aliveTeams.contains("GREEN")) {
                return Messages.getMsg().getString("scoreboard.dead").replace('&', '?');
            }
            return getGiantHealth(Main.GreenGiant);
        }
        else {
            if (!s.equalsIgnoreCase("Blue")) {
                return Messages.getMsg().getString("scoreboard.dead").replace('&', '?');
            }
            if (!com.andrei1058.skygiants.Main.aliveTeams.contains("BLUE")) {
                return Messages.getMsg().getString("scoreboard.dead").replace('&', '?');
            }
            return getGiantHealth(Main.BlueGiant);
        }
    }
    
    @Override
    public int getGiantHealthInt(final String s) {
        if (s.equalsIgnoreCase("Gold")) {
            return (int)Main.GoldGiant.getHealth();
        }
        if (s.equalsIgnoreCase("Magenta")) {
            return (int)Main.MagentaGiant.getHealth();
        }
        if (s.equalsIgnoreCase("Green")) {
            return (int)Main.GreenGiant.getHealth();
        }
        if (s.equalsIgnoreCase("Blue")) {
            return (int)Main.BlueGiant.getHealth();
        }
        return 0;
    }
    
    @Override
    public void killGiant(final String s) {
        if (s.equalsIgnoreCase("Gold")) {
            for (final Entity entity : Bukkit.getWorld(com.andrei1058.skygiants.Main.choosenMap).getEntities()) {
                if (entity instanceof Giant && com.andrei1058.skygiants.Main.GoldGiantRegion.isInRegion(entity.getLocation())) {
                    ((Giant)entity).setHealth(0.0);
                }
            }
            com.andrei1058.skygiants.Main.aliveTeams.remove("GOLD");
        }
        else if (s.equalsIgnoreCase("Magenta")) {
            for (final Entity entity2 : Bukkit.getWorld(com.andrei1058.skygiants.Main.choosenMap).getEntities()) {
                if (entity2 instanceof Giant && com.andrei1058.skygiants.Main.MagentaGiantRegion.isInRegion(entity2.getLocation())) {
                    ((Giant)entity2).setHealth(0.0);
                }
            }
            com.andrei1058.skygiants.Main.aliveTeams.remove("MAGENTA");
        }
        else if (s.equalsIgnoreCase("Green")) {
            for (final Entity entity3 : Bukkit.getWorld(com.andrei1058.skygiants.Main.choosenMap).getEntities()) {
                if (entity3 instanceof Giant && com.andrei1058.skygiants.Main.GreenGiantRegion.isInRegion(entity3.getLocation())) {
                    ((Giant)entity3).setHealth(0.0);
                }
            }
            com.andrei1058.skygiants.Main.aliveTeams.remove("GREEN");
        }
        else if (s.equalsIgnoreCase("Blue")) {
            for (final Entity entity4 : Bukkit.getWorld(com.andrei1058.skygiants.Main.choosenMap).getEntities()) {
                if (entity4 instanceof Giant && com.andrei1058.skygiants.Main.BlueGiantRegion.isInRegion(entity4.getLocation())) {
                    ((Giant)entity4).setHealth(0.0);
                }
            }
            com.andrei1058.skygiants.Main.aliveTeams.remove("BLUE");
        }
    }
    
    private static String getGiantHealth(final GiantNMS giantNMS) {
        return String.valueOf((int)(giantNMS.getHealth() * 100.0 / com.andrei1058.skygiants.Main.GiantHealth) + "%");
    }
    
    @Override
    public void actionMsg(final Player player, final String s) {
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket((Packet)new PacketPlayOutChat(IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + ChatColor.translateAlternateColorCodes('&', s) + "\"}"), (byte)2));
    }
    
    @Override
    public void spawnVillagers() {
        if (!com.andrei1058.skygiants.Main.magentaPlayers.isEmpty()) {
            VillagerNMS.spawnMagentaVillager(Villagers.getVillager("Magenta"));
        }
        if (!com.andrei1058.skygiants.Main.goldPlayers.isEmpty()) {
            VillagerNMS.spawnGoldVillager(Villagers.getVillager("Gold"));
        }
        if (!com.andrei1058.skygiants.Main.greenPlayers.isEmpty()) {
            VillagerNMS.spawnGreenVillager(Villagers.getVillager("Green"));
        }
        if (!com.andrei1058.skygiants.Main.bluePlayers.isEmpty()) {
            VillagerNMS.spawnBlueVillager(Villagers.getVillager("Blue"));
        }
    }
    
    @Override
    public void spawnBeast() {
        switch (new Random().nextInt(2) + 1) {
            case 1: {
                GuardianNMS.spawnGuardian(Beasts.getBeastSpawn());
                break;
            }
            case 2: {
                HorseNMS.spawnHorse(Beasts.getBeastSpawn());
                break;
            }
        }
    }
    
    @Override
    public void registerBeast() {
        final RegisterEntity registerEntity = new RegisterEntity();
        registerEntity.registerEntity("Guardian", 68, EntityGuardian.class, GuardianNMS.class);
        registerEntity.registerEntity("Horse", 100, EntityHorse.class, HorseNMS.class);
    }
    
    @Override
    public Sound catMeow() {
        return Sound.ENTITY_CAT_AMBIENT;
    }
    
    @Override
    public Sound eggPop() {
        return Sound.ENTITY_CHICKEN_EGG;
    }
    
    @Override
    public Sound lvlUp() {
        return Sound.ENTITY_PLAYER_LEVELUP;
    }
    
    @Override
    public Sound anvil() {
        return Sound.BLOCK_ANVIL_LAND;
    }
    
    @Override
    public Sound villager() {
        return Sound.ENTITY_VILLAGER_AMBIENT;
    }
    
    @Override
    public Sound splash() {
        return Sound.ENTITY_SPLASH_POTION_BREAK;
    }
    
    @Override
    public Sound giantHurt() {
        return Sound.ENTITY_ZOMBIE_PIG_HURT;
    }
    
    @Override
    public ItemStack getItm(final Player player) {
        return player.getInventory().getItemInMainHand();
    }
    
    @Override
    public ItemStack potion(final PotionType potionType) {
        final ItemStack itemStack = new ItemStack(Material.POTION, 1);
        final PotionMeta itemMeta = (PotionMeta)itemStack.getItemMeta();
        itemMeta.setBasePotionData(new PotionData(potionType));
        itemStack.setItemMeta((ItemMeta)itemMeta);
        return itemStack;
    }
    
    @Override
    public void transparent(final Player player) {
        player.setCollidable(false);
    }
    
    @Override
    public Boolean getboats() {
        return true;
    }
}
