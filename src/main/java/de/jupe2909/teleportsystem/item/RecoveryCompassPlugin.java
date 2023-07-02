package de.jupe2909.teleportsystem.item;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class RecoveryCompassPlugin implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        ItemStack item = event.getItem();

        if (item != null && item.getType() == Material.COMPASS) {
            if (item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {
                String displayName = item.getItemMeta().getDisplayName();

                if (displayName.equals("Recovery Compass")) {
                    event.setCancelled(true);
                    event.getPlayer().sendMessage("Du darfst den Recovery Compass nicht verschieben!");
                }
            }
        }
    }
}
