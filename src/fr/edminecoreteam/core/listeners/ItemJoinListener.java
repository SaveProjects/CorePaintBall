// 
// Decompiled by Procyon v0.5.36
// 

package fr.edminecoreteam.core.listeners;

import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.Listener;

public class ItemJoinListener implements Listener
{
    
    public static void joinItem(Player p) {
        ItemStack team = new ItemStack(Material.BANNER, 1, (short)15);
        ItemMeta teamM = team.getItemMeta();
        teamM.setDisplayName("§f§lChoix de votre équipe §7• Clique");
        team.setItemMeta(teamM);
        p.getInventory().setItem(0, team);
        
        ItemStack leave = new ItemStack(Material.BED, 1);
        ItemMeta leaveM = leave.getItemMeta();
        leaveM.setDisplayName("§c§lQuitter §7• Clique");
        leave.setItemMeta(leaveM);
        p.getInventory().setItem(8, leave);
    }
    
    public static void spectacleItem(Player p) {
        ItemStack map = new ItemStack(Material.COMPASS, 1);
        ItemMeta mapM = map.getItemMeta();
        mapM.setDisplayName("§a§lJoueurs §7• Clique");
        map.setItemMeta(mapM);
        p.getInventory().setItem(0, map);
        
        ItemStack leave = new ItemStack(Material.BED, 1);
        ItemMeta leaveM = leave.getItemMeta();
        leaveM.setDisplayName("§c§lQuitter §7• Clique");
        leave.setItemMeta(leaveM);
        p.getInventory().setItem(8, leave);
    }
    
    public static void endItem(Player p) {
    	ItemStack replay = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta replayM = replay.getItemMeta();
        replayM.setDisplayName("§d§lRejouer §7• Clique");
        replay.setItemMeta(replayM);
        p.getInventory().setItem(0, replay);
    	
        ItemStack leave = new ItemStack(Material.BED, 1);
        ItemMeta leaveM = leave.getItemMeta();
        leaveM.setDisplayName("§c§lQuitter §7• Clique");
        leave.setItemMeta(leaveM);
        p.getInventory().setItem(8, leave);
    }
    
    public static void changeTeam(Player p, String teams) {
    	if (teams == "Random") {
    		ItemStack team = new ItemStack(Material.BANNER, 1, (short)15);
            ItemMeta teamM = team.getItemMeta();
            teamM.setDisplayName("§f§lChoix de votre équipe §7• Clique");
            team.setItemMeta(teamM);
            p.getInventory().setItem(0, team);
    	}
    	if (teams == "Rouge") {
    		ItemStack team = new ItemStack(Material.BANNER, 1, (short)1);
            ItemMeta teamM = team.getItemMeta();
            teamM.setDisplayName("§f§lChoix de votre équipe §7• Clique");
            team.setItemMeta(teamM);
            p.getInventory().setItem(0, team);
    	}
    	if (teams == "Bleue") {
    		ItemStack team = new ItemStack(Material.BANNER, 1, (short)4);
            ItemMeta teamM = team.getItemMeta();
            teamM.setDisplayName("§f§lChoix de votre équipe §7• Clique");
            team.setItemMeta(teamM);
            p.getInventory().setItem(0, team);
    	}
    	if (teams == "Jaune") {
    		ItemStack team = new ItemStack(Material.BANNER, 1, (short)11);
            ItemMeta teamM = team.getItemMeta();
            teamM.setDisplayName("§f§lChoix de votre équipe §7• Clique");
            team.setItemMeta(teamM);
            p.getInventory().setItem(0, team);
    	}
    	if (teams == "Vert") {
    		ItemStack team = new ItemStack(Material.BANNER, 1, (short)2);
            ItemMeta teamM = team.getItemMeta();
            teamM.setDisplayName("§f§lChoix de votre équipe §7• Clique");
            team.setItemMeta(teamM);
            p.getInventory().setItem(0, team);
    	}
    	if (teams == "Orange") {
    		ItemStack team = new ItemStack(Material.BANNER, 1, (short)14);
            ItemMeta teamM = team.getItemMeta();
            teamM.setDisplayName("§f§lChoix de votre équipe §7• Clique");
            team.setItemMeta(teamM);
            p.getInventory().setItem(0, team);
    	}
    	if (teams == "Rose") {
    		ItemStack team = new ItemStack(Material.BANNER, 1, (short)13);
            ItemMeta teamM = team.getItemMeta();
            teamM.setDisplayName("§f§lChoix de votre équipe §7• Clique");
            team.setItemMeta(teamM);
            p.getInventory().setItem(0, team);
    	}
    }
}
