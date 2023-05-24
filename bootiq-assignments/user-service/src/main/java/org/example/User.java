package org.example;

public class User {
    private final int USER_ID;
    private final String USER_GUID;
    private final String USER_NAME;

    public User(int USER_ID, String USER_GUID, String USER_NAME) {
        this.USER_ID = USER_ID;
        this.USER_GUID = USER_GUID;
        this.USER_NAME = USER_NAME;
    }

    public int getUSER_ID() {
        return USER_ID;
    }

    public String getUSER_GUID() {
        return USER_GUID;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    @Override
    public String toString() {
        return "User{" +
                "USER_ID=" + USER_ID +
                ", USER_GUID='" + USER_GUID + '\'' +
                ", USER_NAME='" + USER_NAME + '\'' +
                '}';
    }
}
