package com.startjava.lesson_2_3_4.hangman;

import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String playerAnswer = "yes";
        while (!playerAnswer.equals("no")) {
            if (playerAnswer.equals("yes")) {
                HangmanGame hangman = new HangmanGame();
                hangman.start();
                System.out.print("Хотите продолжить игру? [yes/no]: ");
            } else {
                System.out.print("Введите корректный ответ [yes / no]: ");
            }
            playerAnswer = scan.nextLine().toLowerCase();
        }
    }
}