package com.roumaysae.implementations;

import com.roumaysae.entities.Transaction;
import com.roumaysae.interfaces.NotificationStrategy;

public class DefaultStrategy implements NotificationStrategy {
    @Override
    public void handleNotification(String agentName, Transaction transaction) {
          System.out.println("Agent: " + agentName + " Transaction: " + transaction);
    }
}
