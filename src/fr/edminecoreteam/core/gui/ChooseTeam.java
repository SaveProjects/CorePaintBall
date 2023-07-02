package fr.edminecoreteam.core.gui;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import fr.edminecoreteam.core.Core;
import fr.edminecoreteam.core.utils.SkullNBT;

public class ChooseTeam implements Listener {
	
	private static Core core = Core.getInstance();
	
	private static ItemStack getSkull(String url) {
		return SkullNBT.getSkull(url);
	}
	
	public static void gui(Player p) {
		
		Inventory inv = Bukkit.createInventory(null, 54, "§8Choix de votre équipe");
        
		new BukkitRunnable() {
            int t = 0;
                
	        public void run() {
	        	
	        	if (!p.getOpenInventory().getTitle().equalsIgnoreCase("§8Choix de votre équipe")) { cancel(); }
		        	if (core.getRouge().contains(p.getDisplayName()))
		            {
		            	ItemStack deco = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
		                ItemMeta decoM = deco.getItemMeta();
		                decoM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		                decoM.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		                decoM.setDisplayName("§r");
		                deco.setItemMeta(decoM);
		                inv.setItem(0, deco); inv.setItem(8, deco); inv.setItem(9, deco); inv.setItem(17, deco);
		                inv.setItem(45, deco); inv.setItem(53, deco); inv.setItem(36, deco); inv.setItem(44, deco);
		            }
		            if (core.getBleue().contains(p.getDisplayName()))
		            {
		            	ItemStack deco = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)11);
		                ItemMeta decoM = deco.getItemMeta();
		                decoM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		                decoM.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		                decoM.setDisplayName("§r");
		                deco.setItemMeta(decoM);
		                inv.setItem(0, deco); inv.setItem(8, deco); inv.setItem(9, deco); inv.setItem(17, deco);
		                inv.setItem(45, deco); inv.setItem(53, deco); inv.setItem(36, deco); inv.setItem(44, deco);
		            }
		            if (core.getJaune().contains(p.getDisplayName()))
		            {
		            	ItemStack deco = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)4);
		                ItemMeta decoM = deco.getItemMeta();
		                decoM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		                decoM.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		                decoM.setDisplayName("§r");
		                deco.setItemMeta(decoM);
		                inv.setItem(0, deco); inv.setItem(8, deco); inv.setItem(9, deco); inv.setItem(17, deco);
		                inv.setItem(45, deco); inv.setItem(53, deco); inv.setItem(36, deco); inv.setItem(44, deco);
		            }
		            if (core.getVert().contains(p.getDisplayName()))
		            {
		            	ItemStack deco = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
		                ItemMeta decoM = deco.getItemMeta();
		                decoM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		                decoM.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		                decoM.setDisplayName("§r");
		                deco.setItemMeta(decoM);
		                inv.setItem(0, deco); inv.setItem(8, deco); inv.setItem(9, deco); inv.setItem(17, deco);
		                inv.setItem(45, deco); inv.setItem(53, deco); inv.setItem(36, deco); inv.setItem(44, deco);
		            }
		            if (core.getOrange().contains(p.getDisplayName()))
		            {
		            	ItemStack deco = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)1);
		                ItemMeta decoM = deco.getItemMeta();
		                decoM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		                decoM.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		                decoM.setDisplayName("§r");
		                deco.setItemMeta(decoM);
		                inv.setItem(0, deco); inv.setItem(8, deco); inv.setItem(9, deco); inv.setItem(17, deco);
		                inv.setItem(45, deco); inv.setItem(53, deco); inv.setItem(36, deco); inv.setItem(44, deco);
		            }
		            if (core.getRose().contains(p.getDisplayName()))
		            {
		            	ItemStack deco = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)6);
		                ItemMeta decoM = deco.getItemMeta();
		                decoM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		                decoM.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		                decoM.setDisplayName("§r");
		                deco.setItemMeta(decoM);
		                inv.setItem(0, deco); inv.setItem(8, deco); inv.setItem(9, deco); inv.setItem(17, deco);
		                inv.setItem(45, deco); inv.setItem(53, deco); inv.setItem(36, deco); inv.setItem(44, deco);
		            }
		            if (!(core.getRouge().contains(p.getDisplayName())) 
		            		&& !(core.getBleue().contains(p.getDisplayName())) 
		            			&& !(core.getJaune().contains(p.getDisplayName())) 
		            				&& !(core.getVert().contains(p.getDisplayName())) 
		            					&& !(core.getOrange().contains(p.getDisplayName())) 
		            						&& !(core.getRose().contains(p.getDisplayName())))
		            {
		            	ItemStack deco = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)0);
		                ItemMeta decoM = deco.getItemMeta();
		                decoM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		                decoM.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		                decoM.setDisplayName("§r");
		                deco.setItemMeta(decoM);
		                inv.setItem(0, deco); inv.setItem(8, deco); inv.setItem(9, deco); inv.setItem(17, deco);
		                inv.setItem(45, deco); inv.setItem(53, deco); inv.setItem(36, deco); inv.setItem(44, deco);
		            }
	        		
                ++t;
                if (t == 10) {
                    run();
                }
            }
        }.runTaskTimer((Plugin)core, 0L, 10L);
        
        
        ItemStack randomTeam = getSkull("http://textures.minecraft.net/texture/7881cc2747ba72cbcb06c3cc331742cd9de271a5bbffd0ecb14f1c6a8b69bc9e");
        ItemMeta randomTeamM = randomTeam.getItemMeta();
        randomTeamM.setDisplayName("§fÉquipe Aléatoire");
        ArrayList<String> loreRandom = new ArrayList<String>();
        loreRandom.add("");
        loreRandom.add(" §dInformation:");
        loreRandom.add(" §f▶ §7Activé ou non le mode");
        loreRandom.add(" §f▶ §7équipe aléatoire.");
        loreRandom.add("");
        loreRandom.add("§8➡ §fCliquez pour y accéder.");
        randomTeamM.setLore(loreRandom);
        randomTeam.setItemMeta(randomTeamM);
        inv.setItem(4, randomTeam);
		
        
        p.openInventory(inv);
        p.playSound(p.getLocation(), Sound.HORSE_ARMOR, 1.0f, 1.0f);
		
		if(core.getConfig().getBoolean("Mode.2vs4") == true) {
		    new BukkitRunnable() {
	            int t = 0;
	                
		        public void run() {
		        	
		        	if (!p.getOpenInventory().getTitle().equalsIgnoreCase("§8Choix de votre équipe")) { cancel(); }
		        		
		        		ItemStack rouge = new ItemStack(Material.BANNER, 1, (byte)1);
		        		ItemMeta rougeM = rouge.getItemMeta();
		        		rougeM.setDisplayName("§cÉquipe Rouge");
		        		if (core.getRouge().contains(p.getDisplayName())) {
		        			rougeM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		        			rougeM.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        		}
		        		ArrayList<String> loreRouge = new ArrayList<String>();
		        		loreRouge.add("");
		        		loreRouge.add(" §dInformation:");
		        		loreRouge.add(" §f▶ §7Joueur(s): §a" + core.getRouge().size() + "§f/" + "§a4");
		        		loreRouge.add("");
		        		loreRouge.add(" §bEmplacement(s):");
	        			if (core.getRouge().size() == 0) {
	        				loreRouge.add(" §f▶ §8Vide...");
	        			}
		        		for (String pls : core.getRouge()) {
		        			loreRouge.add(" §f▶ §8" + pls);
		        		}
		        		if (!core.getRouge().contains(p.getDisplayName())) 
	        			{
		        			loreRouge.add("");
		        			loreRouge.add("§8➡ §fCliquez pour rejoindre.");
	        			}
	        			else
	        			{
	        				loreRouge.add("");
	        				loreRouge.add("§8➡ §fÉquipe séléctionnée.");
	        			}
		        		rougeM.setLore(loreRouge);
		        		rouge.setItemMeta(rougeM);
		        		inv.setItem(21, rouge);
		        		
		        		ItemStack bleue = new ItemStack(Material.BANNER, 1, (byte)4);
		        		ItemMeta bleueM = bleue.getItemMeta();
		        		bleueM.setDisplayName("§9Équipe Bleue");
		        		if (core.getBleue().contains(p.getDisplayName())) {
		        			bleueM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		        			bleueM.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        		}
		        		ArrayList<String> loreBleue = new ArrayList<String>();
		        		loreBleue.add("");
		        		loreBleue.add(" §dInformation:");
		        		loreBleue.add(" §f▶ §7Joueur(s): §a" + core.getBleue().size() + "§f/" + "§a4");
		        		loreBleue.add("");
		        		loreBleue.add(" §bEmplacement(s):");
	        			if (core.getBleue().size() == 0) {
	        				loreBleue.add(" §f▶ §8Vide...");
	        			}
		        		for (String pls : core.getBleue()) {
		        			loreBleue.add(" §f▶ §8" + pls);
		        		}
		        		if (!core.getBleue().contains(p.getDisplayName())) 
	        			{
		        			loreBleue.add("");
		        			loreBleue.add("§8➡ §fCliquez pour rejoindre.");
	        			}
	        			else
	        			{
	        				loreBleue.add("");
	        				loreBleue.add("§8➡ §fÉquipe séléctionnée.");
	        			}
		        		bleueM.setLore(loreBleue);
		        		bleue.setItemMeta(bleueM);
		        		inv.setItem(23, bleue);
		        		
		        		p.updateInventory();
	                ++t;
	                if (t == 10) {
	                    run();
	                }
	            }
	        }.runTaskTimer((Plugin)core, 0L, 10L);
		}
		if (core.getConfig().getBoolean("Mode.4vs4")) {
			new BukkitRunnable() {
	            int t = 0;
	                
		        public void run() {
		        	
		        	if (!p.getOpenInventory().getTitle().equalsIgnoreCase("§8Choix de votre équipe")) { cancel(); }
		        		
		        		ItemStack rouge = new ItemStack(Material.BANNER, 1, (byte)1);
		        		ItemMeta rougeM = rouge.getItemMeta();
		        		rougeM.setDisplayName("§cÉquipe Rouge");
		        		if (core.getRouge().contains(p.getDisplayName())) {
		        			rougeM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		        			rougeM.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        		}
		        		ArrayList<String> loreRouge = new ArrayList<String>();
		        		loreRouge.add("");
		        		loreRouge.add(" §dInformation:");
		        		loreRouge.add(" §f▶ §7Joueur(s): §a" + core.getRouge().size() + "§f/" + "§a4");
		        		loreRouge.add("");
		        		loreRouge.add(" §bEmplacement(s):");
	        			if (core.getRouge().size() == 0) {
	        				loreRouge.add(" §f▶ §8Vide...");
	        			}
		        		for (String pls : core.getRouge()) {
		        			loreRouge.add(" §f▶ §8" + pls);
		        		}
		        		if (!core.getRouge().contains(p.getDisplayName())) 
	        			{
		        			loreRouge.add("");
		        			loreRouge.add("§8➡ §fCliquez pour rejoindre.");
	        			}
	        			else
	        			{
	        				loreRouge.add("");
	        				loreRouge.add("§8➡ §fÉquipe séléctionnée.");
	        			}
		        		rougeM.setLore(loreRouge);
		        		rouge.setItemMeta(rougeM);
		        		inv.setItem(20, rouge);
		        		
		        		ItemStack bleue = new ItemStack(Material.BANNER, 1, (byte)4);
		        		ItemMeta bleueM = bleue.getItemMeta();
		        		bleueM.setDisplayName("§9Équipe Bleue");
		        		if (core.getBleue().contains(p.getDisplayName())) {
		        			bleueM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		        			bleueM.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        		}
		        		ArrayList<String> loreBleue = new ArrayList<String>();
		        		loreBleue.add("");
		        		loreBleue.add(" §dInformation:");
		        		loreBleue.add(" §f▶ §7Joueur(s): §a" + core.getBleue().size() + "§f/" + "§a4");
		        		loreBleue.add("");
		        		loreBleue.add(" §bEmplacement(s):");
	        			if (core.getBleue().size() == 0) {
	        				loreBleue.add(" §f▶ §8Vide...");
	        			}
		        		for (String pls : core.getBleue()) {
		        			loreBleue.add(" §f▶ §8" + pls);
		        		}
		        		if (!core.getBleue().contains(p.getDisplayName())) 
	        			{
		        			loreBleue.add("");
		        			loreBleue.add("§8➡ §fCliquez pour rejoindre.");
	        			}
	        			else
	        			{
	        				loreBleue.add("");
	        				loreBleue.add("§8➡ §fÉquipe séléctionnée.");
	        			}
		        		bleueM.setLore(loreBleue);
		        		bleue.setItemMeta(bleueM);
		        		inv.setItem(21, bleue);
		        		
		        		ItemStack jaune = new ItemStack(Material.BANNER, 1, (byte)11);
		        		ItemMeta jauneM = jaune.getItemMeta();
		        		jauneM.setDisplayName("§eÉquipe Jaune");
		        		if (core.getJaune().contains(p.getDisplayName())) {
		        			jauneM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		        			jauneM.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        		}
		        		ArrayList<String> loreJaune = new ArrayList<String>();
		        		loreJaune.add("");
		        		loreJaune.add(" §dInformation:");
		        		loreJaune.add(" §f▶ §7Joueur(s): §a" + core.getJaune().size() + "§f/" + "§a4");
		        		loreJaune.add("");
		        		loreJaune.add(" §bEmplacement(s):");
	        			if (core.getJaune().size() == 0) {
	        				loreJaune.add(" §f▶ §8Vide...");
	        			}
		        		for (String pls : core.getJaune()) {
		        			loreJaune.add(" §f▶ §8" + pls);
		        		}
		        		if (!core.getJaune().contains(p.getDisplayName())) 
	        			{
		        			loreJaune.add("");
		        			loreJaune.add("§8➡ §fCliquez pour rejoindre.");
	        			}
	        			else
	        			{
	        				loreJaune.add("");
	        				loreJaune.add("§8➡ §fÉquipe séléctionnée.");
	        			}
		        		jauneM.setLore(loreJaune);
		        		jaune.setItemMeta(jauneM);
		        		inv.setItem(23, jaune);
		        		
		        		ItemStack vert = new ItemStack(Material.BANNER, 1, (byte)2);
		        		ItemMeta vertM = vert.getItemMeta();
		        		vertM.setDisplayName("§aÉquipe Verte");
		        		if (core.getVert().contains(p.getDisplayName())) {
		        			vertM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		        			vertM.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        		}
		        		ArrayList<String> loreVert = new ArrayList<String>();
		        		loreVert.add("");
		        		loreVert.add(" §dInformation:");
		        		loreVert.add(" §f▶ §7Joueur(s): §a" + core.getVert().size() + "§f/" + "§a4");
		        		loreVert.add("");
		        		loreVert.add(" §bEmplacement(s):");
	        			if (core.getVert().size() == 0) {
	        				loreVert.add(" §f▶ §8Vide...");
	        			}
		        		for (String pls : core.getVert()) {
		        			loreVert.add(" §f▶ §8" + pls);
		        		}
		        		if (!core.getVert().contains(p.getDisplayName())) 
	        			{
		        			loreVert.add("");
		        			loreVert.add("§8➡ §fCliquez pour rejoindre.");
	        			}
	        			else
	        			{
	        				loreVert.add("");
	        				loreVert.add("§8➡ §fÉquipe séléctionnée.");
	        			}
		        		vertM.setLore(loreVert);
		        		vert.setItemMeta(vertM);
		        		inv.setItem(24, vert);
		        		
		        		p.updateInventory();
	                ++t;
	                if (t == 10) {
	                    run();
	                }
	            }
	        }.runTaskTimer((Plugin)core, 0L, 10L);
		}
		if (core.getConfig().getBoolean("Mode.6vs4")) {
			new BukkitRunnable() {
	            int t = 0;
	                
		        public void run() {
		        	
		        	if (!p.getOpenInventory().getTitle().equalsIgnoreCase("§8Choix de votre équipe")) { cancel(); }
		        		
		        		ItemStack rouge = new ItemStack(Material.BANNER, 1, (byte)1);
		        		ItemMeta rougeM = rouge.getItemMeta();
		        		rougeM.setDisplayName("§cÉquipe Rouge");
		        		if (core.getRouge().contains(p.getDisplayName())) {
		        			rougeM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		        			rougeM.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        		}
		        		ArrayList<String> loreRouge = new ArrayList<String>();
		        		loreRouge.add("");
		        		loreRouge.add(" §dInformation:");
		        		loreRouge.add(" §f▶ §7Joueur(s): §a" + core.getRouge().size() + "§f/" + "§a4");
		        		loreRouge.add("");
		        		loreRouge.add(" §bEmplacement(s):");
	        			if (core.getRouge().size() == 0) {
	        				loreRouge.add(" §f▶ §8Vide...");
	        			}
		        		for (String pls : core.getRouge()) {
		        			loreRouge.add(" §f▶ §8" + pls);
		        		}
		        		if (!core.getRouge().contains(p.getDisplayName())) 
	        			{
		        			loreRouge.add("");
		        			loreRouge.add("§8➡ §fCliquez pour rejoindre.");
	        			}
	        			else
	        			{
	        				loreRouge.add("");
	        				loreRouge.add("§8➡ §fÉquipe séléctionnée.");
	        			}
		        		rougeM.setLore(loreRouge);
		        		rouge.setItemMeta(rougeM);
		        		inv.setItem(21, rouge);
		        		
		        		ItemStack bleue = new ItemStack(Material.BANNER, 1, (byte)4);
		        		ItemMeta bleueM = bleue.getItemMeta();
		        		bleueM.setDisplayName("§9Équipe Bleue");
		        		if (core.getBleue().contains(p.getDisplayName())) {
		        			bleueM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		        			bleueM.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        		}
		        		ArrayList<String> loreBleue = new ArrayList<String>();
		        		loreBleue.add("");
		        		loreBleue.add(" §dInformation:");
		        		loreBleue.add(" §f▶ §7Joueur(s): §a" + core.getBleue().size() + "§f/" + "§a4");
		        		loreBleue.add("");
		        		loreBleue.add(" §bEmplacement(s):");
	        			if (core.getBleue().size() == 0) {
	        				loreBleue.add(" §f▶ §8Vide...");
	        			}
		        		for (String pls : core.getBleue()) {
		        			loreBleue.add(" §f▶ §8" + pls);
		        		}
		        		if (!core.getBleue().contains(p.getDisplayName())) 
	        			{
		        			loreBleue.add("");
		        			loreBleue.add("§8➡ §fCliquez pour rejoindre.");
	        			}
	        			else
	        			{
	        				loreBleue.add("");
	        				loreBleue.add("§8➡ §fÉquipe séléctionnée.");
	        			}
		        		bleueM.setLore(loreBleue);
		        		bleue.setItemMeta(bleueM);
		        		inv.setItem(22, bleue);
		        		
		        		ItemStack jaune = new ItemStack(Material.BANNER, 1, (byte)11);
		        		ItemMeta jauneM = jaune.getItemMeta();
		        		jauneM.setDisplayName("§eÉquipe Jaune");
		        		if (core.getJaune().contains(p.getDisplayName())) {
		        			jauneM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		        			jauneM.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        		}
		        		ArrayList<String> loreJaune = new ArrayList<String>();
		        		loreJaune.add("");
		        		loreJaune.add(" §dInformation:");
		        		loreJaune.add(" §f▶ §7Joueur(s): §a" + core.getJaune().size() + "§f/" + "§a4");
		        		loreJaune.add("");
		        		loreJaune.add(" §bEmplacement(s):");
	        			if (core.getJaune().size() == 0) {
	        				loreJaune.add(" §f▶ §8Vide...");
	        			}
		        		for (String pls : core.getJaune()) {
		        			loreJaune.add(" §f▶ §8" + pls);
		        		}
		        		if (!core.getJaune().contains(p.getDisplayName())) 
	        			{
		        			loreJaune.add("");
		        			loreJaune.add("§8➡ §fCliquez pour rejoindre.");
	        			}
	        			else
	        			{
	        				loreJaune.add("");
	        				loreJaune.add("§8➡ §fÉquipe séléctionnée.");
	        			}
		        		jauneM.setLore(loreJaune);
		        		jaune.setItemMeta(jauneM);
		        		inv.setItem(23, jaune);
		        		
		        		ItemStack vert = new ItemStack(Material.BANNER, 1, (byte)2);
		        		ItemMeta vertM = vert.getItemMeta();
		        		vertM.setDisplayName("§aÉquipe Verte");
		        		if (core.getVert().contains(p.getDisplayName())) {
		        			vertM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		        			vertM.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        		}
		        		ArrayList<String> loreVert = new ArrayList<String>();
		        		loreVert.add("");
		        		loreVert.add(" §dInformation:");
		        		loreVert.add(" §f▶ §7Joueur(s): §a" + core.getVert().size() + "§f/" + "§a4");
		        		loreVert.add("");
		        		loreVert.add(" §bEmplacement(s):");
	        			if (core.getVert().size() == 0) {
	        				loreVert.add(" §f▶ §8Vide...");
	        			}
		        		for (String pls : core.getVert()) {
		        			loreVert.add(" §f▶ §8" + pls);
		        		}
		        		if (!core.getVert().contains(p.getDisplayName())) 
	        			{
		        			loreVert.add("");
		        			loreVert.add("§8➡ §fCliquez pour rejoindre.");
	        			}
	        			else
	        			{
	        				loreVert.add("");
	        				loreVert.add("§8➡ §fÉquipe séléctionnée.");
	        			}
		        		vertM.setLore(loreVert);
		        		vert.setItemMeta(vertM);
		        		inv.setItem(30, vert);
		        		
		        		ItemStack orange = new ItemStack(Material.BANNER, 1, (byte)14);
		        		ItemMeta orangeM = orange.getItemMeta();
		        		orangeM.setDisplayName("§6Équipe Orange");
		        		if (core.getOrange().contains(p.getDisplayName())) {
		        			orangeM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		        			orangeM.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        		}
		        		ArrayList<String> loreOrange = new ArrayList<String>();
		        		loreOrange.add("");
		        		loreOrange.add(" §dInformation:");
		        		loreOrange.add(" §f▶ §7Joueur(s): §a" + core.getOrange().size() + "§f/" + "§a4");
		        		loreOrange.add("");
		        		loreOrange.add(" §bEmplacement(s):");
	        			if (core.getOrange().size() == 0) {
	        				loreOrange.add(" §f▶ §8Vide...");
	        			}
		        		for (String pls : core.getOrange()) {
		        			loreOrange.add(" §f▶ §8" + pls);
		        		}
		        		if (!core.getVert().contains(p.getDisplayName())) 
	        			{
		        			loreOrange.add("");
		        			loreOrange.add("§8➡ §fCliquez pour rejoindre.");
	        			}
	        			else
	        			{
	        				loreOrange.add("");
	        				loreOrange.add("§8➡ §fÉquipe séléctionnée.");
	        			}
		        		orangeM.setLore(loreOrange);
		        		orange.setItemMeta(orangeM);
		        		inv.setItem(31, orange);
		        		
		        		ItemStack rose = new ItemStack(Material.BANNER, 1, (byte)13);
		        		ItemMeta roseM = rose.getItemMeta();
		        		roseM.setDisplayName("§dÉquipe Rose");
		        		if (core.getRose().contains(p.getDisplayName())) {
		        			roseM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		        			roseM.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		        		}
		        		ArrayList<String> loreRose = new ArrayList<String>();
		        		loreRose.add("");
		        		loreRose.add(" §dInformation:");
		        		loreRose.add(" §f▶ §7Joueur(s): §a" + core.getRose().size() + "§f/" + "§a4");
		        		loreRose.add("");
		        		loreRose.add(" §bEmplacement(s):");
	        			if (core.getRose().size() == 0) {
	        				loreRose.add(" §f▶ §8Vide...");
	        			}
		        		for (String pls : core.getRose()) {
		        			loreRose.add(" §f▶ §8" + pls);
		        		}
		        		if (!core.getRose().contains(p.getDisplayName())) 
	        			{
		        			loreRose.add("");
		        			loreRose.add("§8➡ §fCliquez pour rejoindre.");
	        			}
	        			else
	        			{
	        				loreRose.add("");
	        				loreRose.add("§8➡ §fÉquipe séléctionnée.");
	        			}
		        		roseM.setLore(loreRose);
		        		rose.setItemMeta(roseM);
		        		inv.setItem(32, rose);
		        		
		        		p.updateInventory();
	                ++t;
	                if (t == 10) {
	                    run();
	                }
	            }
	        }.runTaskTimer((Plugin)core, 0L, 10L);
		}
        
	}
	
}
