package com.putopug.serverlink;

import com.putopug.serverlink.events.ServerLinkEvents;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class BlacklistCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args.length == 1){
            ServerLinkEvents.plugin.getServer().getPlayer(args[0]); // TODO: Add Permission node serverlink.blacklist to player.
        }
        return true;
    }
}
