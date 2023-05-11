package org.example;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private final BlockingQueue blockingQueue;
    private final UserDao userDao;
    private final List<User> userList;

    public Consumer(BlockingQueue blockingQueue, UserDao userDao, List<User> userList) {
        this.blockingQueue = blockingQueue;
        this.userDao = userDao;
        this.userList = userList;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= userList.size(); i++) {
                User user = (User) blockingQueue.take();
                if (user.getUSER_ID() == -1) {
                    break;
                }
                System.out.println("Consuming: " + user);
                try {
                    userDao.addUser(user);
                } catch (SQLException e) {
                    System.out.println("Could not add user on Dao: " + e.getMessage());
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
