package com.andrei1058.skygiants.protocolLib;

import com.andrei1058.skygiants.*;
import com.comphenix.protocol.*;
import org.bukkit.plugin.*;
import com.comphenix.protocol.events.*;

public class PotionEfect
{
    public static void registerPotionEffects() {
        final Main plugin = Main.plugin;
        Main.protocolLib.addPacketListener((PacketListener)new PacketAdapter(Main.plugin, ListenerPriority.NORMAL, new PacketType[] { PacketType.Play.Server.ENTITY_EFFECT }) {
            public void onPacketSending(final PacketEvent packetEvent) {
                if (packetEvent.getPacketType() == PacketType.Play.Server.ENTITY_EFFECT && Main.spectators.contains(packetEvent.getPlayer())) {
                    packetEvent.setCancelled(true);
                }
            }
        });
    }
}
