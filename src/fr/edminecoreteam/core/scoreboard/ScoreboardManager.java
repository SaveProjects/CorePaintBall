package fr.edminecoreteam.core.scoreboard;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import fr.edminecoreteam.core.Core;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
 
/*
 * This file is part of SamaGamesAPI.
 *
 * SamaGamesAPI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * SamaGamesAPI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with SamaGamesAPI.  If not, see <http://www.gnu.org/licenses/>.
 */
public class ScoreboardManager {
    private final Map<UUID, PersonalScoreboard> scoreboards;
	@SuppressWarnings("unused")
	private final ScheduledFuture<?> glowingTask;
	@SuppressWarnings("unused")
	private final ScheduledFuture<?> reloadingTask;
    private int ipCharIndex;
    private int cooldown;
 
    public ScoreboardManager() {
        scoreboards = new HashMap<>();
        ipCharIndex = 0;
        cooldown = 10;
 
        glowingTask = Core.getInstance().getScheduledExecutorService().scheduleAtFixedRate(() ->
        {
            String ip = colorIpAt();
            //String animWaitText = animWaitText();
            //String animStartText = animStartText();
            for (PersonalScoreboard scoreboard : scoreboards.values())
            	Core.getInstance().getExecutorMonoThread().execute(() -> scoreboard.setLines(ip));
        }, 80, 80, TimeUnit.MILLISECONDS);
        reloadingTask = Core.getInstance().getScheduledExecutorService().scheduleAtFixedRate(() ->
        {
            for (PersonalScoreboard scoreboard : scoreboards.values())
            	Core.getInstance().getExecutorMonoThread().execute(scoreboard::reloadData);
        }, 1, 1, TimeUnit.SECONDS);
    }
 
    public void onDisable() {
        scoreboards.values().forEach(PersonalScoreboard::onLogout);
    }
 
    public void onLogin(Player player) {
        if (scoreboards.containsKey(player.getUniqueId())) {
            return;
        }
        scoreboards.put(player.getUniqueId(), new PersonalScoreboard(player));
    }
 
    public void onLogout(Player player) {
        if (scoreboards.containsKey(player.getUniqueId())) {
            scoreboards.get(player.getUniqueId()).onLogout();
            scoreboards.remove(player.getUniqueId());
        }
    }
 
    public void update(Player player) {
        if (scoreboards.containsKey(player.getUniqueId())) {
            scoreboards.get(player.getUniqueId()).reloadData();
        }
    }
    
    /*private String animStartText() {
    	String attente = "Démarrage";

        if (cooldown > 0) {
            cooldown--;
            return ChatColor.GREEN + attente;
        }
 
        StringBuilder formattedIp = new StringBuilder();
 
        if (ipCharIndex > 0) {
            formattedIp.append(attente.substring(0, ipCharIndex - 1));
            formattedIp.append(ChatColor.DARK_GREEN).append(attente.substring(ipCharIndex - 1, ipCharIndex));
        } else {
            formattedIp.append(attente.substring(0, ipCharIndex));
        }
 
        formattedIp.append(ChatColor.GREEN).append(attente.charAt(ipCharIndex));
 
        if (ipCharIndex + 1 < attente.length()) {
            formattedIp.append(ChatColor.DARK_GREEN).append(attente.charAt(ipCharIndex + 1));
 
            if (ipCharIndex + 2 < attente.length())
                formattedIp.append(ChatColor.GREEN).append(attente.substring(ipCharIndex + 2));
 
            ipCharIndex++;
        } else {
            ipCharIndex = 0;
            cooldown = 50;
        }
 
        return ChatColor.WHITE + formattedIp.toString();
    }
    
    private String animWaitText() {
    	String attente = "Attente...";

        if (cooldown > 0) {
            cooldown--;
            return ChatColor.WHITE + attente;
        }
 
        StringBuilder formattedIp = new StringBuilder();
 
        if (ipCharIndex > 0) {
            formattedIp.append(attente.substring(0, ipCharIndex - 1));
            formattedIp.append(ChatColor.GRAY).append(attente.substring(ipCharIndex - 1, ipCharIndex));
        } else {
            formattedIp.append(attente.substring(0, ipCharIndex));
        }
 
        formattedIp.append(ChatColor.DARK_GRAY).append(attente.charAt(ipCharIndex));
 
        if (ipCharIndex + 1 < attente.length()) {
            formattedIp.append(ChatColor.GRAY).append(attente.charAt(ipCharIndex + 1));
 
            if (ipCharIndex + 2 < attente.length())
                formattedIp.append(ChatColor.WHITE).append(attente.substring(ipCharIndex + 2));
 
            ipCharIndex++;
        } else {
            ipCharIndex = 0;
            cooldown = 50;
        }
 
        return ChatColor.WHITE + formattedIp.toString();
    }*/
 
    private String colorIpAt() {
        String ip = "play.edmine.net";
 
        if (cooldown > 0) {
            cooldown--;
            return ChatColor.YELLOW + ip;
        }
 
        StringBuilder formattedIp = new StringBuilder();
 
        if (ipCharIndex > 0) {
            formattedIp.append(ip.substring(0, ipCharIndex - 1));
            formattedIp.append(ChatColor.GOLD).append(ip.substring(ipCharIndex - 1, ipCharIndex));
        } else {
            formattedIp.append(ip.substring(0, ipCharIndex));
        }
 
        formattedIp.append(ChatColor.RED).append(ip.charAt(ipCharIndex));
 
        if (ipCharIndex + 1 < ip.length()) {
            formattedIp.append(ChatColor.GOLD).append(ip.charAt(ipCharIndex + 1));
 
            if (ipCharIndex + 2 < ip.length())
                formattedIp.append(ChatColor.YELLOW).append(ip.substring(ipCharIndex + 2));
 
            ipCharIndex++;
        } else {
            ipCharIndex = 0;
            cooldown = 50;
        }
 
        return ChatColor.YELLOW + formattedIp.toString();
    }
 
}