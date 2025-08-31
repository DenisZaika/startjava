package com.startjava.lesson_2_3_4.array;

public class HackingSimulatorMain {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) throws InterruptedException {
        int selectedNumber = perform();
        showResult(selectedNumber);
    }

    private static int perform() throws InterruptedException {
        char[] spinnerSymbols = {'-', '\\', '|', '/'};
        System.out.print("Hacking: ");
        for (int i = 0; i < 3; i++) {
            for (char symbol : spinnerSymbols) {
                System.out.print(symbol);
                Thread.sleep(300);
                System.out.print("\b");
            }
        }
        System.out.print(spinnerSymbols[0]);
        Thread.sleep(300);
        System.out.print("\b");
        return (int) (Math.random() * 100);
    }

    private static void showResult(int selectedNumber) {
        if (selectedNumber > 70) {
            System.out.println(ANSI_RED + "Access Granted!" + ANSI_RESET);
        } else {
            System.out.println(ANSI_GREEN + "Access Denied!" + ANSI_RESET);
        }
    }
}
