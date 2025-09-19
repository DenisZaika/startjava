package com.startjava.lesson_2_3_4.array;

public class TriangleCharsPrinter {

    public static void main(String[] args) {
        printTriangleChars(formTriangleParts('0', '9', true));
        printTriangleChars(formTriangleParts('/', '!', false));
        printTriangleChars(formTriangleParts('A', 'J', false));
    }

    private static String[] formTriangleParts(char rangeStart, char rangeEnd, boolean isAscendingOrder) {
        if (rangeStart > rangeEnd) {
            System.out.printf("Ошибка: левая граница (%d) > правой (%d)%n%n", (int) rangeStart, (int) rangeEnd);
            return new String[0];
        }
        String[] triangleParts = new String[rangeEnd - rangeStart + 1];
        int charCount = 1;
        for (char i = 0; i < triangleParts.length; i++) {
            char currSymbol = isAscendingOrder ? rangeStart++ : rangeEnd--;
            triangleParts[i] = String.valueOf(currSymbol).repeat(charCount);
            charCount += 2;
        }
        return triangleParts;
    }

    private static void printTriangleChars(String[] triangleParts) {
        int len = triangleParts.length;
        if (len == 0) {
            return;
        }
        StringBuilder charsTriangle = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int spaceCount = len - (i + 1);
            charsTriangle.append(" ".repeat(spaceCount))
                        .append(triangleParts[i])
                        .append("\n");
        }
        System.out.println(charsTriangle);
    }
}
