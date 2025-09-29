package com.startjava.lesson_2_3_4.hangman;

import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    private final String[] words = new String[]{"mounting", "gameplay", "kitty", "microwave", "smartphone"};
    private final Random random = new Random();
    private final String[] hangmanParts = new String[]{"_______",
            "|     |",
            "|     @",
            "|    /|\\",
            "|    / \\",
            "| GAME OVER!"
    };

    private String secretWord;
    private int attemptsLeft;
    private StringBuilder incorrectLetters;
    private StringBuilder correctLetters;
    private char enteredLetter;

    public void start() {
        incorrectLetters = new StringBuilder();
        correctLetters = new StringBuilder();
        chooseRandomWord();
        attemptsLeft = hangmanParts.length;
        System.out.print("Угадываемое слово: ");

        for (int i = 0; i < secretWord.length(); i++) {
            System.out.print("*");
        }

        System.out.println();
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Осталось попыток: " + attemptsLeft);
            if (!incorrectLetters.isEmpty()) {
                System.out.println("Ошибочные буквы: " + incorrectLetters);
            }
            inputLetter(scan);
            if (isWordGuessed()) {
                System.out.println("Поздравляем! Игра окончена! Вы угадали слово: " +
                        secretWord.toUpperCase());
                return;
            }
            printHangman();
            if (attemptsLeft == 0) {
                System.out.println("Игра проиграна. Загаданное слово: " + secretWord.toUpperCase());
                return;
            }
        } while (true);
    }

    public void chooseRandomWord() {
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
        if (!Character.isLetter(enteredLetter)) {
            System.out.println("Ошибка: введен символ, отличный от кириллицы");
            return false;
        }
        if (correctLetters.toString().indexOf(enteredLetter) >= 0 ||
                incorrectLetters.toString().indexOf(enteredLetter) >= 0) {
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
            System.out.println("Верно! Буква " + enteredLetter + " есть в слове!");
            correctLetters.append(enteredLetter).append(" ");
        } else {
            System.out.println("Неверно! Буквы " + enteredLetter + " нет в слове!");
            incorrectLetters.append(enteredLetter).append(" ");
            attemptsLeft--;
        }
    }

    public boolean isWordGuessed() {
        System.out.print("Угадываемое слово: ");
        boolean isWordCompleted = true;
        for (char wordLetter : secretWord.toCharArray()) {
            if (correctLetters.toString().indexOf(wordLetter) >= 0) {
                System.out.print(Character.toUpperCase(wordLetter));
            } else {
                System.out.print("*");
                isWordCompleted = false;
            }
        }
        System.out.println();
        return isWordCompleted;
    }

    public void printHangman() {
        System.out.println("Виселица:");
        for (int i = 0; i < hangmanParts.length - attemptsLeft; i++) {
            System.out.println(hangmanParts[i]);
        }
    }
}
