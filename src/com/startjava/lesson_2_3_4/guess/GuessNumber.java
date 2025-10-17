package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static final int RANGE_MIN = 1;
    public static final int RANGE_MAX = 100;

    private final Player player1;
    private final Player player2;
    private int secretNumber;
    private final Scanner scan;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        scan = new Scanner(System.in);
    }

    public void start() {
        initGame();
        Random r = new Random();
        secretNumber = (r.nextInt(RANGE_MIN, RANGE_MAX + 1));
        System.out.println("\nИгра началась! У каждого игрока по " + Player.MAX_ATTEMPTS + " попыток");
        Player currPlayer = player1;
        boolean gameWon = false;
        do {
            if (isGuessed(tryGuess(currPlayer), currPlayer)) {
                gameWon = true;
            } else {
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
    }

    private void initGame() {
        player1.clear();
        player2.clear();
    }

    private int tryGuess(Player player) {
        System.out.println("\nПопытка " + player.getAttemptCount());
        System.out.printf("Число вводит %s: ", player.getName());
        return inputNumber(player);
    }

    private int inputNumber(Player player) {
        int playerGuess;
        do {
            try {
                playerGuess = scan.nextInt();
                player.addNumber(playerGuess);
                return playerGuess;
            } catch (InvalidNumberException e) {
                System.out.print(e.getMessage());
            }
        } while (true);
    }

    private boolean isGuessed(int playerGuess, Player player) {
        if (playerGuess == secretNumber) {
            System.out.printf("%s угадал число %d с %d-й попытки%n", player.getName(), playerGuess,
                    player.getAttemptCount() - 1);
            return true;
        }
        String hint = playerGuess < secretNumber ? "меньше" : "больше";
        System.out.printf("%d %s того, что загадал компьютер%n", playerGuess, hint);
        System.out.printf("Игрок %s не угадал число. Ход переходит к следующему игроку%n",
                player.getName());
        if (player.getAttemptCount() == Player.MAX_ATTEMPTS) {
            System.out.println("У " + player.getName() + " закончились попытки");
        }
        return false;
    }

    private void printPlayerNumbers(Player player) {
        System.out.println(player.getName() + ": " +
                Arrays.toString(player.getNumbers()).replaceAll("[\\[\\],]", ""));
    }
}