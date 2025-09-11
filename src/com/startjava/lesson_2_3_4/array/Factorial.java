package com.startjava.lesson_2_3_4.array;

public class Factorial {

    public static void main(String[] args) {
        int[] numbersForFactorial1 = new int[0];
        showNumberFactorial(numbersForFactorial1, calculateFactorial(numbersForFactorial1));
        int[] numbersForFactorial2 = null;
        showNumberFactorial(numbersForFactorial2, calculateFactorial(numbersForFactorial2));
        int[] numbersForFactorial3 = new int[]{8, 0, 9};
        showNumberFactorial(numbersForFactorial3, calculateFactorial(numbersForFactorial3));
        int[] numbersForFactorial4 = new int[]{-3, 1, 7, 13};
        showNumberFactorial(numbersForFactorial4, calculateFactorial(numbersForFactorial4));
        int[] numbersForFactorial5 = new int[]{-22, -0};
        showNumberFactorial(numbersForFactorial5, calculateFactorial(numbersForFactorial5));
    }

    private static long[] calculateFactorial(int... args) {
        if (args == null) {
            System.out.println("Ошибка в данных");
            return null;
        }
        if (args.length == 0) {
            System.out.print("Нет данных\n");
            return null;
        }
        long[] factorials = new long[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i] < 0) {
                System.out.println("Ошибка: факториал " + args[i] + "! не определен");
                factorials[i] = -1;
                continue;
            }
            long factorial = 1;
            for (int j = 2; j <= args[i]; j++) {
                factorial *= j;
            }
            factorials[i] = factorial;
        }
        return factorials;
    }

    private static void showNumberFactorial(int[] numbersForFactorial, long[] factorials) {
        if (numbersForFactorial == null || factorials == null) {
            return;
        }
        for (int i = 0; i < factorials.length; i++) {
            if (factorials[i] == -1) {
                continue;
            }
            System.out.print(numbersForFactorial[i] + "! = ");
            if (numbersForFactorial[i] == 0) {
                System.out.println("1");
                continue;
            }
            for (int j = 0; j < numbersForFactorial[i]; j++) {
                System.out.print(j + 1);
                System.out.print(j != numbersForFactorial[i] - 1 ? " * " : " = " + factorials[i] + "\n");
            }
        }
    }
}
