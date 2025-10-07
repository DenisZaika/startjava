package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    private final String[] mathExpr;

    public Calculator(String mathExpr) {
        this.mathExpr = mathExpr.split("\\s+");
    }

    public double calculate() {
        if (!isValidExpr()) {
            return Double.NaN;
        }
        int operand1 = Integer.parseInt(mathExpr[0]);
        int operand2 = Integer.parseInt(mathExpr[2]);
        char sign = mathExpr[1].charAt(0);
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

    private boolean isValidExpr() {
        if (!mathExpr[1].equals("+") && !mathExpr[1].equals("-") && !mathExpr[1].equals("*") &&
                !mathExpr[1].equals("/") && !mathExpr[1].equals("^") && !mathExpr[1].equals("%")) {
            System.out.println("Ошибка: операция (" + mathExpr[1] + ") не поддерживается");
            return false;
        }
        if (mathExpr[2].equals("0") && (mathExpr[1].equals("/") || mathExpr[1].equals("%"))) {
            System.out.println("Ошибка: деление на ноль запрещено");
            return false;
        }
        return true;
    }
}