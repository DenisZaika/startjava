package com.startjava.graduation;

import java.time.Year;

@SuppressWarnings("ClassCanBeRecord")
public class Book {
    private static final Year MIN_YEAR = Year.of(1800);

    private final String author;
    private final String title;
    private final Year publishedYear;

    public Book(String author, String title, Year publishedYear) {
        validateBookAttributes(author, title, publishedYear);
        this.author = author;
        this.title = title;
        this.publishedYear = publishedYear;
    }

    private void validateBookAttributes(String author, String title, Year publishedYear) {
        validateNotEmpty(author, "имя автора");
        validateNotEmpty(title, "название книги");
        validateYear(publishedYear);
    }

    private void validateNotEmpty(String attributeValue, String attributeName) {
        if (attributeValue == null || attributeValue.isBlank()) {
            throw new IllegalArgumentException("Ошибка: " + attributeName + " не может быть пустым");
        }
    }

    private void validateYear(Year publishedYear) {
        if (!isValidYear(publishedYear)) {
            throw new IllegalArgumentException("Ошибка: год издания должен быть между " + MIN_YEAR +
                    " и текущим " + Year.now());
        }
    }

    private boolean isValidYear(Year publishedYear) {
        return publishedYear.isAfter(MIN_YEAR) && publishedYear.isBefore(Year.now());
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return author + ", " + title + ", " + publishedYear;
    }
}

