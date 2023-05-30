package com.ai.utils;

import java.util.List;

import org.jgap.IChromosome;

public class Printer {
    public static void viewPopulation(List<IChromosome> population){
        for (IChromosome individualChromosome : population) {
            viewIndividual(individualChromosome);
        }
    }

    public static void viewIndividual(IChromosome individualChromosome){
        int xValue;
        int yValue;
        double result;

        int xSign = (Integer) individualChromosome.getGene(0).getAllele();
        int ySign = (Integer) individualChromosome.getGene(5).getAllele();

        int x1 = (Integer) individualChromosome.getGene(1).getAllele();
        int x2 = (Integer) individualChromosome.getGene(2).getAllele();
        int x3 = (Integer) individualChromosome.getGene(3).getAllele();
        int x4 = (Integer) individualChromosome.getGene(4).getAllele();

        int y1 = (Integer) individualChromosome.getGene(6).getAllele();
        int y2 = (Integer) individualChromosome.getGene(7).getAllele();
        int y3 = (Integer) individualChromosome.getGene(8).getAllele();
        int y4 = (Integer) individualChromosome.getGene(9).getAllele();

        String xBinaryString = x1 + "" + x2 + "" + x3 + "" + x4;
        String yBinaryString = y1 + "" + y2 + "" + y3 + "" + y4;

        xValue = Integer.parseInt(xBinaryString, 2);
        yValue = Integer.parseInt(yBinaryString, 2);

        if (xSign == 1) {
            xValue = xValue * -1;
        }

        if (ySign == 1) {
            yValue = yValue * -1;
        }

        System.out.println("(" + xValue + " , " + yValue + ")");
    }
}
