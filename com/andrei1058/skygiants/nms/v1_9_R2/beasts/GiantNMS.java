package com.andrei1058.skygiants.nms.v1_9_R2.beasts;

import org.bukkit.craftbukkit.v1_9_R2.util.*;
import java.lang.reflect.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.craftbukkit.v1_9_R2.*;
import org.bukkit.craftbukkit.v1_9_R2.entity.*;
import org.bukkit.event.entity.*;
import com.andrei1058.skygiants.*;
import net.minecraft.server.v1_9_R2.*;

public class GiantNMS extends EntityGiantZombie
{
    public GiantNMS(final World world) {
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
        this.goalSelector.a(2, (PathfinderGoal)new PathfinderGoalHurtByTarget((EntityCreature)this, true, new Class[] { EntityHuman.class }));
    }
    
    public void move(final double n, final double n2, final double n3) {
    }
    
    public void collide(final Entity entity) {
    }
    
    public void g(final double n, final double n2, final double n3) {
    }
    
    public static Giant spawnMagentaGiant(final Location location) {
        final WorldServer handle = ((CraftWorld)location.getWorld()).getHandle();
        final GiantNMS magentaGiant = new GiantNMS((World)handle);
        magentaGiant.setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
        ((CraftLivingEntity)magentaGiant.getBukkitEntity()).setRemoveWhenFarAway(false);
        ((World)handle).addEntity((Entity)magentaGiant, CreatureSpawnEvent.SpawnReason.CUSTOM);
        magentaGiant.getAttributeInstance(GenericAttributes.maxHealth).setValue(850.0);
        if (!Main.miniSG) {
            magentaGiant.setHealth(850.0f);
        }
        else {
            magentaGiant.setHealth(510.0f);
        }
        com.andrei1058.skygiants.nms.v1_9_R2.Main.MagentaGiant = magentaGiant;
        Main.aliveTeams.add("MAGENTA");
        return (Giant)magentaGiant.getBukkitEntity();
    }
    
    public static Giant spawnOrangeGiant(final Location location) {
        final WorldServer handle = ((CraftWorld)location.getWorld()).getHandle();
        final GiantNMS goldGiant = new GiantNMS((World)handle);
        goldGiant.setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
        ((CraftLivingEntity)goldGiant.getBukkitEntity()).setRemoveWhenFarAway(false);
        ((World)handle).addEntity((Entity)goldGiant, CreatureSpawnEvent.SpawnReason.CUSTOM);
        goldGiant.getAttributeInstance(GenericAttributes.maxHealth).setValue(850.0);
        if (!Main.miniSG) {
            goldGiant.setHealth(850.0f);
        }
        else {
            goldGiant.setHealth(510.0f);
        }
        com.andrei1058.skygiants.nms.v1_9_R2.Main.GoldGiant = goldGiant;
        Main.aliveTeams.add("GOLD");
        return (Giant)goldGiant.getBukkitEntity();
    }
    
    public static Giant spawnBlueGiant(final Location location) {
        final WorldServer handle = ((CraftWorld)location.getWorld()).getHandle();
        final GiantNMS blueGiant = new GiantNMS((World)handle);
        blueGiant.setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
        ((CraftLivingEntity)blueGiant.getBukkitEntity()).setRemoveWhenFarAway(false);
        ((World)handle).addEntity((Entity)blueGiant, CreatureSpawnEvent.SpawnReason.CUSTOM);
        blueGiant.getAttributeInstance(GenericAttributes.maxHealth).setValue(850.0);
        if (!Main.miniSG) {
            blueGiant.setHealth(850.0f);
        }
        else {
            blueGiant.setHealth(510.0f);
        }
        com.andrei1058.skygiants.nms.v1_9_R2.Main.BlueGiant = blueGiant;
        Main.aliveTeams.add("BLUE");
        return (Giant)blueGiant.getBukkitEntity();
    }
    
    public static Giant spawnGreenGiant(final Location location) {
        final WorldServer handle = ((CraftWorld)location.getWorld()).getHandle();
        final GiantNMS greenGiant = new GiantNMS((World)handle);
        greenGiant.setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
        ((CraftLivingEntity)greenGiant.getBukkitEntity()).setRemoveWhenFarAway(false);
        ((World)handle).addEntity((Entity)greenGiant, CreatureSpawnEvent.SpawnReason.CUSTOM);
        greenGiant.getAttributeInstance(GenericAttributes.maxHealth).setValue(850.0);
        if (!Main.miniSG) {
            greenGiant.setHealth(850.0f);
        }
        else {
            greenGiant.setHealth(510.0f);
        }
        com.andrei1058.skygiants.nms.v1_9_R2.Main.GreenGiant = greenGiant;
        Main.aliveTeams.add("GREEN");
        return (Giant)greenGiant.getBukkitEntity();
    }
}
