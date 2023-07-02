package fr.edminecoreteam.core.gamemanager.killcoins;

import java.util.UUID;

public class KillCoinsData 
{
	private final UUID playerId;
    private int coins;

    public KillCoinsData(UUID playerId, int coins) {
        this.playerId = playerId;
        this.coins = coins;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public int getCoins() {
        return coins;
    }

    public void addCoins(int amount) {
        coins += amount;
    }

    public void removeCoins(int amount) {
        coins -= amount;
    }
}
