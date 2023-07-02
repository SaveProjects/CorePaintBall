package fr.edminecoreteam.core.teams;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import fr.edminecoreteam.core.Core;


public class TabListTeams implements Listener
{
	private static Core core = Core.getInstance();
	
	@EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) 
	{
        Player p = e.getPlayer();
        refreshTablist(p);
    }
	
	private void refreshTablist(Player p) {
		
		new BukkitRunnable() {
            int t = 0;   
	        public void run() {
	        	
	        	if (!p.isOnline()) { cancel(); }
	        	
		        if (core.getRouge().contains(p.getName()))
		        {
		        	TeamsTagsManager.setNameTag(p, Teams.powerToTeam(1).getOrderTeam(), Teams.powerToTeam(1).getDisplayName(), Teams.powerToTeam(1).getSuffix());	
		        }
		        if (core.getBleue().contains(p.getName()))
		        {
		        	TeamsTagsManager.setNameTag(p, Teams.powerToTeam(2).getOrderTeam(), Teams.powerToTeam(2).getDisplayName(), Teams.powerToTeam(2).getSuffix());	
		        }
		        if (core.getJaune().contains(p.getName()))
		        {
		        	TeamsTagsManager.setNameTag(p, Teams.powerToTeam(3).getOrderTeam(), Teams.powerToTeam(3).getDisplayName(), Teams.powerToTeam(3).getSuffix());	
		        }
		        if (core.getVert().contains(p.getName()))
		        {
		        	TeamsTagsManager.setNameTag(p, Teams.powerToTeam(4).getOrderTeam(), Teams.powerToTeam(4).getDisplayName(), Teams.powerToTeam(4).getSuffix());	
		        }
		        if (core.getOrange().contains(p.getName()))
		        {
		        	TeamsTagsManager.setNameTag(p, Teams.powerToTeam(5).getOrderTeam(), Teams.powerToTeam(5).getDisplayName(), Teams.powerToTeam(5).getSuffix());	
		        }
		        if (core.getRose().contains(p.getName()))
		        {
		        	TeamsTagsManager.setNameTag(p, Teams.powerToTeam(6).getOrderTeam(), Teams.powerToTeam(6).getDisplayName(), Teams.powerToTeam(6).getSuffix());	
		        }
		        if (!core.getRouge().contains(p.getName()) && !core.getBleue().contains(p.getName()) && !core.getJaune().contains(p.getName()) && !core.getVert().contains(p.getName()) && !core.getOrange().contains(p.getName()) && !core.getRose().contains(p.getName()))
		        {
		        	TeamsTagsManager.setNameTag(p, Teams.powerToTeam(0).getOrderTeam(), Teams.powerToTeam(0).getDisplayName(), Teams.powerToTeam(0).getSuffix());	
		        }
		        
		        ++t;
                if (t == 50) {
                    run();
                }
            }
        }.runTaskTimer((Plugin)core, 0L, 50L);

	}
}
