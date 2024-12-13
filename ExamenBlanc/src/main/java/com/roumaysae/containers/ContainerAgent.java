package com.roumaysae.containers;

import com.roumaysae.entities.Agent;
import com.roumaysae.interfaces.HDMI;

import java.util.HashMap;
import java.util.Map;

public class ContainerAgent {
    private static ContainerAgent instance;
    private Map<String, Agent> agents;
    private HDMI display;

    private ContainerAgent() {
        agents = new HashMap<>();
    }

    // Singleton pattern
    public static synchronized ContainerAgent getInstance() {
        if (instance == null) {
            instance = new ContainerAgent();
        }
        return instance;
    }

    // Configuration de l'afficheur
    public void setDisplay(HDMI display) {
        this.display = display;
    }

    // Ajout d'un agent
    public void addAgent(Agent agent) {
        if (agent != null && !agents.containsKey(agent.getNom())) {
            agents.put(agent.getNom(), agent);
        }
    }

    // Suppression d'un agent
    public void removeAgent(String agentName) {
        agents.remove(agentName);
    }

    // Recherche d'un agent
    public Agent getAgent(String agentName) {
        return agents.get(agentName);
    }

    // Affichage de tous les agents
    public void displayAllAgents() {
        if (display == null) {
            throw new IllegalStateException("Aucun afficheur HDMI connecté !");
        }
        if (agents.isEmpty()) {
            display.display("Aucun agent enregistré.");
        } else {
            display.display("Agents enregistrés :");
            agents.values().forEach(agent -> display.display(" - " + agent.getNom()));
        }
    }
}
