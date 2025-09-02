package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class TransactionReverser {

    public static void main(String[] args) {
        int[] transactions1 = new int[0];
        showTransactions(transactions1, reverseTransactions(transactions1));
        int[] transactions2 = null;
        showTransactions(transactions2, reverseTransactions(transactions2));
        int[] transactions3 = new int[]{5};
        showTransactions(transactions3, reverseTransactions(transactions3));
        int[] transactions4 = new int[]{6, 8, 9, 1};
        showTransactions(transactions4, reverseTransactions(transactions4));
        int[] transactions5 = new int[]{13, 8, 5, 3, 2, 1, 1};
        showTransactions(transactions5, reverseTransactions(transactions5));
    }

    private static int[] reverseTransactions(int[] transactions) {
        if (transactions == null || transactions.length == 0) {
            return transactions;
        }
        int len = transactions.length;
        int[] reversedTransactions = new int[len];
        int i = 0;
        for (int transaction : transactions) {
            reversedTransactions[len - i - 1] = transaction;
            i++;
        }
        return reversedTransactions;
    }

    private static void showTransactions(int[] transactions, int[] reversedTransactions) {
        if (transactions == null) {
            System.out.println("Ошибка в данных");
            return;
        }
        if (transactions.length == 0) {
            System.out.println("Нет данных\n");
            return;
        }
        System.out.print("\nИсходные транзакции: " + Arrays.toString(transactions));
        System.out.println("\n В обратном порядке: " + Arrays.toString(reversedTransactions));
    }
}