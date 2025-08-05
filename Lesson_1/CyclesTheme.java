import java.util.Random;

public class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("1. Вывод ASCII-символов\n");
        System.out.printf("%-10s%-12s%s%n", "DECIMAL", "CHARACTER", "DESCRIPTION");
        for (int i = 33; i <= 47; i += 2) {
            System.out.printf("%4d%11c%12c%s%n", i, i, ' ', Character.getName(i));
        }
        for (int i = 98; i <= 122; i += 2) {
            System.out.printf("%4d%11c%12c%s%n", i, i, ' ', Character.getName(i));
        }

        System.out.println("\n2. Вывод геометрических фигур\n");
        int asteriskSymbolCount = 5;
        int caretSymbolCount = 1;
        for (int i = 1; i <= 5; i++) {
            System.out.print("---------- ");
            for (int j = 1; j <= asteriskSymbolCount; j++) {
                System.out.print('*');
            }
            System.out.print(" ");
            for (int j = 1; j <= caretSymbolCount; j++) {
                System.out.print('^');
            }
            System.out.println();
            asteriskSymbolCount -= 1;
            caretSymbolCount += 2;
        }

        System.out.println("\n3. Вывод таблицы умножения\n");
        System.out.print("""
                  |  2  3  4  5  6  7  8  9
                --+------------------------
                """);
        for (int i = 2; i <= 9; i++) {
            System.out.printf("%d |", i);
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%3d", i * j);
            }
            System.out.println();
        }

        System.out.println("\n4. Вывод чисел в несколько строк\n");
        int rangeLimit = 24;
        int itemsPerRow = 1;
        for (int i = 1, j = itemsPerRow; i < rangeLimit || j != 1; i += 2, j++) {
            System.out.printf("%3d", i < rangeLimit ? i : 0);
            if (j == 5) {
                System.out.println();
                j = 0;
            }
        }

        System.out.println("\n5. Вывод чисел между min и max");
        int firstNumber = 10;
        int secondNumber = 5;
        int thirdNumber = -1;
        int max = firstNumber;
        int min = firstNumber;
        if (firstNumber > secondNumber) {
            min = secondNumber;
        } else {
            max = secondNumber;
        }
        if (thirdNumber > max) {
            max = thirdNumber;
        } else if (thirdNumber < min) {
            min = thirdNumber;
        }
        System.out.printf("""
                %nДано 3 числа: %d, %d, %d
                Минимальное число:  %d
                Максимальное число: %d
                """,
                firstNumber, secondNumber, thirdNumber, min, max);
        System.out.printf("Числа в интервале (%d, %d): ", min, max);
        for (int i = max - 1; i > min; i--) {
            System.out.printf("%d ", i);
        }

        System.out.println("\n\n6. Разные операции над числом");
        int originalNumber = 2234321;
        int reversedNumber = 0;
        int currNumber = originalNumber;
        int twosCount = 0;
        while (currNumber > 0) {
            int digit = currNumber % 10;
            if (digit == 2) {
                twosCount++;
            }
            reversedNumber = reversedNumber * 10 + digit;
            currNumber /= 10;
        }
        String palindromeStatus = (originalNumber == reversedNumber) ? "палиндром" : "не палиндром";
        String evenStatus = (twosCount % 2 == 0) ? "с четным" : "с нечетным";
        System.out.printf("\n%d - %s %s (%d) числом двоек%n",
                reversedNumber, palindromeStatus, evenStatus, twosCount);

        System.out.println("\n7. Проверка счастливого числа");
        originalNumber = 101002;
        int firstPart = originalNumber / 1000;
        int secondPart = originalNumber % 1000;
        int firstCurrNumber = firstPart;
        int secondCurrNumber = secondPart;
        int firstPartSum = 0;
        int secondPartSum = 0;
        while (firstCurrNumber > 0 || secondCurrNumber > 0) {
            if (firstCurrNumber > 0) {
                firstPartSum += firstCurrNumber % 10;
                firstCurrNumber = firstCurrNumber / 10;
            }
            if (secondCurrNumber > 0) {
                secondPartSum += secondCurrNumber % 10;
                secondCurrNumber = secondCurrNumber / 10;
            }
        }
        String numberStatus = (firstPartSum == secondPartSum) ? "счастливое" : "несчастливое";
        System.out.printf("""
                %n%d - %s число
                Сумма цифр %03d: = %d
                Сумма цифр %d: = %d%n""",
                originalNumber, numberStatus,
                secondPart, secondPartSum,
                firstPart, firstPartSum);

        System.out.println("\n8. Генератор пароля\n");
        Random random = new Random();
        String password = "";
        boolean hasCapitalLetter = false;
        boolean hasLowerCaseLetter = false;
        boolean hasDigit = false;
        boolean hasSpecialSymbol = false;
        for (int i = 0; i < 8; i++) {
            char randomSymbol = (char) random.nextInt(33, 127);
            password += randomSymbol;
            if (Character.isUpperCase(randomSymbol)) {
                hasCapitalLetter = true;
            } else if (Character.isLowerCase(randomSymbol)) {
                hasLowerCaseLetter = true;
            } else if (Character.isDigit(randomSymbol)) {
                hasDigit = true;
            } else {
                hasSpecialSymbol = true;
            }
        }
        String reliabilityStatus = "Слабый";
        if (password.length() >= 8 && hasCapitalLetter && hasLowerCaseLetter && hasSpecialSymbol) {
            reliabilityStatus = "Надежный";
        } else if (password.length() >= 8 && (hasCapitalLetter || hasDigit)) {
            reliabilityStatus = "Средний";
        }
        System.out.printf("""
                Пароль: %s
                Надежность: %s
                """,
                password, reliabilityStatus);
    }
}