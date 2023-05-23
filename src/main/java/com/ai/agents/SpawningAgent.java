package com.ai.agents;

import com.ai.messages.Message;

import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

public class SpawningAgent extends Agent {
    
    @Override
    protected void setup() {
        addBehaviour(new CurrentBehaviour());
    }

    class CurrentBehaviour extends OneShotBehaviour {
        @Override
        public void action() {
            try {
                String newAgentName = "Agent " + (Integer.parseInt(myAgent.getLocalName().substring(6)) + 1);
                // Create a new agent
                AgentController ac = getContainerController().createNewAgent(newAgentName, "SelfDestructAgent", null);
                ac.start();

                // Send a message to the new agent
                ACLMessage acl = blockingReceive();
                System.out.println(acl.toString());
            } catch (StaleProxyException e) {
                e.printStackTrace();
            }
        }
    }
}
