package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class TransactionReverser {

    public static void main(String[] args) {
        int[][] allTransactionsList = {
                new int[0],
                null,
                new int[]{5},
                new int[]{6, 8, 9, 1},
                new int[]{13, 8, 5, 3, 2, 1, 1}};
        for (int[] transactionsList : allTransactionsList) {
            showTransactions(transactionsList, reverseTransactions(transactionsList));
        }
    }

    private static int[] reverseTransactions(int[] transactionsList) {
        if (transactionsList == null || transactionsList.length == 0) {
            return transactionsList;
        }
        int len = transactionsList.length;
        int[] reversedTransactionsList = new int[len];
        for (int transaction : transactionsList) {
            len--;
            reversedTransactionsList[len] = transaction;
        }
        return reversedTransactionsList;
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