package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    public static final int MAX_ATTEMPTS = 10;

    private final String name;
    private final int[] numbers;
    private int attemptNumber;

    public Player(String name) {
        this.name = name;
        numbers = new int[MAX_ATTEMPTS];
        attemptNumber = 0;
    }

    public String getName() {
        return name;
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, attemptNumber);
    }

    public void setNumbers(int number) throws InvalidNumberException {
        if (number < 1 || number > 100) {
            throw new InvalidNumberException("Число должно входить в отрезок [1, 100]\nПопробуйте еще раз: ");
        }
        numbers[attemptNumber - 1] = number;
    }

    public int getAttemptNumber() {
        return attemptNumber;
    }

    public void incrementAttempts() {
        if (attemptNumber < MAX_ATTEMPTS) {
            attemptNumber++;
        }
    }

    public boolean hasAttempts() {
        return attemptNumber < MAX_ATTEMPTS;
    }

    public void resetAttempts() {
        attemptNumber = 0;
    }

    public void cleanNumbers() {
        Arrays.fill(numbers, 0, attemptNumber, 0);
    }
} 