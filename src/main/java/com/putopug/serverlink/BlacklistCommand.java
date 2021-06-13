package com.putopug.serverlink;

import com.putopug.serverlink.events.ServerLinkEvents;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BlacklistCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        try {
            DataEngine.addUserToBanList("blacklist",ServerLinkEvents.plugin.getServer().getPlayer(args[0]).getUniqueId().toString(),"minecraft");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }
}
