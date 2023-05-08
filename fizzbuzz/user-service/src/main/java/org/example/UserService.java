package org.example;

import java.util.List;

public interface UserService {
    void addUsers(List<User> userList);
    List<User> printAll();
}
