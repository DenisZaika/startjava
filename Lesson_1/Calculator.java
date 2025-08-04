public class Calculator {
    public static void main(String[] args) {
        int firstOperand = 2;
        int secondOperand = 6;
        char operation = '-';
        int result = 1;
        if (operation == '%') {
            result = firstOperand % secondOperand;
        } else if (operation == '*') {
            result = firstOperand * secondOperand;
        } else if (operation == '+') {
            result = firstOperand + secondOperand;
        } else if (operation == '-') {
            result = firstOperand - secondOperand;
        } else if (operation == '/') {
            result = firstOperand / secondOperand;
        } else if (operation == '^') {
            for (int i = 1; i <= secondOperand; i++) {
                result *= firstOperand;
            }
        } else {
            System.out.println("Выбрана некорректная операция!");
        }
        System.out.printf("%d %c %d = %d", firstOperand, operation, secondOperand, result);
    }
}