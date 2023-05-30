package com.ai.geneticAlgorithms;

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

import com.ai.utils.MyMath;

public class MyFitnessFunction extends FitnessFunction{

    @Override
    protected double evaluate(IChromosome individualChromosome) {
        int numberValue;
        int decimalValue;
        double result;
        double totalNumber;

        int xSign = (Integer) individualChromosome.getGene(0).getAllele();

        int x1 = (Integer) individualChromosome.getGene(1).getAllele();
        int x2 = (Integer) individualChromosome.getGene(2).getAllele();
        int x3 = (Integer) individualChromosome.getGene(3).getAllele();
        int x4 = (Integer) individualChromosome.getGene(4).getAllele();

        int decimal1 = (Integer) individualChromosome.getGene(6).getAllele();
        int decimal2 = (Integer) individualChromosome.getGene(7).getAllele();

        String xBinaryString = x1 + "" + x2 + "" + x3 + "" + x4;
        String decimalString = decimal1 + "" + decimal2;

        numberValue = Integer.parseInt(xBinaryString, 2);
        decimalValue = Integer.parseInt(decimalString, 2);

        if (xSign == 1) {
            numberValue = numberValue * -1;
        }

        totalNumber = numberValue + (decimalValue * 0.01);

        result = MyMath.logarithEquation(totalNumber);

        return result;
    }
    
}
