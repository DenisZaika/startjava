package com.startjava.graduation;

import java.util.Arrays;

public class Bookshelf {
    private static final int TOTAL_SHELVES = 10;

    private final Book[] books;

    private int bookCount;
    private int length;

    public Bookshelf() {
        books = new Book[TOTAL_SHELVES];
        bookCount = 0;
        length = 0;
    }

    public Book[] getBooks() {
        return Arrays.copyOf(books, bookCount);
    }

    public int getBookCount() {
        return bookCount;
    }

    public int getLength() {
        return length;
    }

    public int getFreeShelfCount() {
        return TOTAL_SHELVES - bookCount;
    }

    public int add(Book book) {
        if (bookCount >= TOTAL_SHELVES) {
            return 0;
        }
        books[bookCount++] = book;
        calcLength();
        return 1;
    }

    private void calcLength() {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].toString().length() > length) {
                length = books[i].toString().length();
            }
        }
    }

    public Book find(String title) {
        int position = findBookPosition(title);
        if (position != -1) {
            return books[position];
        }
        return null;
    }

    public Book delete(String title) {
        int position = findBookPosition(title);
        if (position != -1) {
            final Book foundBook = books[position];
            System.arraycopy(books, position + 1, books, position, bookCount - position - 1);
            books[bookCount - 1] = null;
            bookCount--;
            calcLength();
            return foundBook;
        }
        return null;
    }

    private int findBookPosition(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equals(title)) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        Arrays.fill(books, 0, bookCount, null);
        bookCount = 0;
        length = 0;
    }
}
