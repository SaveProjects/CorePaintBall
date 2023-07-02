package fr.edminecoreteam.core.gamemanager.killcoins;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class KillCoinsDataManager 
{
	private final Map<UUID, KillCoinsData> players = new HashMap<>();

    public KillCoinsData getPlayerData(UUID playerId) {
        return players.computeIfAbsent(playerId, id -> new KillCoinsData(id, 0));
    }

    public void addCoins(UUID playerId, int amount) {
        getPlayerData(playerId).addCoins(amount);
    }

    public void removeCoins(UUID playerId, int amount) {
        getPlayerData(playerId).removeCoins(amount);
    }
    
    public Map<UUID, KillCoinsData> returnPlayers()
    {
    	return this.players;
    }
}
