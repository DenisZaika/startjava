package com.startjava.lesson_2_3_4.array;

public class ArrayElementsDeleting {

    public static void main(String[] args) {
        int[] indexes = {-1, 15, 0, 14};
        float[] array = new float[15];
        for (int index : indexes) {
            fillArray(array);
            if (validateIndex(index, array)) {
                System.out.print("\nИсходный массив:\n");
                showArray(array);
                deleteElementsMoreThan(index, array);
                System.out.print("Измененный массив:\n");
                showArray(array);
            }
        }
    }

    private static void fillArray(float[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (Math.random());
        }
    }

    private static boolean validateIndex(int index, float[] array) {
        if (index < 0 || index >= array.length) {
            System.out.println("\nОшибка: введен некорректный индекс " + index);
            System.out.println("Допустимые для ввода индексы от 0 до " + (array.length - 1));
            return false;
        }
        return true;
    }

    private static void deleteElementsMoreThan(int index, float[] array) {
        System.out.printf("array[%d] = %.3f%n", index, array[index]);
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[index]) {
                array[i] = 0;
            }
        }
    }

    private static void showArray(float[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%.3f ", array[i]);
            if ((i + 1) % 8 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
