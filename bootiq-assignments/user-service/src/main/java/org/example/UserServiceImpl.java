package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class UserServiceImpl implements UserService {

    private final Logger logger = LogManager.getLogger(UserServiceImpl.class);
    private final UserDao userDao;
    private final BlockingQueue<User> queue;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
        this.queue = new LinkedBlockingQueue<User>(3);
    }

    @Override
    public void addUsers(List<User> userList) {
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue, userDao, userList);

        Thread producerThread = new Thread(() -> producer.produceUsers(userList));
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
            e.printStackTrace();
        }
        return null;
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
