package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 100;
    public static final int PLAYER_COUNT = 2;

    private final Player player1;
    private final Player player2;
    private int secretNumber;
    private Player currPlayer;
    private final Scanner scan;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        scan = new Scanner(System.in);
    }

    public void start() {
        initGame();
        Random r = new Random();
        secretNumber = r.nextInt(MIN_RANGE, MAX_RANGE + 1);
        System.out.println("\nИгра началась! У каждого игрока по " + Player.MAX_ATTEMPTS + " попыток");
        boolean gameWon = false;
        int inactivePlayerCount = 0;
        do {
            tryGuess(currPlayer);
            if (isGuessed(currPlayer)) {
                gameWon = true;
                break;
            }
            if (!currPlayer.hasAttempts()) {
                inactivePlayerCount++;
                System.out.println("У " + currPlayer.getName() + " закончились попытки");
            }
            changeCurrPlayer();
        } while (inactivePlayerCount < PLAYER_COUNT);
        if (!gameWon) {
            System.out.println("\nНикто не угадал число!");
        }
        System.out.println("\nЗагаданное число: " + secretNumber);
        System.out.println("Введенные числа игроков: ");
        printPlayerNumbers(player1);
        printPlayerNumbers(player2);
    }

    private void initGame() {
        currPlayer = player1;
        player1.clear();
        player2.clear();
    }

    private void tryGuess(Player player) {
        currPlayer.increaseCurrAttempt();
        System.out.println("\nПопытка " + (player.getCurrAttempt()));
        System.out.printf("Число вводит %s: ", player.getName());
        inputNumber(player);
    }

    private void inputNumber(Player player) {
        do {
            try {
                player.addNumber(scan.nextInt());
                return;
            } catch (InvalidNumberException e) {
                System.out.print(e.getMessage());
            }
            System.out.print("Попробуйте еще раз: ");
        } while (true);
    }

    private boolean isGuessed(Player player) {
        int playerGuess = player.getCurrNumber();
        if (playerGuess == secretNumber) {
            System.out.printf("%s угадал число %d с %d-й попытки%n",
                    player.getName(), secretNumber, player.getCurrAttempt());
            return true;
        }
        String hint = playerGuess < secretNumber ? "меньше" : "больше";
        System.out.printf("%d %s того, что загадал компьютер%n", playerGuess, hint);
        System.out.printf("Игрок %s не угадал число. Ход переходит к следующему игроку%n",
                player.getName());
        return false;
    }

    private void changeCurrPlayer() {
        currPlayer = currPlayer == player1 ? player2 : player1;
    }

    private void printPlayerNumbers(Player player) {
        System.out.println(player.getName() + ": " +
                Arrays.toString(player.getNumbers()).replaceAll("[\\[\\],]", ""));
    }
}