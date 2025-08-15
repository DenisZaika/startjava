public class Calculator {

    private int operand1;
    private char sign;
    private int operand2;

    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public boolean setSign(char sign) {
        if (sign != '+' && sign != '-' && sign != '*' && sign != '/' && sign != '^' && sign != '%') {
            return false;
        }
        this.sign = sign;
        return true;
    }

    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }

    public double calculate() {
        if (operand2 == 0 && (sign == '/' || sign == '%')) {
            return Double.NaN;
        }
        switch (sign) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return (double) operand1 / operand2;
            case '^':
                int result = 1;
                int temp = operand2;
                if (operand2 < 0) {
                    temp = -operand2;
                }
                for (int i = 1; i <= temp; i++) {
                    result *= operand1;
                }
                return operand2 > 0 ? result : 1.0 / result;
            case '%':
                return operand1 % operand2;
            default:
                return 0;
        }
    }
}