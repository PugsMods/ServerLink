package com.putopug.serverlink.events;

import com.putopug.serverlink.JDABot;
import com.putopug.serverlink.ServerLink;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ServerLinkEvents implements Listener {
    public static ServerLink plugin;
    public ServerLinkEvents(ServerLink instance){
        plugin = instance;
    }
    @EventHandler
    public static void PlayerChatEvent(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String sendStr = plugin.getConfig().getString("FORMATTING");
        if(sendStr != null){
        sendStr = sendStr.replaceAll("\\$PLAYER_NAME",event.getPlayer().getDisplayName()).replaceAll("\\$PLAYER_MESSAGE",event.getMessage());
        JDABot.smg(sendStr);
        }else{
            Bukkit.getLogger().warning("[ServerLink] WARNING: FORMATTING In config.yml is null, falling back to hardcoded fallback message.");
            JDABot.smg("**"+player.getDisplayName()+"**: "+event.getMessage());
        }
    }
}
