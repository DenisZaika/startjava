package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class TypewriterEffect {
    public static void main(String[] args) throws InterruptedException {
        String[] texts = {
                "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                        "- Robert Martin",
                "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n - James Gosling",
                null,
                ""
        };

        for (String text : texts) {
            int[] minMaxIndexes = findShortestAndLongestWordIndexes(text);
            type(toUpperCaseRange(minMaxIndexes, text));
        }
    }

    private static int[] findShortestAndLongestWordIndexes(String originText) {
        if (originText == null) {
            System.out.println("Ошибка в данных");
            return new int[0];
        }
        if (originText.isEmpty()) {
            System.out.println("Нет данных");
            return new int[0];
        }

        String[] words = originText.replaceAll("\\p{P}", "").split("\\s+");
        int maxLengthIndex = 0;
        int minLengthIndex = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > words[maxLengthIndex].length()) {
                maxLengthIndex = i;
            } else if (words[i].length() < words[minLengthIndex].length()) {
                minLengthIndex = i;
            }
        }
        return new int[]{minLengthIndex, maxLengthIndex};
    }

    private static String toUpperCaseRange(int[] minMaxIndexes, String originText) {
        if (minMaxIndexes.length == 0) {
            return "";
        }
        Arrays.sort(minMaxIndexes);
        String[] words = originText.split("\\s+");
        int wordIndex = 0;
        for (int i = 0; i < words.length; i++) {
            String cleanWord = words[i].replaceAll("\\p{P}", "");
            if (!cleanWord.isEmpty()) {
                if ((wordIndex >= minMaxIndexes[0]) && (wordIndex <= minMaxIndexes[1])) {
                    words[i] = words[i].toUpperCase();
                }
                wordIndex++;
            }
        }
        return String.join(" ", words);
    }

    private static void type(String originText) throws InterruptedException {
        if (originText.isEmpty()) {
            return;
        }
        for (char letter : originText.toCharArray()) {
            System.out.print(letter);
            Thread.sleep(100);
        }
        System.out.println();
    }
}
