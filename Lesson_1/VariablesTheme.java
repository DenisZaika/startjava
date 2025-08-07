import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class VariablesTheme {
    public static void main(String[] args) {
        final LocalTime verificationStartTime = LocalTime.now();
        final long startTime = System.nanoTime();

        System.out.println("1. ВЫВОД ASCII-ГРАФИКИ");
        System.out.println("\nВывод в консоль слова JAVA c помощью конкатенации:\n");
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

        System.out.println("2. Расчет стоимости товара");
        System.out.println("\nПервый способ:");
        float penPrice = 105.5f;
        float bookPrice = 235.23f;
        float totalPrice = penPrice + bookPrice;
        float discount = totalPrice * 0.11f;
        float finalPrice = totalPrice - discount;
        System.out.printf("Стоимость товаров без скидки: %f руб.", totalPrice);
        System.out.printf("%nСумма скидки: %f руб.", discount);
        System.out.printf("%nСтоимость товаров со скидкой: %f руб.", finalPrice);
        System.out.println("\n\nВторой способ:");
        var penPriceBd = new BigDecimal("105.50");
        var bookPriceBd = new BigDecimal("235.23");
        var totalPriceBd = penPriceBd.add(bookPriceBd);
        var discountPercentBd = new BigDecimal("0.11");
        var discountBd = totalPriceBd.multiply(discountPercentBd).setScale(2, RoundingMode.HALF_UP);
        var finalPriceBd = totalPriceBd.subtract(discountBd).setScale(2, RoundingMode.HALF_UP);
        System.out.println("Стоимость товаров без скидки: " + totalPriceBd + " руб.");
        System.out.println("Сумма скидки: " + discountBd + " руб.");
        System.out.println("Стоимость товаров со скидкой: " + finalPriceBd + " руб.");

        System.out.println("\n3. Перестановка значений ячеек в таблице");
        int firstCell = 2;
        int secondCell = 5;
        System.out.printf("%nИсходные данные: A1 = %d, B1 = %d", firstCell, secondCell);
        System.out.println("\nМетод: третья переменная");
        int temp = firstCell;
        firstCell = secondCell;
        secondCell = temp;
        System.out.printf("Результат: A1 = %d, B1 = %d", firstCell, secondCell);
        System.out.println("\n\nМетод: арифметические операции");
        firstCell += secondCell;
        secondCell = firstCell - secondCell;
        firstCell -= secondCell;
        System.out.printf("Результат: A1 = %d, B1 = %d", firstCell, secondCell);
        System.out.println("\n\nМетод: побитовая операция ^");
        firstCell ^= secondCell;
        secondCell ^= firstCell;
        firstCell ^= secondCell;
        System.out.printf("Результат: A1 = %d, B1 = %d", firstCell, secondCell);

        System.out.println("\n\n4. Декодирование сообщения");
        int charCode1 = 1055;
        int charCode2 = 1088;
        int charCode3 = 1080;
        int charCode4 = 1074;
        int charCode5 = 1077;
        int charCode6 = 1090;
        System.out.printf("%n%4d%6d%6d%6d%6d%6d%n",
                charCode1, charCode2, charCode3, charCode4, charCode5, charCode6);
        System.out.printf("%4c%6c%6c%6c%6c%6c", 
                charCode1, charCode2, charCode3, charCode4, charCode5, charCode6);

        System.out.println("\n\n5. Анализ кода товара\n");
        int productCode = 734;
        int productCategory = productCode / 100;
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
                productCode, productCategory, productSubcategory, 
                packagingType, controlSum, virificationCode);

        System.out.println("\n6. Тестирование датчиков перед запуском ракеты\n");
        byte temperature = Byte.MAX_VALUE;
        System.out.printf("""
                [Температура, °C]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                %n""", temperature, ++temperature, --temperature);
        
        short pressure = Short.MAX_VALUE;
        System.out.printf("""
                [Давление, Па]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                %n""", pressure, ++pressure, --pressure);
        
        char systemStatusCode = Character.MAX_VALUE;
        System.out.printf("""
                [Код состояния системы]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                %n""", (int) systemStatusCode, (int) ++systemStatusCode, (int) --systemStatusCode);
        
        int traveledDistance = Integer.MAX_VALUE;
        System.out.printf("""
                [Пройденное расстояние, м]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                %n""", traveledDistance, ++traveledDistance, --traveledDistance);
        
        long flightDuration = Long.MAX_VALUE;
        System.out.printf("""
                [Время c момента старта, с]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """, flightDuration, ++flightDuration, --flightDuration);

        System.out.println("\n7. Вывод параметров JVM и ОС");
        Runtime rt = Runtime.getRuntime();
        int availableCpus = rt.availableProcessors();
        double totalMemory = rt.totalMemory() / (1024.0 * 1024.0);
        double freeMemory = rt.freeMemory() / (1024.0 * 1024.0);
        double usedMemory = totalMemory - freeMemory;
        double maxMemory = rt.maxMemory() / (1024.0 * 1024.0);
        System.out.printf("""
                %nХарактеристики JVM:
                  Доступное число ядер - %d
                  Выделенная память - %.1f МБ
                  Свободная память - %.1f МБ
                  Используемая память - %.1f МБ
                  Максимально доступная для выделения память - %.1f МБ
                """, 
                availableCpus, totalMemory, freeMemory, usedMemory, maxMemory);
        char systemDisk = System.getProperty("user.dir").charAt(0);
        String osVersion = System.getProperty("os.version");
        String javaVersion = System.getProperty("java.version");
        String fileSeparator = System.getProperty("file.separator");
        System.out.printf("""
                %nПараметры ОС:
                  Системный диск: %c
                  Версия ОС: %s
                  Версия java: %s
                  Символ разделения пути: %s
                """, 
                systemDisk, osVersion, javaVersion, fileSeparator);

        System.out.println("\n8. Замер времени работы кода\n");
        LocalTime verificationEndTime = LocalTime.now();
        long finishTime = System.nanoTime();
        double duration = (double) (finishTime - startTime) / 1e9;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss:SSS");
        System.out.printf("""
                Старт проверки: %s
                Финиш проверки: %s
                Время работы:   %.3f сек
                """, 
                dtf.format(verificationStartTime), dtf.format(verificationEndTime), duration);
    }
}