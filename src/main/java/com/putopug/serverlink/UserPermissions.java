package com.putopug.serverlink;

public class UserPermissions{
    private String entry_type;
    private String id;
    private String platform;

    public String getEntryType() {
        return entry_type;
    }

    public String getId() {
        return id;
    }

    public String getPlatform() {
        return platform;
    }
    public void setEntryType(String entry_type) {
        this.entry_type = entry_type;
    }

    public void setId(String identifier) {
        this.id = identifier;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

}
