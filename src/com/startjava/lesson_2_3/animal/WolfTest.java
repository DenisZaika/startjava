package com.startjava.lesson_2_3.animal;

public class WolfTest {

    public static void main(String[] args) {
        Wolf wolfOne = new Wolf();
        wolfOne.setGender("Самец");
        wolfOne.setName("Клык");
        wolfOne.setWeight(30);
        wolfOne.setAge(9);
        wolfOne.setColoring("Серый");
        System.out.println("Пол: " + wolfOne.getGender());
        System.out.println("Кличка: " + wolfOne.getName());
        System.out.println("Вес: " + wolfOne.getWeight() + " кг");
        System.out.println("Возраст " + wolfOne.getAge() + " лет");
        System.out.println("Окрас: " + wolfOne.getColoring());
        wolfOne.move();
        wolfOne.sit();
        wolfOne.run();
        wolfOne.howl();
        wolfOne.hunt();
    }
}