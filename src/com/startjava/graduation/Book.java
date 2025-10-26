package com.startjava.graduation;

import java.time.Year;

@SuppressWarnings("ClassCanBeRecord")
public class Book {
    public static final int MIN_YEAR = 1800;
    public static final int CURR_YEAR = 2025;

    private final String author;
    private final String name;
    private final Year publicationYear;

    public Book(String author, String name, String publicationYear) {
        validateBookAttributes(author, name, publicationYear);
        this.author = author;
        this.name = name;
        this.publicationYear = Year.of(Integer.parseInt(publicationYear));
    }

    public String getName() {
        return name;
    }

    private void validateBookAttributes(String author, String name, String publicationYear)
            throws IllegalArgumentException {
        validateNotEmpty(author, "имя автора");
        validateNotEmpty(name, "название книги");
        validateNotEmpty(publicationYear, "год издания");
        if (!isValidYear(publicationYear)) {
            throw new IllegalArgumentException("Ошибка: год издания должен быть между 1800 и текущим");
        }
    }

    private void validateNotEmpty(String attributeValue, String fieldName) throws IllegalArgumentException {
        if (attributeValue == null || attributeValue.isEmpty()) {
            throw new IllegalArgumentException("Ошибка: " + fieldName + " не может быть пустым");
        }
    }

    private boolean isValidYear(String yearStr) {
        int yearInt = Integer.parseInt(yearStr);
        return yearInt >= MIN_YEAR && yearInt <= CURR_YEAR;
    }

    public String toString() {
        return author + ", " + name + ", " + publicationYear;
    }
}

