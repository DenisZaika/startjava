package com.startjava.lesson_2_3_4.hangman;

import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        HangmanGame hangman = new HangmanGame();
        Scanner scan = new Scanner(System.in);
        String playerAnswer;
        do {
            hangman.start();
            System.out.print("Хотите продолжить игру? [yes/no]: ");
            playerAnswer = scan.nextLine().toLowerCase();
            if (!"yes".equals(playerAnswer) && !"no".equals(playerAnswer)) {
                playerAnswer = getValidAnswer(scan);
            }
        } while ("yes".equals(playerAnswer));
    }

    private static String getValidAnswer(Scanner scan) {
        String playerAnswer;
        do {
            System.out.print("Введите корректный ответ [yes / no]: ");
            playerAnswer = scan.nextLine().toLowerCase();
        } while (!"yes".equals(playerAnswer) && !"no".equals(playerAnswer));
        return playerAnswer;
    }
}