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

    public static void main(String[] args) {
        try {
            addUserToBanList("black","e666037e-8185-4b39-ad99-85b561e7608e"," mc");
            addUserToBanList("black","e666037e-8185-4b39-ad99-85b561e7608e"," mc");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    static Gson gson = new Gson();
    static List banlist = new List();
    public static void addUserToBanList(String entry_type,String id,String platform) throws FileNotFoundException {
        UserPermissions prms = new UserPermissions();
        prms.setEntryType(entry_type);
        prms.setId(id);
        prms.setPlatform(platform);
        banlist.getPerms().add(prms);
        loadOrReloadConfig();
    }
}
