package com.startjava.lesson_2_3_4.array;

public class TriangleCharsPrinter {

    public static void main(String[] args) {
        printCharsPyramid(sortChars('0', '9', true));
        printCharsPyramid(sortChars('/', '!', false));
        printCharsPyramid(sortChars('A', 'J', false));
    }

    private static String[] sortChars(char rangeStart, char rangeEnd, boolean isAscendingOrder) {
        if (rangeStart > rangeEnd) {
            System.out.printf("Ошибка: левая граница (%d) > правой (%d)%n%n", (int) rangeStart, (int) rangeEnd);
            return new String[0];
        }
        String[] pyramidParts = new String[rangeEnd - rangeStart + 1];
        int charRepeatsCount = 1;
        for (char i = 0; i < pyramidParts.length; i++) {
            char currSymbol = isAscendingOrder ?
                    (char) (rangeStart + i) :
                    (char) (rangeEnd - i);
            pyramidParts[i] = String.valueOf(currSymbol).repeat(charRepeatsCount);
            charRepeatsCount += 2;
        }
        return pyramidParts;
    }

    private static void printCharsPyramid(String[] pyramidParts) {
        int len = pyramidParts.length;
        if (len == 0) {
            return;
        }
        StringBuilder charsPyramid = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int spaceCount = len - (i + 1);
            charsPyramid.append(" ".repeat(spaceCount))
                        .append(pyramidParts[i])
                        .append("\n");
        }
        System.out.println(charsPyramid);
    }
}
