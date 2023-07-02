package fr.edminecoreteam.core.listeners;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import fr.edminecoreteam.core.Core;
import fr.edminecoreteam.core.State;
import fr.edminecoreteam.core.data.Data;
import fr.edminecoreteam.core.gamemanager.InventoryGame;
import fr.edminecoreteam.core.gamemanager.SaveInventory;
import fr.edminecoreteam.core.gamemanager.gun.DesertEagle;
import fr.edminecoreteam.core.gamemanager.gun.MP5;
import fr.edminecoreteam.core.utils.ChangeHubInfo;
import fr.edminecoreteam.core.utils.MessageUtils;

public class Instance implements Listener
{
	
	private static Core core = Core.getInstance();
	
    public static void joinWAITING(final Player p) {
        Location spawn = new Location(Bukkit.getWorld("hub"), 2.5, 31.0, 0.5, -90.5f, -4.0f);
        PlayerInventory pi = p.getInventory();
        pi.setHelmet(null);
        pi.setChestplate(null);
        pi.setLeggings(null);
        pi.setBoots(null);
        p.setAllowFlight(false);
		p.setFlying(false);
        
        p.getInventory().clear();
        p.setLevel(0);
        p.setFoodLevel(20);
        p.setHealth(20.0);
        p.setGameMode(GameMode.ADVENTURE);
        p.teleport(spawn);
        ItemJoinListener.joinItem(p);
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 0.5f);
    }
    
    @SuppressWarnings("deprecation")
	public static void joinInGame(Player p) {
    	Location spawn = new Location(Bukkit.getWorld("game"), 
				core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".specSpawn.x")
				, core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".specSpawn.y")
				, core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".specSpawn.z")
				, (float) core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".specSpawn.f")
				, (float) core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".specSpawn.t"));
        
    	if (!core.getPlayersName().contains(p.getName()))
    	{
    		PlayerInventory pi = p.getInventory();
            pi.setHelmet(null);
            pi.setChestplate(null);
            pi.setLeggings(null);
            pi.setBoots(null);
            p.setAllowFlight(false);
    		p.setFlying(false);
            
            p.getInventory().clear();
            p.setLevel(0);
            p.setFoodLevel(20);
            p.setHealth(20.0);
            p.setGameMode(GameMode.SPECTATOR);
            p.teleport(spawn);
            ItemJoinListener.spectacleItem(p);
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 0.5f);
    	}
    	else
    	{
    		p.sendTitle("§e§lBon Retour !", "§7Vous nous avez manquez...");
    	}
    }
    
    @SuppressWarnings("deprecation")
	public static void startGame(Player p) {
    	
    	if(core.getConfig().getBoolean("Mode.2vs4"))
    	{
    		if(core.getRouge().contains(p.getName()))
    		{
    			Location redspawn = new Location(Bukkit.getWorld("game"), 
    					core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".redSpawn.x")
    					, core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".redSpawn.y")
    					, core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".redSpawn.z")
    					, (float) core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".redSpawn.f")
    					, (float) core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".redSpawn.t"));
    			p.teleport(redspawn);
    			MessageUtils.messageStarting(p);
    			p.getInventory().clear();
    			DesertEagle.getGun(p);
    			InventoryGame.getEquipement(p, "rouge");
    			p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1.0f, 1.0f);
    			p.sendTitle("§e§lBonne chance !", "§7Votre équipe: §cRouge");
    		}
    		if(core.getBleue().contains(p.getName()))
    		{
    			Location bluespawn = new Location(Bukkit.getWorld("game"), 
    					core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".blueSpawn.x")
    					, core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".blueSpawn.y")
    					, core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".blueSpawn.z")
    					, (float) core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".blueSpawn.f")
    					, (float) core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".blueSpawn.t"));
    			p.teleport(bluespawn);
    			MessageUtils.messageStarting(p);
    			p.getInventory().clear();
    			DesertEagle.getGun(p);
    			InventoryGame.getEquipement(p, "bleue");
    			p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1.0f, 1.0f);
    			p.sendTitle("§e§lBonne chance !", "§7Votre équipe: §9Bleue");
    		}
    	}
    	
    	if(core.getConfig().getBoolean("Mode.4vs4"))
    	{
    		if(core.getRouge().contains(p.getName()))
    		{
    			Location redspawn = new Location(Bukkit.getWorld("game"), 
    					core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".redSpawn.x")
    					, core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".redSpawn.y")
    					, core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".redSpawn.z")
    					, (float) core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".redSpawn.f")
    					, (float) core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".redSpawn.t"));
    			p.teleport(redspawn);
    			MessageUtils.messageStarting(p);
    			p.getInventory().clear();
    			DesertEagle.getGun(p);
    			InventoryGame.getEquipement(p, "rouge");
    			p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1.0f, 1.0f);
    			p.sendTitle("§e§lBonne chance !", "§7Votre équipe: §cRouge");
    		}
    		if(core.getBleue().contains(p.getName()))
    		{
    			Location bluespawn = new Location(Bukkit.getWorld("game"), 
    					core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".blueSpawn.x")
    					, core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".blueSpawn.y")
    					, core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".blueSpawn.z")
    					, (float) core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".blueSpawn.f")
    					, (float) core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".blueSpawn.t"));
    			p.teleport(bluespawn);
    			MessageUtils.messageStarting(p);
    			p.getInventory().clear();
    			DesertEagle.getGun(p);
    			InventoryGame.getEquipement(p, "bleue");
    			p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1.0f, 1.0f);
    			p.sendTitle("§e§lBonne chance !", "§7Votre équipe: §9Bleue");
    		}
    		if(core.getJaune().contains(p.getName()))
    		{
    			Location redspawn = new Location(Bukkit.getWorld("game"), 
    					core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".yellowSpawn.x")
    					, core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".yellowSpawn.y")
    					, core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".yellowSpawn.z")
    					, (float) core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".yellowSpawn.f")
    					, (float) core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".yellowSpawn.t"));
    			p.teleport(redspawn);
    			MessageUtils.messageStarting(p);
    			p.getInventory().clear();
    			DesertEagle.getGun(p);
    			InventoryGame.getEquipement(p, "jaune");
    			p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1.0f, 1.0f);
    			p.sendTitle("§e§lBonne chance !", "§7Votre équipe: §eJaune");
    		}
    		if(core.getVert().contains(p.getName()))
    		{
    			Location bluespawn = new Location(Bukkit.getWorld("game"), 
    					core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".greenSpawn.x")
    					, core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".greenSpawn.y")
    					, core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".greenSpawn.z")
    					, (float) core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".greenSpawn.f")
    					, (float) core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".greenSpawn.t"));
    			p.teleport(bluespawn);
    			MessageUtils.messageStarting(p);
    			p.getInventory().clear();
    			DesertEagle.getGun(p);
    			InventoryGame.getEquipement(p, "vert");
    			p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1.0f, 1.0f);
    			p.sendTitle("§e§lBonne chance !", "§7Votre équipe: §aVert");
    		}
    	}
    	
    	if(core.getConfig().getBoolean("Mode.6vs4"))
    	{
    		if(core.getRouge().contains(p.getName()))
    		{
    			Location redspawn = new Location(Bukkit.getWorld("game"), 
    					core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".redSpawn.x")
    					, core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".redSpawn.y")
    					, core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".redSpawn.z")
    					, (float) core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".redSpawn.f")
    					, (float) core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".redSpawn.t"));
    			p.teleport(redspawn);
    			MessageUtils.messageStarting(p);
    			p.getInventory().clear();
    			DesertEagle.getGun(p);
    			InventoryGame.getEquipement(p, "rouge");
    			p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1.0f, 1.0f);
    			p.sendTitle("§e§lBonne chance !", "§7Votre équipe: §cRouge");
    		}
    		if(core.getBleue().contains(p.getName()))
    		{
    			Location bluespawn = new Location(Bukkit.getWorld("game"), 
    					core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".blueSpawn.x")
    					, core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".blueSpawn.y")
    					, core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".blueSpawn.z")
    					, (float) core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".blueSpawn.f")
    					, (float) core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".blueSpawn.t"));
    			p.teleport(bluespawn);
    			MessageUtils.messageStarting(p);
    			p.getInventory().clear();
    			DesertEagle.getGun(p);
    			InventoryGame.getEquipement(p, "bleue");
    			p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1.0f, 1.0f);
    			p.sendTitle("§e§lBonne chance !", "§7Votre équipe: §9Bleue");
    		}
    		if(core.getJaune().contains(p.getName()))
    		{
    			Location redspawn = new Location(Bukkit.getWorld("game"), 
    					core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".yellowSpawn.x")
    					, core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".yellowSpawn.y")
    					, core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".yellowSpawn.z")
    					, (float) core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".yellowSpawn.f")
    					, (float) core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".yellowSpawn.t"));
    			p.teleport(redspawn);
    			MessageUtils.messageStarting(p);
    			p.getInventory().clear();
    			DesertEagle.getGun(p);
    			InventoryGame.getEquipement(p, "jaune");
    			p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1.0f, 1.0f);
    			p.sendTitle("§e§lBonne chance !", "§7Votre équipe: §eJaune");
    		}
    		if(core.getVert().contains(p.getName()))
    		{
    			Location bluespawn = new Location(Bukkit.getWorld("game"), 
    					core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".greenSpawn.x")
    					, core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".greenSpawn.y")
    					, core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".greenSpawn.z")
    					, (float) core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".greenSpawn.f")
    					, (float) core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".greenSpawn.t"));
    			p.teleport(bluespawn);
    			MessageUtils.messageStarting(p);
    			p.getInventory().clear();
    			DesertEagle.getGun(p);
    			InventoryGame.getEquipement(p, "vert");
    			p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1.0f, 1.0f);
    			p.sendTitle("§e§lBonne chance !", "§7Votre équipe: §aVert");
    		}
    		if(core.getOrange().contains(p.getName()))
    		{
    			Location redspawn = new Location(Bukkit.getWorld("game"), 
    					core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".orangeSpawn.x")
    					, core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".orangeSpawn.y")
    					, core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".orangeSpawn.z")
    					, (float) core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".orangeSpawn.f")
    					, (float) core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".orangeSpawn.t"));
    			p.teleport(redspawn);
    			MessageUtils.messageStarting(p);
    			p.getInventory().clear();
    			DesertEagle.getGun(p);
    			InventoryGame.getEquipement(p, "orange");
    			p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1.0f, 1.0f);
    			p.sendTitle("§e§lBonne chance !", "§7Votre équipe: §6Orange");
    		}
    		if(core.getRose().contains(p.getName()))
    		{
    			Location bluespawn = new Location(Bukkit.getWorld("game"), 
    					core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".pinkSpawn.x")
    					, core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".pinkSpawn.y")
    					, core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".pinkSpawn.z")
    					, (float) core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".pinkSpawn.f")
    					, (float) core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".pinkSpawn.t"));
    			p.teleport(bluespawn);
    			MessageUtils.messageStarting(p);
    			p.getInventory().clear();
    			DesertEagle.getGun(p);
    			InventoryGame.getEquipement(p, "rose");
    			p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1.0f, 1.0f);
    			p.sendTitle("§e§lBonne chance !", "§7Votre équipe: §dRose");
    		}
    	}
    }
    
    public static void respawnInGame(Player p) {
    	
    	if(core.getConfig().getBoolean("Mode.2vs4"))
    	{
    		Location spawn = new Location(Bukkit.getWorld("game"), 
    				core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".specSpawn.x")
    				, core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".specSpawn.y")
    				, core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".specSpawn.z")
    				, (float) core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".specSpawn.f")
    				, (float) core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".specSpawn.t"));
    		core.addDeath(p, 1);
    		if(core.getRouge().contains(p.getDisplayName()))
    		{
    			Location redspawn = new Location(Bukkit.getWorld("game"), 
    					core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".redSpawn.x")
    					, core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".redSpawn.y")
    					, core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".redSpawn.z")
    					, (float) core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".redSpawn.f")
    					, (float) core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".redSpawn.t"));
    			SaveInventory saveInv = new SaveInventory();
    			saveInv.saveInventory(p);
    			PlayerInventory pi = p.getInventory();
                pi.setHelmet(null);
                pi.setChestplate(null);
                pi.setLeggings(null);
                pi.setBoots(null);
                p.setAllowFlight(false);
        		p.setFlying(false);
                
                p.getInventory().clear();
                p.setLevel(0);
                p.setFoodLevel(20);
                p.setHealth(20.0);
                p.setGameMode(GameMode.SPECTATOR);
                p.teleport(spawn);
                new BukkitRunnable() {
                    int t = 7;
                        
        	        @SuppressWarnings("deprecation")
					public void run() {
        	        	if (!core.isState(State.INGAME))
        	        	{
        	        		cancel();
        	        	}
        	        	if (t == 7)
        	        	{
        	        		p.sendTitle("§c§lVous êtes mort !", "");
        	        	}
        	        	if (t == 6 || t == 5 || t == 4 || t == 3 || t == 2)
        	        	{
        	        		int sec = t -1;
        	        		p.sendTitle("§c§lVous êtes mort !", "§7Respawn dans §e" + sec + "s");
        	        	}
                        --t;
                        if (t == 0) {
                        	p.sendTitle("", "");
                        	p.setGameMode(GameMode.ADVENTURE);
                            p.teleport(redspawn);
                            saveInv.restoreInventory(p);
                            InventoryGame.getEquipement(p, "rouge");
                            p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1.0f, 1.0f);
                            invincibleChecker(p);
                            checkGun(p);
                            cancel();
                        }
                    }
                }.runTaskTimer((Plugin)core, 0L, 20L);
    		}
    		if(core.getBleue().contains(p.getDisplayName()))
    		{
    			Location bluespawn = new Location(Bukkit.getWorld("game"), 
    					core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".blueSpawn.x")
    					, core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".blueSpawn.y")
    					, core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".blueSpawn.z")
    					, (float) core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".blueSpawn.f")
    					, (float) core.getConfig().getDouble("Cartes." + core.getGameWorldName + ".blueSpawn.t"));
    			SaveInventory saveInv = new SaveInventory();
    			saveInv.saveInventory(p);
    			PlayerInventory pi = p.getInventory();
                pi.setHelmet(null);
                pi.setChestplate(null);
                pi.setLeggings(null);
                pi.setBoots(null);
                p.setAllowFlight(false);
        		p.setFlying(false);
                
                p.getInventory().clear();
                p.setLevel(0);
                p.setFoodLevel(20);
                p.setHealth(20.0);
                p.setGameMode(GameMode.SPECTATOR);
                p.teleport(spawn);
                new BukkitRunnable() {
                    int t = 7;
                        
        	        @SuppressWarnings("deprecation")
					public void run() {
        	        	if (!core.isState(State.INGAME))
        	        	{
        	        		cancel();
        	        	}
        	        	if (t == 7)
        	        	{
        	        		p.sendTitle("§c§lVous êtes mort !", "");
        	        	}
        	        	if (t == 6 || t == 5 || t == 4 || t == 3 || t == 2)
        	        	{
        	        		int sec = t -1;
        	        		p.sendTitle("§c§lVous êtes mort !", "§7Respawn dans §e" + sec + "s");
        	        	}
                        --t;
                        if (t == 0) {
                        	p.sendTitle("", "");
                        	p.setGameMode(GameMode.ADVENTURE);
                            p.teleport(bluespawn);
                            saveInv.restoreInventory(p);
                            InventoryGame.getEquipement(p, "bleue");
                            p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1.0f, 1.0f);
                            invincibleChecker(p);
                            checkGun(p);
                            cancel();
                        }
                    }
                }.runTaskTimer((Plugin)core, 0L, 20L);
    		}
    	}
    	
    	if(core.getConfig().getBoolean("Mode.4vs4"))
    	{
    		
    	}
    	
    	if(core.getConfig().getBoolean("Mode.6vs4"))
    	{
    		
    	}
    }
    
    public static void addPoint(Player p) {
    	
    	if (core.getConfig().getBoolean("Mode.2vs4"))
    	{
    		if (core.getRouge().contains(p.getDisplayName())) 
    		{
    			core.rougePoints = core.rougePoints + 1;
    		}
    		if (core.getBleue().contains(p.getDisplayName())) 
    		{
    			core.bleuePoints = core.bleuePoints + 1;
    		}
    		addKillCoins(p);
    		core.addKill(p, 1);
    		verifyKillStreak(p);
    	}
    	
    	if(core.getConfig().getBoolean("Mode.4vs4"))
    	{
    		if (core.getRouge().contains(p.getDisplayName())) 
    		{
    			core.rougePoints = core.rougePoints + 1;
    		}
    		if (core.getBleue().contains(p.getDisplayName())) 
    		{
    			core.bleuePoints = core.bleuePoints + 1;
    		}
    		if (core.getJaune().contains(p.getDisplayName())) 
    		{
    			core.jaunePoints = core.jaunePoints + 1;
    		}
    		if (core.getVert().contains(p.getDisplayName())) 
    		{
    			core.vertPoints = core.vertPoints + 1;
    		}
    		addKillCoins(p);
    		core.addKill(p, 1);
    		verifyKillStreak(p);
    	}
    	
    	if(core.getConfig().getBoolean("Mode.6vs4"))
    	{
    		if (core.getRouge().contains(p.getDisplayName())) 
    		{
    			core.rougePoints = core.rougePoints + 1;
    		}
    		if (core.getBleue().contains(p.getDisplayName())) 
    		{
    			core.bleuePoints = core.bleuePoints + 1;
    		}
    		if (core.getJaune().contains(p.getDisplayName())) 
    		{
    			core.jaunePoints = core.jaunePoints + 1;
    		}
    		if (core.getVert().contains(p.getDisplayName())) 
    		{
    			core.vertPoints = core.vertPoints + 1;
    		}
    		if (core.getOrange().contains(p.getDisplayName())) 
    		{
    			core.orangePoints = core.orangePoints + 1;
    		}
    		if (core.getRose().contains(p.getDisplayName())) 
    		{
    			core.rosePoints = core.rosePoints + 1;
    		}
    		addKillCoins(p);
    		core.addKill(p, 1);
    		verifyKillStreak(p);
    	}
    }
    
    public static void addKillCoins(Player p) {
    	Random rand = new Random();
        int min = 15;
        int max = 30;
        int randomNum = rand.nextInt((max - min) + 1) + min;
        core.addCoins(p, randomNum);
	}
    
    public static void verifyKillStreak(Player p)
    {
    	core.addKillStreak(p, 1);
    	if (core.getKillStreak(p) > core.getMostKillStreak(p))
    	{
    		int finalValue = core.getKillStreak(p);
    		core.setMostKillStreak(p, finalValue);
    	}
    }
    
    public static void checkGun(Player p) {
    	boolean hasDesertEagle = isCheckIsTrue(p, "§aDesert-Eagle");
    	if (hasDesertEagle == false)
    	{
    		DesertEagle.getGun(p);
    	}
    	
		if (core.getMP5().contains(p.getName()))
		{
			boolean hasMP5 = isCheckIsTrue(p, "§aMP5");
	    	if (hasMP5 == false)
	    	{
	    		MP5.getGun(p);
	    	}
		}
	}
    
    private static boolean isCheckIsTrue(Player p, String itemname)
    {
    	ItemStack[] inventory = p.getInventory().getContents();
		for (ItemStack item : inventory) {
	        if (item != null && item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equals("§aDesert-Eagle")) {
	            return true;
	        }
		}
		return false;
    }
    
    public static void invincibleChecker(Player p)
    {
    	core.getIsInvincible().add(p.getName());
    	new BukkitRunnable() {
            int t = 7;
			public void run() {
	        	if (!core.isState(State.INGAME))
	        	{
	        		cancel();
	        	}
	        	if (t == 7)
	        	{
	        		Core.getInstance().title.sendActionBar(p, "§aVous avez 5 secondes d'invincibilités.");
	        	}
	        	if (t == 6 || t == 5 || t == 4 || t == 3 || t == 2)
	        	{
	        		int sec = t -1;
	        		Core.getInstance().title.sendActionBar(p, "§aIl vous reste " + sec + " secondes d'invincibilités.");
	        	}
                --t;
                if (t == 0) {
                	Core.getInstance().title.sendActionBar(p, "§6⚠ Vous n'êtes plus invincible... ⚠");
                    p.playSound(p.getLocation(), Sound.BLAZE_HIT, 1.0f, 1.0f);
                    core.getIsInvincible().remove(p.getName());
                    cancel();
                }
            }
        }.runTaskTimer((Plugin)core, 0L, 20L);
    }
    
    @SuppressWarnings("deprecation")
	public static void endGame(Player p, String winorlose) {
    	
    	if (winorlose == "win")
    	{
    		PlayerInventory pi = p.getInventory();
            pi.setHelmet(null);
            pi.setChestplate(null);
            pi.setLeggings(null);
            pi.setBoots(null);
    		pi.clear();
    		
    		Location spawn = new Location(Bukkit.getWorld("hub"), 2.5, 31.0, 0.5, -90.5f, -4.0f);
    		p.setGameMode(GameMode.ADVENTURE);
    		p.teleport(spawn);
    		p.setAllowFlight(true);
    		p.setFlying(true);
    		ItemJoinListener.endItem(p);
    		p.sendTitle("§e§lVictoire !", "§7Vous avez remporté la partie !");
    		Data data = new Data(p.getName());
    		data.addKills(core.getKill(p));
    		data.addDeaths(core.getDeath(p));
    		data.addVictoires(1);
    		data.addPlayedGames(1);
    		if (core.getMostKillStreak(p) > data.getTopKillStreak())
    		{
    			data.setTopKillStreak(core.getMostKillStreak(p));
    		}
    		
    	}
    	
    	if (winorlose == "egal")
    	{
    		PlayerInventory pi = p.getInventory();
            pi.setHelmet(null);
            pi.setChestplate(null);
            pi.setLeggings(null);
            pi.setBoots(null);
    		pi.clear();
    		
    		Location spawn = new Location(Bukkit.getWorld("hub"), 2.5, 31.0, 0.5, -90.5f, -4.0f);
    		p.setGameMode(GameMode.ADVENTURE);
    		p.teleport(spawn);
    		p.setAllowFlight(true);
    		p.setFlying(true);
    		ItemJoinListener.endItem(p);
    		p.sendTitle("§f§lÉgalité..", "§7Peut-être une prochaine fois !");
    		Data data = new Data(p.getName());
    		data.addKills(core.getKill(p));
    		data.addDeaths(core.getDeath(p));
    		data.addPlayedGames(1);
    		if (core.getMostKillStreak(p) > data.getTopKillStreak())
    		{
    			data.setTopKillStreak(core.getMostKillStreak(p));
    		}
    	}
    	
    	if (winorlose == "lose")
    	{
    		PlayerInventory pi = p.getInventory();
            pi.setHelmet(null);
            pi.setChestplate(null);
            pi.setLeggings(null);
            pi.setBoots(null);
            pi.clear();
            
            Location spawn = new Location(Bukkit.getWorld("hub"), 2.5, 31.0, 0.5, -90.5f, -4.0f);
            p.setGameMode(GameMode.ADVENTURE);
    		p.teleport(spawn);
    		p.setAllowFlight(true);
    		p.setFlying(true);
    		ItemJoinListener.endItem(p);
    		p.sendTitle("§c§lPerdu...", "§7Peut-être une prochaine fois !");
    		Data data = new Data(p.getName());
    		data.addKills(core.getKill(p));
    		data.addDeaths(core.getDeath(p));
    		data.addDefaites(1);
    		data.addPlayedGames(1);
    		if (core.getMostKillStreak(p) > data.getTopKillStreak())
    		{
    			data.setTopKillStreak(core.getMostKillStreak(p));
    		}
    	}
    }

	public static void quitWAITING(Player p) {
		// TODO Auto-generated method stub
		
	} 
	
	public static boolean checkServersForStart()
	{
		String srvName = "PaintBall_TwovsFour_";
		ChangeHubInfo servers = new ChangeHubInfo(srvName);
		for (String srvs : servers.getServer())
		{
			ChangeHubInfo finalservers = new ChangeHubInfo(srvs);
			if (finalservers.getServerMotd().equalsIgnoreCase("WAITING"))
			{
				return true;
			}
		}
		return false;
	}
    
}
