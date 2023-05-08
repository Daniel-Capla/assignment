package org.example;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> printAll();
}
