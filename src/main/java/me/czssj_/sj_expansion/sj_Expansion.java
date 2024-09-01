package me.czssj_.sj_expansion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

import javax.annotation.Nonnull;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;

import me.czssj_.sj_expansion.setup.sj_Expansion_setup;

public class sj_Expansion extends JavaPlugin implements SlimefunAddon
{
    private static sj_Expansion instance;
    private static final String GITHUB_API_URL = "http://api.github.com/repos/czszzh/sj_Expansion/releases/latest";
    private static final Logger LOGGER = Logger.getLogger("sj_Expansion");

    @Override
    public void onEnable() 
    {
        instance = this;
        Config cfg = new Config(this);
        if (cfg.getBoolean("options.check-update")) 
        {
            checkForUpdates();
        }

        sj_Expansion_setup.setup(this);
        LOGGER.info("====================");
        LOGGER.info("|   sj_Expansion   |");
        LOGGER.info("|      by sj_      |");
        LOGGER.info("====================");
    }

    @Override
    public void onDisable() 
    {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() 
    {
        return "https://github.com/czszzh/sj_Expansion/issues";
    }

    @Nonnull
    @Override
    public JavaPlugin getJavaPlugin() 
    {
        return this;
    }

    public static sj_Expansion getInstance() 
    {
        return instance;
    }

    private void checkForUpdates() 
    {
        Bukkit.getScheduler().runTaskAsynchronously(this, () -> {
            try 
            {
                URL url = new URL(GITHUB_API_URL);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) 
                {
                    content.append(inputLine);
                }
                in.close();
                connection.disconnect();

                String latestVersion = content.toString().split("\"tag_name\":\"")[1].split("\"")[0];
                String currentVersion = getDescription().getVersion();

                if (!latestVersion.equals(currentVersion)) 
                {
                    LOGGER.info("A new version is available: " + latestVersion);
                    LOGGER.info("Please update from: https://github.com/czszzh/sj_Expansion/releases");
                }
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        });
    }
}