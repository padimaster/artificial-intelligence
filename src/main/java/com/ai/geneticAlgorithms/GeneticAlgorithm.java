package com.ai.geneticAlgorithms;

import java.util.logging.Logger;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;

import com.ai.utils.Printer;

public class GeneticAlgorithm {
    private Configuration config;
    private Genotype population;
    private int populationSize;
    private int chromosomeLength;

    public GeneticAlgorithm(int chromosomeLength, int populationSize) {
        this.chromosomeLength = chromosomeLength;
        this.populationSize = populationSize;
        this.configure();
    }

    private void configure() {
        Gene[] genes;
        Chromosome chromosome;
        
        config = new DefaultConfiguration();

        try {
            config.setFitnessFunction(new MyFitnessFunction());

            genes = new Gene[chromosomeLength];

            for (int i = 0; i < genes.length; i++) {
                genes[i] = new IntegerGene(config, 0, 1);
            }

            chromosome = new Chromosome(config, genes);

            config.setSampleChromosome(chromosome);
            config.setPopulationSize(populationSize);

            population = Genotype.randomInitialGenotype(config);

        } catch (InvalidConfigurationException e) {
            Logger.getLogger(GeneticAlgorithm.class.getName()).severe(e.getMessage());
        }
    }

    public void run(int generations, int evolutions) {
        for (int i = 0; i < generations; i++) {
            System.out.println("\n\nGeneration: " + i);
            Printer.viewPopulation(population.getPopulation().getChromosomes());
            population.evolve(evolutions);

            System.out.println("\nFittest Chromosome: ");
            Printer.viewIndividual(population.getFittestChromosome());
        }
    }
}
