package com.startjava.lesson_2_3_4.array;

public class TransactionReverserMain {

    public static void main(String[] args) {
        showResult(new int[0], processTransactions(new int[0]));
        showResult(null, processTransactions(null));
        showResult(new int[]{5}, processTransactions(new int[]{5}));
        showResult(new int[]{6, 8, 9, 1}, processTransactions(new int[]{6, 8, 9, 1}));
        showResult(new int[]{13, 8, 5, 3, 2, 1, 1}, processTransactions(new int[]{13, 8, 5, 3, 2, 1, 1}));
    }

    private static int[] processTransactions(int[] transactions) {
        if (transactions == null || transactions.length == 0) {
            return transactions;
        }
        int len = transactions.length;
        int[] reversedTransactions = new int[len];
        for (int i = 0; i < len; i++) {
            reversedTransactions[i] = transactions[len - i - 1];
        }
        return reversedTransactions;
    }

    private static void showResult(int[] transactions, int[] reversedTransactions) {
        if (transactions == null) {
            System.out.println("Ошибка в данных");
            return;
        }
        if (transactions.length == 0) {
            System.out.println("Нет данных\n");
            return;
        }
        System.out.print("\nИсходные транзакции: " + java.util.Arrays.toString(transactions));
        System.out.println("\n В обратном порядке: " + java.util.Arrays.toString(reversedTransactions));
    }
}