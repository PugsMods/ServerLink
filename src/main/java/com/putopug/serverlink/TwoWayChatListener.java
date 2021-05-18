package com.putopug.serverlink;

import com.putopug.serverlink.events.ServerLinkEvents;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

public class TwoWayChatListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if(event.getChannel().getName().equals(ServerLinkEvents.plugin.getConfig().getString("CHANNEL")) && !event.getMessage().getAuthor().isBot()){
            Bukkit.broadcastMessage(event.getAuthor().getName()+": "+event.getMessage().getContentDisplay());
        }
    }
}
