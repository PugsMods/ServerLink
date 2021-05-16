package com.putopug.serverlink;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.TextChannel;

import javax.security.auth.login.LoginException;

public class JDABot{
    public static void main(String[] args) throws LoginException, InterruptedException {
        init();
    }
    static TextChannel chnl;
    public static void init()
            throws LoginException, InterruptedException
    {
        //TODO: Get Token from config
        JDA jda = JDABuilder.createDefault("TOKEN_HERE")
                .build();
        jda.awaitReady();
        //TODO: Get Channel from config
        chnl = jda.getTextChannelsByName("",false).get(0);
    }
    public static void smg(String message) {
        chnl.sendMessage(message).queue();
    }
}
