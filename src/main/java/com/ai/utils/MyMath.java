package com.ai.utils;

public class MyMath {
    public static double logarithEquation(double x) {
        double result;

        result = Math.pow(x, 2);
        result = Math.log(result);

        result = Math.pow(result, 1/3);

        return result;
    }
}
