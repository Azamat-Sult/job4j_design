package ru.job4j.calculator;

import static ru.job4j.math.MathFunction.*;

public class MathCalculator {

    public static double sumAndMultiply(double first, double second) {
        return sum(first, second)
                + multiply(first, second);
    }

    public static double subtractAndDivide(double first, double second) {
        return subtract(first, second)
                + divide(first, second);
    }

    public static double sumAll(double first, double second) {
        return sumAndMultiply(first, second)
                + subtractAndDivide(first, second);
    }

    public static void main(String[] args) {
        System.out.println("Результат расчета равен: " + sumAll(10, 20));
    }
}
