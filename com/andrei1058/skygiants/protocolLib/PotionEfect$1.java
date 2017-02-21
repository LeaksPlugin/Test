package com.andrei1058.skygiants.protocolLib;

import org.bukkit.plugin.*;
import com.comphenix.protocol.*;
import com.comphenix.protocol.events.*;
import com.andrei1058.skygiants.*;

static final class PotionEfect$1 extends PacketAdapter {
    public void onPacketSending(final PacketEvent packetEvent) {
        if (packetEvent.getPacketType() == PacketType.Play.Server.ENTITY_EFFECT && Main.spectators.contains(packetEvent.getPlayer())) {
            packetEvent.setCancelled(true);
        }
    }
}