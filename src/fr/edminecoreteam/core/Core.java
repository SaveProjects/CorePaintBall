package fr.edminecoreteam.core;

import fr.edminecoreteam.core.utils.ChangeHubInfo;
import fr.edminecoreteam.core.utils.FoundLobby;
import fr.edminecoreteam.core.utils.SkullNBT;
import fr.edminecoreteam.core.utils.TitleBuilder;
import fr.edminecoreteam.core.listeners.Instance;
import fr.edminecoreteam.core.listeners.PlayerListeners;
import fr.edminecoreteam.core.scoreboard.JoinScoreboardEvent;
import fr.edminecoreteam.core.scoreboard.LeaveScoreboardEvent;
import fr.edminecoreteam.core.scoreboard.ScoreboardManager;
import fr.edminecoreteam.core.teams.ChatTeam;
import fr.edminecoreteam.core.teams.TabListTeams;
import fr.edminecoreteam.core.admin.AdminCommand;
import fr.edminecoreteam.core.admin.AdminInteractions;
import fr.edminecoreteam.core.admin.AdminMenu;
import fr.edminecoreteam.core.api.MySQL;
import fr.edminecoreteam.core.gamemanager.InteractionsGame;
import fr.edminecoreteam.core.gamemanager.KillCoinsShop;
import fr.edminecoreteam.core.gamemanager.LoadWorld;
import fr.edminecoreteam.core.gamemanager.deaths.DeathsDataManager;
import fr.edminecoreteam.core.gamemanager.gun.DesertEagle;
import fr.edminecoreteam.core.gamemanager.gun.MP5;
import fr.edminecoreteam.core.gamemanager.killcoins.KillCoinsDataManager;
import fr.edminecoreteam.core.gamemanager.killscount.KillDataManager;
import fr.edminecoreteam.core.gamemanager.killstreak.KillStreakDataManager;
import fr.edminecoreteam.core.gamemanager.killstreak.MostKillStreakDataManager;
import fr.edminecoreteam.core.gui.ChooseTeam;
import fr.edminecoreteam.core.listeners.EventsListener;
import org.bukkit.plugin.Plugin;
import org.bukkit.event.Listener;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.bukkit.entity.Player;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

public class Core extends JavaPlugin implements PluginMessageListener 
{
    private static Core instance;
    private KillCoinsDataManager killCoinsDataManager;
    private KillDataManager killDataManager;
    private KillStreakDataManager killStreakDataManager;
    private MostKillStreakDataManager mostKillStreakDataManager;
    private DeathsDataManager deathsDataManager;
    public int srvNumber;
    public boolean isForceStart = false;
    private ScoreboardManager scoreboardManager;
    private ScheduledExecutorService executorMonoThread;
    private ScheduledExecutorService scheduledExecutorService;
    private List<Player> players;
    private List<String> playersName;
    public String getGameWorldName;
    public TitleBuilder title;
    public MySQL database;
    public int timerEnd;
    public int timerEnd(int i) { this.timerEnd = i; return i; }
    public int timerGame;
    public int timerGame(int i) { this.timerGame = i; return i; }
    public int timerStart;
    public int timerStart(int i) { this.timerStart = i; return i; }
    
    private List<String> invincible;
    private List<String> mp5;
    
    //Initialisation des votes de cartes
    
    //Initialisation des équipes
    private List<String> rouge;
    private List<String> bleue;
    private List<String> jaune;
    private List<String> vert;
    private List<String> orange;
    private List<String> rose;
    
    //Liste des points d'équipes
    public int rougePoints;
	public int bleuePoints;
	public int jaunePoints;
	public int vertPoints;
	public int orangePoints;
	public int rosePoints;
    
    private State state;
    
    public Core() {
    	title = new TitleBuilder();
    	
        players = new ArrayList<Player>();
        playersName = new ArrayList<String>();
        rouge = new ArrayList<String>();
        bleue = new ArrayList<String>();
        jaune = new ArrayList<String>();
        vert = new ArrayList<String>();
        orange = new ArrayList<String>();
        rose = new ArrayList<String>();
        
        invincible = new ArrayList<String>();
        mp5 = new ArrayList<String>();
        
        this.rougePoints = 0;
		this.bleuePoints = 0;
		this.jaunePoints = 0;
		this.vertPoints = 0;
		this.orangePoints = 0;
		this.rosePoints = 0;

    }
    
    public void onEnable() {
    	saveDefaultConfig();
    	this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
	    this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);
    	
    	MySQLConnect();
        setState(State.WAITING);
        ScoreboardManager();
        registerListener();
        
        getGameWorld();
        loadGun();
        ChangeHubInfo srvInfo = new ChangeHubInfo(this.getServer().getServerName());
        srvInfo.setMOTD("WAITING");
        FoundLobby fLobby = new FoundLobby();
        srvNumber = fLobby.getServerPerGroup();
    }
    
    @Override
    public void onDisable() {
    	this.getServer().getMessenger().unregisterOutgoingPluginChannel(this);
	    this.getServer().getMessenger().unregisterIncomingPluginChannel(this);
    	getScoreboardManager().onDisable();
    }
    
    private void MySQLConnect() {
        Core.instance = this;
        (this.database = new MySQL("jdbc:mysql://", "45.140.165.235", "22728-database", "22728-database", "S5bV5su4p9")).connexion();
        database.creatingPaintBall();
    }
    
    private void registerListener() {
        Core.instance = this;
        killCoinsDataManager = new KillCoinsDataManager();
        killDataManager = new KillDataManager();
        killStreakDataManager = new KillStreakDataManager();
        mostKillStreakDataManager = new MostKillStreakDataManager();
        deathsDataManager = new DeathsDataManager();
		Bukkit.getPluginManager().registerEvents((Listener)new EventsListener(this), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new PlayerListeners(this), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new LoadWorld(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new TabListTeams(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new ChatTeam(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new ChooseTeam(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new Instance(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new InteractionsGame(this), (Plugin)this);
        
        Bukkit.getPluginManager().registerEvents((Listener)new KillCoinsShop(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new SkullNBT(), (Plugin)this);
        
        Bukkit.getPluginManager().registerEvents((Listener)new AdminMenu(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new AdminInteractions(), (Plugin)this);
        this.getCommand("game").setExecutor((CommandExecutor)new AdminCommand());
    }
    
    private void getGameWorld()
    {
    	String world = LoadWorld.getRandomSubfolderName("gameTemplate/");
    	LoadWorld.createGameWorld(world);
    	getGameWorldName = world;
    }
    
    private void loadGun() {
    	Core.instance = this;
    	Bukkit.getPluginManager().registerEvents((Listener)new DesertEagle(), (Plugin)this);
    	Bukkit.getPluginManager().registerEvents((Listener)new MP5(), (Plugin)this);
    }
    
    private void ScoreboardManager() {
    	instance = this;
    	
    	Bukkit.getPluginManager().registerEvents(new JoinScoreboardEvent(), this);
        Bukkit.getPluginManager().registerEvents(new LeaveScoreboardEvent(), this);
    	
    	scheduledExecutorService = Executors.newScheduledThreadPool(16);
    	executorMonoThread = Executors.newScheduledThreadPool(1);
    	scoreboardManager = new ScoreboardManager();
    }
    
    
    public void setState(State state) {
        this.state = state;
    }
    
    public boolean isState(State state) {
        return this.state == state;
    }
    
    public List<Player> getPlayers() {
        return this.players;
    }
    
    public List<String> getPlayersName() {
        return this.playersName;
    }
    
    //Liste des Teams
    public List<String> getRouge() {
        return this.rouge;
    }
    public List<String> getBleue() {
        return this.bleue;
    }
    public List<String> getJaune() {
        return this.jaune;
    }
    public List<String> getVert() {
        return this.vert;
    }
    public List<String> getOrange() {
        return this.orange;
    }
    public List<String> getRose() {
        return this.rose;
    }
    
    //Liste des initialisation des points
    public int getRougePoints() {
    	return this.rougePoints;
    }
    public int getBleuePoints() {
    	return this.bleuePoints;
    }
    public int getJaunePoints() {
    	return this.jaunePoints;
    }
    public int getVertPoints() {
    	return this.vertPoints;
    }
    public int getOrangePoints() {
    	return this.orangePoints;
    }
    public int getRosePoints() {
    	return this.rosePoints;
    }
    
    public List<String> getMP5() {
        return this.mp5;
    }
    
    public List<String> getIsInvincible() {
        return this.invincible;
    }
    
    
    
	/*
	 * Méthode d'auto-join.
	 */
    public void joinTeam(Player p) {
		
		if (getConfig().getBoolean("Mode.2vs4") == true)
		{
			if (rouge.size() <= bleue.size()) 
			{
				getRouge().add(p.getName());
				
			}
			else if (bleue.size() <= rouge.size()) 
			{
				getBleue().add(p.getName());
			}
		}
		
		if (getConfig().getBoolean("Mode.4vs4") == true)
		{
			if(rouge.size() <= bleue.size() && rouge.size() <= jaune.size() && rouge.size() <= vert.size()) 
			{
				getRouge().add(p.getName());
			} 
			else if(bleue.size() <= vert.size() && bleue.size() <= jaune.size() && bleue.size() <= rouge.size()) 
			{
				getBleue().add(p.getName());
			} 
			else if(jaune.size() <= vert.size() && jaune.size() <= rouge.size() && jaune.size() <= bleue.size()) 
			{
				getJaune().add(p.getName());
			} 
			else if(vert.size() <= rouge.size() && vert.size() <= bleue.size() && vert.size() <= jaune.size())
			{
				getVert().add(p.getName());
			}
		}
		
		if (getConfig().getBoolean("Mode.6vs4") == true)
		{
			if(rouge.size() <= bleue.size() && rouge.size() <= jaune.size() && rouge.size() <= vert.size() && rouge.size() <= orange.size() && rouge.size() <= rose.size())
			{
				getRouge().add(p.getName());
			}
			else if(bleue.size() <= jaune.size() && bleue.size() <= vert.size() && bleue.size() <= orange.size() && bleue.size() <= rose.size() && bleue.size() <= rouge.size())
			{
				getBleue().add(p.getName());
			}
			else if(jaune.size() <= vert.size() && jaune.size() <= orange.size() && jaune.size() <= rose.size() && jaune.size() <= rouge.size() && jaune.size() <= bleue.size())
			{
				getJaune().add(p.getName());
			}
			else if(vert.size() <= orange.size() && vert.size() <= rose.size() && vert.size() <= rouge.size() && vert.size() <= bleue.size() && vert.size() <= jaune.size()) 
			{
				getVert().add(p.getName());
			}
			else if(orange.size() <= rose.size() && orange.size() <= rouge.size() && orange.size() <= bleue.size() && orange.size() <= jaune.size() && orange.size() <= vert.size())
			{
				getOrange().add(p.getName());
			}
			else if(rose.size() <= rouge.size() && rose.size() <= bleue.size() && rose.size() <= jaune.size() && rose.size() <= vert.size() && rose.size() <= orange.size())
			{
				getRose().add(p.getName());
			}
		}

	}
    
    /*
	 * Méthode d'auto-leave.
	 */
    public void leaveTeam(Player p) {
    	
    	if (getConfig().getBoolean("Mode.2vs4") == true)
		{
    		if(getRouge().contains(p.getName()))
    		{
    			getRouge().remove(p.getName());
    		}
    		if(getBleue().contains(p.getName()))
    		{
    			getBleue().remove(p.getName());
    		}
		}
    	
    	if (getConfig().getBoolean("Mode.4vs4") == true)
		{
    		if(getRouge().contains(p.getName()))
    		{
    			getRouge().remove(p.getName());
    		}
    		if(getBleue().contains(p.getName()))
    		{
    			getBleue().remove(p.getName());
    		}
    		if(getJaune().contains(p.getName()))
    		{
    			getJaune().remove(p.getName());
    		}
    		if(getVert().contains(p.getName()))
    		{
    			getVert().remove(p.getName());
    		}
		}
    	
    	if (getConfig().getBoolean("Mode.6vs4") == true)
		{
    		if(getRouge().contains(p.getName()))
    		{
    			getRouge().remove(p.getName());
    		}
    		if(getBleue().contains(p.getName()))
    		{
    			getBleue().remove(p.getName());
    		}
    		if(getJaune().contains(p.getName()))
    		{
    			getJaune().remove(p.getName());
    		}
    		if(getVert().contains(p.getName()))
    		{
    			getVert().remove(p.getName());
    		}
    		if(getOrange().contains(p.getName()))
    		{
    			getOrange().remove(p.getName());
    		}
    		if(getRose().contains(p.getName()))
    		{
    			getRose().remove(p.getName());
    		}
		}
    	
    }
    
    public void addCoins(Player player, int amount) {
    	killCoinsDataManager.addCoins(player.getUniqueId(), amount);
    }

    public void removeCoins(Player player, int amount) {
    	killCoinsDataManager.removeCoins(player.getUniqueId(), amount);
    }

    public int getCoins(Player player) {
        return killCoinsDataManager.getPlayerData(player.getUniqueId()).getCoins();
    }
    
    public Player getPlayerWithMostCoins(List<Player> players) {
        if (players.isEmpty()) {
            return null;
        }

        Player playerWithMostCoins = players.get(0);
        int maxCoins = getCoins(playerWithMostCoins);

        for (Player player : players) {
            int coins = getCoins(player);
            if (coins > maxCoins) {
                maxCoins = coins;
                playerWithMostCoins = player;
            }
        }

        return playerWithMostCoins;
    }
    
    public void addDeath(Player player, int amount) {
    	deathsDataManager.addDeath(player.getUniqueId(), amount);
    }

    public void removeDeath(Player player, int amount) {
    	deathsDataManager.removeDeath(player.getUniqueId(), amount);
    }

    public int getDeath(Player player) {
        return deathsDataManager.getPlayerData(player.getUniqueId()).getDeath();
    }
    
    public void addKill(Player player, int amount) {
    	killDataManager.addKill(player.getUniqueId(), amount);
    }

    public void removeKill(Player player, int amount) {
    	killDataManager.removeKill(player.getUniqueId(), amount);
    }

    public int getKill(Player player) {
        return killDataManager.getPlayerData(player.getUniqueId()).getKills();
    }
    
    public Player getPlayerWithMostKills(List<Player> players) {
        if (players.isEmpty()) {
            return null;
        }

        Player playerWithMostKills = players.get(0);
        int maxKills = getKill(playerWithMostKills);

        for (Player player : players) {
            int coins = getKill(player);
            if (coins > maxKills) {
            	maxKills = coins;
                playerWithMostKills = player;
            }
        }

        return playerWithMostKills;
    }
    
    public void addKillStreak(Player player, int amount) {
    	killStreakDataManager.addKill(player.getUniqueId(), amount);
    }

    public void removeKillStreak(Player player) {
    	killStreakDataManager.removeKill(player.getUniqueId());
    }

    public int getKillStreak(Player player) {
        return killStreakDataManager.getPlayerData(player.getUniqueId()).getKillStreak();
    }
    
    public void setMostKillStreak(Player player, int amount) {
    	mostKillStreakDataManager.setKill(player.getUniqueId(), amount);
    }

    public int getMostKillStreak(Player player) {
        return mostKillStreakDataManager.getPlayerData(player.getUniqueId()).getMostKillStreak();
    }
    
    public Player getPlayerWithMostKillStreak(List<Player> players) {
        if (players.isEmpty()) {
            return null;
        }

        Player playerWithMostKills = players.get(0);
        int maxKills = getMostKillStreak(playerWithMostKills);

        for (Player player : players) {
            int coins = getMostKillStreak(player);
            if (coins > maxKills) {
            	maxKills = coins;
                playerWithMostKills = player;
            }
        }

        return playerWithMostKills;
    }
    
    public static void copyDirectory(String sourceDirectoryLocation, String destinationDirectoryLocation)
    		  throws IOException {
    		    Files.walk(Paths.get(sourceDirectoryLocation))
    		      .forEach(source -> {
    		          Path destination = Paths.get(destinationDirectoryLocation, source.toString()
    		            .substring(sourceDirectoryLocation.length()));
    		          try {
    		              Files.copy(source, destination);
    		          } catch (IOException e) {
    		              e.printStackTrace();
    		          }
    		      });
    		}
    
    @Override
	public void onPluginMessageReceived(String channel, Player player, byte[] message) 
	{
	    if (!channel.equals("BungeeCord")) 
	    {
	      return;
	    }
	    ByteArrayDataInput in = ByteStreams.newDataInput(message);
	    String subchannel = in.readUTF();
	    if (subchannel.equals("SomeSubChannel")) 
	    {
	      // Use the code sample in the 'Response' sections below to read
	      // the data.
	    }
	}
    
    public static Core getInstance() {
        return Core.instance;
    }
    
    public ScoreboardManager getScoreboardManager() {
        return this.scoreboardManager;
    }
    
    public ScheduledExecutorService getExecutorMonoThread() {
        return this.executorMonoThread;
    }
    
    public ScheduledExecutorService getScheduledExecutorService() {
        return this.scheduledExecutorService;
    }
    
    public static Plugin getPlugin() {
        return null;
    }
}
