package fr.edminecoreteam.core.gamemanager;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SaveInventory 
{
	private Map<UUID, ItemStack[]> savedInventories = new HashMap<>();

    public void saveInventory(Player player) {
        savedInventories.put(player.getUniqueId(), player.getInventory().getContents());
    }

    public void restoreInventory(Player player) {
        ItemStack[] savedInventory = savedInventories.get(player.getUniqueId());
        if (savedInventory != null) {
            player.getInventory().setContents(savedInventory);
            player.sendMessage(ChatColor.GREEN + "Votre inventaire a été restauré !");
        } else {
            player.sendMessage(ChatColor.RED + "Aucun inventaire sauvegardé pour vous !");
        }
    }
}
