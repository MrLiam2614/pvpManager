package me.mrliam2614.commands;

import me.mrliam2614.PvpManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CmdPvp implements CommandExecutor {
    private final PvpManager plugin;

    public CmdPvp(PvpManager plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("pvpmanager.admin")){
            if(args.length >= 1){
                if(args[0].equalsIgnoreCase("enable")){
                    sender.sendMessage(plugin.getFacilitisAPI().strUtils.colored("&7[&cPvPManager&7] &cPvP Enabled"));
                    plugin.getServer().broadcastMessage(plugin.getFacilitisAPI().strUtils.colored("&7[&cPvPManager&7] &6PvP is now &cEnabled"));
                    plugin.setPvpActive(true);
                }else if(args[0].equalsIgnoreCase("disable")){
                    sender.sendMessage(plugin.getFacilitisAPI().strUtils.colored("&7[&cPvPManager&7] &aPvP Disabled"));
                    plugin.getServer().broadcastMessage(plugin.getFacilitisAPI().strUtils.colored("&7[&cPvPManager&7] &6PvP is now &aDisabled"));
                    plugin.setPvpActive(false);
                }else{
                    sender.sendMessage(plugin.getFacilitisAPI().strUtils.colored("&7[&cPvPManager&7] &aDo i need to enable or disable PVP?"));
                }
            }else{
                sender.sendMessage(plugin.getFacilitisAPI().strUtils.colored("&7[&cPvPManager&7] &aDo i need to enable or disable PVP?"));
            }
        }else{
            sender.sendMessage(plugin.getFacilitisAPI().strUtils.colored("&7[&cPvPManager&7] &cYou don't have permissions to do this command."));
        }
        return false;
    }
}
