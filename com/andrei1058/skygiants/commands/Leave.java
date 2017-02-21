package com.andrei1058.skygiants.commands;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import com.andrei1058.skygiants.configuration.*;
import com.andrei1058.skygiants.*;
import org.bukkit.plugin.*;
import com.google.common.io.*;

public class Leave implements CommandExecutor
{
    public boolean onCommand(final CommandSender commandSender, final Command command, final String s, final String[] array) {
        if (!(commandSender instanceof Player)) {
            return true;
        }
        final Player player = (Player)commandSender;
        if (command.getName().equalsIgnoreCase("leave")) {
            final ByteArrayDataOutput dataOutput = ByteStreams.newDataOutput();
            dataOutput.writeUTF("Connect");
            dataOutput.writeUTF(Settings.getCfg().getString("lobby-server"));
            player.sendPluginMessage((Plugin)Main.plugin, "BungeeCord", dataOutput.toByteArray());
            return true;
        }
        return false;
    }
}
