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
            System.out.print("----------");
            System.out.print(" ");
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
        int numbersAmount = 1;
        for (int i = 1; i < rangeLimit; i += 2) {
            System.out.printf("%3d", i);
            if (numbersAmount % 5 == 0 || i + 2 >= rangeLimit) {
                while (numbersAmount % 5 != 0) {
                    System.out.printf("%3d", 0);
                    numbersAmount++;
                }
                System.out.println();
            }
            numbersAmount++;
        }

        System.out.println("\n5. Вывод чисел между min и max");
        int firstNumber = 10;
        int secondNumber = 5;
        int thirdNumber = -1;
        int maxNumber = firstNumber;
        int minNumber = firstNumber;
        if (firstNumber > secondNumber) {
            maxNumber = firstNumber;
            minNumber = secondNumber;
        } else {
            maxNumber = secondNumber;
            minNumber = firstNumber;
        }
        if (thirdNumber > maxNumber) {
            maxNumber = thirdNumber;
        } else if (thirdNumber < minNumber) {
            minNumber = thirdNumber;
        }
        System.out.printf("""
                %nДано 3 числа: %d, %d, %d
                Минимальное число:  %d
                Максимальное число: %d
                """,
                firstNumber, secondNumber, thirdNumber, minNumber, maxNumber);
        System.out.printf("Числа в интервале (%d, %d): ", minNumber, maxNumber);
        for (int i = maxNumber - 1; i > minNumber; i--) {
            System.out.printf("%d ", i);
        }

        System.out.println("\n\n6. Разные операции над числом");
        int originalNumber = 2234321;
        int reversedNumber = 0;
        int temp = originalNumber;
        int twosCount = 0;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit == 2) {
                twosCount += 1;
            }
            reversedNumber = reversedNumber * 10 + digit;
            temp /= 10;
        }
        String palindromeStatus = (originalNumber == reversedNumber) ? "палиндром" : "не палиндром";
        String evenStatus = (twosCount % 2 == 0) ? "с четным" : "с нечетным";
        System.out.printf("\n%d - %s %s (%d) числом двоек%n",
                reversedNumber, palindromeStatus, evenStatus, twosCount);

        System.out.println("\n7. Проверка счастливого числа");
        originalNumber = 101002;
        int firstPart = originalNumber / 1000;
        int secondPart = originalNumber % 1000;
        int firstPartSum = 0;
        temp = firstPart;
        while (temp > 0) {
            firstPartSum += temp % 10;
            temp /= 10;
        }
        temp = secondPart;
        int secondPartSum = 0;
        while (temp > 0) {
            secondPartSum += temp % 10;
            temp /= 10;
        }
        String numberStatus = (firstPartSum == secondPartSum) ? "счастливое" : "несчастливое";
        System.out.printf("""
                %n%d - %s число
                Сумма цифр %03d: = %d
                Сумма цифр %d: = %d%n""",
                originalNumber, numberStatus, secondPart, secondPartSum, firstPart, firstPartSum);

        System.out.println("\n8. Генератор пароля\n");
        Random random = new Random();
        String password = "";
        for (int i = 1; i <= 8; i++) {
            int symbolCategory = random.nextInt(1, 5);
            char randomSymbol;
            switch (symbolCategory) {
                // Цифры
                case 1:
                    randomSymbol = (char) random.nextInt(48, 58);
                    break;

                // Заглавные
                case 2:
                    randomSymbol = (char) random.nextInt(65, 91);
                    break;

                // Строчные
                case 3:
                    randomSymbol = (char) random.nextInt(97, 123);
                    break;

                // Спец. символы
                case 4:
                    int symbolSubcategory = random.nextInt(1, 5);
                    switch (symbolSubcategory) {
                        case 1:
                            randomSymbol = (char) random.nextInt(33, 48);
                            break;
                        case 2:
                            randomSymbol = (char) random.nextInt(58, 65);
                            break;
                        case 3:
                            randomSymbol = (char) random.nextInt(91, 97);
                            break;
                        case 4:
                            randomSymbol = (char) random.nextInt(123, 127);
                            break;
                        default:
                            randomSymbol = '?';
                            break;
                    }
                    break;
                default:
                    randomSymbol = '?';
                    break;
            }
            password += randomSymbol;
        }
        boolean hasCapitalLetter = false;
        boolean hasLowerCaseLetter = false;
        boolean hasDigit = false;
        boolean hasSpecialSymbol = false;
        for (int i = 0; i < 8; i++) {
            if (!hasCapitalLetter && Character.isUpperCase(password.charAt(i))) {
                hasCapitalLetter = true;
            }
            if (!hasLowerCaseLetter && Character.isLowerCase(password.charAt(i))) {
                hasLowerCaseLetter = true;
            }
            if (!hasDigit && Character.isDigit(password.charAt(i))) {
                hasDigit = true;
            }
            if (!hasSpecialSymbol && !Character.isLetterOrDigit(password.charAt(i))) {
                hasSpecialSymbol = true;
            }
        }
        String reliabilityStatus = "";
        if (password.length() >= 8 && hasCapitalLetter && hasLowerCaseLetter && hasSpecialSymbol) {
            reliabilityStatus = "Надежный";
        } else if (password.length() >= 8 && (hasCapitalLetter || hasDigit)) {
            reliabilityStatus = "Средний";
        } else {
            reliabilityStatus = "Слабый";
        }
        System.out.printf("""
                Пароль: %s
                Надежность: %s
                """,
                password, reliabilityStatus);
    }
}