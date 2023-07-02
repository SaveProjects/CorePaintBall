// 
// Decompiled by Procyon v0.5.36
// 

package fr.edminecoreteam.core.listeners;

import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.EventHandler;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.Bukkit;
import fr.edminecoreteam.core.State;
import fr.edminecoreteam.core.gui.ChooseTeam;
import fr.edminecoreteam.core.utils.FoundLobby;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;

import fr.edminecoreteam.core.Core;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;

public class EventsListener implements Listener
{
    private Core core;
    public EventsListener(Core core) {
        this.core = core;
    }
    
    @EventHandler
    private void onDamage(EntityDamageEvent e) {
    	
    	if (e.getEntityType() != EntityType.PLAYER) { return; }
	    	if(e.getEntity() instanceof Player) {
	    		Player p = (Player)e.getEntity();
	            if (core.isState(State.WAITING) || core.isState(State.STARTING) || core.isState(State.FINISH)) {
	                e.setCancelled(true);
	                if (e.getCause().equals(EntityDamageEvent.DamageCause.VOID)) {
	                    Location spawn = new Location(Bukkit.getWorld("hub"), 2.5, 31.0, 0.5, -90.5f, -4.0f);
	                    p.teleport(spawn);
	                }
	            }
	            if (core.isState(State.INGAME)) {
	            	p.setHealth(20);
	                if (e.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {
	                	e.setCancelled(true);
	                }
	            }
	    	}
    }
    
    @EventHandler
    private void onDrop(PlayerDropItemEvent e) {
        if (core.isState(State.WAITING) || core.isState(State.STARTING) || core.isState(State.FINISH)) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    private void onHungerBarChange(FoodLevelChangeEvent e) {
        if (e.getEntityType() != EntityType.PLAYER) {
            return;
        }
        if (core.isState(State.WAITING) || core.isState(State.STARTING) || core.isState(State.INGAME) || core.isState(State.FINISH)) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    private void onWeatherChange(WeatherChangeEvent e) {
		e.setCancelled(true);
	}
    
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player)e.getWhoClicked();
        ItemStack it = e.getCurrentItem();
        if (it == null) {
            return;
        }
        if (it.getType() == Material.BANNER && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lChoix de votre équipe §7• Clique")) {
            e.setCancelled(true);
            ChooseTeam.gui(p);
        }
        if (it.getType() == Material.BED && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lQuitter §7• Clique")) {
            e.setCancelled(true);
            p.performCommand("hub");
        }
        if (it.getType() == Material.NETHER_STAR && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lRejouer §7• Clique")) {
            e.setCancelled(true);
            FoundLobby.foundGame(p);
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
        if (it.getType() == Material.BANNER && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§f§lChoix de votre équipe §7• Clique") && (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK || a == Action.LEFT_CLICK_AIR || a == Action.LEFT_CLICK_BLOCK)) {
            e.setCancelled(true);
            ChooseTeam.gui(p);
        }
        if (it.getType() == Material.BED && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§c§lQuitter §7• Clique") && (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK || a == Action.LEFT_CLICK_AIR || a == Action.LEFT_CLICK_BLOCK)) {
            e.setCancelled(true);
            p.performCommand("hub");
        }
        if (it.getType() == Material.NETHER_STAR && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§d§lRejouer §7• Clique") && (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK || a == Action.LEFT_CLICK_AIR || a == Action.LEFT_CLICK_BLOCK)) {
            e.setCancelled(true);
            FoundLobby.foundGame(p);
        }
    }
    
    
    @EventHandler
    public void chooseTeamInteract(InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        final ItemStack it = e.getCurrentItem();
        if (it == null) {
            return;
        }
        if (e.getView().getTopInventory().getTitle().equals("§8Choix de votre équipe")) {
        	if (it.getType() == Material.STAINED_GLASS_PANE) { e.setCancelled(true); }
        	
        	if (it.getType() == Material.SKULL_ITEM && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§fÉquipe Aléatoire")) 
        	{
        		e.setCancelled(true);
        		core.leaveTeam(p);
            	p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
            	ItemJoinListener.changeTeam(p, "Random");
        	}
        	
        	if (it.getType() == Material.BANNER && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cÉquipe Rouge")) 
        	{
        		e.setCancelled(true);
        		if(!core.getRouge().contains(p.getName())) 
        		{
        			if (core.getRouge().size() < 4) 
        			{
        				core.leaveTeam(p);
            			core.getRouge().add(p.getName());
            			p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
            			ItemJoinListener.changeTeam(p, "Rouge");
        			}
        		}
        		else 
        		{
        			p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0f, 1.0f);
        		}
        	}
        	if (it.getType() == Material.BANNER && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§9Équipe Bleue")) 
        	{
        		e.setCancelled(true);
        		if(!core.getBleue().contains(p.getName())) 
        		{
        			if (core.getBleue().size() < 4) 
        			{
        				core.leaveTeam(p);
            			core.getBleue().add(p.getName());
            			p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
            			ItemJoinListener.changeTeam(p, "Bleue");
        			}
        		}
        		else 
        		{
        			p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0f, 1.0f);
        		}
        	}
        	if (it.getType() == Material.BANNER && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eÉquipe Jaune")) 
        	{
        		e.setCancelled(true);
        		if(!core.getJaune().contains(p.getName())) 
        		{
        			if (core.getJaune().size() < 4) 
        			{
        				core.leaveTeam(p);
            			core.getJaune().add(p.getName());
            			p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
            			ItemJoinListener.changeTeam(p, "Jaune");
        			}
        		}
        		else 
        		{
        			p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0f, 1.0f);
        		}
        	}
        	if (it.getType() == Material.BANNER && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aÉquipe Verte")) 
        	{
        		e.setCancelled(true);
        		if(!core.getVert().contains(p.getName())) 
        		{
        			if (core.getVert().size() < 4) 
        			{
        				core.leaveTeam(p);
            			core.getVert().add(p.getName());
            			p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
            			ItemJoinListener.changeTeam(p, "Vert");
        			}
        		}
        		else 
        		{
        			p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0f, 1.0f);
        		}
        	}
        	if (it.getType() == Material.BANNER && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Équipe Orange")) 
        	{
        		e.setCancelled(true);
        		if(!core.getOrange().contains(p.getName())) 
        		{
        			if (core.getOrange().size() < 4) 
        			{
        				core.leaveTeam(p);
            			core.getOrange().add(p.getName());
            			p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
            			ItemJoinListener.changeTeam(p, "Orange");
        			}
        		}
        		else 
        		{
        			p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0f, 1.0f);
        		}
        	}
        	if (it.getType() == Material.BANNER && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§dÉquipe Rose")) 
        	{
        		e.setCancelled(true);
        		if(!core.getRose().contains(p.getName())) 
        		{
        			if (core.getRose().size() < 4) 
        			{
        				core.leaveTeam(p);
            			core.getRose().add(p.getName());
            			p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
            			ItemJoinListener.changeTeam(p, "Rose");
        			}
        		}
        		else 
        		{
        			p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0f, 1.0f);
        		}
        	}
        	
        }
    }
    
    
}
