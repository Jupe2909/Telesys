package de.jupe2909.teleportsystem.commands;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;
import java.io.SequenceInputStream;

public class inv implements Listener {
    @EventHandler

    public void onInvClick(InventoryClickEvent event){
        if (event.getCurrentItem() == null) return;
        if (event.getView().getTitle() == "§cTeleportation") {
            Player player = (Player) event.getWhoClicked();
            event.setCancelled(true);
            if (event.getCurrentItem().getItemMeta().hasLocalizedName()){
                switch (event.getCurrentItem().getItemMeta().getLocalizedName()){
                    case "Survival":
                        player.setGameMode(GameMode.SURVIVAL);
                        player.closeInventory();
                        break;
                    case "Creative":
                        player.setGameMode(GameMode.CREATIVE);
                        player.closeInventory();
                        break;
                    case "spawn":
                        player.sendMessage("");
                        player.sendMessage("Das Teleportazionsystem ist in bearbeitung.");
                        TextComponent c = new TextComponent("Hier Klicken und Enter drücken zum Teleportieren");
                        TextComponent klickme = new TextComponent("server rp_main");
                        c.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND,  "server rp.main"));

                        break;

                }
            }
        }
    }}
