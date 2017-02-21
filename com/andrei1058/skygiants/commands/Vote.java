package com.andrei1058.skygiants.commands;

import org.bukkit.command.*;
import com.andrei1058.skygiants.*;
import com.andrei1058.skygiants.game.*;
import org.bukkit.entity.*;
import com.andrei1058.skygiants.utils.*;
import com.andrei1058.skygiants.configuration.*;

public class Vote implements CommandExecutor
{
    public boolean onCommand(final CommandSender commandSender, final Command command, final String s, final String[] array) {
        if (command.getName().equalsIgnoreCase("vote")) {
            if (Main.MAINTENANCE) {
                commandSender.sendMessage(Main.PREFIX + Messages.getMsg().getString("voting-disabled").replace('&', '?'));
                return true;
            }
            if (Main.STATUS == GameState.PLAYING) {
                commandSender.sendMessage(Main.PREFIX + Messages.getMsg().getString("voting-disabled").replace('&', '?'));
                return true;
            }
            if (Main.voted.contains(commandSender)) {
                commandSender.sendMessage(Main.PREFIX + Messages.getMsg().getString("already-voted").replace('&', '?'));
                return true;
            }
            if (array.length == 1) {
                if (!Misc.isInt(array[0])) {
                    ArenaCfg.listArenaVotes((Player)commandSender);
                    return true;
                }
                if (Settings.getCfg().getStringList("Arenas").size() < Integer.valueOf(array[0])) {
                    commandSender.sendMessage(Main.PREFIX + Messages.getMsg().getString("invalid-option").replace('&', '?'));
                    return true;
                }
                Main.mapsVoting.replace(Settings.getCfg().getStringList("Arenas").get(Integer.valueOf(array[0]) - 1), Main.mapsVoting.get(Settings.getCfg().getStringList("Arenas").get(Integer.valueOf(array[0]) - 1)) + 1);
                Main.voted.add((Player)commandSender);
                ArenaCfg.listArenaVotes((Player)commandSender);
            }
            else {
                ArenaCfg.listArenaVotes((Player)commandSender);
            }
        }
        return false;
    }
}
