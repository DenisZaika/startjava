package com.startjava.lesson_2_3_4.array;

public class HackingSimulator {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) throws InterruptedException {
        int selectedNumber = showSpinner();
        showHackingResult(selectedNumber);
    }

    private static int showSpinner() throws InterruptedException {
        char[] spins = {'-', '\\', '|', '/'};
        System.out.print("Hacking:  ");
        for (int i = 0; i < 12; i++) {
            System.out.print("\b" + spins[i % 4]);
            Thread.sleep(300);
        }
        return (int) (Math.random() * 100);
    }

    private static void showHackingResult(int selectedNumber) {
        System.out.print("\b" +
                (selectedNumber > 70 ? ANSI_RED + " Access Granted!" : "\b" + ANSI_GREEN + " Access Denied!") +
                ANSI_RESET);
    }
}
