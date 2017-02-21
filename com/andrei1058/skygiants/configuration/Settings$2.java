package com.andrei1058.skygiants.configuration;

import org.bukkit.*;
import org.bukkit.command.*;

static final class Settings$2 implements Runnable {
    @Override
    public void run() {
        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "restart");
    }
}