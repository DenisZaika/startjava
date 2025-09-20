package com.startjava.lesson_2_3_4.array;

public class TypewriterEffect {

    public static void main(String[] args) throws InterruptedException {
        String text1 = """
                Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.
                - Robert Martin
                """;
        int[] minMaxIndexes = searchShortestLongestWord(text1);
        printFormattedText(formatText(minMaxIndexes, text1));

        String text2 = """
                Java - это C++, из которого убрали все пистолеты, ножи и дубинки.
                - James Gosling
                """;
        minMaxIndexes = searchShortestLongestWord(text2);
        printFormattedText(formatText(minMaxIndexes, text2));

        String text3 = null;
        minMaxIndexes = searchShortestLongestWord(text3);
        printFormattedText(formatText(minMaxIndexes, text3));

        String text4 = "";
        minMaxIndexes = searchShortestLongestWord(text4);
        printFormattedText(formatText(minMaxIndexes, text4));
    }

    private static int[] searchShortestLongestWord(String originText) {
        if (originText == null) {
            System.out.println("Ошибка в данных");
            return new int[0];
        }
        if (originText.isEmpty()) {
            System.out.println("Нет данных");
            return new int[0];
        }

        String[] words = originText.replaceAll("\\p{P}", "")
                                     .split("\\s+");
        int[] wordsLens = new int[words.length];
        for (int i = 0; i < wordsLens.length; i++) {
            wordsLens[i] = words[i].length();
        }
        int maxLengthIndex = 0;
        int minLengthIndex = 0;
        for (int i = 0; i < wordsLens.length; i++) {
            if (wordsLens[i] > wordsLens[maxLengthIndex]) {
                maxLengthIndex = i;
            }
            if (wordsLens[i] < wordsLens[minLengthIndex]) {
                minLengthIndex = i;
            }
        }
        return minLengthIndex > maxLengthIndex
                ? new int[]{maxLengthIndex, minLengthIndex}
                : new int[] {minLengthIndex, maxLengthIndex};
    }

    private static String formatText(int[] minMaxIndexes, String originText) {
        if (minMaxIndexes.length == 0) {
            return "";
        }
        StringBuilder formattedText = new StringBuilder();
        String[] lines = originText.split("\n");
        int wordIndex = 0;
        for (String line : lines) {
            String[] wordsInLine = line.split("\\s+");
            for (String word : wordsInLine) {
                if (word.matches("\\p{P}")) {
                    formattedText.append(word).append(" ");
                    continue;
                }
                formattedText.append(((wordIndex >= minMaxIndexes[0]) && (wordIndex <= minMaxIndexes[1]))
                        ? word.toUpperCase() : word);
                formattedText.append(" ");
                wordIndex++;
            }
            formattedText.append("\n");
        }
        return String.valueOf(formattedText);
    }

    private static void printFormattedText(String originText) throws InterruptedException {
        if (originText.isEmpty()) {
            return;
        }
        for (char letter : originText.toCharArray()) {
            System.out.print(letter);
            Thread.sleep(100);
        }
    }
}
