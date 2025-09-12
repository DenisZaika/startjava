package com.startjava.lesson_2_3_4.array;

public class FactorialCalculator {

    public static void main(String[] args) {
        int[][] factorialInputLists = {
                new int[0],
                null,
                new int[]{8, 0, 9},
                new int[]{-3, 1, 7, 13},
                new int[]{-22, -0}
        };
        for (int[] factorialInputs : factorialInputLists) {
            showNumberFactorial(factorialInputs, calculateFactorial(factorialInputs));
        }
    }

    private static long[] calculateFactorial(int... factorialInputs) {
        if (factorialInputs == null) {
            System.out.println("Ошибка в данных");
            return null;
        }
        if (factorialInputs.length == 0) {
            System.out.print("Нет данных\n");
            return null;
        }
        long[] factorials = new long[factorialInputs.length];
        for (int i = 0; i < factorialInputs.length; i++) {
            if (factorialInputs[i] < 0) {
                System.out.println("Ошибка: факториал " + factorialInputs[i] + "! не определен");
                continue;
            }
            long factorial = 1;
            for (int j = 2; j <= factorialInputs[i]; j++) {
                factorial *= j;
            }
            factorials[i] = factorial;
        }
        return factorials;
    }

    private static void showNumberFactorial(int[] factorialInputs, long[] factorials) {
        if (factorialInputs == null || factorials == null) {
            return;
        }
        for (int i = 0; i < factorials.length; i++) {
            if (factorials[i] == 0) {
                continue;
            }
            StringBuilder factorialExp = new StringBuilder(factorialInputs[i] + "! = ");
            if (factorialInputs[i] == 0 || factorialInputs[i] == 1) {
                factorialExp.append("1");
                System.out.println(factorialExp);
                continue;
            }
            for (int j = 0; j < factorialInputs[i]; j++) {
                factorialExp.append(j + 1);
                factorialExp.append(j != factorialInputs[i] - 1 ? " * " : " = " + factorials[i] + "\n");
            }
            System.out.print(factorialExp);
        }
    }
}
