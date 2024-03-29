package kagan0ft.kurallar.events;

import kagan0ft.kurallar.Kurallar;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class GUIEvent implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (player.hasMetadata("OpenedMenu")) {
            event.setCancelled(true);

            if (event.getSlot() == 21) {
                player.sendMessage(ChatColor.GREEN + "You have read the rules.");
                player.closeInventory();

            } else if (event.getSlot() == 23) {
                player.sendMessage(ChatColor.GREEN + "You have read the rules.");
                player.closeInventory();

            }
        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();

        if (player.hasMetadata("OpenedMenu"))
            player.removeMetadata("OpenedMenu", Kurallar.getInstance());
    }
}
