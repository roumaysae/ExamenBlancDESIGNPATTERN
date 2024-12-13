package com.roumaysae.entities;

import com.roumaysae.implementations.DefaultStrategy;
import com.roumaysae.interfaces.NotificationStrategy;
import com.roumaysae.interfaces.Observable;
import com.roumaysae.interfaces.Observer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Agent implements Observable, Observer {
    private String nom;
    private List<Transaction> transactions = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();
    private NotificationStrategy strategy;


    public Agent(String nom) {
        this.nom = nom;
        this.strategy = new DefaultStrategy();

    }

    // Implémentation de Observable
    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String agentName, Transaction transaction) {
        for (Observer observer : observers) {
            observer.update(agentName, transaction);
        }
    }

    // Implémentation de Observer
    @Override
    public void update(String agentName, Transaction transaction) {
        System.out.println("Agent: " + agentName + " a ajouté la transaction: " + transaction);
    }

    public String getNom() {
        return nom;
    }
    public NotificationStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(NotificationStrategy strategy) {
        this.strategy = strategy;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Ajouter une transaction et notifier
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        notifyObservers(this.nom,transaction);
        // Appliquer la stratégie de notification
        strategy.handleNotification(this.nom, transaction);
    }

    // Affichage du nom et des transactions
    public void afficherTransactions() {
        System.out.println("Agent: " + nom);
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
    // Calculer et retourner la transaction ayant le montant le plus grand
    public Transaction getTransactionMaxMontant() {
        return transactions.stream()
                .max(Comparator.comparingDouble(Transaction::getMontant))
                .orElse(null);
    }
    @Override
    public String toString() {
        return "Agent: " + nom + ", Transactions: " + transactions;
    }


}
