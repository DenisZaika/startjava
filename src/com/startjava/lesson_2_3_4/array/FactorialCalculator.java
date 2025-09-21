package com.startjava.lesson_2_3_4.array;

public class FactorialCalculator {
    public static void main(String[] args) {
        int[][] inputNumbers = {
                {},
                null,
                {8, 0, 9},
                {-3, 1, 7, 13},
                {-22, -0}
        };
        for (int[] number : inputNumbers) {
            printFactorialExpressions(number, calculate(number));
        }
    }

    private static long[] calculate(int... inputNumbers) {
        if (inputNumbers == null) {
            System.out.println("Ошибка в данных");
            return null;
        }
        if (inputNumbers.length == 0) {
            System.out.print("Нет данных\n");
            return null;
        }
        long[] factorials = new long[inputNumbers.length];
        for (int i = 0; i < inputNumbers.length; i++) {
            if (inputNumbers[i] < 0) {
                System.out.println("Ошибка: факториал " + inputNumbers[i] + "! не определен");
                continue;
            }
            long factorial = 1;
            for (int j = 2; j <= inputNumbers[i]; j++) {
                factorial *= j;
            }
            factorials[i] = factorial;
        }
        return factorials;
    }

    private static void printFactorialExpressions(int[] inputNumbers, long[] factorials) {
        if (inputNumbers == null || factorials == null) {
            return;
        }
        for (int i = 0; i < factorials.length; i++) {
            if (factorials[i] == 0) {
                continue;
            }
            StringBuilder factorialExp = new StringBuilder();
            factorialExp.append(inputNumbers[i]);
            factorialExp.append("! = ");
            if (inputNumbers[i] == 0 || inputNumbers[i] == 1) {
                factorialExp.append("1");
                System.out.println(factorialExp);
                continue;
            }
            for (int j = 0; j < inputNumbers[i]; j++) {
                factorialExp.append(j + 1)
                            .append(j != inputNumbers[i] - 1 ? " * " : " = ")
                            .append(j != inputNumbers[i] - 1 ? "" : factorials[i])
                            .append(j != inputNumbers[i] - 1 ? "" : "\n");
            }
            System.out.print(factorialExp);
        }
    }
}
