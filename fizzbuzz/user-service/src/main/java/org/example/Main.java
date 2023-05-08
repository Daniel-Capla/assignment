package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Database db = new Database();

        db.addUser(new User(1, "a1", "Robert"));
        db.printAll();
    
    }
}