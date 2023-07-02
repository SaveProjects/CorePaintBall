package fr.edminecoreteam.core.teams;

import java.util.HashMap;
import java.util.Map;

public enum Teams
{
    NOTEAM("NOTEAM", 0, 0, "§l§6Rank", "§7Joueur", "§7", ""), 
    ROUGE("ROUGE", 1, 1, "§k§6Rank", "§fROUGE", "§c§lR §c", ""), 
    BLEUE("BLEUE", 2, 2, "§i§6Rank", "§eSUPER-VIP", "§9§lB §9", ""), 
    JAUNE("JAUNE", 3, 3, "§f§6Rank", "§aSUPREME", "§e§lJ §e", ""), 
    VERT("VERT", 4, 4, "§e§6Rank", "§bULTRA", "§a§lV §a", ""), 
    ORANGE("ORANGE", 5, 5, "§d§6Rank", "§3ELITE", "§6§lO §6", ""), 
    ROSE("ROSE", 6, 6, "§c§4Rank", "§6STREAMER", "§d§lR §d", "");
    
    private int power;
    private String name;
    private String orderRank;
    private String displayName;
    private String suffix;
    public static Map<Integer, Teams> teams;
    
    static {
    	Teams.teams = new HashMap<Integer, Teams>();
    	Teams[] values;
        for (int length = (values = values()).length, i = 0; i < length; ++i) {
        	Teams teams = values[i];
        	Teams.teams.put(teams.getPower(), teams);
        }
    }
    
    private Teams(String rank, int ordinal, int power, String orderRank, String name, String displayName, String Suffix) {
        this.power = power;
        this.name = name;
        this.orderRank = orderRank;
        this.displayName = displayName;
        this.suffix = Suffix;
    }
    
    public String getName() {
        return this.name;
    }
    
    public static Teams powerToTeam(int power) {
        return Teams.teams.get(power);
    }
    
    public int getPower() {
        return this.power;
    }
    
    public String getOrderTeam() {
        return this.orderRank;
    }
    
    public String getDisplayName() {
        return this.displayName;
    }
    
    public String getSuffix() {
        return this.suffix;
    }
}
