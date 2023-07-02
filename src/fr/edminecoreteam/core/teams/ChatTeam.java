package fr.edminecoreteam.core.teams;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import fr.edminecoreteam.core.Core;
import fr.edminecoreteam.core.State;
import fr.edminecoreteam.core.rank.Rank;
import fr.edminecoreteam.core.utils.RankInfo;

public class ChatTeam implements Listener
{
	private static Core core = Core.getInstance();
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e)
	{
		Player p = e.getPlayer();
		e.setCancelled(true);
		if (core.isState(State.WAITING) || core.isState(State.STARTING) || core.isState(State.FINISH))
		{
			RankInfo rankInfo = new RankInfo(p);
			if (rankInfo.getRankType().equalsIgnoreCase("static"))
	        {
	        	if (rankInfo.getRankID() > 0)
	        	{
	        		e.setFormat(Rank.powerToRank(rankInfo.getRankID()).getDisplayName() + p.getName() + Rank.powerToRank(rankInfo.getRankID()).getSuffix() + " §8» §f" + e.getMessage().replace("&", "§"));
	                for (Player players : Bukkit.getOnlinePlayers()) {
	                    players.sendMessage(e.getFormat());
	                }
	        	}
	        	else if (rankInfo.getRankID() == 0)
	        	{
	        		e.setFormat(Rank.powerToRank(rankInfo.getRankID()).getDisplayName() + p.getName() + " §8» §7" + e.getMessage());
	                for (Player players : Bukkit.getOnlinePlayers()) {
	                    players.sendMessage(e.getFormat());
	                }
	        	}
	        }
	        if (rankInfo.getRankType().equalsIgnoreCase("tempo")) 
	        {
	        	if (rankInfo.getRankID() >= 3)
	        	{
	        		e.setFormat(Rank.powerToRank(rankInfo.getRankID()).getDisplayName() + p.getName() + Rank.powerToRank(rankInfo.getRankID()).getSuffix() + " §8» §f" + e.getMessage());
	                for (Player players : Bukkit.getOnlinePlayers()) {
	                    players.sendMessage(e.getFormat());
	                }
	        	}
	        	else if (rankInfo.getRankID() < 3)
	        	{
	        		e.setFormat(Rank.powerToRank(rankInfo.getRankID()).getDisplayName() + p.getName() + Rank.powerToRank(rankInfo.getRankID()).getSuffix() + " §8» §7" + e.getMessage());
	                for (Player players : Bukkit.getOnlinePlayers()) {
	                    players.sendMessage(e.getFormat());
	                }
	        	}
	        }
	        if (rankInfo.getRankType().equalsIgnoreCase("module")) 
	        {
	        	e.setFormat(Rank.powerToRank(rankInfo.getRankModule()).getDisplayName() + p.getName() + Rank.powerToRank(rankInfo.getRankModule()).getSuffix() + " §8» §f" + e.getMessage());
                for (Player players : Bukkit.getOnlinePlayers()) {
                    players.sendMessage(e.getFormat());
                }
	        }
	        if (rankInfo.getRankType().equalsIgnoreCase("staff")) 
	        {
	        	e.setFormat(Rank.powerToRank(rankInfo.getRankModule()).getDisplayName() + p.getName() + Rank.powerToRank(rankInfo.getRankModule()).getSuffix() + " §8» §f" + e.getMessage().replace("&", "§"));
                for (Player players : Bukkit.getOnlinePlayers()) {
                    players.sendMessage(e.getFormat());
                }
	        }
		}
		if (core.isState(State.INGAME))
		{
			String msg = e.getMessage();
			if (msg.contains("!") && msg.indexOf("!") == 0)
			{
				msg = msg.substring(1);
				msg = msg.replace("!", "");
				if (core.getRouge().contains(p.getName()))
		        {
					e.setFormat("§e§lGLOBAL §e➟ " + Teams.powerToTeam(1).getDisplayName() + p.getName() + " §8» §f" + msg);
					for (Player players : Bukkit.getOnlinePlayers()) {
	                    players.sendMessage(e.getFormat());
	                }
		        }
		        if (core.getBleue().contains(p.getName()))
		        {
		        	e.setFormat("§e§lGLOBAL §e➟ " + Teams.powerToTeam(2).getDisplayName() + p.getName() + " §8» §f" + msg);
		        	for (Player players : Bukkit.getOnlinePlayers()) {
	                    players.sendMessage(e.getFormat());
	                }
		        }
		        if (core.getJaune().contains(p.getName()))
		        {
		        	e.setFormat("§e§lGLOBAL §e➟ " + Teams.powerToTeam(3).getDisplayName() + p.getName() + " §8» §f" + msg);
		        	for (Player players : Bukkit.getOnlinePlayers()) {
	                    players.sendMessage(e.getFormat());
	                }
		        }
		        if (core.getVert().contains(p.getName()))
		        {
		        	e.setFormat("§e§lGLOBAL §e➟ " + Teams.powerToTeam(4).getDisplayName() + p.getName() + " §8» §f" + msg);
		        	for (Player players : Bukkit.getOnlinePlayers()) {
	                    players.sendMessage(e.getFormat());
	                }
		        }
		        if (core.getOrange().contains(p.getName()))
		        {
		        	e.setFormat("§e§lGLOBAL §e➟ " + Teams.powerToTeam(5).getDisplayName() + p.getName() + " §8» §f" + msg);
		        	for (Player players : Bukkit.getOnlinePlayers()) {
	                    players.sendMessage(e.getFormat());
	                }
		        }
		        if (core.getRose().contains(p.getName()))
		        {
		        	e.setFormat("§e§lGLOBAL §e➟ " + Teams.powerToTeam(6).getDisplayName() + p.getName() + " §8» §f" + msg);
		        	for (Player players : Bukkit.getOnlinePlayers()) {
	                    players.sendMessage(e.getFormat());
	                }
		        }
		        if (!core.getRouge().contains(p.getName()) && !core.getBleue().contains(p.getName()) && !core.getJaune().contains(p.getName()) && !core.getVert().contains(p.getName()) && !core.getOrange().contains(p.getName()) && !core.getRose().contains(p.getName()))
		        {
		        	return;
		        }
			}
			else
			{
				if (core.getRouge().contains(p.getName()))
		        {
					for (String pls : core.getRouge())
					{
						Player pl = Bukkit.getPlayer(pls);
						pl.sendMessage(Teams.powerToTeam(1).getDisplayName() + p.getName() + " §8» §7" + msg);
					}
		        }
		        if (core.getBleue().contains(p.getName()))
		        {
		        	for (String pls : core.getBleue())
					{
						Player pl = Bukkit.getPlayer(pls);
						pl.sendMessage(Teams.powerToTeam(2).getDisplayName() + p.getName() + " §8» §7" + msg);
					}
		        }
		        if (core.getJaune().contains(p.getName()))
		        {
		        	for (String pls : core.getJaune())
					{
						Player pl = Bukkit.getPlayer(pls);
						pl.sendMessage(Teams.powerToTeam(3).getDisplayName() + p.getName() + " §8» §7" + msg);
					}
		        }
		        if (core.getVert().contains(p.getName()))
		        {
		        	for (String pls : core.getVert())
					{
						Player pl = Bukkit.getPlayer(pls);
						pl.sendMessage(Teams.powerToTeam(4).getDisplayName() + p.getName() + " §8» §7" + msg);
					}
		        }
		        if (core.getOrange().contains(p.getName()))
		        {
		        	for (String pls : core.getOrange())
					{
						Player pl = Bukkit.getPlayer(pls);
						pl.sendMessage(Teams.powerToTeam(5).getDisplayName() + p.getName() + " §8» §7" + msg);
					}
		        }
		        if (core.getRose().contains(p.getName()))
		        {
		        	for (String pls : core.getRose())
					{
						Player pl = Bukkit.getPlayer(pls);
						pl.sendMessage(Teams.powerToTeam(5).getDisplayName() + p.getName() + " §8» §7" + msg);
					}
		        }
		        if (!core.getRouge().contains(p.getName()) && !core.getBleue().contains(p.getName()) && !core.getJaune().contains(p.getName()) && !core.getVert().contains(p.getName()) && !core.getOrange().contains(p.getName()) && !core.getRose().contains(p.getName()))
		        {
		        	for (Player pls : Bukkit.getOnlinePlayers())
		        	{
		        		if (!core.getRouge().contains(pls.getName()) && !core.getBleue().contains(pls.getName()) && !core.getJaune().contains(pls.getName()) && !core.getVert().contains(pls.getName()) && !core.getOrange().contains(pls.getName()) && !core.getRose().contains(pls.getName()))
				        {
		        			pls.sendMessage("§8§lSPEC " + Teams.powerToTeam(0).getDisplayName() + p.getName() + " §8» §f" + msg);
				        }
		        	}
		        }
			}
		}
	}
}
