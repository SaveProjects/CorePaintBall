package fr.edminecoreteam.core.tasks;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import fr.edminecoreteam.core.Core;
import fr.edminecoreteam.core.State;
import fr.edminecoreteam.core.listeners.Instance;
import fr.edminecoreteam.core.utils.ChangeHubInfo;
import fr.edminecoreteam.core.utils.MessageUtils;

public class GameTask extends BukkitRunnable 
{
	
	 public int timer;
	 private Core core;  
	    
	 public GameTask(Core core) {
	    this.core = core;
	    this.timer = core.getConfig().getInt("Timers.game");
	 }
	 
	 public void run() {
	    	core.timerGame(timer);
	    	if (core.getConfig().getBoolean("Mode.2vs4"))
	    	{
	    		List<String> blueOnline = new ArrayList<String>();
	    		List<String> redOnline = new ArrayList<String>();
	    		
	    		for (String pls : core.getBleue())
	    		{
	    			if (Bukkit.getPlayer(pls) != null)
	    			{
	    				blueOnline.add(pls);
	    			}
	    		}
	    		for (String pls : core.getRouge())
	    		{
	    			if (Bukkit.getPlayer(pls) != null)
	    			{
	    				redOnline.add(pls);
	    			}
	    		}
	    		
	    		if (blueOnline.size() == 0 || redOnline.size() == 0)
	    		{
	    			core.setState(State.FINISH);
	    			
	    			if(core.bleuePoints == core.rougePoints)
					{
						for (String bleue : core.getBleue())
						{
							if (Bukkit.getPlayer(bleue) != null)
							{
								Player p = Bukkit.getPlayer(bleue);
								Instance.endGame(p, "egal");
								MessageUtils.messageEnd2vs4(p);
							}
						}
						for (String rouge : core.getRouge())
						{
							if (Bukkit.getPlayer(rouge) != null)
							{
								Player p = Bukkit.getPlayer(rouge);
								Instance.endGame(p, "egal");
								MessageUtils.messageEnd2vs4(p);
							}
						}
					}
		    		if(core.bleuePoints > core.rougePoints)
					{
						for (String bleue : core.getBleue())
						{
							if (Bukkit.getPlayer(bleue) != null)
							{
								Player p = Bukkit.getPlayer(bleue);
								Instance.endGame(p, "win");
								MessageUtils.messageEnd2vs4(p);
							}
						}
						for (String rouge : core.getRouge())
						{
							if (Bukkit.getPlayer(rouge) != null)
							{
								Player p = Bukkit.getPlayer(rouge);
								Instance.endGame(p, "lose");
								MessageUtils.messageEnd2vs4(p);
							}
						}
					}
					if(core.rougePoints > core.bleuePoints)
					{
						for (String rouge : core.getRouge())
						{
							if (Bukkit.getPlayer(rouge) != null)
							{
								Player p = Bukkit.getPlayer(rouge);
								Instance.endGame(p, "win");
								MessageUtils.messageEnd2vs4(p);
							}
						}
						for (String bleue : core.getBleue())
						{
							if (Bukkit.getPlayer(bleue) != null)
							{
								Player p = Bukkit.getPlayer(bleue);
								Instance.endGame(p, "lose");
								MessageUtils.messageEnd2vs4(p);
							}
						}
					}
	    			
					core.setState(State.FINISH);
					ChangeHubInfo srvInfo = new ChangeHubInfo(core.getServer().getServerName());
                    srvInfo.setMOTD("FINISH");
	    			EndTask start = new EndTask(core);
		            start.runTaskTimer((Plugin)this.core, 0L, 20L);
		            cancel();
	    		}
	    		
	    		if (CheckerPoints.Checker() == true)
	    		{
		    		core.setState(State.FINISH);
		    		
		    		if(core.bleuePoints == core.rougePoints)
					{
						for (String bleue : core.getBleue())
						{
							if (Bukkit.getPlayer(bleue) != null)
							{
								Player p = Bukkit.getPlayer(bleue);
								Instance.endGame(p, "egal");
								MessageUtils.messageEnd2vs4(p);
							}
						}
						for (String rouge : core.getRouge())
						{
							if (Bukkit.getPlayer(rouge) != null)
							{
								Player p = Bukkit.getPlayer(rouge);
								Instance.endGame(p, "egal");
								MessageUtils.messageEnd2vs4(p);
							}
						}
					}
		    		if(core.bleuePoints > core.rougePoints)
					{
						for (String bleue : core.getBleue())
						{
							if (Bukkit.getPlayer(bleue) != null)
							{
								Player p = Bukkit.getPlayer(bleue);
								Instance.endGame(p, "win");
								MessageUtils.messageEnd2vs4(p);
							}
						}
						for (String rouge : core.getRouge())
						{
							if (Bukkit.getPlayer(rouge) != null)
							{
								Player p = Bukkit.getPlayer(rouge);
								Instance.endGame(p, "lose");
								MessageUtils.messageEnd2vs4(p);
							}
						}
					}
					if(core.rougePoints > core.bleuePoints)
					{
						for (String rouge : core.getRouge())
						{
							if (Bukkit.getPlayer(rouge) != null)
							{
								Player p = Bukkit.getPlayer(rouge);
								Instance.endGame(p, "win");
								MessageUtils.messageEnd2vs4(p);
							}
						}
						for (String bleue : core.getBleue())
						{
							if (Bukkit.getPlayer(bleue) != null)
							{
								Player p = Bukkit.getPlayer(bleue);
								Instance.endGame(p, "lose");
								MessageUtils.messageEnd2vs4(p);
							}
						}
					}
					
					core.setState(State.FINISH);
					ChangeHubInfo srvInfo = new ChangeHubInfo(core.getServer().getServerName());
                    srvInfo.setMOTD("FINISH");
					EndTask start = new EndTask(core);
		            start.runTaskTimer((Plugin)this.core, 0L, 20L);
		            cancel();
	    		}
	    	}
	    	if (core.getConfig().getBoolean("Mode.4vs4"))
	    	{
	    		
	    	}
	    	if (core.getConfig().getBoolean("Mode.6vs4"))
	    	{
	    		
	    	}
	        
	        if (timer == 5)
	        {
	        	for (Player pls : core.getPlayers()) {
	                
	                pls.playSound(pls.getLocation(), Sound.NOTE_PLING, 1.0f, 1.5f);
	            }
	        }
	        if (timer == 4)
	        {
	        	for (Player pls : core.getPlayers()) {
	                
	                pls.playSound(pls.getLocation(), Sound.NOTE_PLING, 1.0f, 1.2f);
	            }
	        }
	        if (timer == 3)
	        {
	        	for (Player pls : core.getPlayers()) {
	                
	                pls.playSound(pls.getLocation(), Sound.NOTE_PLING, 1.0f, 1.0f);
	            }
	        }
	        if (timer == 2)
	        {
	        	for (Player pls : core.getPlayers()) {
	                
	                pls.playSound(pls.getLocation(), Sound.NOTE_PLING, 1.0f, 0.7f);
	            }
	        }
	        if (timer == 1)
	        {
	        	for (Player pls : core.getPlayers()) {
	                
	                pls.playSound(pls.getLocation(), Sound.NOTE_PLING, 1.0f, 0.5f);
	            }
	        }
	        if (timer == 0) {
	            if(core.getConfig().getBoolean("Mode.2vs4") == true) {
	            	if(core.bleuePoints == core.rougePoints)
					{
						for (String bleue : core.getBleue())
						{
							if (Bukkit.getPlayer(bleue) != null)
							{
								Player p = Bukkit.getPlayer(bleue);
								Instance.endGame(p, "egal");
								MessageUtils.messageEnd2vs4(p);
							}
						}
						for (String rouge : core.getRouge())
						{
							if (Bukkit.getPlayer(rouge) != null)
							{
								Player p = Bukkit.getPlayer(rouge);
								Instance.endGame(p, "egal");
								MessageUtils.messageEnd2vs4(p);
							}
						}
					}
		    		if(core.bleuePoints > core.rougePoints)
					{
						for (String bleue : core.getBleue())
						{
							if (Bukkit.getPlayer(bleue) != null)
							{
								Player p = Bukkit.getPlayer(bleue);
								Instance.endGame(p, "win");
								MessageUtils.messageEnd2vs4(p);
							}
						}
						for (String rouge : core.getRouge())
						{
							if (Bukkit.getPlayer(rouge) != null)
							{
								Player p = Bukkit.getPlayer(rouge);
								Instance.endGame(p, "lose");
								MessageUtils.messageEnd2vs4(p);
							}
						}
					}
					if(core.rougePoints > core.bleuePoints)
					{
						for (String rouge : core.getRouge())
						{
							if (Bukkit.getPlayer(rouge) != null)
							{
								Player p = Bukkit.getPlayer(rouge);
								Instance.endGame(p, "win");
								MessageUtils.messageEnd2vs4(p);
							}
						}
						for (String bleue : core.getBleue())
						{
							if (Bukkit.getPlayer(bleue) != null)
							{
								Player p = Bukkit.getPlayer(bleue);
								Instance.endGame(p, "lose");
								MessageUtils.messageEnd2vs4(p);
							}
						}
					}
	            }/*else if(core.getConfig().getBoolean("Mode.4vs4") == true) {
	            	for (Player plsTeam : core.getPlayers()) {
	            		
	                }
	            }else if(core.getConfig().getBoolean("Mode.6vs4") == true) {
	            	for (Player plsTeam : core.getPlayers()) {
	            		
	                }
	            }*/
	            core.setState(State.FINISH);
	            ChangeHubInfo srvInfo = new ChangeHubInfo(core.getServer().getServerName());
                srvInfo.setMOTD("FINISH");
	            
	            EndTask start = new EndTask(core);
	            start.runTaskTimer((Plugin)core, 0L, 20L);
	            cancel();
	        }
	        --timer;
	    }
	
}
