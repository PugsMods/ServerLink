package com.putopug.serverlink.events;

import com.putopug.serverlink.JDABot;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import static org.bukkit.Bukkit.getServer;

public class ServerLinkEvents implements Listener {
    @EventHandler
    public static void PlayerChatEvent(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        player.sendMessage("Chat Message Detected! - "+event.getMessage());
        //TODO: Get Channel from config file
        //TODO: Customizable formatting
        JDABot.smg("**"+event.getPlayer()+"**: "+event.getMessage());
    }
}
