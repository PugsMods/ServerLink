package com.putopug.serverlink.events;

import com.putopug.serverlink.JDABot;
import com.putopug.serverlink.ServerLink;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import static org.bukkit.Bukkit.getServer;

public class ServerLinkEvents implements Listener {
    public ServerLinkEvents(ServerLink instance){
        plugin = instance;
    }
    public static ServerLink plugin;
    @EventHandler
    public static void PlayerChatEvent(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        //TODO: Customizable formatting
        JDABot.smg("**"+event.getPlayer().getDisplayName()+"**: "+event.getMessage());
    }
}
