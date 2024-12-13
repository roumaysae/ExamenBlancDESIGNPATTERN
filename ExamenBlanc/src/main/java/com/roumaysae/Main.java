package com.roumaysae;

import com.roumaysae.containers.ContainerAgent;
import com.roumaysae.entities.Agent;
import com.roumaysae.entities.Transaction;
import com.roumaysae.enums.TransactionType;
import com.roumaysae.implementations.ScoringStrategy;

import java.sql.Date;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Création du conteneur
        ContainerAgent containerAgent = ContainerAgent.getInstance();

        // Création d'agents
        Agent agent1 = new Agent("Agent1");
        Agent agent2 = new Agent("Agent2");
        Agent agent3 = new Agent("Agent3");

        // Ajout d'agents dans le conteneur
        containerAgent.addAgent(agent1);
        containerAgent.addAgent(agent2);
        containerAgent.addAgent(agent3);

        // Affichage des agents enregistrés
        System.out.println("=== Agents enregistrés dans le conteneur ===");
        containerAgent.displayAllAgents();

        // Abonnement des agents
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

        // Test avec la stratégie ScoringStrategy
        System.out.println("\nTest avec la ScoringStrategy:");
        agent1.setStrategy(new ScoringStrategy());
        agent1.addTransaction(transaction2);
        agent1.afficherTransactions();

        // Affichage des transactions des autres agents
        System.out.println("\nTransactions des autres agents:");
        agent2.afficherTransactions();
        agent3.afficherTransactions();

        // Suppression et affichage après suppression
        System.out.println("\nSuppression de l'agent2...");
        containerAgent.removeAgent("Agent2");
        containerAgent.displayAllAgents();
    }
}
