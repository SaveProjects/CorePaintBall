package fr.edminecoreteam.core.gamemanager.killscount;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class KillDataManager 
{
	private final Map<UUID, KillData> players = new HashMap<>();

    public KillData getPlayerData(UUID playerId) {
        return players.computeIfAbsent(playerId, id -> new KillData(id, 0));
    }

    public void addKill(UUID playerId, int amount) {
        getPlayerData(playerId).addKill(amount);
    }

    public void removeKill(UUID playerId, int amount) {
        getPlayerData(playerId).removeKill(amount);
    }
    
    public Map<UUID, KillData> returnPlayers()
    {
    	return this.players;
    }
}
