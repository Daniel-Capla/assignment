package org.example;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Producer {
    static final int MAX_QUEUE_SIZE = 3;
    private final LinkedBlockingQueue<User> userQueue;

    public Producer(LinkedBlockingQueue<User> userQueue) {
        this.userQueue = userQueue;
    }

    public void produceUsers(List<User> userList) throws InterruptedException {
        try {
            for (User user :
                    userList) {
                System.out.println("Producing: " + user);
                userQueue.put(user);
                if (userQueue.size() == MAX_QUEUE_SIZE) {
                    Thread.sleep(1);
                }
            }
            //put predefined user with id -1 that will tell Consumer it's the end of the production
            userQueue.put(new User(-1, "", ""));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
