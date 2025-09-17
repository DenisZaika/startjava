package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class UniqueNumbersArray {

    public static void main(String[] args) {
        printUniqueNumbers(createArray(-30, -10, 23), 23);
        printUniqueNumbers(createArray(10, 50, 10), 10);
        printUniqueNumbers(createArray(-34, -34, 1), 1);
        printUniqueNumbers(createArray(-1, 2, -3), -3);
        printUniqueNumbers(createArray(5, -8, 2), 2);
    }

    private static int[] createArray(int rangeStart, int rangeEnd, int numbersPerString) {
        if (numbersPerString < 1) {
            System.out.printf("\nОшибка: количество чисел в строке не должно быть < 1 (%d)%n", numbersPerString);
            return new int[0];
        }
        if (rangeStart > rangeEnd) {
            System.out.printf("\nОшибка: левая граница (%d) > правой (%d)%n", rangeStart, rangeEnd);
            return new int[0];
        }
        int len = (int) (0.75 * (rangeEnd - rangeStart + 1));
        if (len <= 0) {
            System.out.printf("\nОшибка: длина массива должна быть > 0 (%d)%n", len);
            return new int[0];
        }

        int[] uniqueNumbers = new int[len];
        Random r = new Random();
        for (int i = 0; i < len; i++) {
            while (true) {
                int number = r.nextInt(rangeStart, rangeEnd + 1);
                boolean isUniqueNumber = true;
                for (int j = 0; j < i; j++) {
                    if (number == uniqueNumbers[j]) {
                        isUniqueNumber = false;
                        break;
                    }
                }
                if (isUniqueNumber) {
                    uniqueNumbers[i] = number;
                    break;
                }
            }
        }
        return uniqueNumbers;
    }

    private static void printUniqueNumbers(int[] uniqueNumbers, int numbersPerString) {
        if (uniqueNumbers.length == 0) {
            return;
        }
        Arrays.sort(uniqueNumbers);
        System.out.println("\n\nМассив уникальных чисел:");
        for (int i = 0; i < uniqueNumbers.length; i++) {
            System.out.print(uniqueNumbers[i] + " ");
            if ((i + 1) % numbersPerString == 0) {
                System.out.println();
            }
        }
    }
}
