package me.mrliam2614.events;

import me.mrliam2614.PvpManager;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class onPlayerHitPlayer implements Listener {

    private final PvpManager plugin;

    public onPlayerHitPlayer(PvpManager plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onHitPlayer(EntityDamageByEntityEvent e){
        Entity damager = e.getDamager();
        Entity damaged = e.getEntity();

        if(damager instanceof Player && damaged instanceof Player){
            if(plugin.isPvpActive() == false){
                e.setCancelled(true);
                damager.sendMessage(plugin.getFacilitisAPI().strUtils.colored("&7[&cPvPManager&7] &cPVP is disabled!"));
            }
        }
    }
}
