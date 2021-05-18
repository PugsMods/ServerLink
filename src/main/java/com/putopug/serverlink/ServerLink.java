package com.putopug.serverlink;

import com.putopug.serverlink.events.ServerLinkEvents;
import org.bukkit.Bukkit;
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
            Bukkit.getLogger().severe("[ServerLink] JDA failed to login, did you put the correct token?");
        }
        if(this.getConfig().getBoolean("POST-SERVER-STARTUP-MESSAGE")){
            JDABot.smg("Server started");
        }
    }
    @Override
    public void onDisable() {
        if(this.getConfig().getBoolean("POST-SERVER-SHUTDOWN-MESSAGE")){
            JDABot.smg("Shutting down server.");
        }
    }
}
