package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    private final int operand1;
    private final char sign;
    private final int operand2;

    public Calculator(String[] mathExp) {
        operand1 = Integer.parseInt(mathExp[0]);
        sign = mathExp[1].charAt(0);
        operand2 = Integer.parseInt(mathExp[2]);
    }

    public double calculate() {
        if (operand2 == 0 && (sign == '/' || sign == '%')) {
            return Double.NaN;
        }
        return switch (sign) {
            case '+' -> operand1 + operand2;
            case '-' -> operand1 - operand2;
            case '*' -> operand1 * operand2;
            case '/' -> (double) operand1 / operand2;
            case '^' -> Math.pow(operand1, operand2);
            case '%' -> Math.floorMod(operand1, operand2);
            default -> 0;
        };
    }
}