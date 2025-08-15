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

            while (true) {
                System.out.print("Введите второе число: ");
                int operand2 = scan.nextInt();
                calc.setOperand2(operand2);
                double result = calc.calculate();
                if (!Double.isNaN(result)) {
                    System.out.printf("%d %c %d = %.3f%n", operand1, sign, operand2, result);
                    break;
                }
                System.out.println("Ошибка: деление на ноль запрещено");
            }

            do {
                System.out.print("Хотите продолжить вычисления? [yes/no]:");
                userAnswer = scan.next();
                if (userAnswer.equals("yes")) {
                    break;
                } 
                if (userAnswer.equals("no")) {
                    return;
                }
            } while (true);
        } 
    }
}