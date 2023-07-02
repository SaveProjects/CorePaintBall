package fr.edminecoreteam.core.gamemanager.killstreak;

import java.util.UUID;

public class MostKillStreakData 
{
	private final UUID playerId;
    private int coins;

    public MostKillStreakData(UUID playerId, int coins) {
        this.playerId = playerId;
        this.coins = coins;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public int getMostKillStreak() {
        return coins;
    }
    
    public void setMostKillStreak(int amount) {
        coins = amount;
    }
}
