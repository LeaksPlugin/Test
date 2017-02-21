package com.andrei1058.skygiants.nms.v1_10_R1;

import org.bukkit.craftbukkit.v1_10_R1.util.*;
import java.lang.reflect.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.craftbukkit.v1_10_R1.*;
import org.bukkit.craftbukkit.v1_10_R1.entity.*;
import com.andrei1058.skygiants.configuration.*;
import org.bukkit.event.entity.*;
import net.minecraft.server.v1_10_R1.*;

public class VillagerNMS extends EntityVillager
{
    public VillagerNMS(final World world) {
        super(world);
        try {
            final Field declaredField = PathfinderGoalSelector.class.getDeclaredField("b");
            declaredField.setAccessible(true);
            final Field declaredField2 = PathfinderGoalSelector.class.getDeclaredField("c");
            declaredField2.setAccessible(true);
            declaredField.set(this.goalSelector, new UnsafeList());
            declaredField.set(this.targetSelector, new UnsafeList());
            declaredField2.set(this.goalSelector, new UnsafeList());
            declaredField2.set(this.targetSelector, new UnsafeList());
        }
        catch (Exception ex) {}
        this.goalSelector.a(0, (PathfinderGoal)new PathfinderGoalFloat((EntityInsentient)this));
        this.goalSelector.a(5, (PathfinderGoal)new PathfinderGoalMoveTowardsRestriction((EntityCreature)this, 0.6));
        this.goalSelector.a(9, (PathfinderGoal)new PathfinderGoalInteract((EntityInsentient)this, (Class)EntityHuman.class, 3.0f, 1.0f));
        this.goalSelector.a(9, (PathfinderGoal)new PathfinderGoalInteract((EntityInsentient)this, (Class)EntityVillager.class, 5.0f, 0.02f));
        this.goalSelector.a(9, (PathfinderGoal)new PathfinderGoalRandomStroll((EntityCreature)this, 0.6));
        this.goalSelector.a(10, (PathfinderGoal)new PathfinderGoalLookAtPlayer((EntityInsentient)this, (Class)EntityHuman.class, 8.0f));
    }
    
    public void move(final double n, final double n2, final double n3) {
    }
    
    public void collide(final Entity entity) {
    }
    
    public boolean damageEntity(final DamageSource damageSource, final float n) {
        return false;
    }
    
    public void g(final double n, final double n2, final double n3) {
    }
    
    public static Villager spawnGoldVillager(final Location location) {
        final WorldServer handle = ((CraftWorld)location.getWorld()).getHandle();
        final VillagerNMS villagerNMS = new VillagerNMS((World)handle);
        villagerNMS.setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
        ((CraftLivingEntity)villagerNMS.getBukkitEntity()).setRemoveWhenFarAway(false);
        villagerNMS.setCustomName(Messages.getMsg().getString("merchant").replace('&', '?'));
        villagerNMS.setCustomNameVisible(true);
        ((World)handle).addEntity((Entity)villagerNMS, CreatureSpawnEvent.SpawnReason.CUSTOM);
        return (Villager)villagerNMS.getBukkitEntity();
    }
    
    public static Villager spawnMagentaVillager(final Location location) {
        final WorldServer handle = ((CraftWorld)location.getWorld()).getHandle();
        final VillagerNMS villagerNMS = new VillagerNMS((World)handle);
        villagerNMS.setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
        ((CraftLivingEntity)villagerNMS.getBukkitEntity()).setRemoveWhenFarAway(false);
        villagerNMS.setCustomName(Messages.getMsg().getString("merchant").replace('&', '?'));
        villagerNMS.setCustomNameVisible(true);
        ((World)handle).addEntity((Entity)villagerNMS, CreatureSpawnEvent.SpawnReason.CUSTOM);
        return (Villager)villagerNMS.getBukkitEntity();
    }
    
    public static Villager spawnGreenVillager(final Location location) {
        final WorldServer handle = ((CraftWorld)location.getWorld()).getHandle();
        final VillagerNMS villagerNMS = new VillagerNMS((World)handle);
        villagerNMS.setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
        ((CraftLivingEntity)villagerNMS.getBukkitEntity()).setRemoveWhenFarAway(false);
        villagerNMS.setCustomName(Messages.getMsg().getString("merchant").replace('&', '?'));
        villagerNMS.setCustomNameVisible(true);
        ((World)handle).addEntity((Entity)villagerNMS, CreatureSpawnEvent.SpawnReason.CUSTOM);
        return (Villager)villagerNMS.getBukkitEntity();
    }
    
    public static Villager spawnBlueVillager(final Location location) {
        final WorldServer handle = ((CraftWorld)location.getWorld()).getHandle();
        final VillagerNMS villagerNMS = new VillagerNMS((World)handle);
        villagerNMS.setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
        ((CraftLivingEntity)villagerNMS.getBukkitEntity()).setRemoveWhenFarAway(false);
        villagerNMS.setCustomName(Messages.getMsg().getString("merchant").replace('&', '?'));
        villagerNMS.setCustomNameVisible(true);
        ((World)handle).addEntity((Entity)villagerNMS, CreatureSpawnEvent.SpawnReason.CUSTOM);
        return (Villager)villagerNMS.getBukkitEntity();
    }
}
