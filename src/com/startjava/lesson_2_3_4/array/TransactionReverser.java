package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class TransactionReverser {
    public static void main(String[] args) {
        int[][] originTransactions = {
                {},
                null,
                {5},
                {6, 8, 9, 1},
                {13, 8, 5, 3, 2, 1, 1}};
        for (int[] transactions : originTransactions) {
            showTransactions(transactions, reverseTransactions(transactions));
        }
    }

    private static int[] reverseTransactions(int[] transactions) {
        if (transactions == null || transactions.length == 0) {
            return transactions;
        }
        int len = transactions.length;
        int[] reversedTransactions = new int[len];
        for (int transaction : transactions) {
            reversedTransactions[--len] = transaction;
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