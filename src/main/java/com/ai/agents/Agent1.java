package com.ai.agents;

import com.ai.messages.Message;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class Agent1 extends Agent {
    
    @Override
    protected void setup() {
        System.out.println("Initialized " + getLocalName());
        addBehaviour(new CurrentBehaviour());
    }

    class CurrentBehaviour extends CyclicBehaviour {
        @Override
        public void action() {
            System.out.println(getName() + ": Sending message to Aggent 2");
            Message.send(ACLMessage.REQUEST, "Agent2", this.getAgent(), "COD001", "From Aggent 1", null);
            ACLMessage acl = blockingReceive();
            System.out.println(acl.toString());
        }
    }
}