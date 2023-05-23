package com.ai.messages;


import jade.core.AID;
import jade.core.Agent;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import jade.util.leap.Serializable;

public class Message {
    public static void send(int messageType, String receiver, Agent sender, String messageIDString, String messageContent, Serializable serializable) { 
        ACLMessage msg = new ACLMessage(messageType);
        AID aid = new AID();
        aid.setLocalName(receiver);
        msg.addReceiver(aid);
        msg.setSender(sender.getAID());
        msg.setLanguage(FIPANames.ContentLanguage.FIPA_SL);
        msg.setConversationId(messageIDString);
        
        if (messageContent != null) {
            msg.setContent(messageContent);
        }

        if (serializable != null) {
            try {
                msg.setContentObject(serializable);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        sender.send(msg);
    }
}
