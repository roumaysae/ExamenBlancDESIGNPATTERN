package com.roumaysae.interfaces;

import com.roumaysae.entities.Transaction;

public interface NotificationStrategy {
        void handleNotification(String agentName, Transaction transaction);
}

