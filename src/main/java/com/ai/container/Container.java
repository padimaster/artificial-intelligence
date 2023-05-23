package com.ai.container;

import com.ai.agents.Agent1;
import com.ai.agents.Agent2;
import com.ai.agents.Agent3;
import com.ai.agents.Agent4;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

public class Container {
    AgentController agenteController;
    AgentContainer mainContainer;
    Object[] contenedor = new Object[1];

    public void contenedor() {
        Runtime runtime = jade.core.Runtime.instance();

        runtime.setCloseVM(true);
        System.out.println("Runtime ha sido creado\n");

        Profile profile = new ProfileImpl(null, 1099, null);
        System.out.println("Perfil por defecto creado");

        mainContainer = runtime.createMainContainer(profile);
        System.out.println("Contenedor creado" + profile.toString());
        contenedor[0] = this;
        initAgents();
    }

    private void initAgents() {

        try {
            mainContainer.createNewAgent("Agent1", Agent1.class.getName(), null).start();
            mainContainer.createNewAgent("Agent2", Agent2.class.getName(), null).start();
            mainContainer.createNewAgent("Agent3", Agent3.class.getName(), null).start();
            mainContainer.createNewAgent("Agent4", Agent4.class.getName(), null).start();
//
        } catch (StaleProxyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Container().contenedor();
    }
}
