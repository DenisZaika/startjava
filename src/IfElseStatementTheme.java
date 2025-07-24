import java.math.BigDecimal;
import java.math.RoundingMode;

public class IfElseStatementTheme {
    public static void main(String[] args) {
        System.out.println("1. Перевод псевдокода на язык Java");
        boolean isMale = true;
        if (isMale) {
            System.out.println("Клиент мужского пола");
        } else {
            System.out.println("Клиент женского пола");
        }

        int age = 17;
        if (age > 18) {
            System.out.println("Клиент совершеннолетний");
        } else {
            System.out.println("Клиент несовершеннолетний");
        }

        float height = 1.6F;
        if (height < 1.8) {
            System.out.println("Клиент невысокий");
        } else {
            System.out.println("Клиент высокий");
        }

        System.out.println("\n2. Поиск большего числа шагов");
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
        float avgStepsCount = (float) (yesterdayStepsCount + todayStepsCount) / 2.0f;
        System.out.printf("Среднее количество шагов: %.2f%n", avgStepsCount);

        System.out.println("\n3. Проверка количества гостей");
        int guestsCount = -2;
        if (guestsCount < 0) {
            System.out.println("Ошибка! Число гостей не может быть отрицательным числом!");
        } else if (guestsCount == 0) {
            System.out.println("Пока никто не записался на мероприятие!");
        } else if (guestsCount % 2 == 0) {
            System.out.printf("Записалось %d гостей. Можно формировать пары для конкурсов.", guestsCount);
        } else if (guestsCount % 2 == 1) {
            System.out.printf("Записалось %d гостей. Нужны индивидуальные задания.", guestsCount);
        }

        System.out.println("\n4. Определение первого символа никнейма");
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
        System.out.println("\nВторой способ: методы класса Character");
        if (Character.isLowerCase(firstNameChar)) {
            System.out.printf("Имя \"%s\" начинается с маленькой буквы \"%c\"", name, firstNameChar);
        } else if (Character.isUpperCase(firstNameChar)) {
            System.out.printf("Имя \"%s\" начинается с большой буквы \"%c\"", name, firstNameChar);
        } else if (Character.isDigit(firstNameChar)) {
            System.out.printf("Имя \"%s\" начинается с цифры \"%c\"", name, firstNameChar);
        } else if (Character.compare(firstNameChar, '$') == 0) {
            System.out.printf("Имя \"%s\" начинается с символа \"%c\"", name, firstNameChar);
        }

        System.out.println("\n\n5. Инвентаризация");
        int serialNumber = 123;
        int computerNumber = 123;
        if (serialNumber == computerNumber) {

        }

        System.out.println("\n6. Подсчет начисленных банком %");
        System.out.println("\nПервый способ: использование float");
        float depositAmount = 321123.79f;
        float interestAmount;
        if (depositAmount < 100_000) {
            interestAmount = (float) (depositAmount * 0.05);
        } else if ((depositAmount >= 100_000) && (depositAmount <= 300_000)) {
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
        if (depositAmountBd.compareTo(BigDecimal.valueOf(100_000)) < 0) {
            BigDecimal interestAmountBd = depositAmountBd.multiply(rate5);
        } else if ((depositAmountBd.compareTo(BigDecimal.valueOf(100_000)) >= 0) &&
                (depositAmountBd.compareTo(BigDecimal.valueOf(300_000)) <= 0)) {
            BigDecimal interestAmountBd = depositAmountBd.multiply(rate7);
        } else {
            BigDecimal interestAmountBd = depositAmountBd.multiply(rate10);
        }
        System.out.printf("""
                Сумма вклада:          %.2f руб
                Сумма начисленного %% : %.2f руб
                Итоговая сумма с %% :   %.2f руб
                """,
                depositAmount, interestAmount, totalAmount);

        System.out.println("\n7. Определение оценки по предметам");
        int historyPercentage = 59;
        int programmingPercentage = 92;
        int historyGrade;
        if (historyPercentage < 60) {
            historyGrade = 2;
        } else if (historyPercentage <= 73) {
            historyGrade = 3;
        } else if (historyPercentage <= 91) {
            historyGrade = 4;
        } else {
            historyGrade = 5;
        }
        int programmingGrade;
        if (programmingPercentage < 60) {
            programmingGrade = 2;
        } else if (programmingPercentage <= 73) {
            programmingGrade = 3;
        } else if (programmingPercentage <= 91) {
            programmingGrade = 4;
        } else {
            programmingGrade = 5;
        }
        float avgGrade = (float) (historyGrade + programmingGrade) / 2.0f;
        float avgPercentage = (float) (historyPercentage+programmingPercentage) / 2.0f;
        System.out.printf("""
                Оценки по предметам:
                  История:          %d
                  Программирование: %d%n
                Средний балл по предметам: %.2f
                Средний %% по предметам:   %.2f
                """,
                historyGrade, programmingGrade, avgGrade, avgPercentage);

        System.out.println("\n8. Расчет годовой прибыли");
        BigDecimal monthlyIncome = new BigDecimal("13025.233");
        BigDecimal monthlyRoomRent = new BigDecimal("5123.018");
        BigDecimal monthlyproductionCost = new BigDecimal("9001.729");
        BigDecimal monthlyExpense = monthlyRoomRent.add(monthlyproductionCost);
        BigDecimal monthlyProfit = monthlyIncome.subtract(monthlyExpense);
        BigDecimal annualProfit = monthlyProfit.multiply(BigDecimal.valueOf(12));
        if (annualProfit.compareTo(BigDecimal.valueOf(0)) > 0) {
            System.out.printf("Прибыль за год: %+.2f руб.", annualProfit);
        } else {
            System.out.printf("Прибыль за год: %.2f руб.", annualProfit);
        }
    }
}