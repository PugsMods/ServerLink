package com.putopug.serverlink;

import com.google.common.collect.ImmutableSet;
import com.putopug.serverlink.events.ServerLinkEvents;
import com.putopug.serverlink.events.TwoWayChatListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import javax.security.auth.login.LoginException;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Objects;

public class JDABot {
    static TextChannel chnl;
    static JDA jda;

    public static void init()
            throws LoginException, InterruptedException {
        jda = JDABuilder.createDefault(ServerLinkEvents.plugin.getConfig().getString("TOKEN")).addEventListeners(new TwoWayChatListener()).build();
        jda.awaitReady();

        if (Objects.requireNonNull(ServerLinkEvents.plugin.getConfig().getString("CHANNEL-FIND-MODE")).equalsIgnoreCase("string")) {
            chnl = jda.getTextChannelsByName(Objects.requireNonNull(ServerLinkEvents.plugin.getConfig().getString("CHANNEL")), false).get(0);
        } else if (Objects.requireNonNull(ServerLinkEvents.plugin.getConfig().getString("CHANNEL-FIND-MODE")).equalsIgnoreCase("id")) {
            chnl = jda.getTextChannelById(Objects.requireNonNull(ServerLinkEvents.plugin.getConfig().getString("CHANNEL")));
        } else {
            throw new IllegalArgumentException("FATAL: ServerLink Could Not Parse Channel-Find-Mode , please check the config.yml found in SERVER_ROOT/plugins/ServerLink/config.yml, did you make any spelling mistakes in the Field CHANNEL-FIND-MODE? The only 2 valid options are: string, id");
        }

    }

    public static void smg(String message) {
        message = message.replaceAll("\\\\", "/");
        chnl.sendMessage(message).allowedMentions(Collections.emptySet()).queue();
        if (ServerLinkEvents.plugin.getConfig().getBoolean("MULTICHANNEL-MODE")) {
            for (Object x : ServerLinkEvents.plugin.getConfig().getList("MULTICHANNEL-CHANNELS")) {
                TextChannel textChannel = jda.getTextChannelById(x.toString());
                message = message.replaceAll("\\\\", "/");
                textChannel.sendMessage(message).allowedMentions(Collections.emptySet()).queue();
            }
        }
    }
}
