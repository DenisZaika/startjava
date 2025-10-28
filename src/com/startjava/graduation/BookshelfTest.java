package com.startjava.graduation;

import com.startjava.lesson_2_3_4.array.TypewriterEffect;
import java.util.Scanner;

public class BookshelfTest {
    private static final Scanner SCAN = new Scanner(System.in);
    private static final int MIN_MENU_POINT = 1;
    private static final int MAX_MENU_POINT = 5;

    public static void main(String[] args) throws InterruptedException {
        String welcomeText = "Добро пожаловать в книжный шкаф!\n" +
                "Здесь Вы можете найти интересные книги или добавить новые в свою коллекцию!";
        TypewriterEffect.type(welcomeText);
        Bookshelf bookshelf = new Bookshelf();
        while (true) {
            printBookshelf(bookshelf);
            printMenu();
            if (!handleMenu(bookshelf)) {
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
            int longestBookData = bookshelf.getLength();
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

    private static void printMenu() {
        System.out.println("""
                \nМеню:
                1. Добавить книгу
                2. Найти книгу
                3. Удалить книгу
                4. Очистить шкаф
                5. Закрыть шкаф
                """);
    }

    private static boolean handleMenu(Bookshelf bookshelf) {
        boolean isCorrectChoice;
        do {
            System.out.print("Ваш выбор: ");
            String userChoice = SCAN.nextLine();
            isCorrectChoice = true;
            switch (userChoice) {
                case "1":
                    if (bookshelf.getFreeShelfCount() == 0 || bookshelf.add(addBookToShelf()) == 0) {
                        System.out.println("\nОшибка: книга не может быть сохранена, " +
                                "в шкафу закончилось место!");
                    } else {
                        System.out.println("\nКнига успешно добавлена!");
                    }
                    break;
                case "2":
                    Book foundBook = bookshelf.find(inputTitle());
                    if (foundBook == null) {
                        System.out.println("\nОшибка: книга не найдена!");
                    } else {
                        System.out.println("\nКнига успешно найдена!");
                        System.out.println("Найденная книга: " + foundBook);
                    }
                    break;
                case "3":
                    Book deletedBook = bookshelf.delete(inputTitle());
                    if (deletedBook == null) {
                        System.out.println("\nОшибка: книга не удалена, так как её нет в шкафу!");
                    } else {
                        System.out.println("\nКнига \"" + deletedBook + "\" успешно удалена!");
                    }
                    break;
                case "4":
                    bookshelf.clear();
                    System.out.println("\nШкаф успешно очищен от всех книг!");
                    break;
                case "5":
                    System.out.println("Шкаф закрыт.");
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

    private static Book addBookToShelf() {
        while (true) {
            System.out.print("\n*Введите данные книги*");
            System.out.print("\nАвтор: ");
            String bookAuthor = SCAN.nextLine();
            System.out.print("Название: ");
            String title = SCAN.nextLine();
            System.out.print("Год издания: ");
            String publishedYear = SCAN.nextLine();
            try {
                return new Book(bookAuthor, title, publishedYear);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String inputTitle() {
        System.out.print("Введите название книги: ");
        return SCAN.nextLine();
    }
}
