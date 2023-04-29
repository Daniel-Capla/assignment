package org.example;

public class User {
    private int USER_ID;
    private int USER_GUID;
    private String USER_NAME;

    public User(int USER_ID, int USER_GUID, String USER_NAME) {
        this.USER_ID = USER_ID;
        this.USER_GUID = USER_GUID;
        this.USER_NAME = USER_NAME;
    }

    public int getUSER_ID() {
        return USER_ID;
    }

    public int getUSER_GUID() {
        return USER_GUID;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }
}
