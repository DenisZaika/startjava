public class JaegerTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("\nСоздание первого Jaeger...");
        for (int i = 0; i < 5; i++) {
            System.out.print(".  " + "\r");
            Thread.sleep(150);
            System.out.print(".. " + "\r");
            Thread.sleep(150);
            System.out.print("..." + "\r");
            Thread.sleep(150);
        }
        Jaeger jaeger1 = new Jaeger();
        System.out.println("Настройка параметров...");
        for (int i = 0; i < 5; i++) {
            System.out.print(".  " + "\r");
            Thread.sleep(150);
            System.out.print(".. " + "\r");
            Thread.sleep(150);
            System.out.print("..." + "\r");
            Thread.sleep(150);
        }
        jaeger1.setModelName("Черно-Альфа");
        System.out.println("Имя модели: " + jaeger1.getModelName());
        jaeger1.setMark("Марк-1");
        System.out.println("Марк: " + jaeger1.getMark());
        jaeger1.setOrigin("Россия");
        System.out.println("Происхождение: " + jaeger1.getOrigin());
        jaeger1.setHeight(85.34f);
        System.out.println("Рост: " + jaeger1.getHeight() + " м");
        jaeger1.setWeight(2.412f);
        System.out.println("Вес: " + jaeger1.getWeight() + " т");
        jaeger1.setSpeed(3);
        System.out.println("Скорость: " + jaeger1.getSpeed());
        jaeger1.setStrength(10);
        System.out.println("Сила: " + jaeger1.getStrength());
        jaeger1.setArmor(10);
        System.out.println("Броня: " + jaeger1.getArmor());
        System.out.println(jaeger1.getModelName() + " " + jaeger1.move());
        System.out.println(jaeger1.getModelName() + " " + jaeger1.scanKaiju());
        System.out.println(jaeger1.getModelName() + " " + jaeger1.useVortexCannon());

        System.out.println("\nСоздание второго Jaeger...");
        for (int i = 0; i < 5; i++) {
            System.out.print(".  " + "\r");
            Thread.sleep(150);
            System.out.print(".. " + "\r");
            Thread.sleep(150);
            System.out.print("..." + "\r");
            Thread.sleep(150);
        }
        Jaeger jaeger2 = new Jaeger("Gipsy Danger", "Марк-3", "США", 79.25f, 1.98f, 7, 8, 6);
        System.out.println("Имя модели: " + jaeger2.getModelName());
        System.out.println("Марк: " + jaeger2.getMark());
        System.out.println("Происхождение: " + jaeger2.getOrigin());
        System.out.println("Рост: " + jaeger2.getHeight() + " м");
        System.out.println("Вес: " + jaeger2.getWeight() + " т");
        System.out.println("Скорость: " + jaeger2.getSpeed());
        System.out.println("Сила: " + jaeger2.getStrength());
        System.out.println("Броня: " + jaeger2.getArmor());
        System.out.println(jaeger2.getModelName() + " " + jaeger2.move());
        System.out.println(jaeger2.getModelName() + " " + jaeger2.scanKaiju());
        System.out.println(jaeger2.getModelName() + " " + jaeger2.useVortexCannon());
    }
}