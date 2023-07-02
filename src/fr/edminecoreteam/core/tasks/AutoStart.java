package fr.edminecoreteam.core.tasks;

import fr.edminecoreteam.core.State;
import fr.edminecoreteam.core.listeners.Instance;
import fr.edminecoreteam.core.utils.ChangeHubInfo;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import fr.edminecoreteam.core.Core;
import org.bukkit.scheduler.BukkitRunnable;

public class AutoStart extends BukkitRunnable
{
    public int timer;
    private Core core;
    
    
    public AutoStart(Core core) {
        this.core = core;
        this.timer = core.getConfig().getInt("Timers.start");
    }
    
	@SuppressWarnings("deprecation")
	public void run() {
    	core.timerStart(timer);
    	if (core.getConfig().getBoolean("Mode.2vs4"))
    	{
    		if (core.getPlayers().size() < 4 && core.isForceStart == false) {
                for (Player pls : core.getPlayers()) {
                    pls.setLevel(0);
                    pls.playSound(pls.getLocation(), Sound.VILLAGER_NO, 1.0f, 1.0f);
                }
                Bukkit.broadcastMessage("§cErreur de lancement, il manque des joueurs...");
                core.setState(State.WAITING);
                ChangeHubInfo srvInfo = new ChangeHubInfo(core.getServer().getServerName());
                srvInfo.setMOTD("WAITING");
                cancel();
            }
    		else if (core.getPlayers().size() > 4)
    		{
    			if (core.getPlayers().size() == 8)
    			{
    				if (timer > core.getConfig().getInt("Timers.startFull"))
    				{
    					timer = core.getConfig().getInt("Timers.startFull");
    				}
    			}
    		}
    	}
    	if (core.getConfig().getBoolean("Mode.4vs4"))
    	{
    		if (core.getPlayers().size() < 12 && core.isForceStart == false) {
                for (Player pls : core.getPlayers()) {
                    pls.setLevel(0);
                    pls.playSound(pls.getLocation(), Sound.VILLAGER_NO, 1.0f, 1.0f);
                }
                Bukkit.broadcastMessage("§cErreur de lancement, il manque des joueurs...");
                core.setState(State.WAITING);
                ChangeHubInfo srvInfo = new ChangeHubInfo(core.getServer().getServerName());
                srvInfo.setMOTD("WAITING");
                cancel();
            }
    		else if (core.getPlayers().size() > 12)
    		{
    			if (core.getPlayers().size() == 16)
    			{
    				if (timer > core.getConfig().getInt("Timers.startFull"))
    				{
    					timer = core.getConfig().getInt("Timers.startFull");
    				}
    			}
    		}
    	}
    	if (core.getConfig().getBoolean("Mode.6vs4"))
    	{
    		if (core.getPlayers().size() < 18 && core.isForceStart == false) {
                for (Player pls : core.getPlayers()) {
                    pls.setLevel(0);
                    pls.playSound(pls.getLocation(), Sound.VILLAGER_NO, 1.0f, 1.0f);
                }
                Bukkit.broadcastMessage("§cErreur de lancement, il manque des joueurs...");
                core.setState(State.WAITING);
                ChangeHubInfo srvInfo = new ChangeHubInfo(core.getServer().getServerName());
                srvInfo.setMOTD("WAITING");
                cancel();
            }
    		else if (core.getPlayers().size() > 18)
    		{
    			if (core.getPlayers().size() == 22)
    			{
    				if (timer > core.getConfig().getInt("Timers.startFull"))
    				{
    					timer = core.getConfig().getInt("Timers.startFull");
    				}
    			}
    		}
    	}
        for (Player pls : core.getPlayers()) {
            pls.setLevel(timer);
            if (timer != 5 && timer != 4 && timer != 3 && timer != 2 && timer != 1) {
            	pls.playSound(pls.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
            }
        }
        if (timer == 20)
        {
        	for (Player pls : core.getPlayers()) {
                pls.sendTitle("§e§lLancement du jeu", "§7dans §7" + timer + " §7secondes...");
            }
        }
        if (timer == 10)
        {
        	for (Player pls : core.getPlayers()) {
                pls.sendTitle("§e§lLancement du jeu", "§7dans §7" + timer + " §7secondes...");
            }
        }
        if (timer == 5)
        {
        	for (Player pls : core.getPlayers()) {
                pls.sendTitle("§a§l" + timer, "§7préparez-vous.");
                pls.playSound(pls.getLocation(), Sound.NOTE_PLING, 1.0f, 1.5f);
            }
        }
        if (timer == 4)
        {
        	for (Player pls : core.getPlayers()) {
                pls.sendTitle("§6§l" + timer, "");
                pls.playSound(pls.getLocation(), Sound.NOTE_PLING, 1.0f, 1.2f);
            }
        }
        if (timer == 3)
        {
        	for (Player pls : core.getPlayers()) {
                pls.sendTitle("§e§l" + timer, "");
                pls.playSound(pls.getLocation(), Sound.NOTE_PLING, 1.0f, 1.0f);
            }
        }
        if (timer == 2)
        {
        	for (Player pls : core.getPlayers()) {
                pls.sendTitle("§c§l" + timer, "");
                pls.playSound(pls.getLocation(), Sound.NOTE_PLING, 1.0f, 0.7f);
            }
        }
        if (timer == 1)
        {
        	for (Player pls : core.getPlayers()) {
                pls.sendTitle("§4§l" + timer, "");
                pls.playSound(pls.getLocation(), Sound.NOTE_PLING, 1.0f, 0.5f);
            }
        }
        if (timer == 0) {
            for (Player pls : core.getPlayers()) {
                pls.setLevel(0);
            }
            if(core.getConfig().getBoolean("Mode.2vs4") == true) {
            	for (Player plsTeam : core.getPlayers()) {
                	if (!core.getRouge().contains(plsTeam.getDisplayName()) && !core.getBleue().contains(plsTeam.getDisplayName())) {
                		core.joinTeam(plsTeam);
                	}
                }
            	for (String rouge : core.getRouge()) {
            		Player p = Bukkit.getPlayer(rouge);
            		Instance.startGame(p);
            	}
            	for (String bleue : core.getBleue()) {
            		Player p = Bukkit.getPlayer(bleue);
            		Instance.startGame(p);
            	}
            }else if(core.getConfig().getBoolean("Mode.4vs4") == true) {
            	for (Player plsTeam : core.getPlayers()) {
            		if (!core.getRouge().contains(plsTeam.getDisplayName()) && !core.getBleue().contains(plsTeam.getDisplayName()) && 
            				!core.getJaune().contains(plsTeam.getDisplayName()) && !core.getVert().contains(plsTeam.getDisplayName())) {
            			core.joinTeam(plsTeam);
                	}
                }
            }else if(core.getConfig().getBoolean("Mode.6vs4") == true) {
            	for (Player plsTeam : core.getPlayers()) {
            		if (!core.getRouge().contains(plsTeam.getDisplayName()) && !core.getBleue().contains(plsTeam.getDisplayName()) && 
            				!core.getJaune().contains(plsTeam.getDisplayName()) && !core.getVert().contains(plsTeam.getDisplayName()) &&
            					!core.getOrange().contains(plsTeam.getDisplayName()) && !core.getRose().contains(plsTeam.getDisplayName())) {
            			core.joinTeam(plsTeam);
                	}
                }
            }
            Bukkit.broadcastMessage("§6§l➡ §e§lLancement du jeu !");
            core.setState(State.INGAME);
            ChangeHubInfo srvInfo = new ChangeHubInfo(core.getServer().getServerName());
            srvInfo.setMOTD("INGAME");
            GameTask start = new GameTask(core);
            start.runTaskTimer((Plugin)this.core, 0L, 20L);
            cancel();
        }
        --timer;
    }
}
