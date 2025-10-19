package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    public static final int MAX_ATTEMPTS = 10;

    private final String name;
    private final int[] numbers;
    private int currAttempt;

    public Player(String name) {
        this.name = name;
        numbers = new int[MAX_ATTEMPTS];
        currAttempt = 0;
    }

    public String getName() {
        return name;
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, currAttempt);
    }

    public int getCurrAttempt() {
        return currAttempt;
    }

    public void clear() {
        Arrays.fill(numbers, 0, currAttempt, 0);
        currAttempt = 0;
    }

    public void increaseCurrAttempt() {
        if (currAttempt < MAX_ATTEMPTS) {
            currAttempt++;
        }
    }

    public void addNumber(int number) {
        if (number < GuessNumber.MIN_RANGE || number > GuessNumber.MAX_RANGE) {
            throw new InvalidNumberException("Число должно входить в отрезок [" +
                    GuessNumber.MIN_RANGE +
                    ", " + GuessNumber.MAX_RANGE + "]\n");
        }
        numbers[currAttempt - 1] = number;
    }

    public boolean hasAttempts() {
        return currAttempt < MAX_ATTEMPTS;
    }
} 