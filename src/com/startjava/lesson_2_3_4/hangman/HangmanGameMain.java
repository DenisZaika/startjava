package com.startjava.lesson_2_3_4.hangman;

import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        HangmanGame hangman = new HangmanGame();
        Scanner scan = new Scanner(System.in);
        String playerAnswer = "yes";
        boolean isCorrect = true;
        do {
            if (isCorrect) {
                if (playerAnswer.equals("no")) {
                    break;
                }
                hangman.start();
                System.out.print("Хотите продолжить игру? [yes/no]: ");
            } else {
                System.out.print("Введите корректный ответ [yes / no]: ");
            }
            playerAnswer = scan.nextLine().toLowerCase();
            isCorrect = playerAnswer.equals("yes") || playerAnswer.equals("no");
        } while (true);
    }
}