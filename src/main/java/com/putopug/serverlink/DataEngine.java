package com.putopug.serverlink;

import com.google.gson.Gson;
import com.putopug.serverlink.events.ServerLinkEvents;

import java.io.*;
import java.util.Scanner;

public class DataEngine {
    public static List banlist;
    public static File list;
    public static void loadOrReloadConfig() throws FileNotFoundException {
        list = new File(ServerLinkEvents.plugin.getDataFolder()+File.separator+"UserPermissionList.json");
        banlist= new Gson().fromJson(new BufferedReader(new FileReader(ServerLinkEvents.plugin.getDataFolder()+File.separator+"UserPermissionList.json")),List.class);
        if(!list.exists()) {
        try {
            list.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }

    static Gson gson = new Gson();
    static List banlistSer = new List();
    public static void addUserToBanList(String entry_type,String id,String platform) throws Exception {
        UserPermissions prms = new UserPermissions();
        prms.setEntryType(entry_type);
        prms.setId(id);
        prms.setPlatform(platform);
        banlistSer.getPerms().add(prms);
        FileWriter writer = new FileWriter(list,false);
        writer.write(gson.toJson(banlistSer));
        loadOrReloadConfig();
    }
}
