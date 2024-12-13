package com.roumaysae.interfaces;

import com.roumaysae.entities.Transaction;

public interface Observer {
    void update(String agentName, Transaction transaction);  // Réagir à une notification
}
