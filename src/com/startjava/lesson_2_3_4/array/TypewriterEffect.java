package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class TypewriterEffect {
    public static void main(String[] args) throws InterruptedException {
        String text1 = "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                "- Robert Martin";
        String text2 = "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                "- James Gosling";
        String text3 = null;
        String text4 = "";
        String[] texts = {text1, text2, text3, text4};
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
            }
            if (words[i].length() < words[minLengthIndex].length()) {
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
        String textWithMarkers = originText.replace("\n", "/n");
        String[] words = textWithMarkers.split("\\s+");
        int wordIndex = 0;
        for (int i = 0; i < words.length; i++) {
            if (!words[i].matches("\\p{P}")) {
                if ((wordIndex >= minMaxIndexes[0]) && (wordIndex <= minMaxIndexes[1])) {
                    words[i] = words[i].toUpperCase();
                }
                wordIndex++;
            }
        }
        String formattedText = String.join(" ", words);
        formattedText = formattedText.replaceAll("(?i)/n", "\n");
        return formattedText;
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
