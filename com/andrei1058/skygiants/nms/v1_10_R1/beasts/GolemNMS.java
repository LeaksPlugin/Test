package com.andrei1058.skygiants.nms.v1_10_R1.beasts;

import java.util.*;
import java.lang.reflect.*;
import com.andrei1058.skygiants.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.craftbukkit.v1_10_R1.*;
import org.bukkit.craftbukkit.v1_10_R1.entity.*;
import org.bukkit.event.entity.*;
import com.andrei1058.skygiants.configuration.*;
import net.minecraft.server.v1_10_R1.*;

public class GolemNMS extends EntityIronGolem
{
    public GolemNMS(final World world) {
        super(world);
        try {
            final Field declaredField = PathfinderGoalSelector.class.getDeclaredField("b");
            declaredField.setAccessible(true);
            final Field declaredField2 = PathfinderGoalSelector.class.getDeclaredField("c");
            declaredField2.setAccessible(true);
            declaredField.set(this.goalSelector, new HashSet());
            declaredField.set(this.targetSelector, new HashSet());
            declaredField2.set(this.goalSelector, new HashSet());
            declaredField2.set(this.targetSelector, new HashSet());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        this.goalSelector.a(5, (PathfinderGoal)new PathfinderGoalMoveTowardsRestriction((EntityCreature)this, 0.6));
        this.goalSelector.a(9, (PathfinderGoal)new PathfinderGoalInteract((EntityInsentient)this, (Class)EntityHuman.class, 3.0f, 1.0f));
        this.goalSelector.a(9, (PathfinderGoal)new PathfinderGoalRandomStroll((EntityCreature)this, 0.6));
        this.goalSelector.a(10, (PathfinderGoal)new PathfinderGoalLookAtPlayer((EntityInsentient)this, (Class)EntityHuman.class, 8.0f));
        this.goalSelector.a(2, (PathfinderGoal)new PathfinderGoalHurtByTarget((EntityCreature)this, true, new Class[] { EntityHuman.class }));
        this.goalSelector.a(10, (PathfinderGoal)new PathfinderGoalMeleeAttack((EntityCreature)this, 2.0, true));
    }
    
    public void move(final double n, final double n2, final double n3) {
    }
    
    public void collide(final Entity entity) {
    }
    
    public void g(final double n, final double n2, final double n3) {
    }
    
    public void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(GenericAttributes.maxHealth).setValue((double)Main.BeastHealth);
    }
    
    public static IronGolem spawnGolem(final Location location) {
        final WorldServer handle = ((CraftWorld)location.getWorld()).getHandle();
        final GolemNMS golemNMS = new GolemNMS((World)handle);
        golemNMS.setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
        ((CraftLivingEntity)golemNMS.getBukkitEntity()).setRemoveWhenFarAway(false);
        ((World)handle).addEntity((Entity)golemNMS, CreatureSpawnEvent.SpawnReason.CUSTOM);
        golemNMS.setCustomName(Messages.getMsg().getString("talos").replace('&', '?'));
        golemNMS.setCustomNameVisible(false);
        golemNMS.setPlayerCreated(false);
        golemNMS.setHealth((float)Main.BeastHealth);
        Main.beastSpawned = true;
        Main.beastType = "IRON_GOLEM";
        return (IronGolem)golemNMS.getBukkitEntity();
    }
}
