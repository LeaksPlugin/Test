package com.andrei1058.skygiants.debug;

import com.andrei1058.skygiants.*;

public class Logger
{
    public static void debugMsg(final String s) {
        if (!Main.Debug) {
            return;
        }
        Main.plugin.getLogger().info(s);
    }
}
