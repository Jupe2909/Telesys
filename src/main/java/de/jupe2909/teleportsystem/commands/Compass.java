package de.jupe2909.teleportsystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;

public class Compass implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Dieser Befehl kann nur von einem Spieler ausgeführt werden.");
            return true;
        }

        Player player = (Player) sender;
        Inventory inventory = player.getInventory();

        ItemStack item = new ItemStack(Material.RECOVERY_COMPASS); // Erstelle das gewünschte Item
        int slot = 8; // Der gewünschte Inventarslot, auf dem das Item platziert werden soll

        inventory.setItem(slot, item); // Item auf den Slot im Inventar des Spielers platzieren

        sender.sendMessage("Kompass wurde auf Slot " + slot + " platziert.");

        return true;
    }
}
