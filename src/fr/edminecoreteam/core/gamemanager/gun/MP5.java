package fr.edminecoreteam.core.gamemanager.gun;


import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import fr.edminecoreteam.core.Core;

public class MP5 implements Listener {
	
	private List<Player> recharge;
	public MP5() {
		recharge = new ArrayList<Player>();
	}
	public List<Player> getRecharge() {
	    return this.recharge;
	}
	
	public static void getGun(Player p) {
		ItemStack gunStarter = new ItemStack(Material.IRON_HOE, 32);
        ItemMeta gunStarterM = gunStarter.getItemMeta();
        gunStarterM.setDisplayName("§aMP5");
        gunStarter.setItemMeta((ItemMeta)gunStarterM);
        p.getInventory().addItem(gunStarter);
	}
	
	@EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        Player p = e.getPlayer();
        if (e.getItemDrop().getItemStack().getType() == Material.IRON_HOE)
        {
        	if (e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase("§aMP5"))
        	{
        		e.setCancelled(true);
        		p.getInventory().remove(p.getItemInHand());
        		recharge(p);
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
        if (it.getType() == Material.IRON_HOE && it.getItemMeta().hasDisplayName() 
        		&& it.getItemMeta().getDisplayName().equalsIgnoreCase("§aMP5") 
        		&& (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK || a == Action.LEFT_CLICK_AIR || a == Action.LEFT_CLICK_BLOCK)) {
            e.setCancelled(true);
            ItemStack hand = p.getInventory().getItemInHand();
            
            if (!recharge.contains(p))
            {
            	if (hand.getAmount() > 1)
                {
                	hand.setAmount(hand.getAmount() - 3);
                    p.getInventory().setItemInHand(hand);
                    Shoot("1", p);
                   
                }
                else if (hand.getAmount() == 2)
                {
                	hand.setAmount(0);
                    p.getInventory().remove(p.getItemInHand());
                    Shoot("2", p);
                	
                }
            }
            else if (recharge.contains(p))
            {
            	p.sendMessage("§cVeuillez attendre avant de tirer à nouveau...");
            	p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0f, 1.0f);
            }
        }
        
        
    }
	
	private void Shoot(String gun, Player p) {
		
		if (gun == "1")
		{
			recharge.add(p);
			new BukkitRunnable() { 
				int t = 6;
				public void run() {
					if (t == 6)
					{
						p.launchProjectile(Snowball.class);
	                    p.playSound(p.getLocation(), Sound.EXPLODE, 1.0f, 3f);
					}
					if (t == 5)
					{
						p.launchProjectile(Snowball.class);
	                    p.playSound(p.getLocation(), Sound.EXPLODE, 1.0f, 3f);
					}
					if (t == 4)
					{
						p.launchProjectile(Snowball.class);
	                    p.playSound(p.getLocation(), Sound.EXPLODE, 1.0f, 3f);
					}
					Core.getInstance().title.sendActionBar(p, "§eArmement...");
					
                    --t;
                    if (t == 0) {
                    	Core.getInstance().title.sendActionBar(p, "§d");
                    	recharge.remove(p);
                        cancel();
                    }
                }
            }.runTaskTimer((Plugin)Core.getInstance(), 0L, 2L);
		}
		if (gun == "2")
		{
			recharge.add(p);
			new BukkitRunnable() { 
				int t = 6;
				public void run() {
					if (t == 6)
					{
						p.launchProjectile(Snowball.class);
	                    p.playSound(p.getLocation(), Sound.EXPLODE, 1.0f, 3f);
					}
					if (t == 5)
					{
						p.launchProjectile(Snowball.class);
	                    p.playSound(p.getLocation(), Sound.EXPLODE, 1.0f, 3f);
					}
					
                    --t;
                    if (t == 0) {
                    	recharge.remove(p);
                    	recharge(p);
                        cancel();
                    }
                }
            }.runTaskTimer((Plugin)Core.getInstance(), 0L, 2L);
		}
		
	}
	
	
	public void addPlayertoRecharge(Player p) {
		recharge.add(p);
	}
	
	private void recharge(Player p) {
		Core.getInstance().title.sendActionBar(p, "§6Rechargement en cours...");
		int Slot = p.getInventory().getHeldItemSlot();
		p.playSound(p.getLocation(), Sound.ANVIL_USE, 1.0f, 0.5f);
		recharge.add(p);
		new BukkitRunnable() {
            
            int t = 5;
			public void run() {
                
                --t ;
                if (t == 0) {
                	
                	ItemStack gunStarter = new ItemStack(Material.IRON_HOE, 32);
                    ItemMeta gunStarterM = gunStarter.getItemMeta();
                    gunStarterM.setDisplayName("§aMP5");
                    gunStarter.setItemMeta((ItemMeta)gunStarterM);
                    p.getInventory().setItem(Slot, gunStarter);
                    Core.getInstance().title.sendActionBar(p, "§aRechargement terminé !");
            		p.playSound(p.getLocation(), Sound.NOTE_PLING, 1.0f, 1.2f);
            		recharge.remove(p);
                    cancel();
                }
            }
        }.runTaskTimer((Plugin)Core.getInstance(), 0L, 10L);
		
	}

}
