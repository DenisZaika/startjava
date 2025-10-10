package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Scanner;

public class GuessNumber {
    private static final int RANGE_MIN = 1;
    private static final int RANGE_MAX = 100;

    private final Player player1;
    private final Player player2;
    private int secretNumber;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        secretNumber = (int) (Math.random() * RANGE_MAX + RANGE_MIN);
        System.out.println("\nИгра началась! У каждого игрока по " + Player.MAX_ATTEMPTS + " попыток");
        Player currPlayer = player1;
        boolean gameWon = false;
        do {
            currPlayer.incrementAttempts();
            if (isCorrectGuess(processPlayerMove(currPlayer), currPlayer)) {
                gameWon = true;
            } else {
                handleIncorrectGuess(currPlayer);
                currPlayer = currPlayer == player1 ? player2 : player1;
            }
        } while ((player1.hasAttempts() || player2.hasAttempts()) && !gameWon);
        if (!gameWon) {
            System.out.println("\nНикто не угадал число!");
        }
        System.out.println("\nЗагаданное число: " + secretNumber);
        System.out.println("Введенные числа игроков: ");
        printPlayerNumbers(player1);
        printPlayerNumbers(player2);
        resetGame();
    }

    private int processPlayerMove(Player player) {
        System.out.println("\nПопытка " + player.getAttemptNumber());
        System.out.printf("Число вводит %s: ", player.getName());
        return inputNumber(player);
    }

    private int inputNumber(Player player) {
        Scanner scan = new Scanner(System.in);
        int playerGuess;
        do {
            try {
                playerGuess = scan.nextInt();
                player.setNumbers(playerGuess);
                return playerGuess;
            } catch (InvalidNumberException e) {
                System.out.print(e.getMessage());
            }
        } while (true);
    }

    private boolean isCorrectGuess(int playerGuess, Player player) {
        if (playerGuess == secretNumber) {
            System.out.printf("%s угадал число %d с %d-й попытки%n", player.getName(), playerGuess,
                    player.getAttemptNumber());
            return true;
        }
        return false;
    }

    private void handleIncorrectGuess(Player player) {
        giveHint(player.getNumbers()[player.getAttemptNumber() - 1]);
        System.out.printf("Игрок %s не угадал число. Ход переходит к следующему игроку%n",
                player.getName());
        if (player.getAttemptNumber() == Player.MAX_ATTEMPTS) {
            System.out.println("У " + player.getName() + " закончились попытки");
        }
    }

    private void giveHint(int playerGuess) {
        String hint = playerGuess < secretNumber ? "меньше" : "больше";
        System.out.printf("%d %s того, что загадал компьютер%n", playerGuess, hint);
    }

    private void printPlayerNumbers(Player player) {
        System.out.println(player.getName() + ": " +
                Arrays.toString(player.getNumbers()).replaceAll("[\\[\\],]", ""));
    }

    private void resetGame() {
        player1.cleanNumbers();
        player1.resetAttempts();
        player2.cleanNumbers();
        player2.resetAttempts();
    }
}