package com.putopug.serverlink.events;

import org.bukkit.ChatColor;
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

    }
}
