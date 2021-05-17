package com.putopug.serverlink;

import com.putopug.serverlink.events.ServerLinkEvents;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.TextChannel;

import javax.security.auth.login.LoginException;
import java.util.Objects;

public class JDABot{
    static TextChannel chnl;
    public static void init()
            throws LoginException, InterruptedException
    {
        JDA jda = JDABuilder.createDefault(ServerLinkEvents.plugin.getConfig().getString("TOKEN"))
                .build();
        jda.awaitReady();
        if(Objects.requireNonNull(ServerLinkEvents.plugin.getConfig().getString("CHANNEL-FIND-MODE")).equalsIgnoreCase("string")){
            chnl = jda.getTextChannelsByName(Objects.requireNonNull(ServerLinkEvents.plugin.getConfig().getString("CHANNEL")),false).get(0);
        }else if(Objects.requireNonNull(ServerLinkEvents.plugin.getConfig().getString("CHANNEL-FIND-MODE")).equalsIgnoreCase("id")){
        chnl = jda.getTextChannelById(Objects.requireNonNull(ServerLinkEvents.plugin.getConfig().getString("CHANNEL")));
        }else{
            throw new IllegalArgumentException("FATAL: ServerLink Could Not Parse Channel-Find-Mode , please check the config.yml found in SERVER_ROOT/plugins/ServerLink/config.yml, did you make any spelling mistakes in the Field CHANNEL-FIND-MODE? The only 2 valid options are: string, id");
        }

    }
    public static void smg(String message) {
        chnl.sendMessage(message).queue();
    }
}
