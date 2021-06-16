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
        if (this.getConfig().getBoolean("POST-SERVER-STARTUP-MESSAGE")) {
            if (this.getConfig().getString("STARTUP-FORMATTING") != null) {
                JDABot.smg(this.getConfig().getString("STARTUP-FORMATTING"));
            } else {
                Bukkit.getLogger().warning("[ServerLink] WARNING: STARTUP-FORMATTING Key in null, Falling back to default hardcoded Message");
                JDABot.smg("**Server started.**");
            }
        }
    }

    @Override
    public void onDisable() {
        if (this.getConfig().getBoolean("POST-SERVER-SHUTDOWN-MESSAGE")) {
            if (this.getConfig().getString("SHUTDOWN-FORMATTING") != null) {
                JDABot.smg(this.getConfig().getString("SHUTDOWN-FORMATTING"));
            } else {
                Bukkit.getLogger().warning("[ServerLink] WARNING: SHUTDOWN-FORMATTING Key in null, Falling back to default hardcoded Message");
                JDABot.smg("**Shutting down server.**");
            }
        }
        JDABot.jda.shutdownNow();
    }
}
