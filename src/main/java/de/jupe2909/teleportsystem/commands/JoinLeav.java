package de.jupe2909.teleportsystem.commands;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class JoinLeav  implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        Inventory inventory = player.getInventory();

        ItemStack item = new ItemStack(Material.RECOVERY_COMPASS); // Erstelle das gewünschte Item
        int slot = 8; // Der gewünschte Inventarslot, auf dem das Item platziert werden soll

        inventory.setItem(slot, item); // Item auf den Slot im Inventar des Spielers platzieren

    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        ItemStack item = e.getItemDrop().getItemStack();
        if (item.getType() == Material.RECOVERY_COMPASS) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onMoveItem(InventoryClickEvent e) {
        if (e.getCurrentItem() != null && e.getCurrentItem().getType() == Material.RECOVERY_COMPASS) {
            e.setCancelled(true);
        }
    }

    }


