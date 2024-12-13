package com.roumaysae.interfaces;

import com.roumaysae.entities.Transaction;

public interface Observable {
    void subscribe(Observer observer);    // Ajouter un abonné
    void unsubscribe(Observer observer);  // Supprimer un abonné
    void notifyObservers(String agentName, Transaction transaction);  // Notifier les abonnés
}
