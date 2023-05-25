package org.example;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Consumer implements Runnable {
    private final LinkedBlockingQueue<User> blockingQueue;
    private final UserDao userDao;
    private final List<User> userList;

    public Consumer(LinkedBlockingQueue<User> blockingQueue, UserDao userDao, List<User> userList) {
        this.blockingQueue = blockingQueue;
        this.userDao = userDao;
        this.userList = userList;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= userList.size(); i++) {
                User user = blockingQueue.take();
                if (user.getUSER_ID() == -1) {
                    break;
                }
                System.out.println("Consuming: " + user);
                userDao.addUser(user);
            }
        } catch (InterruptedException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
