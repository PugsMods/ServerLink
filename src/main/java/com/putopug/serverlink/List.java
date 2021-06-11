package com.putopug.serverlink;

import java.util.Map;

public class List {
    private Map<String,UserPermissions> perms;
}
class UserPermissions{
    private final String entry_type;
    private final String id;
    private final String platform;

    UserPermissions(String entry_type,String id, String platform) {
       this.platform = platform;
       this.id = id;
       this.entry_type = entry_type;
    }

    public String getEntryType() {
        return entry_type;
    }

    public String getId() {
        return id;
    }

    public String getPlatform() {
        return platform;
    }
}
