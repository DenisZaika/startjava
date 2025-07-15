import java.math.BigDecimal;
import java.math.RoundingMode;

public class VariablesTheme {
    public static void main(String[] args) {
        System.out.println("1. ВЫВОД ASCII-ГРАФИКИ");
        System.out.println("Вывод в консоль слова JAVA c помощью конкатенации:\n");
        System.out.println(
                "                     /\\\n" + 
                "   J    a  v     v  /  \\\n" +
                "   J   a a  v   v  /_( )\\\n" +
                "J  J  aaaaa  V V  /      \\\n" +
                " JJ  a     a  V  /___/\\___\\\n");
        System.out.println("Вывод в консоль слова JAVA c помощью текстового блока:\n");
        System.out.println("""
                                     /\\
                   J    a  v     v  /  \\
                   J   a a  v   v  /_( )\\
                J  J  aaaaa  V V  /      \\
                 JJ  a     a  V  /___/\\___\\
                """);

        System.out.println("\n2. Расчет стоимости товара");
        System.out.println("\nПервый способ:");
        float penPrice = 105.5f;
        float bookPrice = 235.23f;
        float totalPrice = penPrice + bookPrice;
        float discount = totalPrice * 0.11f;
        float finalPrice = totalPrice - discount;
        System.out.println("Стоимость товаров без скидки: %f руб.".formatted(totalPrice));
        System.out.println("Сумма скидки: %f руб.".formatted(discount));
        System.out.println("Стоимость товаров со скидкой: %f руб.".formatted(finalPrice));
        System.out.println("\nВторой способ:");
        // .add(b) - сумма
        // .substract(b) - вычитание
        // .abs() -модуль
        // .negate() - унарный минус
        // .multiply(b) умножение
        // .setScale(точность, RoundingMode.HALF_UP)
        // .divide(b, точность RoundingMode.HALF_UP) - деление
        // .compareTo(b) == 0 - сравнение на равенство (true - если верно); < - если проверка на меньше
        // .intValueExact() - вывод целой части, для дроби уточнить округление
        // .short(byte)ValueExact(точность)
        // .ToPlainString() - вывод текстового представления ВСЕГДА ПРИ ВЫВОДЕ В ЛОГИ И 
        // ОТОБРАЖЕНИИ ПОЛЬЗОВАТЕЛЮ
        var penPriceBd = new BigDecimal("105.50");
        var bookPriceBd = new BigDecimal("235.23");
        var totalPriceBd = penPriceBd.add(bookPriceBd);
        var discountPercentBd = new BigDecimal("0.11");
        var discountBd = totalPriceBd.multiply(discountPercentBd).setScale(2, RoundingMode.HALF_UP);
        var finalPriceBd = totalPriceBd.subtract(discountBd).setScale(2, RoundingMode.HALF_UP);
        System.out.println("Стоимость товаров без скидки: " + totalPriceBd.toPlainString() + " руб.");
        System.out.println("Сумма скидки: " + discountBd.toPlainString() + " руб.");
        System.out.println("Стоимость товаров со скидкой: " + finalPriceBd.toPlainString() + " руб.");

        System.out.println("\n3. Перестановка значений ячеек в таблице");

        System.out.println("\n4. Декодирование сообщения");
        int firstCharCode = 1055;
        int secondCharCode = 1088;
        int thirdCharCode = 1080;
        int fourthCharCode = 1074;
        int fifthCharCode = 1077;
        int sixthCharCode = 1090;
        char firstChar = (char) firstCharCode;
        char secondChar = (char) secondCharCode;
        char thirdChar = (char) thirdCharCode;
        char fourthChar = (char) fourthCharCode;
        char fifthChar = (char) fifthCharCode;
        char sixthChar = (char) sixthCharCode;
        System.out.printf("%6d%6d%6d%6d%6d%6d\n", 
                firstCharCode, secondCharCode, 
                thirdCharCode, fourthCharCode, 
                fifthCharCode, sixthCharCode);
        System.out.printf("%6s%6s%6s%6s%6s%6s", 
                (char) firstCharCode, (char) secondCharCode, 
                (char) thirdCharCode, (char) fourthCharCode, 
                (char) fifthCharCode, (char) sixthCharCode);

        System.out.println("\n\n5. Анализ кода товара");
        var productCode = 734;
        var productCategory = productCode / 100;
        int productSubcategory = productCode / 10 % 10;
        int packagingType = productCode % 10;
        int controlSum = productCategory + productSubcategory + packagingType;
        int virificationCode = productCategory * productSubcategory * packagingType;
        System.out.printf("""
                Код товара: %d
                  категория товара - %d
                  подкатегория - %d
                  тип упаковки - %d
                Контрольная сумма = %d
                Проверочный код = %d
                """,
                productCode,
                productCategory,
                productSubcategory,
                packagingType,
                controlSum,
                virificationCode);

        System.out.println("\n\n6. Тестирование датчиков перед запуском ракеты\n");
        byte temperature = Byte.MAX_VALUE;
        System.out.printf("""
                [Температура, °C]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                \n""",
                temperature,
                ++temperature,
                --temperature);
        short pressure = Short.MAX_VALUE;
        System.out.printf("""
                [Давление, Па]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                \n""",
                pressure,
                ++pressure,
                --pressure);
        char systemStatusCode = Character.MAX_VALUE;
        System.out.printf("""
                [Код состояния системы]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                \n""",
                (int) systemStatusCode,
                (int) ++systemStatusCode,
                (int) --systemStatusCode);
        int traveledDistance = Integer.MAX_VALUE;
        System.out.printf("""
                [Пройденное расстояние, м]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                \n""",
                traveledDistance,
                ++traveledDistance,
                --traveledDistance);
        long flightDuration = Long.MAX_VALUE;
        System.out.printf("""
                [Время c момента старта, с]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """,
                flightDuration,
                ++flightDuration,
                --flightDuration);
    }
}