package de.jupe2909.teleportsystem.commands;

import de.jupe2909.teleportsystem.util.itemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;


public class Testcommand implements CommandExecutor {

    @Override
    public boolean onCommand( CommandSender sender,  Command command,  String s,  String[] strings) {

        if (!(sender instanceof Player)) return false;
        String message = "System bereit";

        Player player = (Player) sender;

        sender.sendMessage(message);
        Inventory inventory = Bukkit.createInventory( null , 3*9, "§cTest" );
        inventory.setItem(10, new itemBuilder(Material.PAPER).setDisplayname("§aSpielerinformation").setLore("§7Name: " + player.getName() , "§7UUID: " + player.getUniqueId(), "§7Gamemode: " + player.getGameMode() ).build());

        if (player.getGameMode() == GameMode.CREATIVE){
            inventory.setItem(12, new itemBuilder(Material.IRON_SWORD).setDisplayname("§aGamemode Survival").setLocalizedName("Survival").build());

        }else {
            inventory.setItem(12, new itemBuilder(Material.COMMAND_BLOCK).setDisplayname("§aGamemode Survival").setLocalizedName("Creative").build());

        }

        inventory.setItem(14, new itemBuilder(Material.GRASS_BLOCK).setDisplayname("§aGamemode Zum Spawn").setLocalizedName("spawn").build());

        player.openInventory(inventory);
        return false;
    }
}
