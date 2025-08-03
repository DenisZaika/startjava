public class Calculator {
    public static void main(String[] args) {
        int firstOperand = 12;
        int secondOperand = 5;
        char operation = '%';
        int result = 1;
        if (operation == 37) {
            result = firstOperand % secondOperand;
        } else if (operation == 42) {
            result = firstOperand * secondOperand;
        } else if (operation == 43) {
            result = firstOperand + secondOperand;
        } else if (operation == 45) {
            result = firstOperand - secondOperand;
        } else if (operation == 47) {
            result = firstOperand / secondOperand;
        } else if (operation == 94) {
            for (int i = 1; i <= secondOperand; i++) {
                result *= firstOperand;
            }
        } else {
            System.out.println("Выбрана некорректная операция!");
        }
        System.out.printf("%d %c %d = %d", firstOperand, operation, secondOperand, result);
    }
}