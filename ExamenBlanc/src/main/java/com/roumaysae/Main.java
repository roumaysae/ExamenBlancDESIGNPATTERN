package com.roumaysae;

import com.roumaysae.entities.Agent;
import com.roumaysae.entities.Transaction;
import com.roumaysae.enums.TransactionType;
import com.roumaysae.implementations.ScoringStrategy;
import com.roumaysae.implementations.HistoryStrategy;
import com.roumaysae.implementations.DefaultStrategy;

import java.sql.Date;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Création d'agents
        Agent agent1 = new Agent("Agent1");
        Agent agent2 = new Agent("Agent2");
        Agent agent3 = new Agent("Agent3");

        // Abonnement
        agent1.subscribe(agent2);
        agent1.subscribe(agent3);

        // Création de transactions
        Transaction transaction1 = new Transaction.TransactionBuilder()
                .withId("T001")
                .withDate(Date.valueOf(LocalDate.now()))
                .withMontant(1000)
                .withType(TransactionType.Vente)
                .build();

        Transaction transaction2 = new Transaction.TransactionBuilder()
                .withId("T002")
                .withDate(Date.valueOf(LocalDate.now()))
                .withMontant(-500)
                .withType(TransactionType.Achat)
                .build();

        // Affichage de la transaction avant ajout
        System.out.println("Transaction 1 avant ajout:");
        System.out.println(transaction1.toString());

//        // Test avec la stratégie par défaut
//        System.out.println("\nTest avec la DefaultStrategy:");
//        agent1.setStrategy(new DefaultStrategy());
//        agent1.addTransaction(transaction1);  // Utilisation de la stratégie par défaut
//        agent1.afficherTransactions();

        // Test avec la stratégie ScoringStrategy (calcul du solde)
        System.out.println("\nTest avec la ScoringStrategy:");
        agent1.setStrategy(new ScoringStrategy()); // Changer la stratégie à ScoringStrategy
        agent1.addTransaction(transaction2); // Ajout de la transaction pour calculer le solde
        agent1.afficherTransactions();

//        // Test avec la stratégie HistoryStrategy (garde l'historique des transactions)
//        System.out.println("\nTest avec la HistoryStrategy:");
//        agent1.setStrategy(new HistoryStrategy()); // Changer la stratégie à HistoryStrategy
//        agent1.addTransaction(transaction1);  // Ajout de la transaction dans l'historique
//        agent1.afficherTransactions();

        // Affichage des transactions des autres agents
        agent2.afficherTransactions();
        agent3.afficherTransactions();
    }
}
