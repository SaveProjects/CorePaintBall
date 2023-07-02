package fr.edminecoreteam.core.gamemanager.deaths;

import java.util.UUID;

public class DeathsData 
{
	private final UUID playerId;
    private int coins;

    public DeathsData(UUID playerId, int coins) {
        this.playerId = playerId;
        this.coins = coins;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public int getDeath() {
        return coins;
    }

    public void addDeath(int amount) {
        coins += amount;
    }

    public void removeDeath(int amount) {
        coins -= amount;
    }
}
