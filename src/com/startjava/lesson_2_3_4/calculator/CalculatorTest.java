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
                String[] mathExp = scan.nextLine().split("\\s+");
                if (!mathExp[1].equals("+") && !mathExp[1].equals("-") && !mathExp[1].equals("*") &&
                        !mathExp[1].equals("/") && !mathExp[1].equals("^") && !mathExp[1].equals("%")) {
                    System.out.println("Ошибка: операция (" + mathExp[1] + ") не поддерживается");
                    continue;
                }
                Calculator calc = new Calculator(mathExp);
                double result = calc.calculate();
                outputResult(mathExp, result);
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            } else {
                System.out.print("Введите корректный ответ [yes / no]: ");
            }
            userAnswer = scan.nextLine().toLowerCase();
        }
    }

    private static void outputResult(String[] mathExp, double result) {
        if (Double.isNaN(result)) {
            System.out.println("Ошибка: деление на ноль запрещено");
        } else {
            String pattern = "#.###";
            DecimalFormat df = new DecimalFormat(pattern);
            String formattedResult = df.format(result).replace('.', ',');
            System.out.println(mathExp[0] + " " + mathExp[1] + " " + mathExp[2] + " = " + formattedResult);
        }
    }
}