package org.example;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    void addUsers(List<User> userList);

    List<User> printAll();

    void deleteAll() throws SQLException;
}
