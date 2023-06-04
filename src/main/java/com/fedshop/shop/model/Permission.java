package com.fedshop.shop.model;

public enum Permission {

    DEVELOPERS_READ("user:read"),
    DEVELOPERS_WRITE("user:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
