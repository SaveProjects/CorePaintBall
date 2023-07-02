package fr.edminecoreteam.core.gamemanager;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import fr.edminecoreteam.core.Core;
import fr.edminecoreteam.core.gamemanager.gun.MP5;

public class KillCoinsShop implements Listener {
	
	private static Core core = Core.getInstance();
	
	//private static ItemStack getSkull(String url) { return SkullNBT.getSkull(url); }
	
	@EventHandler
    public void onDrop(PlayerDropItemEvent e) {
		if (e.getItemDrop().getItemStack().getType() == Material.SKULL_ITEM)
        {
        	if (e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lBlack-Market §7• Clique"))
        	{
        		e.setCancelled(true);
        	}
        }
    }
	
	@EventHandler
    public void inventoryClick(InventoryClickEvent e) {
        Player p = (Player)e.getWhoClicked();
        ItemStack it = e.getCurrentItem();
        if (it == null) {
            return;
        }
        if (it.getType() == Material.SKULL_ITEM && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lBlack-Market §7• Clique")) { e.setCancelled(true); }
        if (e.getView().getTopInventory().getTitle().equals("§8Black-Market")) {
        	if (it.getType() == Material.STAINED_GLASS_PANE) { e.setCancelled(true); }
        	
        	if (it.getType() == Material.IRON_HOE && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§fMP5")) 
        	{
        		e.setCancelled(true);
        		if (core.getCoins(p) >= 150)
        		{
        			if (!core.getMP5().contains(p.getName()))
        			{
        				core.removeCoins(p, 150);
        				core.getMP5().add(p.getName());
        				MP5.getGun(p);
        				p.closeInventory();
        			}
        			else if (core.getMP5().contains(p.getName()))
        			{
        				p.sendMessage("§cErreur, vous possédez déjà cette arme...");
        			}
        		}
        		else
        		{
        			if (!core.getMP5().contains(p.getName()))
        			{
        				p.sendMessage("§cErreur, vous ne possédez pas assez de Kill-Coins...");
        			}
        			else if (core.getMP5().contains(p.getName()))
        			{
        				p.sendMessage("§cErreur, vous possédez déjà cette arme...");
        			}
        		}
        	}
        }
    }
	
	@EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Action a = e.getAction();
        ItemStack it = e.getItem();
        if (it == null) {
            return;
        }
        if (it.getType() == Material.SKULL_ITEM && it.getItemMeta().hasDisplayName() 
        		&& it.getItemMeta().getDisplayName().equalsIgnoreCase("§e§lBlack-Market §7• Clique") 
        		&& (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK || a == Action.LEFT_CLICK_AIR || a == Action.LEFT_CLICK_BLOCK)) {
            e.setCancelled(true);
            gui(p);
        } 
    }
	
	public static void gui(Player p) {
		
		Inventory inv = Bukkit.createInventory(null, 45, "§8Black-Market");
        
		new BukkitRunnable() {
            int t = 0;
                
	        public void run() {
	        	
	        	if (!p.getOpenInventory().getTitle().equalsIgnoreCase("§8Black-Market")) { cancel(); }
		            	ItemStack deco = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)4);
		                ItemMeta decoM = deco.getItemMeta();
		                decoM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		                decoM.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		                decoM.setDisplayName("§r");
		                deco.setItemMeta(decoM);
		                inv.setItem(0, deco); inv.setItem(8, deco); inv.setItem(9, deco); inv.setItem(17, deco);
		                inv.setItem(27, deco); inv.setItem(35, deco); inv.setItem(36, deco); inv.setItem(44, deco);
	        		
                ++t;
                if (t == 10) {
                    run();
                }
            }
        }.runTaskTimer((Plugin)core, 0L, 10L);
        
        
        ItemStack Mitraillette = new ItemStack(Material.IRON_HOE, 1);
        ItemMeta MitrailletteM = Mitraillette.getItemMeta();
        MitrailletteM.setDisplayName("§fMP5");
        ArrayList<String> loreMitraillette = new ArrayList<String>();
        loreMitraillette.add("");
        loreMitraillette.add(" §dInformation:");
        loreMitraillette.add(" §f▶ §7Mode de tire: §aRafale");
        loreMitraillette.add(" §f▶ §7Munissions: §a32 §8(par chargeurs)");
        loreMitraillette.add("");
        loreMitraillette.add(" §fPrix: §e150 KC");
        loreMitraillette.add("");
        if (core.getCoins(p) >= 150)
		{
			if (!core.getMP5().contains(p.getName()))
			{
				loreMitraillette.add("§8➡ §fCliquez pour acheter.");
			}
			else
			{
				loreMitraillette.add("§8➡ §aArme débloqué.");
			}
		}
        else
        {
			if (!core.getMP5().contains(p.getName()))
			{
				loreMitraillette.add("§8➡ §cPas assez de Kill-Coins...");
			}
			else
			{
				loreMitraillette.add("§8➡ §aArme débloqué.");
			}
        }
        MitrailletteM.setLore(loreMitraillette);
        Mitraillette.setItemMeta(MitrailletteM);
        inv.setItem(21, Mitraillette);
		
        
        p.openInventory(inv);
        p.playSound(p.getLocation(), Sound.HORSE_ARMOR, 1.0f, 1.0f);
	}

}
