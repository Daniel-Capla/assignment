package org.example;

import java.sql.SQLException;
import java.util.List;

public class UserDao {
    private final Database db;

    public UserDao(Database db) {
        this.db = db;
    }

    public void addUser(User user) throws SQLException {
        db.addUser(user);
    }

    public List<User> printAll() throws SQLException {
        return db.printAll();
    }
}
