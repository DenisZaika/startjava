package com.startjava.lesson_2_3_4.hangman;

import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    private final String[] words;
    private final String[] gallows;
    private String secretWord;
    private int attemptsLeft;
    private StringBuilder wrongLetters;
    private StringBuilder guessedWord;
    private char enteredLetter;

    public HangmanGame() {
        words = new String[]{"mounting", "gameplay", "kitty", "microwave", "smartphone"};
        gallows = new String[]{"_______",
                "|     |",
                "|     @",
                "|    /|\\",
                "|    / \\",
                "| GAME OVER!"
        };
    }

    public void start() {
        wrongLetters = new StringBuilder();
        chooseRandomWord();
        guessedWord = new StringBuilder("*".repeat(secretWord.length()));
        attemptsLeft = gallows.length;
        System.out.print("Угадываемое слово: " + guessedWord);
        System.out.println();
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Осталось попыток: " + attemptsLeft);
            if (!wrongLetters.isEmpty()) {
                System.out.println("Ошибочные буквы: " + wrongLetters);
            }
            inputLetter(scan);
            if (!guessedWord.toString().contains("*")) {
                System.out.println("Поздравляем! Игра окончена! Вы угадали слово: " +
                        secretWord.toUpperCase());
                return;
            }
            System.out.print("Угадываемое слово: " + guessedWord);
            printHangman();
            if (attemptsLeft == 0) {
                System.out.println("Игра проиграна. Загаданное слово: " + secretWord.toUpperCase());
                return;
            }
        } while (true);
    }

    public void chooseRandomWord() {
        Random random = new Random();
        secretWord = words[random.nextInt(words.length)];
    }

    public void inputLetter(Scanner scan) {
        do {
            System.out.print("Введите букву: ");
            String input = scan.nextLine();
            if (input.isEmpty()) {
                System.out.println("Ошибка: пустой ввод!");
                continue;
            }
            enteredLetter = input.toLowerCase().charAt(0);
            System.out.println();
        } while (!isValidLetter());
        findLetterInWord();
    }

    public boolean isValidLetter() {
        if (enteredLetter < 'a' || enteredLetter > 'z') {
            System.out.println("Ошибка: введен символ, отличный от кириллицы");
            return false;
        }
        char upperCaseLetter = Character.toUpperCase(enteredLetter);
        if (guessedWord.toString().contains(Character.toString(upperCaseLetter)) ||
                wrongLetters.toString().indexOf(enteredLetter) >= 0) {
            System.out.println("Эту букву вы уже вводили!");
            return false;
        }
        return true;
    }

    public void findLetterInWord() {
        if (secretWord.indexOf(enteredLetter) >= 0) {
            if (attemptsLeft < 6) {
                attemptsLeft++;
            }
            System.out.println("Верно! Буква \"" + enteredLetter + "\" есть в слове!");
            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == enteredLetter) {
                    guessedWord.setCharAt(i, Character.toUpperCase(enteredLetter));
                }
            }
        } else {
            System.out.println("Неверно! Буквы \"" + enteredLetter + "\" нет в слове!");
            wrongLetters.append(enteredLetter).append(" ");
            attemptsLeft--;
        }
    }

    public void printHangman() {
        System.out.println("\nВиселица:");
        for (int i = 0; i < gallows.length - attemptsLeft; i++) {
            System.out.println(gallows[i]);
        }
    }
}
