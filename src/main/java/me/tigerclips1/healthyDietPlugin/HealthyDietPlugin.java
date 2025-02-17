// Package this class to a jar.
package me.tigerclips1.healthyDietPlugin;

// Import the required classes.

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

// The main plugin class.
public final class HealthyDietPlugin extends JavaPlugin {

    // Make it where if the plugin start it will load the diet class.
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new healthyDiet(this), this);
    }
}
