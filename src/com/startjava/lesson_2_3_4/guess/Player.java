package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    public static final int MAX_ATTEMPTS = 10;

    private final String name;
    private final int[] numbers;
    private int attemptCount;

    public Player(String name) {
        this.name = name;
        numbers = new int[MAX_ATTEMPTS];
        attemptCount = 1;
    }

    public String getName() {
        return name;
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, attemptCount - 1);
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public void addNumber(int number) throws InvalidNumberException {
        if (number < GuessNumber.RANGE_MIN || number > GuessNumber.RANGE_MAX) {
            throw new InvalidNumberException("Число должно входить в отрезок [" + GuessNumber.RANGE_MIN +
                    ", " + GuessNumber.RANGE_MAX + "]\nПопробуйте еще раз: ");
        }
        numbers[attemptCount - 1] = number;
        if (attemptCount < MAX_ATTEMPTS) {
            attemptCount++;
        }
    }

    public boolean hasAttempts() {
        return attemptCount < MAX_ATTEMPTS;
    }

    public void clear() {
        Arrays.fill(numbers, 0, attemptCount, 0);
        attemptCount = 1;
    }
} 