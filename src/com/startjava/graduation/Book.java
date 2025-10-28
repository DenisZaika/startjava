package com.startjava.graduation;

import java.time.Year;

@SuppressWarnings("ClassCanBeRecord")
public class Book {
    private static final Year MIN_YEAR = Year.of(1800);
    private static final Year CURR_YEAR = Year.now();

    private final String author;
    private final String title;
    private final Year publishedYear;

    public Book(String author, String title, String publishedYear) {
        validateBookAttributes(author, title, publishedYear);
        this.author = author;
        this.title = title;
        this.publishedYear = Year.of(Integer.parseInt(publishedYear));
    }

    private void validateBookAttributes(String author, String title, String publishedYear)
            throws IllegalArgumentException {
        validateNotEmpty(author, "имя автора");
        validateNotEmpty(title, "название книги");
        validateNotEmpty(publishedYear, "год издания");
        if (!isValidYear(publishedYear)) {
            throw new IllegalArgumentException("Ошибка: год издания должен быть между " + MIN_YEAR +
                    " и текущим " + CURR_YEAR);
        }
    }

    private void validateNotEmpty(String attributeValue, String attributeName)
            throws IllegalArgumentException {
        if (attributeValue == null || attributeValue.isBlank()) {
            throw new IllegalArgumentException("Ошибка: " + attributeName + " не может быть пустым");
        }
    }

    private boolean isValidYear(String publishedYearStr) {
        Year publishedYear = Year.of(Integer.parseInt(publishedYearStr));
        return publishedYear.compareTo(MIN_YEAR) >= 0 && publishedYear.compareTo(CURR_YEAR) <= 0;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return author + ", " + title + ", " + publishedYear;
    }
}

