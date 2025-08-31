package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {

    public static void main(String[] args) {
        String userAnswer = "yes";
        Scanner scan = new Scanner(System.in);

        while ("yes".equals(userAnswer)) {
            Calculator calc = new Calculator();

            System.out.print("\nВведите первое число: ");
            int operand1 = scan.nextInt();
            calc.setOperand1(operand1);
            char sign;

            while (true) {
                System.out.print("Введите знак операции (+, -, *, /, ^, %): ");
                sign = scan.next().charAt(0);
                if (calc.setSign(sign)) {
                    break;
                }
                System.out.printf("Ошибка: операция '%c' не поддерживается%n", sign);
            }

            int operand2;
            System.out.print("Введите второе число: ");
            operand2 = scan.nextInt();
            calc.setOperand2(operand2);

            double result = calc.calculate();
            outputResult(operand1, sign, operand2, result);

            do {
                System.out.print("Хотите продолжить вычисления? [yes/no]:");
                userAnswer = scan.next();
            } while (!"yes".equals(userAnswer) && !"no".equals(userAnswer));
        } 
    }

    private static void outputResult(int operand1, char sign, int operand2, double result) {
        if (Double.isNaN(result)) {
            System.out.println("Ошибка: деление на ноль запрещено");
        } else {
            System.out.printf("%d %c %d = %.3f%n", operand1, sign, operand2, result);
        }
    }
}