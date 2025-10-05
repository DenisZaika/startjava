package com.startjava.lesson_2_3_4.hangman;

import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    private final String[] words;
    private final String secretWord;
    private final StringBuilder guessedWord;
    private final String[] gallows;
    private final StringBuilder wrongLetters;

    private int attemptsLeft;
    private char enteredLetter;

    public HangmanGame() {
        words = new String[]{"монтаж", "холодильник", "дерево", "окно", "смартфон"};
        secretWord = chooseRandomWord();
        guessedWord = new StringBuilder("*".repeat(secretWord.length()));
        gallows = new String[]{"_______",
                "|     |",
                "|     @",
                "|    /|\\",
                "|    / \\",
                "| GAME OVER!"
        };
        attemptsLeft = gallows.length;
        wrongLetters = new StringBuilder();
    }

    public String chooseRandomWord() {
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }

    public void start() {
        Scanner scan = new Scanner(System.in);
        do {
            printGameState();
            inputLetter(scan);
            printGallows();
        } while (!isGameFinished());
    }

    public void printGameState() {
        System.out.println("Угадываемое слово: " + guessedWord);
        System.out.println("Осталось попыток: " + attemptsLeft);
        if (!wrongLetters.isEmpty()) {
            System.out.println("Ошибочные буквы: " + wrongLetters);
        }
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
        if (enteredLetter < 'а' || enteredLetter > 'я') {
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
            if (attemptsLeft < gallows.length) {
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

    public boolean isGameFinished() {
        if (!guessedWord.toString().contains("*")) {
            System.out.println("Поздравляем! Игра окончена! Вы угадали слово: " +
                    secretWord.toUpperCase());
            return true;
        }
        if (attemptsLeft == 0) {
            System.out.println("Игра проиграна. Загаданное слово: " + secretWord.toUpperCase());
            return true;
        }
        return false;
    }

    public void printGallows() {
        System.out.println("\nВиселица:");
        for (int i = 0; i < gallows.length - attemptsLeft; i++) {
            System.out.println(gallows[i]);
        }
        System.out.println();
    }
}
