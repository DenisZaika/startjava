package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Player player1 = createPlayer(scan, "первого");
        Player player2 = createPlayer(scan, "второго");

        GuessNumber game = new GuessNumber(player1, player2);
        String playerAnswer = "yes";

        while (!"no".equals(playerAnswer)) {
            if ("yes".equals(playerAnswer)) {
                game.start();
                System.out.print("Хотите продолжить игру? [yes/no]: ");
            } else {
                System.out.print("Введите корректный ответ [yes / no]: ");
            }
            playerAnswer = scan.nextLine().toLowerCase();
        }
    }

    private static Player createPlayer(Scanner scan, String playerTurn) {
        System.out.print("Введите имя " + playerTurn + " игрока: ");
        String name = scan.nextLine();
        return new Player(name);
    }
}