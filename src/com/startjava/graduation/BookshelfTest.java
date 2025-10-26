package com.startjava.graduation;

import com.startjava.lesson_2_3_4.array.TypewriterEffect;
import java.util.Scanner;

public class BookshelfTest {
    private static final int MIN_MENU_POINT = 1;
    private static final int MAX_MENU_POINT = 5;
    private static final Scanner SCAN = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        String welcomeText = "Добро пожаловать в книжный шкаф!\n" +
                "Здесь Вы можете найти интересные книги или добавить новые в свою коллекцию!";
        TypewriterEffect.type(welcomeText);
        Bookshelf bookshelf = new Bookshelf();
        String menu = """
                1. Найти книгу
                2. Добавить книгу
                3. Удалить книгу
                4. Очистить шкаф
                5. Закрыть шкаф
                """;
        while (true) {
            printBookshelf(bookshelf);
            System.out.println("\nМеню: \n" + menu);
            if (!handleMenu(bookshelf)) {
                System.out.println("Шкаф закрыт.");
                return;
            }
            do {
                System.out.print("Для продолжения работы нажмите клавишу <Enter>");
            } while (SCAN.nextLine().equals("\n"));
        }
    }

    private static void printBookshelf(Bookshelf bookshelf) {
        if (bookshelf.getBookCount() >= 1) {
            System.out.println("\nВ шкафу книг - " + bookshelf.getBookCount() +
                    ", свободно полок - " + bookshelf.getFreeShelfCount() + "\n");
            int longestBookData = findLongestBookData(bookshelf);
            for (Book book : bookshelf.getBooks()) {
                System.out.print("|" + book.toString() +
                        " ".repeat(longestBookData - book.toString().length()) + "|\n");
                System.out.println("|" + "-".repeat(longestBookData) + "|");
            }
            System.out.println("|" + " ".repeat(longestBookData) + "|");
        } else {
            System.out.println("\nШкаф пуст. Вы можете добавить в него первую книгу");
        }
    }

    private static int findLongestBookData(Bookshelf bookshelf) {
        int max = 0;
        for (Book book : bookshelf.getBooks()) {
            if (book.toString().length() > max) {
                max = book.toString().length();
            }
        }
        return max;
    }

    private static boolean handleMenu(Bookshelf bookshelf) {
        boolean isCorrectChoice;
        do {
            System.out.print("Ваш выбор: ");
            String userChoice = SCAN.nextLine();
            isCorrectChoice = true;
            switch (userChoice) {
                case "1":
                    System.out.println(bookshelf.find(inputBookName()));
                    break;
                case "2":
                    if (bookshelf.getFreeShelfCount() == 0) {
                        System.out.println("\nОшибка: книга не может быть сохранена, " +
                                "в шкафу закончилось место!");
                    } else {
                        bookshelf.add(addBookToShelf());
                    }
                    break;
                case "3":
                    bookshelf.delete(inputBookName());
                    break;
                case "4":
                    bookshelf.clear();
                    break;
                case "5":
                    return false;
                default:
                    System.out.println("Ошибка: неверное значение меню (" + userChoice +
                            "). Допустимые значения: " + MIN_MENU_POINT +
                            " - " + MAX_MENU_POINT);
                    isCorrectChoice = false;
                    break;
            }
        } while (!isCorrectChoice);
        return true;
    }

    private static String inputBookName() {
        System.out.print("Введите название книги: ");
        return SCAN.nextLine();
    }

    private static Book addBookToShelf() {
        while (true) {
            System.out.print("\n*Введите данные книги*");
            System.out.print("\nАвтор: ");
            String bookAuthor = SCAN.nextLine();
            System.out.print("Название: ");
            String bookName = SCAN.nextLine();
            System.out.print("Год издания: ");
            String publicationYear = SCAN.nextLine();
            try {
                return new Book(bookAuthor, bookName, publicationYear);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
