package com.andrei1058.skygiants.protocolLib;

import org.bukkit.entity.*;
import com.andrei1058.skygiants.*;
import com.comphenix.protocol.*;
import com.comphenix.protocol.wrappers.*;
import com.andrei1058.skygiants.configuration.*;
import java.lang.reflect.*;
import com.comphenix.protocol.events.*;
import org.bukkit.*;
import java.util.*;

public class Borders
{
    public static void magentaBorders(final Player player) {
        final Main plugin = Main.plugin;
        final PacketContainer packet = Main.protocolLib.createPacket(PacketType.Play.Server.WORLD_BORDER);
        packet.getWorldBorderActions().write(0, (Object)EnumWrappers.WorldBorderAction.INITIALIZE);
        packet.getDoubles().write(0, (Object)ArenaCfg.getArena(Main.choosenMap).getDouble("Border.Magenta.X")).write(1, (Object)ArenaCfg.getArena(Main.choosenMap).getDouble("Border.Magenta.Z")).write(2, (Object)ArenaCfg.getArena(Main.choosenMap).getDouble("Border.Magenta.Size")).write(3, (Object)ArenaCfg.getArena(Main.choosenMap).getDouble("Border.Magenta.Size"));
        packet.getLongs().write(0, (Object)0L);
        packet.getIntegers().write(0, (Object)29999984).write(1, (Object)0).write(2, (Object)0);
        try {
            final Main plugin2 = Main.plugin;
            Main.protocolLib.sendServerPacket(player, packet);
        }
        catch (InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void goldBorders(final Player player) {
        final Main plugin = Main.plugin;
        final PacketContainer packet = Main.protocolLib.createPacket(PacketType.Play.Server.WORLD_BORDER);
        packet.getWorldBorderActions().write(0, (Object)EnumWrappers.WorldBorderAction.INITIALIZE);
        packet.getDoubles().write(0, (Object)ArenaCfg.getArena(Main.choosenMap).getDouble("Border.Gold.X")).write(1, (Object)ArenaCfg.getArena(Main.choosenMap).getDouble("Border.Gold.Z")).write(2, (Object)ArenaCfg.getArena(Main.choosenMap).getDouble("Border.Gold.Size")).write(3, (Object)ArenaCfg.getArena(Main.choosenMap).getDouble("Border.Gold.Size"));
        packet.getLongs().write(0, (Object)0L);
        packet.getIntegers().write(0, (Object)29999984).write(1, (Object)0).write(2, (Object)0);
        try {
            final Main plugin2 = Main.plugin;
            Main.protocolLib.sendServerPacket(player, packet);
        }
        catch (InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void greenBorders(final Player player) {
        final Main plugin = Main.plugin;
        final PacketContainer packet = Main.protocolLib.createPacket(PacketType.Play.Server.WORLD_BORDER);
        packet.getWorldBorderActions().write(0, (Object)EnumWrappers.WorldBorderAction.INITIALIZE);
        packet.getDoubles().write(0, (Object)ArenaCfg.getArena(Main.choosenMap).getDouble("Border.Green.X")).write(1, (Object)ArenaCfg.getArena(Main.choosenMap).getDouble("Border.Green.Z")).write(2, (Object)ArenaCfg.getArena(Main.choosenMap).getDouble("Border.Green.Size")).write(3, (Object)ArenaCfg.getArena(Main.choosenMap).getDouble("Border.Green.Size"));
        packet.getLongs().write(0, (Object)0L);
        packet.getIntegers().write(0, (Object)29999984).write(1, (Object)0).write(2, (Object)0);
        try {
            final Main plugin2 = Main.plugin;
            Main.protocolLib.sendServerPacket(player, packet);
        }
        catch (InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void blueBorders(final Player player) {
        final Main plugin = Main.plugin;
        final PacketContainer packet = Main.protocolLib.createPacket(PacketType.Play.Server.WORLD_BORDER);
        packet.getWorldBorderActions().write(0, (Object)EnumWrappers.WorldBorderAction.INITIALIZE);
        packet.getDoubles().write(0, (Object)ArenaCfg.getArena(Main.choosenMap).getDouble("Border.Blue.X")).write(1, (Object)ArenaCfg.getArena(Main.choosenMap).getDouble("Border.Blue.Z")).write(2, (Object)ArenaCfg.getArena(Main.choosenMap).getDouble("Border.Blue.Size")).write(3, (Object)ArenaCfg.getArena(Main.choosenMap).getDouble("Border.Bluereload.Size"));
        packet.getLongs().write(0, (Object)0L);
        packet.getIntegers().write(0, (Object)29999984).write(1, (Object)0).write(2, (Object)0);
        try {
            final Main plugin2 = Main.plugin;
            Main.protocolLib.sendServerPacket(player, packet);
        }
        catch (InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void removeBorder() {
        final Main plugin = Main.plugin;
        final PacketContainer packet = Main.protocolLib.createPacket(PacketType.Play.Server.WORLD_BORDER);
        packet.getWorldBorderActions().write(0, (Object)EnumWrappers.WorldBorderAction.INITIALIZE);
        packet.getDoubles().write(0, (Object)Main.plugin.getConfig().getDouble("Border.Magenta.Z")).write(1, (Object)Main.plugin.getConfig().getDouble("Border.Magenta.Z")).write(2, (Object)3.0E7).write(3, (Object)3.0E7);
        packet.getLongs().write(0, (Object)0L);
        packet.getIntegers().write(0, (Object)29999984).write(1, (Object)0).write(2, (Object)0);
        try {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                final Main plugin2 = Main.plugin;
                Main.protocolLib.sendServerPacket(player, packet);
            }
        }
        catch (InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }
}
