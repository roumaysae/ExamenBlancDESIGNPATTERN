package com.roumaysae.implementations;

import com.roumaysae.entities.Transaction;
import com.roumaysae.interfaces.NotificationStrategy;

import java.util.ArrayList;
import java.util.List;

public class HistoryStrategy implements NotificationStrategy {
    private List<Transaction> history = new ArrayList<>();

    @Override
    public void handleNotification(String agentName, Transaction transaction) {
        history.add(transaction);
        System.out.println("Agent: " + agentName + " | Transaction a bien ajoutée à l'historique: " + transaction);
    }
}
