package com.ai.agents;

import com.ai.messages.Message;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class Agent3 extends Agent{
    @Override
    protected void setup() {
        System.out.println("Initialized " + getLocalName());
        addBehaviour(new CurrentBehaviour());
    }

    class CurrentBehaviour extends CyclicBehaviour {
        @Override
        public void action() {
            ACLMessage acl = blockingReceive();
            System.out.println(acl.toString());
            Message.send(ACLMessage.INFORM, "Agent2", this.getAgent(), "COD001", "From Aggent 2", null);
        }
    } 
}
