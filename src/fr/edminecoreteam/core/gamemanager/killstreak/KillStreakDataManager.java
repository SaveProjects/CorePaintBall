package fr.edminecoreteam.core.gamemanager.killstreak;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class KillStreakDataManager 
{
	private final Map<UUID, KillStreakData> players = new HashMap<>();

    public KillStreakData getPlayerData(UUID playerId) {
        return players.computeIfAbsent(playerId, id -> new KillStreakData(id, 0));
    }

    public void addKill(UUID playerId, int amount) {
        getPlayerData(playerId).addKillStreak(amount);
    }

    public void removeKill(UUID playerId) {
        getPlayerData(playerId).removeKillStreak();
    }
    
    public Map<UUID, KillStreakData> returnPlayers()
    {
    	return this.players;
    }
}
