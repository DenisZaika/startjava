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
        String name = "#Denis";
        char firstNameChar = name.charAt(0);
        String messageStart = "Имя \"%s\" начинается с ";
        System.out.println("Первый способ: диапазон кодов");
        if ((firstNameChar <= 'z') && (firstNameChar >= 'a')) {
            System.out.printf(messageStart + "маленькой буквы \"%c\"", name, firstNameChar);
        } else if ((firstNameChar <= 'Z') && (firstNameChar >= 'A')) {
            System.out.printf(messageStart + "большой буквы \"%c\"", name, firstNameChar);
        } else if ((firstNameChar <= '9') && (firstNameChar >= '0')) {
            System.out.printf(messageStart + "цифры \"%c\"", name, firstNameChar);
        } else {
            System.out.printf(messageStart + "символа \"%c\"", name, firstNameChar);
        }
        System.out.println("\n\nВторой способ: методы класса Character");
        if (Character.isLowerCase(firstNameChar)) {
            System.out.printf(messageStart + "маленькой буквы \"%c\"", name, firstNameChar);
        } else if (Character.isUpperCase(firstNameChar)) {
            System.out.printf(messageStart + "большой буквы \"%c\"", name, firstNameChar);
        } else if (Character.isDigit(firstNameChar)) {
            System.out.printf(messageStart + "цифры \"%c\"", name, firstNameChar);
        } else {
            System.out.printf(messageStart + "символа \"%c\"", name, firstNameChar);
        }

        System.out.println("\n\n5. Инвентаризация\n");
        int serialNumber = 120;
        int assetNumber = 123;
        if (serialNumber == assetNumber) {
            System.out.printf("[№%d] : компьютер на 3-м этаже в кабинете 2%n", serialNumber);
        } else {
            int serialNumberFirstDigit = serialNumber / 100;
            int serialNumberSecondDigit = serialNumber / 10 % 10;
            int serialNumberThirdDigit = serialNumber % 10;
            int assetNumberFirstDigit = assetNumber / 100;
            int assetNumberSecondDigit = assetNumber / 10 % 10;
            int assetNumberThirdDigit = assetNumber % 10;
            String actualMatch = "";
            actualMatch += (serialNumberFirstDigit == assetNumberFirstDigit)
                    ? serialNumberFirstDigit : "_";
            actualMatch += (serialNumberSecondDigit == assetNumberSecondDigit) 
                    ? serialNumberSecondDigit : "_";
            actualMatch += (serialNumberThirdDigit == assetNumberThirdDigit) 
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
        int interestRate = 10;
        if (depositAmount < 100_000) {
            interestRate = 5;
        } else if (depositAmount <= 300_000) {
            interestRate = 7;
        }
        float interestAmount = depositAmount * interestRate * 0.01f;
        float totalAmount = depositAmount + interestAmount;
        System.out.printf("""
                Сумма вклада:         %f руб
                Сумма начисленного %%: %f руб
                Итоговая сумма с %%:   %f руб
                """,
                depositAmount, interestAmount, totalAmount);
        System.out.println("\nВторой способ: использование BigDecimal");
        BigDecimal depositAmountBd = new BigDecimal("321123.79");
        BigDecimal interestRateBd = BigDecimal.valueOf(10);
        if (depositAmountBd.compareTo(BigDecimal.valueOf(100_000)) < 0) {
            interestRateBd = BigDecimal.valueOf(5);
        } else if (depositAmountBd.compareTo(BigDecimal.valueOf(300_000)) <= 0) {
            interestRateBd = BigDecimal.valueOf(7);
        }
        BigDecimal interestAmountBd = depositAmountBd.multiply(interestRateBd)
                .multiply(new BigDecimal("0.01"));
        BigDecimal totalAmountBd = depositAmountBd.add(interestAmountBd).setScale(2, RoundingMode.HALF_UP);
        System.out.printf("""
                Сумма вклада:         %s руб
                Сумма начисленного %%: %s руб
                Итоговая сумма с %%:   %s руб
                """,
                depositAmountBd, interestAmountBd.setScale(2, RoundingMode.HALF_UP), totalAmountBd);

        System.out.println("\n7. Определение оценки по предметам\n");
        int historyPercentage = 59;
        int historyGrade = 5;
        if (historyPercentage <= 60) {
            historyGrade = 2;
        } else if (historyPercentage <= 73) {
            historyGrade = 3;
        } else if (historyPercentage <= 91) {
            historyGrade = 4;
        }
        int programmingGrade = 5;
        int programmingPercentage = 92;
        if (programmingPercentage <= 60) {
            programmingGrade = 2;
        } else if (programmingPercentage <= 73) {
            programmingGrade = 3;
        } else if (programmingPercentage <= 91) {
            programmingGrade = 4;
        }
        float avgGrade = (historyGrade + programmingGrade) / 2.0f;
        float avgPercentage = (historyPercentage + programmingPercentage) / 2.0f;
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
        BigDecimal annualProfit = monthlyIncome.subtract(monthlyRoomRent.add(monthlyProductionCost))
                .multiply(BigDecimal.valueOf(12));
        if (annualProfit.compareTo(BigDecimal.valueOf(0)) > 0) {
            System.out.printf("Прибыль за год: %+.2f руб.", annualProfit);
        } else {
            System.out.printf("Прибыль за год: %.2f руб.", annualProfit);
        }
    }
}