package com.andrei1058.skygiants.utils;

import java.net.*;
import com.andrei1058.skygiants.*;
import java.io.*;

static final class Updater$1 implements Runnable {
    @Override
    public void run() {
        try {
            final HttpURLConnection httpURLConnection = (HttpURLConnection)new URL("http://www.spigotmc.org/api/general.php").openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.getOutputStream().write("key=98BE0FE67F88AB82B4C197FAF1DC3B69206EFDCC4D3B80FC83A00037510B99B4&resource=29803".getBytes());
            final String version = Main.plugin.getDescription().getVersion();
            final String replaceAll = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream())).readLine().replaceAll("[a-zA-Z ]", "");
            if (!replaceAll.equalsIgnoreCase(version)) {
                final Main plugin = Main.plugin;
                Main.updateAvailable = true;
                final Main plugin2 = Main.plugin;
                Main.newVersion = replaceAll;
                Main.plugin.getLogger().info("There is a nev version available!");
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}