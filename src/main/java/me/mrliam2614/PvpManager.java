package me.mrliam2614;

import me.mrliam2614.commands.CmdPvp;
import me.mrliam2614.events.onPlayerHitPlayer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class PvpManager extends JavaPlugin {
    private FacilitisAPI facilitisAPI;
    private boolean pvpActive;
    public void onEnable(){
        facilitisAPI = FacilitisAPI.getInstance();
        facilitisAPI.messages.EnableMessage(this);
        pvpActive = true;
        register();
    }

    public void onDisable(){
        facilitisAPI.messages.DisableMessage(this);
    }

    private void register(){
        getCommand("pvp").setExecutor(new CmdPvp(this));
        Bukkit.getPluginManager().registerEvents(new onPlayerHitPlayer(this), this);
    }

    public FacilitisAPI getFacilitisAPI() {
        return facilitisAPI;
    }

    public boolean isPvpActive() {
        return pvpActive;
    }

    public void setPvpActive(Boolean state){
        pvpActive = state;
    }
}
