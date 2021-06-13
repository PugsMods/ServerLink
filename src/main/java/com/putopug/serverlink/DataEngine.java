package com.putopug.serverlink;

import com.google.gson.Gson;
import com.putopug.serverlink.events.ServerLinkEvents;

import java.io.*;
import java.util.Scanner;

public class DataEngine {
    public static void loadOrReloadConfig() throws FileNotFoundException {
        File list = new File(ServerLinkEvents.plugin.getDataFolder()+File.separator+"UserPermissionList.json");
        List banlist = new Gson().fromJson(new BufferedReader(new FileReader(ServerLinkEvents.plugin.getDataFolder()+File.separator+"UserPermissionList.json")),List.class);
        if(!list.exists()) {
        try {
            list.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }

    public static void addUserToBanList(String entry_type,String id,String platform) throws FileNotFoundException {
        Gson gson = new Gson();
        List banlist = new List();
        banlist.getPerms().put("ENTRY_001", new UserPermissions());
        String banstr = "{\"entry_type\":\""+entry_type+"\", \"id\": \""+id+"\",\"platform\":\""+platform+"\"}";
        System.out.println(gson.toJson(banlist));
        //loadOrReloadConfig();
    }
}
