package org.example;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class UserServiceImpl implements UserService{
    private final UserDao userDao;
    private final BlockingQueue<User> queue;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
        this.queue = new LinkedBlockingQueue<User>(10);
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
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> printAll() {
        try {
            return userDao.printAll();
        } catch (SQLException e) {
            System.out.println("Could not fetch users from DB");
            throw new RuntimeException(e);
        }
    }
}
