package fr.edminecoreteam.core.gamemanager;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import fr.edminecoreteam.core.Core;
import fr.edminecoreteam.core.listeners.Instance;
import fr.edminecoreteam.core.utils.MessageUtils;

public class InteractionsGame implements Listener {
	
	public Core core;
	
	public InteractionsGame(Core core) {
		this.core = core;
	}
	
	@EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        //Player p = (Player)e.getWhoClicked();
        ItemStack it = e.getCurrentItem();
        if (it == null) {
            return;
        }
        if (it.getType() == Material.LEATHER_HELMET || it.getType() == Material.LEATHER_CHESTPLATE || it.getType() == Material.LEATHER_LEGGINGS || it.getType() == Material.LEATHER_BOOTS) {
            e.setCancelled(true);
        }
    }
	
	@EventHandler
    private void snowBallDamage(EntityDamageByEntityEvent e) {
    	if (e.getEntityType() != EntityType.PLAYER) { return; }
    	if (e.getEntity() instanceof Player) {
    		if (e.getDamager() instanceof Projectile) {
    			if(e.getDamager() instanceof Snowball) {
    				Snowball sn = (Snowball)e.getDamager();
    				if(sn.getShooter() instanceof Player) {
    					Entity victim = (Player)e.getEntity();
    					Player attacker = (Player)sn.getShooter();
    					//code
    					
    					if(core.getConfig().getBoolean("Mode.2vs4"))
    					{
    						if(core.getRouge().contains(victim.getName()))
     	              		{
     		              		if(core.getRouge().contains(attacker.getName()))
     		              		{
     		              			e.setCancelled(true);
     		              		} else {
     		              			if (core.getIsInvincible().contains(victim.getName()))
     		              			{
     		              				((Player) attacker).sendMessage("§cVous ne pouvez pas toucher §c§l" + ((Player) victim).getDisplayName() + " §ccar il vient de respawn...");
     		              				e.setCancelled(true);
     		              				return;
     		              			}
     		              			victim.sendMessage("§6" + ((Player) attacker).getDisplayName() + " §7vous a tué...");
     		        				((Player) attacker).sendMessage("§7Vous avez tué §6" + ((Player) victim).getDisplayName() + "§7.");
     		        				MessageUtils.deathMessage(attacker, (Player) victim);
     		        				
     		        				core.removeKillStreak((Player) victim);
     		        				Instance.respawnInGame((Player) victim);
     		        				Instance.addPoint(attacker);
     		              		}
     	              		}
     	    		      	if(core.getBleue().contains(victim.getName()))
     	    				{
     	    					if(core.getBleue().contains(attacker.getName())) 
     	    					{
     	    						e.setCancelled(true);
     	    					} else {
     	    						if (core.getIsInvincible().contains(victim.getName()))
     		              			{
     		              				((Player) attacker).sendMessage("§cVous ne pouvez pas toucher §c§l" + ((Player) victim).getDisplayName() + " §ccar il vient de respawn...");
     		              				e.setCancelled(true);
     		              				return;
     		              			}
     		              			victim.sendMessage("§6" + ((Player) attacker).getDisplayName() + " §7vous a tué...");
     		        				((Player) attacker).sendMessage("§7Vous avez tué §6" + ((Player) victim).getDisplayName() + "§7.");
     		        				MessageUtils.deathMessage(attacker, (Player) victim);
     		        				
     		        				core.removeKillStreak((Player) victim);
     		        				Instance.respawnInGame((Player) victim);
     		        				Instance.addPoint(attacker);
     		              		}
     	    				}
    					}
    					
    					if(core.getConfig().getBoolean("Mode.4vs4"))
    					{
    						if(core.getRouge().contains(victim.getName()))
     	              		{
     		              		if(core.getRouge().contains(attacker.getName()))
     		              		{
     		              			e.setCancelled(true);
     		              		} else {
     		              			if (core.getIsInvincible().contains(victim.getName()))
     		              			{
     		              				((Player) attacker).sendMessage("§cVous ne pouvez pas toucher §c§l" + ((Player) victim).getDisplayName() + " §ccar il vient de respawn...");
     		              				e.setCancelled(true);
     		              				return;
     		              			}
     		              			victim.sendMessage("§6" + ((Player) attacker).getDisplayName() + " §7vous a tué...");
     		        				((Player) attacker).sendMessage("§7Vous avez tué §6" + ((Player) victim).getDisplayName() + "§7.");
     		        				MessageUtils.deathMessage(attacker, (Player) victim);
     		        				
     		        				core.removeKillStreak((Player) victim);
     		        				Instance.respawnInGame((Player) victim);
     		        				Instance.addPoint(attacker);
     		              		}
     	              		}
     	    		      	if(core.getBleue().contains(victim.getName()))
     	    				{
     	    					if(core.getBleue().contains(attacker.getName())) 
     	    					{
     	    						e.setCancelled(true);
     	    					} else {
     	    						if (core.getIsInvincible().contains(victim.getName()))
     		              			{
     		              				((Player) attacker).sendMessage("§cVous ne pouvez pas toucher §c§l" + ((Player) victim).getDisplayName() + " §ccar il vient de respawn...");
     		              				e.setCancelled(true);
     		              				return;
     		              			}
     		              			victim.sendMessage("§6" + ((Player) attacker).getDisplayName() + " §7vous a tué...");
     		        				((Player) attacker).sendMessage("§7Vous avez tué §6" + ((Player) victim).getDisplayName() + "§7.");
     		        				MessageUtils.deathMessage(attacker, (Player) victim);
     		        				
     		        				core.removeKillStreak((Player) victim);
     		        				Instance.respawnInGame((Player) victim);
     		        				Instance.addPoint(attacker);
     		              		}
     	    				}
     	    		      	if(core.getJaune().contains(victim.getName()))
     	    				{
     	    					if(core.getJaune().contains(attacker.getName())) 
     	    					{
     	    						e.setCancelled(true);
     	    					} else {
     	    						if (core.getIsInvincible().contains(victim.getName()))
     		              			{
     		              				((Player) attacker).sendMessage("§cVous ne pouvez pas toucher §c§l" + ((Player) victim).getDisplayName() + " §ccar il vient de respawn...");
     		              				e.setCancelled(true);
     		              				return;
     		              			}
     		              			victim.sendMessage("§6" + ((Player) attacker).getDisplayName() + " §7vous a tuer...");
     		        				((Player) attacker).sendMessage("§7Vous avez tuer §6" + ((Player) victim).getDisplayName() + "§7.");
     		        				MessageUtils.deathMessage(attacker, (Player) victim);
     		        				
     		        				core.removeKillStreak((Player) victim);
     		        				Instance.respawnInGame((Player) victim);
     		        				Instance.addPoint(attacker);
     		              		}
     	    				}
     	    				
     	    				if(core.getVert().contains(victim.getName()))
     	    				{
     	    					if(core.getVert().contains(attacker.getName())) 
     	    					{
     	    						e.setCancelled(true);
     	    					} else {
     	    						if (core.getIsInvincible().contains(victim.getName()))
     		              			{
     		              				((Player) attacker).sendMessage("§cVous ne pouvez pas toucher §c§l" + ((Player) victim).getDisplayName() + " §ccar il vient de respawn...");
     		              				e.setCancelled(true);
     		              				return;
     		              			}
     		              			victim.sendMessage("§6" + ((Player) attacker).getDisplayName() + " §7vous a tué...");
     		        				((Player) attacker).sendMessage("§7Vous avez tué §6" + ((Player) victim).getDisplayName() + "§7.");
     		        				MessageUtils.deathMessage(attacker, (Player) victim);
     		        				
     		        				core.removeKillStreak((Player) victim);
     		        				Instance.respawnInGame((Player) victim);
     		        				Instance.addPoint(attacker);
     		              		}
     	    				}
    					}
    					
    					if(core.getConfig().getBoolean("Mode.6vs4"))
    					{
    						if(core.getRouge().contains(victim.getName()))
     	              		{
     		              		if(core.getRouge().contains(attacker.getName()))
     		              		{
     		              			e.setCancelled(true);
     		              		} else {
     		              			if (core.getIsInvincible().contains(victim.getName()))
     		              			{
     		              				((Player) attacker).sendMessage("§cVous ne pouvez pas toucher §c§l" + ((Player) victim).getDisplayName() + " §ccar il vient de respawn...");
     		              				e.setCancelled(true);
     		              				return;
     		              			}
     		              			victim.sendMessage("§6" + ((Player) attacker).getDisplayName() + " §7vous a tué...");
     		        				((Player) attacker).sendMessage("§7Vous avez tué §6" + ((Player) victim).getDisplayName() + "§7.");
     		        				MessageUtils.deathMessage(attacker, (Player) victim);
     		        				
     		        				core.removeKillStreak((Player) victim);
     		        				Instance.respawnInGame((Player) victim);
     		        				Instance.addPoint(attacker);
     		              		}
     	              		}
     	    		      	if(core.getBleue().contains(victim.getName()))
     	    				{
     	    					if(core.getBleue().contains(attacker.getName())) 
     	    					{
     	    						e.setCancelled(true);
     	    					} else {
     	    						if (core.getIsInvincible().contains(victim.getName()))
     		              			{
     		              				((Player) attacker).sendMessage("§cVous ne pouvez pas toucher §c§l" + ((Player) victim).getDisplayName() + " §ccar il vient de respawn...");
     		              				e.setCancelled(true);
     		              				return;
     		              			}
     		              			victim.sendMessage("§6" + ((Player) attacker).getDisplayName() + " §7vous a tué...");
     		        				((Player) attacker).sendMessage("§7Vous avez tué §6" + ((Player) victim).getDisplayName() + "§7.");
     		        				MessageUtils.deathMessage(attacker, (Player) victim);
     		        				
     		        				core.removeKillStreak((Player) victim);
     		        				Instance.respawnInGame((Player) victim);
     		        				Instance.addPoint(attacker);
     		              		}
     	    				}
     	    		      	if(core.getJaune().contains(victim.getName()))
     	    				{
     	    					if(core.getJaune().contains(attacker.getName())) 
     	    					{
     	    						e.setCancelled(true);
     	    					} else {
     	    						if (core.getIsInvincible().contains(victim.getName()))
     		              			{
     		              				((Player) attacker).sendMessage("§cVous ne pouvez pas toucher §c§l" + ((Player) victim).getDisplayName() + " §ccar il vient de respawn...");
     		              				e.setCancelled(true);
     		              				return;
     		              			}
     		              			victim.sendMessage("§6" + ((Player) attacker).getDisplayName() + " §7vous a tué...");
     		        				((Player) attacker).sendMessage("§7Vous avez tué §6" + ((Player) victim).getDisplayName() + "§7.");
     		        				MessageUtils.deathMessage(attacker, (Player) victim);
     		        				
     		        				core.removeKillStreak((Player) victim);
     		        				Instance.respawnInGame((Player) victim);
     		        				Instance.addPoint(attacker);
     		              		}
     	    				}
     	    				
     	    				if(core.getVert().contains(victim.getName()))
     	    				{
     	    					if(core.getVert().contains(attacker.getName())) 
     	    					{
     	    						e.setCancelled(true);
     	    					} else {
     	    						if (core.getIsInvincible().contains(victim.getName()))
     		              			{
     		              				((Player) attacker).sendMessage("§cVous ne pouvez pas toucher §c§l" + ((Player) victim).getDisplayName() + " §ccar il vient de respawn...");
     		              				e.setCancelled(true);
     		              				return;
     		              			}
     		              			victim.sendMessage("§6" + ((Player) attacker).getDisplayName() + " §7vous a tué...");
     		        				((Player) attacker).sendMessage("§7Vous avez tué §6" + ((Player) victim).getDisplayName() + "§7.");
     		        				MessageUtils.deathMessage(attacker, (Player) victim);
     		        				
     		        				core.removeKillStreak((Player) victim);
     		        				Instance.respawnInGame((Player) victim);
     		        				Instance.addPoint(attacker);
     		              		}
     	    				}
     	    				
     	    				if(core.getOrange().contains(victim.getName()))
     	    				{
     	    					if(core.getOrange().contains(attacker.getName())) 
     	    					{
     	    						e.setCancelled(true);
     	    					} else {
     	    						if (core.getIsInvincible().contains(victim.getName()))
     		              			{
     		              				((Player) attacker).sendMessage("§cVous ne pouvez pas toucher §c§l" + ((Player) victim).getDisplayName() + " §ccar il vient de respawn...");
     		              				e.setCancelled(true);
     		              				return;
     		              			}
     		              			victim.sendMessage("§6" + ((Player) attacker).getDisplayName() + " §7vous a tué...");
     		        				((Player) attacker).sendMessage("§7Vous avez tué §6" + ((Player) victim).getDisplayName() + "§7.");
     		        				MessageUtils.deathMessage(attacker, (Player) victim);
     		        				
     		        				core.removeKillStreak((Player) victim);
     		        				Instance.respawnInGame((Player) victim);
     		        				Instance.addPoint(attacker);
     		              		}
     	    				}
     	    				
     	    				if(core.getRose().contains(victim.getName()))
     	    				{
     	    					if(core.getRose().contains(attacker.getName())) 
     	    					{
     	    						e.setCancelled(true);
     	    					} else {
     	    						if (core.getIsInvincible().contains(victim.getName()))
     		              			{
     		              				((Player) attacker).sendMessage("§cVous ne pouvez pas toucher §c§l" + ((Player) victim).getDisplayName() + " §ccar il vient de respawn...");
     		              				e.setCancelled(true);
     		              				return;
     		              			}
     		              			victim.sendMessage("§6" + ((Player) attacker).getDisplayName() + " §7vous a tué...");
     		        				((Player) attacker).sendMessage("§7Vous avez tué §6" + ((Player) victim).getDisplayName() + "§7.");
     		        				MessageUtils.deathMessage(attacker, (Player) victim);
     		        				
     		        				core.removeKillStreak((Player) victim);
     		        				Instance.respawnInGame((Player) victim);
     		        				Instance.addPoint(attacker);
     		              		}
     	    				}
    					}
    				}
    			}
    		}
    	}
	}
    
    @EventHandler
    private void nopvpTeam(EntityDamageByEntityEvent e) {
    	if (e.getEntityType() != EntityType.PLAYER) { return; }
    	if (e.getDamager() instanceof Projectile) { return; }
    	
		Player victim = (Player) e.getEntity();
		Player attacker = (Player) e.getDamager();
		
		if (core.getConfig().getBoolean("Mode.2vs4"))
		{
			if(core.getRouge().contains(victim.getName()))
			{
				if(core.getRouge().contains(attacker.getName())) 
				{
					e.setCancelled(true);
				}
			}
			
			if(core.getBleue().contains(victim.getName()))
			{
				if(core.getBleue().contains(attacker.getName())) 
				{
					e.setCancelled(true);
				}
			}
		}
		
		if (core.getConfig().getBoolean("Mode.4vs4"))
		{
			if(core.getRouge().contains(victim.getName()))
			{
				if(core.getRouge().contains(attacker.getName())) 
				{
					e.setCancelled(true);
				}
			}
			
			if(core.getBleue().contains(victim.getName()))
			{
				if(core.getBleue().contains(attacker.getName())) 
				{
					e.setCancelled(true);
				}
			}
			
			if(core.getJaune().contains(victim.getName()))
			{
				if(core.getJaune().contains(attacker.getName())) 
				{
					e.setCancelled(true);
				}
			}
			
			if(core.getVert().contains(victim.getName()))
			{
				if(core.getVert().contains(attacker.getName())) 
				{
					e.setCancelled(true);
				}
			}
		}
		
		if (core.getConfig().getBoolean("Mode.6vs4"))
		{
			if(core.getRouge().contains(victim.getName()))
			{
				if(core.getRouge().contains(attacker.getName())) 
				{
					e.setCancelled(true);
				}
			}
			
			if(core.getBleue().contains(victim.getName()))
			{
				if(core.getBleue().contains(attacker.getName())) 
				{
					e.setCancelled(true);
				}
			}
			
			if(core.getJaune().contains(victim.getName()))
			{
				if(core.getJaune().contains(attacker.getName())) 
				{
					e.setCancelled(true);
				}
			}
			
			if(core.getVert().contains(victim.getName()))
			{
				if(core.getVert().contains(attacker.getName())) 
				{
					e.setCancelled(true);
				}
			}
			
			if(core.getOrange().contains(victim.getName()))
			{
				if(core.getOrange().contains(attacker.getName())) 
				{
					e.setCancelled(true);
				}
			}
			
			if(core.getRose().contains(victim.getName()))
			{
				if(core.getRose().contains(attacker.getName())) 
				{
					e.setCancelled(true);
				}
			}
		}

	}
}
