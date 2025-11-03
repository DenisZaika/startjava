package com.startjava.graduation;

import com.startjava.lesson_2_3_4.array.TypewriterEffect;
import java.time.Year;
import java.util.Scanner;

public class BookshelfTest {
    private static final int MIN_MENU_ITEM = 1;
    private static final int MAX_MENU_ITEM = 5;

    public static void main(String[] args) throws InterruptedException {
        String welcomeText = "Добро пожаловать в книжный шкаф!\n" +
                "Здесь Вы можете найти интересные книги или добавить новые в свою коллекцию!";
        TypewriterEffect.type(welcomeText);
        Bookshelf bookshelf = new Bookshelf();
        Scanner scan = new Scanner(System.in);
        openBookshelf(bookshelf, scan);
    }

    private static void openBookshelf(Bookshelf bookshelf, Scanner scan) {
        while (true) {
            printBookshelf(bookshelf);
            printMenu();
            if (!handleMenu(bookshelf, scan)) {
                return;
            }
            do {
                System.out.print("Для продолжения работы нажмите клавишу <Enter>");
            } while (scan.nextLine().equals("\n"));
        }
    }

    private static void printBookshelf(Bookshelf bookshelf) {
        if (bookshelf.getBookCount() == 0) {
            System.out.println("\nШкаф пуст. Вы можете добавить в него первую книгу");
            return;
        }
        System.out.println("\nВ шкафу книг - " + bookshelf.getBookCount() +
                ", свободно полок - " + bookshelf.getFreeShelfCount() + "\n");
        int shelfLength = bookshelf.getLength();
        for (Book book : bookshelf.getBooks()) {
            System.out.print("|" + book.toString() +
                    " ".repeat(shelfLength - book.toString().length()) + "|\n");
            System.out.println("|" + "-".repeat(shelfLength) + "|");
        }
        System.out.println("|" + " ".repeat(shelfLength) + "|");
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

    private static boolean handleMenu(Bookshelf bookshelf, Scanner scan) {
        boolean isCorrectChoice;
        do {
            System.out.print("Ваш выбор: ");
            String userChoice = scan.nextLine();
            isCorrectChoice = true;
            switch (userChoice) {
                case "1" -> addBook(bookshelf, scan);
                case "2" -> findBook(bookshelf, scan);
                case "3" -> deleteBook(bookshelf, scan);
                case "4" -> clearBookshelf(bookshelf);
                case "5" -> {
                    exit();
                    return false;
                }
                default -> {
                    printChoiceError(userChoice);
                    isCorrectChoice = false;
                }
            }
        } while (!isCorrectChoice);
        return true;
    }

    private static void addBook(Bookshelf bookshelf, Scanner scan) {
        if (bookshelf.getFreeShelfCount() == 0 || !bookshelf.add(createBook(scan))) {
            System.out.println("\nОшибка: книга не может быть сохранена, " +
                    "в шкафу закончилось место!");
        } else {
            System.out.println("\nКнига успешно добавлена!");
        }
    }

    private static void findBook(Bookshelf bookshelf, Scanner scan) {
        Book foundBook = bookshelf.find(inputTitle(scan));
        if (foundBook == null) {
            System.out.println("\nОшибка: книга не найдена!");
        } else {
            System.out.println("\nКнига успешно найдена!");
            System.out.println("Найденная книга: " + foundBook);
        }
    }

    private static void deleteBook(Bookshelf bookshelf, Scanner scan) {
        Book deletedBook = bookshelf.delete(inputTitle(scan));
        if (deletedBook == null) {
            System.out.println("\nОшибка: книга не удалена, так как её нет в шкафу!");
        } else {
            System.out.println("\nКнига \"" + deletedBook + "\" успешно удалена!");
        }
    }

    private static void clearBookshelf(Bookshelf bookshelf) {
        bookshelf.clear();
        System.out.println("\nШкаф успешно очищен от всех книг!");
    }

    private static void exit() {
        System.out.println("Шкаф закрыт.");
    }

    private static void printChoiceError(String userChoice) {
        System.out.println("Ошибка: неверное значение меню (" + userChoice +
                "). Допустимые значения: " + MIN_MENU_ITEM +
                " - " + MAX_MENU_ITEM);
    }

    private static Book createBook(Scanner scan) {
        while (true) {
            System.out.print("\nВведите автора книги: ");
            String bookAuthor = scan.nextLine();
            String title = inputTitle(scan);
            System.out.print("Введите год издания: ");
            String publishedYear = scan.nextLine();
            try {
                if (publishedYear == null || publishedYear.isBlank()) {
                    throw new IllegalArgumentException("Ошибка: год издания не может быть пустым");
                }
                return new Book(bookAuthor, title, Year.of(Integer.parseInt(publishedYear)));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String inputTitle(Scanner scan) {
        System.out.print("Введите название книги: ");
        return scan.nextLine();
    }
}
