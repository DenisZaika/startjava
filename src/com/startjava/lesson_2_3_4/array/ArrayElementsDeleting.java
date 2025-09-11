package com.startjava.lesson_2_3_4.array;

public class ArrayElementsDeleting {

    public static void main(String[] args) {
        int[] indexes = {-1, 15, 0, 14};
        float[] array = new float[15];
        for (int index : indexes) {
            fillArray(array);
            System.out.print("\nИсходный массив: ");
            showArray(array);
            if (deleteElements(index, array)) {
                System.out.print("Измененный массив: ");
                showArray(array);
            }
        }
    }

    private static void fillArray(float[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (Math.random());
        }
    }

    private static boolean deleteElements(int num, float[] array) {
        if (num < 0 || num >= array.length) {
            System.out.println("Ошибка: введен некорректный индекс " + num);
            System.out.println("Допустимые для ввода индексы от 0 до " + (array.length - 1));
            return false;
        }
        System.out.printf("array[%d] = %.3f%n", num, array[num]);
        for (int i = num + 1; i < array.length; i++) {
            array[i] = 0;
        }
        return true;
    }

    private static void showArray(float[] array) {
        for (float num : array) {
            System.out.printf("%.3f ", num);
        }
        System.out.println();
    }
}
