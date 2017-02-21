package com.andrei1058.skygiants.utils;

import com.andrei1058.skygiants.*;
import java.util.*;

static final class Database$1 implements Runnable {
    @Override
    public void run() {
        if (Main.DatabaseB) {
            final ArrayList<String> list = new ArrayList<String>();
            list.add("ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY");
            list.add("Player char(36)");
            list.add("Kills INT");
            list.add("Deaths INT");
            list.add("BeastsSlain INT");
            list.add("GoldEarnt INT");
            list.add("GamesPlayed INT");
            list.add("Victories INT");
            list.add("Shutdowns INT");
            list.add("Rampages INT");
            list.add("UUID char(36)");
            new MySQL(Database.host, Database.port, Database.database, Database.username, Database.password).createTable(Database.table, list);
            Main.plugin.getLogger().info("Database connected!");
        }
    }
}