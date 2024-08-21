package me.czssj_.sj_expansion;

import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;

import me.czssj_.sj_expansion.setup.sj_Expansion_setup;

public class sj_Expansion extends JavaPlugin implements SlimefunAddon
{
    private static sj_Expansion instance;

    @Override
    public void onEnable() 
    {
        instance = this;
        /*
        //Read something from your config.yml
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
             //You could start an Auto-Updater for example
        }
        */

        sj_Expansion_setup.setup(this);
    }

    @Override
    public void onDisable() 
    {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() 
    {
        // You can return a link to your Bug Tracker instead of null here
        return null;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        /*
         * You will need to return a reference to your Plugin here.
         * If you are using your main class for this, simply return "this".
         */
        return this;
    }

    public static sj_Expansion getInstance() 
    {
        return instance;
    }
}