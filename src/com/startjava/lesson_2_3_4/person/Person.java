package com.startjava.lesson_2_3.person;

public class Person {

    String gender = "male";
    String name = "Denis";
    int height = 172;
    int weight = 71;
    int age = 25;

    void move() {
        System.out.println("Прошел 1 метр");
    }

    boolean sit() {
        System.out.println("Человек сел");
        return true;
    }

    void run() {
        System.out.println("Человек пробежал 8 метров");
    }

    void speak() {
        System.out.println("Человек разговаривает");
    }

    void learnJava() {
        System.out.println("Учит Java");
    }
}