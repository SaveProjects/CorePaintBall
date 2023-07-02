package fr.edminecoreteam.core.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.entity.Player;

import fr.edminecoreteam.core.Core;

public class MessageUtils {
	
	private static Core core = Core.getInstance();
	
	public static void messageStarting(Player p) {
		p.sendMessage("");
		p.sendMessage(" §7Bienvenue sur le §6§lPaintBall §7!");
		p.sendMessage("  §c§lInformations:");
		p.sendMessage("   §7• §fRemportez la partie en §agagnant");
		p.sendMessage("   §7• §fle plus de §dpoints §fpossible !");
		p.sendMessage("");
		p.sendMessage("  §d§lAstuces:");
		p.sendMessage("   §7• §fUtilisez vos §ekill-coins");
		p.sendMessage("   §7• §fpour acquérir des §6compétences§f.");
		p.sendMessage("   §7• §fUtilisez la touche §9drop");
		p.sendMessage("   §7• §fpour recharger votre §aarme§f.");
		p.sendMessage("");
	}
	
	public static void deathMessage(Player attacker, Player victim)
	{
		Random rand = new Random();
        int min = 1;
        int max = 5;
        int randomNum = rand.nextInt((max - min) + 1) + min;
        if (randomNum == 1)
        {
        	core.getServer().broadcastMessage("§e§lAïe, ca chauffe ! §c" + victim.getName() + " §fs'est fait laminé par §a" + attacker.getName() + " §f!");
        }
        if (randomNum == 2)
        {
        	core.getServer().broadcastMessage("§b§lLe cachotier ! §c" + victim.getName() + " §fs'est fait prendre par surprise par §a" + attacker.getName() + " §f!");
        }
        if (randomNum == 3)
        {
        	core.getServer().broadcastMessage("§c§lON FIRE ! §c" + victim.getName() + " §fs'est fait exploser par §a" + attacker.getName() + " §f!");
        }
        if (randomNum == 4)
        {
        	core.getServer().broadcastMessage("§a§lHou là là ! §fTout le monde est témoin de ce qu'il s'est passé entre §c" + victim.getName() + " §fet §a" + attacker.getName() + " §f?");
        }
        if (randomNum == 5)
        {
        	core.getServer().broadcastMessage("§a§lOMG ! §fLà c'est chaud ! §c" + victim.getName() + " §fa pris une grosse bastos de §a" + attacker.getName() + " §f!");
        }
	}
	
	public static void messageEnd2vs4(Player p) {
		String teamWin = "";
		if (core.bleuePoints > core.rougePoints)
		{
			teamWin = "§9§lBleue";
		}
		else if (core.bleuePoints < core.rougePoints)
		{
			teamWin = "§c§lRouge";
		}
		else if (core.bleuePoints == core.rougePoints)
		{
			teamWin = "§f§lÉgalité";
		}
		List<Player> mostcoins = new ArrayList<Player>();
		for (Player pls : core.getPlayers())
		{
			mostcoins.add(pls);
		}
		Player mostKillCoins = core.getPlayerWithMostCoins(mostcoins);
		
		List<Player> mostkill = new ArrayList<Player>();
		for (Player pls : core.getPlayers())
		{
			mostkill.add(pls);
		}
		Player mostKill = core.getPlayerWithMostKills(mostkill);
		
		List<Player> mostkillstreak = new ArrayList<Player>();
		for (Player pls : core.getPlayers())
		{
			mostkillstreak.add(pls);
		}
		Player mostKillStreak = core.getPlayerWithMostKillStreak(mostkillstreak);
		p.sendMessage("");
		p.sendMessage("  §d§lCompte rendu:");
		p.sendMessage("   §7• §9Bleue§7: §f" + core.bleuePoints);
		p.sendMessage("   §7• §cRouge§7: §f" + core.rougePoints);
		p.sendMessage("   §7• §7Vitoire: " + teamWin);
		p.sendMessage("");
		p.sendMessage("   §7• §7Meilleur Richesse§7: §e" + mostKillCoins.getName() + " §e✸");
		p.sendMessage("   §7• §7Top Kill§7: §c" + mostKill.getName() +" §c⚔");
		p.sendMessage("   §7• §7Meilleur Kill-Streak: §b" + mostKillStreak.getName() + " §b⚜");
		p.sendMessage("");
		p.sendMessage(" §8➡ §fVisionnez vos statistiques sur votre profil.");
		p.sendMessage("");
	}
	

}
