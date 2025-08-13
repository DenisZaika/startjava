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
        } else {
            this.sign = sign;
            return true;
        }
    }

    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }

    public boolean canCalculate() {
        switch (sign) {
            case '/':
            case '%':
                return operand2 != 0;
            default:
                return true;
        }
    }

    public double calculate() {
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
                return Math.pow(operand1, operand2);
            case '%':
                return operand1 % operand2;
            default:
                return 0;
        }
    }
}