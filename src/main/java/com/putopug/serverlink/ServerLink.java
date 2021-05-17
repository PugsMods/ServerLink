package com.putopug.serverlink;

import com.putopug.serverlink.events.ServerLinkEvents;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.LoginException;

public final class ServerLink extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new ServerLinkEvents(this), this);
        try {
            JDABot.init();
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onDisable() {
    }
}
