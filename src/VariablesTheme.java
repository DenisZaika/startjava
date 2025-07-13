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
        // .ToPlainString() - вывод текстового представления ВСЕГДА ПРИ ВЫВОДЕ В ЛОГИ И ОТОБРАЖЕНИИ ПОЛЬЗОВАТЕЛЮ
        var penPriceBd = new BigDecimal("105.50");
        var bookPriceBd = new BigDecimal("235.23");
        var totalPriceBd = penPriceBd.add(bookPriceBd);
        var discountPercentBd = new BigDecimal("0.11");
        var discountBd = totalPriceBd.multiply(discountPercentBd).setScale(2, RoundingMode.HALF_UP);
        var finalPriceBd = totalPriceBd.subtract(discountBd).setScale(2, RoundingMode.HALF_UP);
        System.out.println("Стоимость товаров без скидки: " + totalPriceBd.toPlainString() + " руб.");
        System.out.println("Сумма скидки: " + discountBd.toPlainString() + " руб.");
        System.out.println("Стоимость товаров со скидкой: " + finalPriceBd.toPlainString() + " руб.");
    };
}