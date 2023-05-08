package org.example;

import java.util.List;
import java.util.concurrent.BlockingDeque;

public class Producer {
    private BlockingDeque<User> userQueue;


    public Producer(BlockingDeque<User> userQueue) {
        this.userQueue = userQueue;
    }

    public void produceUsers(List<User> userList) {
        try {
            for (User user :
                    userList) {
                System.out.println("Producing: " + user);
                userQueue.put(user);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
