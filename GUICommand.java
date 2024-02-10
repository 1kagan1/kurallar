package kagan0ft.kurallar.commands;

import kagan0ft.kurallar.Kurallar;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;
import java.util.List;

public class GUICommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("You need to be a player to use this.");
            return true;
        }

        Player player = (Player) commandSender;

        Inventory inventory = Bukkit.createInventory(player, 9 * 6, ChatColor.AQUA + "RULES");

        // Book 1
        ItemStack book1 = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta book1Meta = book1.getItemMeta();
        book1Meta.setDisplayName(ChatColor.AQUA + "MUTE RULES");

        // Book 1 Lore
        List<String> book1Lore = new ArrayList<>();
        book1Lore.add(ChatColor.DARK_AQUA + "Capitalization & Letter Extension & Spam: Mute for 20 - 35 minutes");
        book1Lore.add(ChatColor.DARK_AQUA + "Insult & Disrespect: Mute for 2 hours");
        book1Lore.add(ChatColor.DARK_AQUA + "Provocation: Mute for 35 minutes");
        book1Lore.add(ChatColor.DARK_AQUA + "Profanity: Mute for 4 hours");
        book1Lore.add(ChatColor.DARK_AQUA + "Sexual Content: Mute for 1 - 3 days");
        book1Lore.add(ChatColor.DARK_AQUA + "Family Insults: Mute for 12 - 24 hours");
        book1Lore.add(ChatColor.DARK_AQUA + "Mentioning Server Name: Mute for 3 days");
        book1Lore.add(ChatColor.DARK_AQUA + "Racism: Mute for 3 days");
        book1Meta.setLore(book1Lore);
        book1.setItemMeta(book1Meta);

        // Book 2
        ItemStack book2 = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta book2Meta = book2.getItemMeta();
        book2Meta.setDisplayName(ChatColor.AQUA + "BAN RULES");

        // Book 2 Lore
        List<String> book2Lore = new ArrayList<>();
        book2Lore.add(ChatColor.DARK_AQUA + "Disrespect to Religious/National Values - Permanent Ban");
        book2Lore.add(ChatColor.DARK_AQUA + "Server Advertising & Social Media Advertisements: Permanent Ban");
        book2Lore.add(ChatColor.DARK_AQUA + "In-Game Trade with Real Money - Permanent Ban");
        book2Lore.add(ChatColor.DARK_AQUA + "Cheating: 14 Days, Permanent Ban");
        book2Lore.add(ChatColor.DARK_AQUA + "Macro/AutoClicker: 7 Days Ban");
        book2Lore.add(ChatColor.DARK_AQUA + "Scamming - 14 Days Ban");
        book2Meta.setLore(book2Lore);

        book2.setItemMeta(book2Meta);

        // Add items to the GUI
        inventory.setItem(21, book1);
        inventory.setItem(23, book2);

        // Open the GUI
        player.openInventory(inventory);
        player.setMetadata("OpenedMenu", new FixedMetadataValue(Kurallar.getInstance(), "Rules Menu"));

        return true;
    }
}
