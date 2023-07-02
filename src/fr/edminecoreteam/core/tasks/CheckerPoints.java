package fr.edminecoreteam.core.tasks;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import fr.edminecoreteam.core.Core;

public class CheckerPoints {
	
	private static Core core = Core.getInstance();  
	private static boolean getRouge25 = false;
	private static boolean getRouge50 = false;
	private static boolean getRouge75 = false;
	
	private static boolean getBleue25 = false;
	private static boolean getBleue50 = false;
	private static boolean getBleue75 = false;
	
	private static boolean getJaune25 = false;
	private static boolean getJaune50 = false;
	private static boolean getJaune75 = false;
	
	private static boolean getVert25 = false;
	private static boolean getVert50 = false;
	private static boolean getVert75 = false;
	
	private static boolean getOrange25 = false;
	private static boolean getOrange50 = false;
	private static boolean getOrange75 = false;
	
	private static boolean getRose25 = false;
	private static boolean getRose50 = false;
	private static boolean getRose75 = false;
	
	public static boolean Checker() {
		
		if (core.getRougePoints() == 25)
		{
			if (getRouge25 == false)
				getRouge25 = true;
			Bukkit.broadcastMessage("§6§lÇa chauffe par la  ! §7L'équipe §cRouge §7ont désormais §e25 points§7.");
			for (Player pls : core.getPlayers()) {
				pls.playSound(pls.getLocation(), Sound.FIRE, 1.0f, 1.0f);
			}
			return false;
		}
		if (core.getRougePoints() == 50)
		{
			if (getRouge50 == false)
				getRouge50 = true;
			Bukkit.broadcastMessage("§6§lC'est du paté  ! §7L'équipe §cRouge §7ont désormais §e50 points§7.");
			for (Player pls : core.getPlayers()) {
				pls.playSound(pls.getLocation(), Sound.CAT_MEOW, 1.0f, 1.0f);
			}
			return false;
		}
		if (core.getRougePoints() == 75)
		{
			if (getRouge75 == false)
				getRouge75 = true;
			Bukkit.broadcastMessage("§6§lAlerte généraleee  ! §7L'équipe §cRouge §7ont désormais §e75 points§7.");
			for (Player pls : core.getPlayers()) {
				pls.playSound(pls.getLocation(), Sound.ENDERMAN_SCREAM, 1.0f, 1.0f);
			}
			return false;
		}
		if (core.getRougePoints() == 100)
		{
			return true;
		}
		
		if (core.getBleuePoints() == 25)
		{
			if (getBleue25 == false)
				getBleue25 = true;
			Bukkit.broadcastMessage("§6§lÇa chauffe par la  ! §7L'équipe §9Bleue §7ont désormais §e25 points§7.");
			for (Player pls : core.getPlayers()) {
				pls.playSound(pls.getLocation(), Sound.FIRE, 1.0f, 1.0f);
			}
			return false;
		}
		if (core.getBleuePoints() == 50)
		{
			if (getBleue50 == false)
				getBleue50 = true;
			Bukkit.broadcastMessage("§6§lC'est du paté  ! §7L'équipe §9Bleue §7ont désormais §e50 points§7.");
			for (Player pls : core.getPlayers()) {
				pls.playSound(pls.getLocation(), Sound.CAT_MEOW, 1.0f, 1.0f);
			}
			return false;
		}
		if (core.getBleuePoints() == 75)
		{
			if (getBleue75 == false)
				getBleue75 = true;
			Bukkit.broadcastMessage("§6§lAlerte généraleee  ! §7L'équipe §9Bleue §7ont désormais §e75 points§7.");
			for (Player pls : core.getPlayers()) {
				pls.playSound(pls.getLocation(), Sound.ENDERMAN_SCREAM, 1.0f, 1.0f);
			}
			return false;
		}
		if (core.getBleuePoints() == 100)
		{
			return true;
		}
		
		if (core.getJaunePoints() == 25)
		{
			if (getJaune25 == false)
				getJaune25 = true;
			Bukkit.broadcastMessage("§6§lÇa chauffe par la  ! §7L'équipe §eJaune §7ont désormais §e25 points§7.");
			for (Player pls : core.getPlayers()) {
				pls.playSound(pls.getLocation(), Sound.FIRE, 1.0f, 1.0f);
			}
			return false;
		}
		if (core.getJaunePoints() == 50)
		{
			if (getJaune50 == false)
				getJaune50 = true;
			Bukkit.broadcastMessage("§6§lC'est du paté  ! §7L'équipe §eJaune §7ont désormais §e50 points§7.");
			for (Player pls : core.getPlayers()) {
				pls.playSound(pls.getLocation(), Sound.CAT_MEOW, 1.0f, 1.0f);
			}
			return false;
		}
		if (core.getJaunePoints() == 75)
		{
			if (getJaune75 == false)
				getJaune75 = true;
			Bukkit.broadcastMessage("§6§lAlerte généraleee  ! §7L'équipe §eJaune §7ont désormais §e75 points§7.");
			for (Player pls : core.getPlayers()) {
				pls.playSound(pls.getLocation(), Sound.ENDERMAN_SCREAM, 1.0f, 1.0f);
			}
			return false;
		}
		if (core.getJaunePoints() == 100)
		{
			return true;
		}
		
		if (core.getVertPoints() == 25)
		{
			if (getVert25 == false)
				getVert25 = true;
			Bukkit.broadcastMessage("§6§lÇa chauffe par la  ! §7L'équipe §aVerte §7ont désormais §e25 points§7.");
			for (Player pls : core.getPlayers()) {
				pls.playSound(pls.getLocation(), Sound.FIRE, 1.0f, 1.0f);
			}
			return false;
		}
		if (core.getVertPoints() == 50)
		{
			if (getVert50 == false)
				getVert50 = true;
			Bukkit.broadcastMessage("§6§lC'est du paté  ! §7L'équipe §aVerte §7ont désormais §e50 points§7.");
			for (Player pls : core.getPlayers()) {
				pls.playSound(pls.getLocation(), Sound.CAT_MEOW, 1.0f, 1.0f);
			}
			return false;
		}
		if (core.getVertPoints() == 75)
		{
			if (getVert75 == false)
				getVert75 = true;
			Bukkit.broadcastMessage("§6§lAlerte généraleee  ! §7L'équipe §aVerte §7ont désormais §e75 points§7.");
			for (Player pls : core.getPlayers()) {
				pls.playSound(pls.getLocation(), Sound.ENDERMAN_SCREAM, 1.0f, 1.0f);
			}
			return false;
		}
		if (core.getVertPoints() == 100)
		{
			return true;
		}
		
		if (core.getOrangePoints() == 25)
		{
			if (getOrange25 == false)
				getOrange25 = true;
			Bukkit.broadcastMessage("§6§lÇa chauffe par la  ! §7L'équipe §6Orange §7ont désormais §e25 points§7.");
			for (Player pls : core.getPlayers()) {
				pls.playSound(pls.getLocation(), Sound.FIRE, 1.0f, 1.0f);
			}
			return false;
		}
		if (core.getOrangePoints() == 50)
		{
			if (getOrange50 == false)
				getOrange50 = true;
			Bukkit.broadcastMessage("§6§lC'est du paté  ! §7L'équipe §6Orange §7ont désormais §e50 points§7.");
			for (Player pls : core.getPlayers()) {
				pls.playSound(pls.getLocation(), Sound.CAT_MEOW, 1.0f, 1.0f);
			}
			return false;
		}
		if (core.getOrangePoints() == 75)
		{
			if (getOrange75 == false)
				getOrange75 = true;
			Bukkit.broadcastMessage("§6§lAlerte généraleee  ! §7L'équipe §6Orange §7ont désormais §e75 points§7.");
			for (Player pls : core.getPlayers()) {
				pls.playSound(pls.getLocation(), Sound.ENDERMAN_SCREAM, 1.0f, 1.0f);
			}
			return false;
		}
		if (core.getOrangePoints() == 100)
		{
			return true;
		}
		
		if (core.getRosePoints() == 25)
		{
			if (getRose25 == false)
				getRose25 = true;
			Bukkit.broadcastMessage("§6§lÇa chauffe par la  ! §7L'équipe §dRose §7ont désormais §e25 points§7.");
			for (Player pls : core.getPlayers()) {
				pls.playSound(pls.getLocation(), Sound.FIRE, 1.0f, 1.0f);
			}
			return false;
		}
		if (core.getRosePoints() == 50)
		{
			if (getRose50 == false)
				getRose50 = true;
			Bukkit.broadcastMessage("§6§lC'est du paté  ! §7L'équipe §dRose §7ont désormais §e50 points§7.");
			for (Player pls : core.getPlayers()) {
				pls.playSound(pls.getLocation(), Sound.CAT_MEOW, 1.0f, 1.0f);
			}
			return false;
		}
		if (core.getRosePoints() == 75)
		{
			if (getRose75 == false)
				getRose75 = true;
			Bukkit.broadcastMessage("§6§lAlerte généraleee  ! §7L'équipe §dRose §7ont désormais §e75 points§7.");
			for (Player pls : core.getPlayers()) {
				pls.playSound(pls.getLocation(), Sound.ENDERMAN_SCREAM, 1.0f, 1.0f);
			}
			return false;
		}
		if (core.getRosePoints() == 100)
		{
			return true;
		}
		
		return false;
	}

}
