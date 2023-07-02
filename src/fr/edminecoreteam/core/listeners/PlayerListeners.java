package fr.edminecoreteam.core.listeners;

import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import fr.edminecoreteam.core.tasks.AutoStart;
import fr.edminecoreteam.core.utils.ChangeHubInfo;
import fr.edminecoreteam.core.State;
import fr.edminecoreteam.core.data.Data;

import org.bukkit.event.player.PlayerJoinEvent;
import fr.edminecoreteam.core.Core;
import org.bukkit.event.Listener;

public class PlayerListeners implements Listener
{
    private Core core;
    
    public PlayerListeners(Core core) {
        this.core = core;
    }
    
    @EventHandler
    private void onJoin(PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        	Data data = new Data(p.getName());
        	data.createData();
	        //Mode 2vs4
	        if (core.getConfig().getBoolean("Mode.2vs4") == true) {
	        	p.sendMessage("2vs4");
	        	if (core.isState(State.WAITING)) 
	        	{
	        		if (core.getPlayers().size() == 8) {
	                    p.kickPlayer("§cPartie pleine...");
	                    return;
	                }
	        		if (!core.getPlayers().contains(p)) 
	        		{
	                    core.getPlayers().add(p);
	                    core.getPlayersName().add(p.getName());
	                    Instance.joinWAITING(p);
	                }
	        		core.getServer().broadcastMessage("§e" + p.getName() + "§7 a rejoint le jeu. §d" + core.getPlayers().size() + "§d/8");
	        		e.setJoinMessage(null);
		        	if (core.getPlayers().size() == 6) {
	                    AutoStart start = new AutoStart(core);
	                    start.runTaskTimer((Plugin)this.core, 0L, 20L);
	                    core.setState(State.STARTING);
	                    ChangeHubInfo srvInfo = new ChangeHubInfo(core.getServer().getServerName());
	                    srvInfo.setMOTD("STARTING");
	                    boolean checkSrv = Instance.checkServersForStart();
	                    if (checkSrv == false)
	                    {
	                    	srvInfo.setStatus(2);
	                    }
	                }
	        	}
	        	if (core.isState(State.STARTING))
	        	{
	        		if (core.getPlayers().size() == 8) {
	                    p.kickPlayer("§cPartie pleine...");
	                    return;
	                }
	        		if (!core.getPlayers().contains(p)) 
	        		{
	                    core.getPlayers().add(p);
	                    core.getPlayersName().add(p.getName());
	                    Instance.joinWAITING(p);
	                }
	        		core.getServer().broadcastMessage("§e" + p.getName() + "§7 a rejoint le jeu. §d" + core.getPlayers().size() + "§d/8");
	        		e.setJoinMessage(null);
	        	}
	        	if (core.isState(State.INGAME))
	        	{
	        		e.setJoinMessage(null);
	                Instance.joinInGame(p);
	        	}
	        }
	        
	        //Mode 4vs4
	        if (core.getConfig().getBoolean("Mode.4vs4") == true) {
	        	p.sendMessage("4vs4");
	        	if (core.isState(State.WAITING)) 
	        	{
	        		if (core.getPlayers().size() == 16) {
	                    p.kickPlayer("§cPartie pleine...");
	                    return;
	                }
	        		if (!core.getPlayers().contains(p)) 
	        		{
	                    core.getPlayers().add(p);
	                    core.getPlayersName().add(p.getName());
	                    Instance.joinWAITING(p);
	                }
	        		core.getServer().broadcastMessage("§e" + p.getName() + "§7 a rejoint le jeu. §d" + core.getPlayers().size() + "§d/16");
	        		e.setJoinMessage(null);
		        	if (core.getPlayers().size() == 12) {
	                    final AutoStart start = new AutoStart(core);
	                    start.runTaskTimer((Plugin)this.core, 0L, 20L);
	                    core.setState(State.STARTING);
	                    ChangeHubInfo srvInfo = new ChangeHubInfo(core.getServer().getServerName());
	                    srvInfo.setMOTD("STARTING");
	                    boolean checkSrv = Instance.checkServersForStart();
	                    if (checkSrv == false)
	                    {
	                    	srvInfo.setStatus(2);
	                    }
	                }
		        	if (core.isState(State.STARTING))
		        	{
		        		if (core.getPlayers().size() == 16) {
		                    p.kickPlayer("§cPartie pleine...");
		                    return;
		                }
		        		if (!core.getPlayers().contains(p)) 
		        		{
		                    core.getPlayers().add(p);
		                    core.getPlayersName().add(p.getName());
		                    Instance.joinWAITING(p);
		                }
		        		core.getServer().broadcastMessage("§e" + p.getName() + "§7 a rejoint le jeu. §d" + core.getPlayers().size() + "§d/16");
		        		e.setJoinMessage(null);
		        	}
	        	}
	        }
	        
	        //Mode 6vs4
	        if (core.getConfig().getBoolean("Mode.6vs4") == true) {
	        	p.sendMessage("6vs4");
	        	if (core.isState(State.WAITING)) 
	        	{
	        		if (core.getPlayers().size() == 24) {
	                    p.kickPlayer("§cPartie pleine...");
	                    return;
	                }
	        		if (!core.getPlayers().contains(p)) 
	        		{
	                    core.getPlayers().add(p);
	                    core.getPlayersName().add(p.getName());
	                    Instance.joinWAITING(p);
	                }
	        		core.getServer().broadcastMessage("§e" + p.getName() + "§7 a rejoint le jeu. §d" + core.getPlayers().size() + "§d/24");
	        		e.setJoinMessage(null);
		        	if (core.getPlayers().size() == 18) {
	                    final AutoStart start = new AutoStart(core);
	                    start.runTaskTimer((Plugin)core, 0L, 20L);
	                    core.setState(State.STARTING);
	                    ChangeHubInfo srvInfo = new ChangeHubInfo(core.getServer().getServerName());
	                    srvInfo.setMOTD("STARTING");
	                    boolean checkSrv = Instance.checkServersForStart();
	                    if (checkSrv == false)
	                    {
	                    	srvInfo.setStatus(2);
	                    }
	                }
		        	if (core.isState(State.STARTING))
		        	{
		        		if (core.getPlayers().size() == 24) {
		                    p.kickPlayer("§cPartie pleine...");
		                    return;
		                }
		        		if (!core.getPlayers().contains(p)) 
		        		{
		                    core.getPlayers().add(p);
		                    core.getPlayersName().add(p.getName());
		                    Instance.joinWAITING(p);
		                }
		        		core.getServer().broadcastMessage("§e" + p.getName() + "§7 a rejoint le jeu. §d" + core.getPlayers().size() + "§d/24");
		        		e.setJoinMessage(null);
		        	}
	        	}
	        }
    }
    
    @EventHandler
    private void onQuit(PlayerQuitEvent e) {
        final Player p = e.getPlayer();
        
        if (core.getConfig().getBoolean("Mode.2vs4") == true) {
        	if (core.isState(State.WAITING)) {
                if (core.getPlayers().contains(p)) {
                    core.getPlayers().remove(p);
                    core.getPlayersName().remove(p.getDisplayName());
                    core.leaveTeam(p);
                    core.getServer().broadcastMessage("§e" + p.getName() + "§7 a quitté le jeu. §d" + core.getPlayers().size() + "§d/8");
                    e.setQuitMessage(null);
                }
                Instance.quitWAITING(p);
            }
            if (core.isState(State.STARTING)) {
                if (core.getPlayers().contains(p)) {
                    core.getPlayers().remove(p);
                    core.getPlayersName().remove(p.getDisplayName());
                    core.leaveTeam(p);
                    core.getServer().broadcastMessage("§e" + p.getName() + "§7 a quitté le jeu. §d" + core.getPlayers().size() + "§d/8");
                    e.setQuitMessage(null);
                }
                Instance.quitWAITING(p);
            }
            if (core.isState(State.INGAME) || core.isState(State.FINISH) ) {
                if (core.getPlayers().contains(p)) {
                    core.getServer().broadcastMessage("§e" + p.getName() + "§7 a quitté le jeu, il peut revenir a tout moments.");
                    e.setQuitMessage(null);
                }else {
                	e.setQuitMessage(null);
                }
                Instance.quitWAITING(p);
            }
        }
        
        if (core.getConfig().getBoolean("Mode.4vs4") == true) {
        	if (core.isState(State.WAITING)) {
                if (core.getPlayers().contains(p)) {
                    core.getPlayers().remove(p);
                    core.getPlayersName().remove(p.getDisplayName());
                    core.leaveTeam(p);
                    core.getServer().broadcastMessage("§e" + p.getName() + "§7 a quitté le jeu. §d" + core.getPlayers().size() + "§d/16");
                    e.setQuitMessage(null);
                }
                Instance.quitWAITING(p);
            }
            if (core.isState(State.STARTING)) {
                if (core.getPlayers().contains(p)) {
                    core.getPlayers().remove(p);
                    core.getPlayersName().remove(p.getDisplayName());
                    core.leaveTeam(p);
                    core.getServer().broadcastMessage("§e" + p.getName() + "§7 a quitté le jeu. §d" + core.getPlayers().size() + "§d/16");
                    e.setQuitMessage(null);
                }
                Instance.quitWAITING(p);
            }
            if (core.isState(State.INGAME) || core.isState(State.FINISH) ) {
                if (core.getPlayers().contains(p)) {
                	core.getServer().broadcastMessage("§e" + p.getName() + "§7 a quitté le jeu, il peut revenir a tout moments.");
                    e.setQuitMessage(null);
                }else {
                	e.setQuitMessage(null);
                }
                Instance.quitWAITING(p);
            }
        }
        
        if (core.getConfig().getBoolean("Mode.6vs4") == true) {
        	if (core.isState(State.WAITING)) {
                if (core.getPlayers().contains(p)) {
                    core.getPlayers().remove(p);
                    core.getPlayersName().remove(p.getDisplayName());
                    core.leaveTeam(p);
                    core.getServer().broadcastMessage("§e" + p.getName() + "§7 a quitté le jeu. §d" + core.getPlayers().size() + "§d/24");
                    e.setQuitMessage(null);
                }
                Instance.quitWAITING(p);
            }
            if (core.isState(State.STARTING)) {
                if (core.getPlayers().contains(p)) {
                    core.getPlayers().remove(p);
                    core.getPlayersName().remove(p.getDisplayName());
                    core.leaveTeam(p);
                    core.getServer().broadcastMessage("§e" + p.getName() + "§7 a quitté le jeu. §d" + core.getPlayers().size() + "§d/24");
                    e.setQuitMessage(null);
                }
                Instance.quitWAITING(p);
            }
            if (core.isState(State.INGAME) || core.isState(State.FINISH) ) {
                if (core.getPlayers().contains(p)) {
                	core.getServer().broadcastMessage("§e" + p.getName() + "§7 a quitté le jeu, il peut revenir a tout moments.");
                    e.setQuitMessage(null);
                }else {
                	e.setQuitMessage(null);
                }
                Instance.quitWAITING(p);
            }
        }
    }
}
