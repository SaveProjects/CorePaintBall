package fr.edminecoreteam.core.gamemanager.killstreak;

import java.util.UUID;

public class KillStreakData 
{
	private final UUID playerId;
    private int coins;

    public KillStreakData(UUID playerId, int coins) {
        this.playerId = playerId;
        this.coins = coins;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public int getKillStreak() {
        return coins;
    }

    public void addKillStreak(int amount) {
        coins += amount;
    }

    public void removeKillStreak() {
        coins = 0;
    }
}
