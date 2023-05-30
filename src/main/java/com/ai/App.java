package com.ai;

import com.ai.geneticAlgorithms.GeneticAlgorithm;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(8, 10);
        geneticAlgorithm.run(100, 5);
    }
}
