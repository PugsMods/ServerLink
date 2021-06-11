package com.putopug.serverlink;

import com.putopug.serverlink.events.ServerLinkEvents;

import java.io.File;
import java.io.IOException;

public class DataEngine {
    public static void loadOrReloadConfig(){
        File list = new File(ServerLinkEvents.plugin.getDataFolder()+File.separator+"UserPermissionList.json");
        if(!list.exists()) {
        try {
            list.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }

    public static void addUserToBanList(String entry_type,String id,String platform){
        String banstr = "{\"entry_type\":\""+entry_type+"\", \"id\": \""+id+"\",\"platform\":\""+platform+"\"}";
        System.out.println(banstr);
    }
}
