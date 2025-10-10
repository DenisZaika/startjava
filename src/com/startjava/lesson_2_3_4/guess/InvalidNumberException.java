package com.startjava.lesson_2_3_4.guess;

public class InvalidNumberException extends Exception {
    public InvalidNumberException(String message) {
        super(message);
    }
}