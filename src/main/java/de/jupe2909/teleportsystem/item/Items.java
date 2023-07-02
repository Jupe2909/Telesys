package de.jupe2909.teleportsystem.item;

import de.jupe2909.teleportsystem.util.itemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Items implements Listener {
    @EventHandler

    public void onInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if (event.getItem() == null) return;

        ItemStack itemStack = event.getItem();

        if (itemStack.getType() == Material.RECOVERY_COMPASS){

            Inventory inventory = Bukkit.createInventory( null , 3*9, "§cTeleportation" );
            inventory.setItem(10, new itemBuilder(Material.PAPER).setDisplayname("§aSpielerinformation").setLore("§7Name: " + player.getName() , "§7UUID: " + player.getUniqueId(), "§7Gamemode: " + player.getGameMode() ).build());

            if (player.getGameMode() == GameMode.CREATIVE){
                inventory.setItem(12, new itemBuilder(Material.IRON_SWORD).setDisplayname("§aGamemode Survival").setLocalizedName("Survival").build());

            }else {
                inventory.setItem(12, new itemBuilder(Material.COMMAND_BLOCK).setDisplayname("§aGamemode Survival").setLocalizedName("Creative").build());

            }

            inventory.setItem(14, new itemBuilder(Material.GRASS_BLOCK).setDisplayname("§aGamemode Test TP").setLocalizedName("spawn").build());

            player.openInventory(inventory);;
        }




}

    public static class RecoveryCompass {

        public static void giveRecoveryCompass(Player player) {
            ItemStack compass = new ItemStack(Material.COMPASS);
            ItemMeta meta = compass.getItemMeta();
            meta.setDisplayName("Recovery Compass");
            compass.setItemMeta(meta);

            player.getInventory().setItem(7, compass);
        }
    }
}
