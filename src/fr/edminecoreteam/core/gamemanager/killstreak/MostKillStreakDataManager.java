package fr.edminecoreteam.core.gamemanager.killstreak;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MostKillStreakDataManager 
{
	private final Map<UUID, MostKillStreakData> players = new HashMap<>();

    public MostKillStreakData getPlayerData(UUID playerId) {
        return players.computeIfAbsent(playerId, id -> new MostKillStreakData(id, 0));
    }

    public void setKill(UUID playerId, int amount) {
        getPlayerData(playerId).setMostKillStreak(amount);
    }
    
    public Map<UUID, MostKillStreakData> returnPlayers()
    {
    	return this.players;
    }
}
