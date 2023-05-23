package com.ai.agents;

import com.ai.messages.Message;

import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

public class ChildAgent extends Agent {
    
    @Override
    protected void setup() {
        addBehaviour(new CurrentBehaviour());
    }

    class CurrentBehaviour extends OneShotBehaviour {
        @Override
        public void action() {
            System.out.println(getName());
            

            Message.send(ACLMessage.REQUEST, "Agent2", this.getAgent(), "COD002", "From Aggent 2", null);
        }
    }
}
