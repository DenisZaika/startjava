import java.util.Scanner;

public class CalculatorTest {

    public static void main(String[] args) {
        boolean shouldRepeat = true;
        Scanner scan = new Scanner(System.in);

        while (shouldRepeat) {
            Calculator calc = new Calculator();

            System.out.print("\nВведите первое число: ");
            int operand1 = scan.nextInt();
            calc.setOperand1(operand1);
            boolean isValidSign = false;

            System.out.print("Введите знак операции (+, -, *, /, ^, %): ");
            char sign = scan.next().charAt(0);
            isValidSign = calc.setSign(sign);

            System.out.print("Введите второе число: ");
            int operand2 = scan.nextInt();
            calc.setOperand2(operand2);

            if (!isValidSign) {
                System.out.printf("Ошибка: операция '%c' не поддерживается%n", sign);
            } else if (!calc.canCalculate()) {
                System.out.println("Ошибка: деление на ноль запрещено");
            } else {
                System.out.printf("%d %c %d = %.2f%n", operand1, sign, operand2, calc.calculate());
            }
            
            do {
                System.out.print("Хотите продолжить вычисления? [yes/no]:");
                String userAnswer = scan.next();
                if (userAnswer.equals("yes")) {
                    break;
                } else if (userAnswer.equals("no")) {
                    return;
                }
            } while (true);
        }
    }
}