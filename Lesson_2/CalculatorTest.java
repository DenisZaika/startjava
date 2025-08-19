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

            do {
                System.out.print("Введите знак операции (+, -, *, /, ^, %): ");
                sign = scan.next().charAt(0);
                if (!calc.setSign(sign)) {
                    System.out.printf("Ошибка: операция '%c' не поддерживается%n", sign);
                }
            } while (!calc.setSign(sign));

            int operand2;

            do {
                System.out.print("Введите второе число: ");
                operand2 = scan.nextInt();
                calc.setOperand2(operand2);
                if (Double.isNaN(calc.calculate())) {
                    System.out.println("Ошибка: деление на ноль запрещено");
                }
            } while (Double.isNaN(calc.calculate()));

            System.out.printf("%d %c %d = %.3f%n", operand1, sign, operand2, calc.calculate());

            do {
                System.out.print("Хотите продолжить вычисления? [yes/no]:");
                userAnswer = scan.next();
            } while (!"yes".equals(userAnswer) && !"no".equals(userAnswer));
        } 
    }
}