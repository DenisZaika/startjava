package com.startjava.lesson_1.final_;

import java.util.Random;

// Игра Камень-Ножницы-Бумага
public class RpsGameFormatting {
    public static void main(String[] args) throws InterruptedException {
        String rock = "R";
        String scissors = "S";
        String paper = "P";

        // Ход первого игрока
        String firstPlayerName = "HELL";
        Random random = new Random();
        int firstPlayerPosition = random.nextInt(1, 100);
        String firstPlayerSign = rock;
        if (firstPlayerPosition > 66) {
            firstPlayerSign = paper;
        } else if (firstPlayerPosition > 33) {
            firstPlayerSign = scissors;
        }
        System.out.printf("Ход %s: %n", firstPlayerName);
        for (int i = 0; i < 5; i++) {
            System.out.print(rock + "\r");
            Thread.sleep(100);
            System.out.print(scissors + "\r");
            Thread.sleep(100);
            System.out.print(paper + "\r");
            Thread.sleep(100);
        }
        System.out.println(firstPlayerSign);

        // Ход второго игрока
        String secondPlayerName = "WALLE";
        int secondPlayerPosition = random.nextInt(1, 100);
        String secondPlayerSign = rock;
        if (secondPlayerPosition > 66) {
            secondPlayerSign = paper;
        } else if (secondPlayerPosition > 33) {
            secondPlayerSign = scissors;
        }
        System.out.printf("Ход %s: %n", secondPlayerName);
        for (int i = 0; i < 5; i++) {
            System.out.print(rock + "\r");
            Thread.sleep(100);
            System.out.print(scissors + "\r");
            Thread.sleep(100);
            System.out.print(paper + "\r");
            Thread.sleep(100);
        }
        System.out.println(secondPlayerSign);
        if (firstPlayerSign.equals(secondPlayerSign)) {
            System.out.println("Победила дружба!");
            return;
        }
        boolean isFirstPlayerWinner = firstPlayerSign.equals(rock) && secondPlayerSign.equals(scissors) ||
                firstPlayerSign.equals(scissors) && secondPlayerSign.equals(paper) ||
                firstPlayerSign.equals(paper) && secondPlayerSign.equals(rock);
        String winnerName = secondPlayerName;
        if (isFirstPlayerWinner) {
            winnerName = firstPlayerName;
        }
        System.out.printf("Победитель - %s", winnerName);
    }
}