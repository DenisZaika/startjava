import java.math.BigDecimal;
import java.math.RoundingMode;

public class IfElseStatementTheme {
    public static void main(String[] args) {
        System.out.println("1. Перевод псевдокода на язык Java\n");
        boolean isMale = true;
        if (!isMale) {
            System.out.println("Клиент женского пола");
        } else {
            System.out.println("Клиент мужского пола");
        }
        int age = 17;
        if (age > 18) {
            System.out.println("Клиент совершеннолетний");
        } else {
            System.out.println("Клиент несовершеннолетний");
        }
        float height = 1.6F;
        if (height < 1.8F) {
            System.out.println("Клиент невысокого роста");
        } else {
            System.out.println("Клиент высокого роста");
        }

        System.out.println("\n2. Поиск большего числа шагов\n");
        int yesterdayStepsCount = 10_100;
        int todayStepsCount = 10_255;
        System.out.printf("""
                Пройденное количество шагов:
                  Вчера:   %,d
                  Сегодня: %,d
                """,
                yesterdayStepsCount, todayStepsCount);
        if (yesterdayStepsCount < todayStepsCount) {
            System.out.println("Вчера было пройдено меньше шагов, чем сегодня.");
        } else if (yesterdayStepsCount == todayStepsCount) {
            System.out.println("Количество шагов, пройденных вчера " +
                    "равно количеству шагов, пройденных сегодня.");
        } else {
            System.out.println("Вчера было пройдено больше шагов, чем сегодня");
        }
        double avgStepsCount = (yesterdayStepsCount + todayStepsCount) / 2.0;
        System.out.printf("Среднее количество шагов: %.2f%n", avgStepsCount);

        System.out.println("\n3. Проверка количества гостей\n");
        int guestsCount = -1;
        if (guestsCount < 0) {
            System.out.println("Ошибка! Число гостей не может быть отрицательным числом!");
        } else if (guestsCount == 0) {
            System.out.println("Пока никто не записался на мероприятие!");
        } else if (guestsCount % 2 == 0) {
            System.out.printf("Записалось %d гостей. Можно формировать пары для конкурсов.%n", guestsCount);
        } else if (guestsCount % 2 == 1) {
            System.out.printf("Записалось %d гостей. Нужны индивидуальные задания.%n", guestsCount);
        }

        System.out.println("\n4. Определение первого символа никнейма\n");
        String name = "Denis";
        char firstNameChar = name.charAt(0);
        System.out.println("Первый способ: диапазон кодов");
        if ((firstNameChar <= 'z') && (firstNameChar >= 'a')) {
            System.out.printf("Имя \"%s\" начинается с маленькой буквы \"%c\"", name, firstNameChar);
        } else if ((firstNameChar <= 'Z') && (firstNameChar >= 'A')) {
            System.out.printf("Имя \"%s\" начинается с большой буквы \"%c\"", name, firstNameChar);
        } else if ((firstNameChar <= '9') && (firstNameChar >= '0')) {
            System.out.printf("Имя \"%s\" начинается с цифры \"%c\"", name, firstNameChar);
        } else if (firstNameChar == '$') {
            System.out.printf("Имя \"%s\" начинается с символа \"%c\"", name, firstNameChar);
        }
        System.out.println("\n\nВторой способ: методы класса Character");
        if (Character.isLowerCase(firstNameChar)) {
            System.out.printf("Имя \"%s\" начинается с маленькой буквы \"%c\"", name, firstNameChar);
        } else if (Character.isUpperCase(firstNameChar)) {
            System.out.printf("Имя \"%s\" начинается с большой буквы \"%c\"", name, firstNameChar);
        } else if (Character.isDigit(firstNameChar)) {
            System.out.printf("Имя \"%s\" начинается с цифры \"%c\"", name, firstNameChar);
        } else if (Character.compare(firstNameChar, '$') == 0) {
            System.out.printf("Имя \"%s\" начинается с символа \"%c\"", name, firstNameChar);
        }

        System.out.println("\n\n5. Инвентаризация\n");
        int serialNumber = 120;
        int computerNumber = 123;
        if (serialNumber == computerNumber) {
            System.out.printf("[№%d] : компьютер на 3-м этаже в кабинете 2%n", serialNumber);
        } else {
            int serialNumberFirstDigit = serialNumber / 100;
            int serialNumberSecondDigit = serialNumber / 10 % 10;
            int serialNumberThirdDigit = serialNumber % 10;
            int computerNumberFirstDigit = computerNumber / 100;
            int computerNumberSecondDigit = computerNumber / 10 % 10;
            int computerNumberThirdDigit = computerNumber % 10;
            String actualMatch = "";
            actualMatch += (serialNumberFirstDigit == computerNumberFirstDigit)
                    ? serialNumberFirstDigit : "_";
            actualMatch += (serialNumberSecondDigit == computerNumberSecondDigit) 
                    ? serialNumberSecondDigit : "_";
            actualMatch += (serialNumberThirdDigit == computerNumberThirdDigit) 
                    ? serialNumberThirdDigit : "_";
            if (actualMatch.equals("___")) {
                System.out.printf("[№%d]: оборудование не идентифицировано%n", serialNumber);
            } else {
                System.out.printf("""
                        Нет полного совпадения:
                        База данных: [№%d]
                        Фактический: [№%s]
                        """,
                        serialNumber, actualMatch);
            }          
        }

        System.out.println("\n6. Подсчет начисленных банком %");
        System.out.println("\nПервый способ: использование float");
        float depositAmount = 321123.79f;
        float interestAmount;
        if (depositAmount < 100_000) {
            interestAmount = (float) (depositAmount * 0.05);
        } else if (depositAmount <= 300_000) {
            interestAmount = (float) (depositAmount * 0.07);
        } else {
            interestAmount = (float) (depositAmount * 0.10);
        }
        float totalAmount = depositAmount + interestAmount;
        System.out.printf("""
                Сумма вклада:          %f руб
                Сумма начисленного %% : %f руб
                Итоговая сумма с %% :   %f руб
                """,
                depositAmount, interestAmount, totalAmount);
        System.out.println("\nВторой способ: использование BigDecimal");
        BigDecimal depositAmountBd = new BigDecimal("321123.79");
        BigDecimal rate5 = new BigDecimal("0.05");
        BigDecimal rate7 = new BigDecimal("0.07");
        BigDecimal rate10 = new BigDecimal("0.10");
        BigDecimal interestAmountBd;
        if (depositAmountBd.compareTo(BigDecimal.valueOf(100_000)) < 0) {
            interestAmountBd = depositAmountBd.multiply(rate5);
        } else if (depositAmountBd.compareTo(BigDecimal.valueOf(300_000)) <= 0) {
            interestAmountBd = depositAmountBd.multiply(rate7);
        } else {
            interestAmountBd = depositAmountBd.multiply(rate10);
        }
        BigDecimal totalAmountBd = depositAmountBd.add(interestAmountBd).setScale(2, RoundingMode.HALF_UP);
        System.out.printf("""
                Сумма вклада:          %s руб
                Сумма начисленного %% : %s руб
                Итоговая сумма с %% :   %s руб
                """,
                depositAmountBd, interestAmountBd.setScale(2, RoundingMode.HALF_UP), totalAmountBd);

        System.out.println("\n7. Определение оценки по предметам\n");
        int historyPercentage = 59;
        int programmingPercentage = 92;
        int historyGrade;
        if (historyPercentage <= 60) {
            historyGrade = 2;
        } else if (historyPercentage <= 73) {
            historyGrade = 3;
        } else if (historyPercentage <= 91) {
            historyGrade = 4;
        } else {
            historyGrade = 5;
        }
        int programmingGrade;
        if (programmingPercentage <= 60) {
            programmingGrade = 2;
        } else if (programmingPercentage <= 73) {
            programmingGrade = 3;
        } else if (programmingPercentage <= 91) {
            programmingGrade = 4;
        } else {
            programmingGrade = 5;
        }
        double avgGrade = (historyGrade + programmingGrade) / 2.0;
        double avgPercentage = (historyPercentage + programmingPercentage) / 2.0;
        System.out.printf("""
                Оценки по предметам:
                  История:          %d (процент %d%%)
                  Программирование: %d (процент %d%%)%n
                Средний балл по предметам: %.2f
                Средний %% по предметам:   %.2f
                """,
                historyGrade, historyPercentage,
                programmingGrade, programmingPercentage,
                avgGrade, avgPercentage);

        System.out.println("\n8. Расчет годовой прибыли\n");
        BigDecimal monthlyIncome = new BigDecimal("13025.233");
        BigDecimal monthlyRoomRent = new BigDecimal("5123.018");
        BigDecimal monthlyProductionCost = new BigDecimal("9001.729");
        BigDecimal monthlyExpense = monthlyRoomRent.add(monthlyProductionCost);
        BigDecimal monthlyProfit = monthlyIncome.subtract(monthlyExpense);
        BigDecimal annualProfit = monthlyProfit.multiply(BigDecimal.valueOf(12));
        if (annualProfit.compareTo(BigDecimal.valueOf(0)) > 0) {
            System.out.printf("Прибыль за год: %+.2f руб.", annualProfit);
        } else {
            System.out.printf("Прибыль за год: %.2f руб.", annualProfit);
        }
    }
}