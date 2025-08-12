public class WolfTest {

    public static void main(String[] args) {
        Wolf wolfOne = new Wolf();
        wolfOne.gender = "Самец";
        wolfOne.name = "Клык";
        wolfOne.weight = 30;
        wolfOne.age = 7;
        wolfOne.coloring = "Серый";
        System.out.println("Пол: " + wolfOne.gender);
        System.out.println("Кличка: " + wolfOne.name);
        System.out.println("Вес: " + wolfOne.weight + " кг");
        System.out.println("Возраст " + wolfOne.age + " лет");
        System.out.println("Окрас: " + wolfOne.coloring);
        wolfOne.move();
        wolfOne.sit();
        wolfOne.run();
        wolfOne.howl();
        wolfOne.hunt();
    }
}