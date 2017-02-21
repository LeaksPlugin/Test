package com.andrei1058.skygiants.game;

import org.bukkit.entity.*;
import com.andrei1058.skygiants.utils.*;
import com.andrei1058.skygiants.*;
import com.andrei1058.skygiants.configuration.*;
import java.util.*;
import org.bukkit.scoreboard.*;

static final class Scoreboard$1 implements Runnable {
    final /* synthetic */ Player val$p;
    
    @Override
    public void run() {
        final MySQL mySQL = new MySQL(Database.host, Database.port, Database.database, Database.username, Database.password);
        mySQL.connect();
        Main.sb = Main.sbmanager.getNewScoreboard();
        (Main.obj = Main.sb.registerNewObjective("Test", "Test2")).setDisplayName(Messages.getMsg().getString("stats").replace('&', '?'));
        Main.obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        final Score score = Main.obj.getScore(Messages.getMsg().getString("deaths").replace('&', '?'));
        final Score score2 = Main.obj.getScore(Messages.getMsg().getString("gold-earnt").replace('&', '?'));
        final Score score3 = Main.obj.getScore(Messages.getMsg().getString("games-played").replace('&', '?'));
        final Score score4 = Main.obj.getScore(Messages.getMsg().getString("kills").replace('&', '?'));
        final Score score5 = Main.obj.getScore(Messages.getMsg().getString("beasts-slain").replace('&', '?'));
        final Score score6 = Main.obj.getScore(Messages.getMsg().getString("rampages").replace('&', '?'));
        final Score score7 = Main.obj.getScore(Messages.getMsg().getString("shutdowns").replace('&', '?'));
        final Score score8 = Main.obj.getScore(Messages.getMsg().getString("victories").replace('&', '?'));
        score.setScore((int)mySQL.getScore(Database.table, "Deaths", this.val$p));
        score2.setScore((int)mySQL.getScore(Database.table, "GoldEarnt", this.val$p));
        score3.setScore((int)mySQL.getScore(Database.table, "GamesPlayed", this.val$p));
        score4.setScore((int)mySQL.getScore(Database.table, "Kills", this.val$p));
        score5.setScore((int)mySQL.getScore(Database.table, "BeastsSlain", this.val$p));
        score6.setScore((int)mySQL.getScore(Database.table, "Rampages", this.val$p));
        score7.setScore((int)mySQL.getScore(Database.table, "Shutdowns", this.val$p));
        score8.setScore((int)mySQL.getScore(Database.table, "Victories", this.val$p));
        this.val$p.setScoreboard(Main.sb);
        if (!mySQL.isDataExists(Database.table, "UUID", this.val$p.getUniqueId().toString())) {
            final ArrayList<String> list = new ArrayList<String>();
            list.add("ID");
            list.add("Player");
            list.add("Kills");
            list.add("Deaths");
            list.add("BeastsSlain");
            list.add("GoldEarnt");
            list.add("GamesPlayed");
            list.add("Victories");
            list.add("Shutdowns");
            list.add("Rampages");
            list.add("UUID");
            final ArrayList<String> list2 = new ArrayList<String>();
            list2.add("0");
            list2.add(this.val$p.getName().toString());
            list2.add("0");
            list2.add("0");
            list2.add("0");
            list2.add("0");
            list2.add("0");
            list2.add("0");
            list2.add("0");
            list2.add("0");
            list2.add(this.val$p.getUniqueId().toString());
            mySQL.createDate(Database.table, list, list2);
        }
        mySQL.close();
    }
}