package com.andrei1058.skygiants.nms.v1_10_R1.beasts;

import org.bukkit.craftbukkit.v1_10_R1.util.*;
import java.lang.reflect.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.craftbukkit.v1_10_R1.*;
import org.bukkit.craftbukkit.v1_10_R1.entity.*;
import org.bukkit.event.entity.*;
import com.andrei1058.skygiants.configuration.*;
import com.andrei1058.skygiants.*;
import net.minecraft.server.v1_10_R1.*;

public class GuardianNMS extends EntityGuardian
{
    public GuardianNMS(final World world) {
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
        this.goalSelector.a(5, (PathfinderGoal)new PathfinderGoalMoveTowardsRestriction((EntityCreature)this, 0.6));
        this.goalSelector.a(9, (PathfinderGoal)new PathfinderGoalInteract((EntityInsentient)this, (Class)EntityHuman.class, 3.0f, 1.0f));
        this.goalSelector.a(9, (PathfinderGoal)new PathfinderGoalRandomStroll((EntityCreature)this, 0.6));
        this.goalSelector.a(10, (PathfinderGoal)new PathfinderGoalLookAtPlayer((EntityInsentient)this, (Class)EntityHuman.class, 8.0f));
        this.goalSelector.a(2, (PathfinderGoal)new PathfinderGoalHurtByTarget((EntityCreature)this, true, new Class[] { EntityHuman.class }));
        this.goalSelector.a(10, (PathfinderGoal)new PathfinderGoalMeleeAttack((EntityCreature)this, 1.0, true));
        this.targetSelector.a(5, (PathfinderGoal)new PathfinderGoalNearestAttackableTarget((EntityCreature)this, (Class)EntityHuman.class, true));
    }
    
    public void move(final double n, final double n2, final double n3) {
    }
    
    public void collide(final Entity entity) {
    }
    
    public void g(final double n, final double n2, final double n3) {
    }
    
    public static Guardian spawnGuardian(final Location location) {
        final WorldServer handle = ((CraftWorld)location.getWorld()).getHandle();
        final GuardianNMS guardianNMS = new GuardianNMS((World)handle);
        guardianNMS.setElder(true);
        guardianNMS.getAttributeInstance(GenericAttributes.maxHealth).setValue(350.0);
        guardianNMS.setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
        ((CraftLivingEntity)guardianNMS.getBukkitEntity()).setRemoveWhenFarAway(false);
        ((World)handle).addEntity((Entity)guardianNMS, CreatureSpawnEvent.SpawnReason.CUSTOM);
        guardianNMS.setCustomNameVisible(false);
        guardianNMS.setCustomName(Messages.getMsg().getString("hydros").replace('&', '?'));
        guardianNMS.setHealth((float)Main.BeastHealth);
        Main.beastSpawned = true;
        Main.beastType = "GUARDIAN";
        return (Guardian)guardianNMS.getBukkitEntity();
    }
}
