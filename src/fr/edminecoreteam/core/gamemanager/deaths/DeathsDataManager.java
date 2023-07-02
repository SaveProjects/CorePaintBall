package fr.edminecoreteam.core.gamemanager.deaths;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DeathsDataManager 
{
	private final Map<UUID, DeathsData> players = new HashMap<>();

    public DeathsData getPlayerData(UUID playerId) {
        return players.computeIfAbsent(playerId, id -> new DeathsData(id, 0));
    }

    public void addDeath(UUID playerId, int amount) {
        getPlayerData(playerId).addDeath(amount);
    }

    public void removeDeath(UUID playerId, int amount) {
        getPlayerData(playerId).removeDeath(amount);
    }
    
    public Map<UUID, DeathsData> returnPlayers()
    {
    	return this.players;
    }
}
