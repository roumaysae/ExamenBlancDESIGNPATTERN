package com.roumaysae.containers;

import com.roumaysae.entities.Agent;

import java.util.HashMap;
import java.util.Map;

public class ContainerAgent {
     // Singleton instance
        private static ContainerAgent instance;

        // HashMap for storing agents
        private Map<String, Agent> agents;

        // Private constructor
        private ContainerAgent() {
            agents = new HashMap<>();
        }

        // Method to get the singleton instance
        public static synchronized ContainerAgent getInstance() {
            if (instance == null) {
                instance = new ContainerAgent();
            }
            return instance;
        }

        // Add an agent to the container
        public void addAgent(Agent agent) {
            if (agent != null && !agents.containsKey(agent.getNom())) {
                agents.put(agent.getNom(), agent);
                System.out.println("Agent added: " + agent.getNom());
            } else {
                System.out.println("Agent already exists or is invalid.");
            }
        }

        // Remove an agent by name
        public void removeAgent(String name) {
            if (agents.containsKey(name)) {
                agents.remove(name);
                System.out.println("Agent removed: " + name);
            } else {
                System.out.println("Agent not found.");
            }
        }

        // Find an agent by name
        public Agent findAgent(String name) {
            return agents.get(name);
        }

        // Display all agents and their transactions
        public void displayAllAgents() {
            if (agents.isEmpty()) {
                System.out.println("No agents registered.");
            } else {
                for (Agent agent : agents.values()) {
                    agent.toString();
                }
            }
        }
    }

