package org.example;

import java.util.concurrent.BlockingDeque;

public class Consumer {
    private final BlockingDeque blockingDeque;
    private final UserDao userDao;

    public Consumer(BlockingDeque blockingDeque, UserDao userDao) {
        this.blockingDeque = blockingDeque;
        this.userDao = userDao;
    }


}
