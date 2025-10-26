package com.startjava.graduation;

import java.util.Arrays;

public class Bookshelf {
    public static final int TOTAL_SHELVES = 10;

    private final Book[] books;

    private int bookCount;

    public Bookshelf() {
        books = new Book[TOTAL_SHELVES];
        bookCount = 0;
    }

    public Book[] getBooks() {
        return Arrays.copyOf(books, bookCount);
    }

    public int getBookCount() {
        return bookCount;
    }

    public int getFreeShelfCount() {
        return TOTAL_SHELVES - bookCount;
    }

    public String find(String name) {
        int position = findBookPosition(name);
        if (position != -1) {
            System.out.println("\nКнига успешно найдена!");
            return "Найденная книга: " + books[position].toString();
        }
        return "\nОшибка: книги \"" + name + "\" в шкафу нет!";
    }

    public void add(Book book) {
        books[bookCount] = book;
        bookCount++;
        System.out.println("\nКнига успешно добавлена!");
    }

    public void delete(String name) {
        int position = findBookPosition(name);
        if (position != -1) {
            System.out.println("\nКнига \"" + books[position].toString() + "\" успешно удалена!");
            System.arraycopy(books, position + 1, books, position, bookCount - position - 1);
            books[bookCount - 1] = null;
            bookCount--;
        } else {
            System.out.println("\nОшибка: указанная книга не удалена, \"" + name + "\" в шкафу отсутствует!");
        }
    }

    private int findBookPosition(String name) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        Arrays.fill(books, null);
        bookCount = 0;
        System.out.println("\nШкаф успешно очищен от всех книг!");
    }
}
