package fr.edminecoreteam.core.gamemanager;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import fr.edminecoreteam.core.utils.SkullNBT;

public class InventoryGame {
	
	private static ItemStack getSkull(String url) { return SkullNBT.getSkull(url); }
	
	public static void getEquipement(Player p, String team) {
		
		PlayerInventory pi = p.getInventory();
		
		ItemStack killcoins = getSkull("http://textures.minecraft.net/texture/d177a94e2bd08bbd83944658b34202b69ac36c28a86d298cfcc044ef28b309db");
        SkullMeta killcoinsM = (SkullMeta)killcoins.getItemMeta();
        killcoinsM.setDisplayName("§e§lBlack-Market §7• Clique");
        killcoins.setItemMeta((ItemMeta)killcoinsM);
        p.getInventory().setItem(8, killcoins);
		
		if(team == "rouge")
		{
			ItemStack Helmet = new ItemStack(Material.LEATHER_HELMET, 1);
	        LeatherArmorMeta HelmetM = (LeatherArmorMeta)Helmet.getItemMeta();
	        HelmetM.setColor(Color.RED);
	        Helmet.setItemMeta((ItemMeta)HelmetM);
	        pi.setHelmet(Helmet);
			
			ItemStack chestPlate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
	        LeatherArmorMeta chestPlateM = (LeatherArmorMeta)chestPlate.getItemMeta();
	        chestPlateM.setColor(Color.RED);
	        chestPlate.setItemMeta((ItemMeta)chestPlateM);
	        pi.setChestplate(chestPlate);
	        
	        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
	        LeatherArmorMeta leggingsM = (LeatherArmorMeta)leggings.getItemMeta();
	        leggingsM.setColor(Color.RED);
	        leggings.setItemMeta((ItemMeta)leggingsM);
	        pi.setLeggings(leggings);
	        
	        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
	        LeatherArmorMeta bootsM = (LeatherArmorMeta)boots.getItemMeta();
	        bootsM.setColor(Color.RED);
	        boots.setItemMeta((ItemMeta)bootsM);
	        pi.setBoots(boots);
		}
		
		if(team == "bleue")
		{
			ItemStack Helmet = new ItemStack(Material.LEATHER_HELMET, 1);
	        LeatherArmorMeta HelmetM = (LeatherArmorMeta)Helmet.getItemMeta();
	        HelmetM.setColor(Color.BLUE);
	        Helmet.setItemMeta((ItemMeta)HelmetM);
	        pi.setHelmet(Helmet);
			
			ItemStack chestPlate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
	        LeatherArmorMeta chestPlateM = (LeatherArmorMeta)chestPlate.getItemMeta();
	        chestPlateM.setColor(Color.BLUE);
	        chestPlate.setItemMeta((ItemMeta)chestPlateM);
	        pi.setChestplate(chestPlate);
	        
	        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
	        LeatherArmorMeta leggingsM = (LeatherArmorMeta)leggings.getItemMeta();
	        leggingsM.setColor(Color.BLUE);
	        leggings.setItemMeta((ItemMeta)leggingsM);
	        pi.setLeggings(leggings);
	        
	        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
	        LeatherArmorMeta bootsM = (LeatherArmorMeta)boots.getItemMeta();
	        bootsM.setColor(Color.BLUE);
	        boots.setItemMeta((ItemMeta)bootsM);
	        pi.setBoots(boots);
		}
		
		if(team == "jaune")
		{
			ItemStack Helmet = new ItemStack(Material.LEATHER_HELMET, 1);
	        LeatherArmorMeta HelmetM = (LeatherArmorMeta)Helmet.getItemMeta();
	        HelmetM.setColor(Color.YELLOW);
	        Helmet.setItemMeta((ItemMeta)HelmetM);
	        pi.setHelmet(Helmet);
			
			ItemStack chestPlate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
	        LeatherArmorMeta chestPlateM = (LeatherArmorMeta)chestPlate.getItemMeta();
	        chestPlateM.setColor(Color.YELLOW);
	        chestPlate.setItemMeta((ItemMeta)chestPlateM);
	        pi.setChestplate(chestPlate);
	        
	        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
	        LeatherArmorMeta leggingsM = (LeatherArmorMeta)leggings.getItemMeta();
	        leggingsM.setColor(Color.YELLOW);
	        leggings.setItemMeta((ItemMeta)leggingsM);
	        pi.setLeggings(leggings);
	        
	        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
	        LeatherArmorMeta bootsM = (LeatherArmorMeta)boots.getItemMeta();
	        bootsM.setColor(Color.YELLOW);
	        boots.setItemMeta((ItemMeta)bootsM);
	        pi.setBoots(boots);
		}
		
		if(team == "vert")
		{
			ItemStack Helmet = new ItemStack(Material.LEATHER_HELMET, 1);
	        LeatherArmorMeta HelmetM = (LeatherArmorMeta)Helmet.getItemMeta();
	        HelmetM.setColor(Color.LIME);
	        Helmet.setItemMeta((ItemMeta)HelmetM);
	        pi.setHelmet(Helmet);
			
			ItemStack chestPlate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
	        LeatherArmorMeta chestPlateM = (LeatherArmorMeta)chestPlate.getItemMeta();
	        chestPlateM.setColor(Color.LIME);
	        chestPlate.setItemMeta((ItemMeta)chestPlateM);
	        pi.setChestplate(chestPlate);
	        
	        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
	        LeatherArmorMeta leggingsM = (LeatherArmorMeta)leggings.getItemMeta();
	        leggingsM.setColor(Color.LIME);
	        leggings.setItemMeta((ItemMeta)leggingsM);
	        pi.setLeggings(leggings);
	        
	        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
	        LeatherArmorMeta bootsM = (LeatherArmorMeta)boots.getItemMeta();
	        bootsM.setColor(Color.LIME);
	        boots.setItemMeta((ItemMeta)bootsM);
	        pi.setBoots(boots);
		}
		
		if(team == "orange")
		{
			ItemStack Helmet = new ItemStack(Material.LEATHER_HELMET, 1);
	        LeatherArmorMeta HelmetM = (LeatherArmorMeta)Helmet.getItemMeta();
	        HelmetM.setColor(Color.ORANGE);
	        Helmet.setItemMeta((ItemMeta)HelmetM);
	        pi.setHelmet(Helmet);
			
			ItemStack chestPlate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
	        LeatherArmorMeta chestPlateM = (LeatherArmorMeta)chestPlate.getItemMeta();
	        chestPlateM.setColor(Color.ORANGE);
	        chestPlate.setItemMeta((ItemMeta)chestPlateM);
	        pi.setChestplate(chestPlate);
	        
	        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
	        LeatherArmorMeta leggingsM = (LeatherArmorMeta)leggings.getItemMeta();
	        leggingsM.setColor(Color.ORANGE);
	        leggings.setItemMeta((ItemMeta)leggingsM);
	        pi.setLeggings(leggings);
	        
	        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
	        LeatherArmorMeta bootsM = (LeatherArmorMeta)boots.getItemMeta();
	        bootsM.setColor(Color.ORANGE);
	        boots.setItemMeta((ItemMeta)bootsM);
	        pi.setBoots(boots);
		}
		
		if(team == "rose")
		{
			ItemStack Helmet = new ItemStack(Material.LEATHER_HELMET, 1);
	        LeatherArmorMeta HelmetM = (LeatherArmorMeta)Helmet.getItemMeta();
	        HelmetM.setColor(Color.FUCHSIA);
	        Helmet.setItemMeta((ItemMeta)HelmetM);
	        pi.setHelmet(Helmet);
			
			ItemStack chestPlate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
	        LeatherArmorMeta chestPlateM = (LeatherArmorMeta)chestPlate.getItemMeta();
	        chestPlateM.setColor(Color.FUCHSIA);
	        chestPlate.setItemMeta((ItemMeta)chestPlateM);
	        pi.setChestplate(chestPlate);
	        
	        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
	        LeatherArmorMeta leggingsM = (LeatherArmorMeta)leggings.getItemMeta();
	        leggingsM.setColor(Color.FUCHSIA);
	        leggings.setItemMeta((ItemMeta)leggingsM);
	        pi.setLeggings(leggings);
	        
	        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
	        LeatherArmorMeta bootsM = (LeatherArmorMeta)boots.getItemMeta();
	        bootsM.setColor(Color.FUCHSIA);
	        boots.setItemMeta((ItemMeta)bootsM);
	        pi.setBoots(boots);
		}
		
	}

}
