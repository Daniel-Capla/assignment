package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class UserServiceImpl implements UserService {
    static final int MAX_QUEUE_SIZE = 3;

    private final Logger logger = LogManager.getLogger(UserServiceImpl.class);
    private final UserDao userDao;
    private final LinkedBlockingQueue<User> queue;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
        this.queue = new LinkedBlockingQueue<User>(MAX_QUEUE_SIZE);
    }

    @Override
    public void addUsers(List<User> userList) {
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue, userDao, userList);

        Thread producerThread = new Thread(() -> {
            try {
                producer.produceUsers(userList);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error(e.getStackTrace());
            e.printStackTrace();
        }
    }

    @Override
    public List<User> printAll() {
        try {
            return userDao.printAll();
        } catch (SQLException e) {
            System.out.println("Could not fetch users from DB");
            logger.error(e.getStackTrace());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAll() {
        try {
            userDao.deleteAll();
        } catch (SQLException e) {
            logger.error(e.getStackTrace());
            e.printStackTrace();
        }
    }
}
