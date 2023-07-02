package fr.edminecoreteam.core.gamemanager.killscount;

import java.util.UUID;

public class KillData 
{
	private final UUID playerId;
    private int coins;

    public KillData(UUID playerId, int coins) {
        this.playerId = playerId;
        this.coins = coins;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public int getKills() {
        return coins;
    }

    public void addKill(int amount) {
        coins += amount;
    }

    public void removeKill(int amount) {
        coins -= amount;
    }
}
