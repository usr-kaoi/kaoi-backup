package com.erudio.api_rest_math.math;

public class SimpleMath {

    public Double sum(Double numberOne, Double numberTwo) {
        return numberOne + numberTwo;
    }

    public Double difference(Double numberOne, Double numberTwo) {
        return numberOne - numberTwo;
    }

    public Double product(Double numberOne, Double numberTwo) {
        return numberOne * numberTwo;
    }

    public Double quotient (Double numberOne, Double numberTwo) {
        return numberOne / numberTwo;
    }

    public Double mean(Double numberOne, Double numberTwo) {
        return (numberOne + numberTwo) / 2;
    }

    public Double root(Double number) {
        return Math.sqrt(number);
    }
}
