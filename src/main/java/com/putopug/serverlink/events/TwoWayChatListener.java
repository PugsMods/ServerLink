package com.putopug.serverlink.events;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

public class TwoWayChatListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (ServerLinkEvents.plugin.getConfig().getString("CHANNEL-FIND-MODE").equalsIgnoreCase("id")) {
            if (!event.getMessage().getAuthor().isBot() && event.getChannel().getId().equals(ServerLinkEvents.plugin.getConfig().getString("CHANNEL"))) {
                if (ServerLinkEvents.plugin.getConfig().getBoolean("USE-NICKS-IN-2-WAY-CHAT")) {
                    if (event.getMember().getNickname() != null) {
                        Bukkit.broadcastMessage(event.getMember().getNickname() + ": " + event.getMessage().getContentDisplay());
                    } else {
                        Bukkit.broadcastMessage(event.getAuthor().getName() + ": " + event.getMessage().getContentDisplay());
                    }
                } else {
                    Bukkit.broadcastMessage(event.getAuthor().getName() + ": " + event.getMessage().getContentDisplay());
                }
            }
        } else {
            if (event.getChannel().getName().equals(ServerLinkEvents.plugin.getConfig().getString("CHANNEL")) && !event.getMessage().getAuthor().isBot()) {
                if (ServerLinkEvents.plugin.getConfig().getBoolean("USE-NICKS-IN-2-WAY-CHAT")) {
                    if (event.getMember().getNickname() != null) {
                        Bukkit.broadcastMessage(event.getMember().getNickname() + ": " + event.getMessage().getContentDisplay());
                    } else {
                        Bukkit.broadcastMessage(event.getAuthor().getName() + ": " + event.getMessage().getContentDisplay());
                    }
                } else {
                    Bukkit.broadcastMessage(event.getAuthor().getName() + ": " + event.getMessage().getContentDisplay());
                }
            }
        }
    }
}
