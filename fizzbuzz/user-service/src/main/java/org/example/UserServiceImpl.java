package org.example;

import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class UserServiceImpl implements UserService{
    private final UserDao userDao;
    private final BlockingDeque<User> queue;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
        this.queue = new LinkedBlockingDeque<User>(10);
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public List<User> printAll() {
        return null;
    }
}
