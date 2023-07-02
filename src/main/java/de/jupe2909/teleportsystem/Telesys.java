package de.jupe2909.teleportsystem;
//lol
import de.jupe2909.teleportsystem.commands.Compass;
import de.jupe2909.teleportsystem.commands.JoinLeav;
import de.jupe2909.teleportsystem.commands.Testcommand;
import de.jupe2909.teleportsystem.commands.inv;

import de.jupe2909.teleportsystem.item.Items;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class Telesys extends JavaPlugin implements @NotNull Listener {

    @Override
    public void onEnable() {
        getCommand("test").setExecutor(new Testcommand());
        getCommand("compass").setExecutor(new Compass());
        Bukkit.getPluginManager().registerEvents(new inv(), this);
        Bukkit.getPluginManager().registerEvents(new Items(), this);
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JoinLeav() , this);


    }
    @Override
    public void onDisable() {
        // Plugin-Deaktivierung
    }

}
