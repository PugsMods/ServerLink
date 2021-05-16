package com.putopug.serverlink;

import com.putopug.serverlink.events.ServerLinkEvents;
import org.bukkit.plugin.java.JavaPlugin;

public final class ServerLink extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ServerLinkEvents(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
