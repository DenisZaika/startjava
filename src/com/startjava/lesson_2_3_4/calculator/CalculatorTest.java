package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        String userAnswer = "yes";
        Scanner scan = new Scanner(System.in);

        while (!"no".equals(userAnswer)) {
            if ("yes".equals(userAnswer)) {
                System.out.print("\nВведите выражение из трех аргументов, например, 2 ^ 10: ");
                String mathExpr = scan.nextLine();
                Calculator calc = new Calculator(mathExpr);
                double result = calc.calculate();
                if (Double.isNaN(result)) {
                    continue;
                }
                outputResult(mathExpr, result);
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            } else {
                System.out.print("Введите корректный ответ [yes / no]: ");
            }
            userAnswer = scan.nextLine().toLowerCase();
        }
    }

    private static void outputResult(String mathExpr, double result) {
        DecimalFormat df = new DecimalFormat("#.###");
        System.out.println(mathExpr + " = " + df.format(result));
    }
}