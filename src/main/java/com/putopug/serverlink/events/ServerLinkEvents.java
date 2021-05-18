package com.putopug.serverlink.events;

import com.putopug.serverlink.JDABot;
import com.putopug.serverlink.ServerLink;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ServerLinkEvents implements Listener {
    public static ServerLink plugin;
    public ServerLinkEvents(ServerLink instance){
        plugin = instance;
    }
    @EventHandler
    public static void PlayerChatEvent(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String sendStr = plugin.getConfig().getString("CHAT-FORMATTING");
        if(sendStr != null){
        sendStr = sendStr.replaceAll("\\$PLAYER_NAME",event.getPlayer().getDisplayName()).replaceAll("\\$PLAYER_MESSAGE",event.getMessage());
        JDABot.smg(sendStr);
        }else{
            Bukkit.getLogger().warning("[ServerLink] WARNING: CHAT-FORMATTING In config.yml is null, falling back to hardcoded fallback message.");
            JDABot.smg("**"+player.getDisplayName()+"**: "+event.getMessage());
        }
    }
    @EventHandler
    public static void  PlayerJoinEvent(PlayerLoginEvent event){
        Player player = event.getPlayer();
        String sendStr = plugin.getConfig().getString("JOIN-FORMATTING");
        if(plugin.getConfig().getBoolean("POST-JOIN-MESSAGE")){
        if(sendStr != null){
            sendStr = sendStr.replaceAll("\\$PLAYER_NAME",event.getPlayer().getDisplayName());
            JDABot.smg(sendStr);
        }else{
            Bukkit.getLogger().warning("[ServerLink] WARNING: JOIN-FORMATTING In config.yml is null, falling back to hardcoded fallback message.");
            JDABot.smg("**"+player.getDisplayName()+"** joined the game.");
        }
        }
    }
    @EventHandler
    public static void  PlayerLeaveEvent(PlayerQuitEvent event){
        Player player = event.getPlayer();
        String sendStr = plugin.getConfig().getString("LEAVE-FORMATTING");
        if(plugin.getConfig().getBoolean("POST-LEAVE-MESSAGE")){
            if(sendStr != null){
                sendStr = sendStr.replaceAll("\\$PLAYER_NAME",event.getPlayer().getDisplayName());
                JDABot.smg(sendStr);
            }else{
                Bukkit.getLogger().warning("[ServerLink] WARNING: LEAVE-FORMATTING In config.yml is null, falling back to hardcoded fallback message.");
                JDABot.smg("**"+player.getDisplayName()+"** left the game.");
            }
        }
    }
}
