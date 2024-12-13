package com.roumaysae.implementations;

import com.roumaysae.entities.Transaction;
import com.roumaysae.enums.TransactionType;
import com.roumaysae.interfaces.NotificationStrategy;

public class ScoringStrategy implements NotificationStrategy {
    private double solde = 0;
    @Override
    public void handleNotification(String agentName, Transaction transaction) {
        if ("Vente".equals(transaction.getType())) {
            solde += transaction.getMontant();
        } else if ("Achat".equals(transaction.getType())) {
            solde -= transaction.getMontant();
        }
        System.out.println("Agent: " + agentName + " | Nouveau Solde: " + solde);
    }
}
