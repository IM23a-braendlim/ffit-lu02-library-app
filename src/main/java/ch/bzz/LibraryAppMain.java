package ch.bzz;
import java.util.Scanner;  // Import the Scanner class

public class LibraryAppMain {
    private static final Book BOOK_1 = new Book(1, "978-3-8362-9544-4", "Java ist auch eine Insel", "Christian Ullenboom", 2023);
    private static final Book BOOK_2 = new Book(2, "978-3-8362-9544-4", "Grundkurs Java", "Dietmar Abts", 2024);

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter something:");

        String input = myObj.nextLine(); // Read user input
        while (!input.equals("quit")) {
            switch (input) {
                case "help" -> System.out.println("Available commands:\n" +
                        "help - Show this help message\n" +
                        "quit - Exit the application\n" +
                        "add - Add a new book\n" +
                        "list - List all books\n" +
                        "search - Search for a book by title\n");
                case "add" -> {
                    System.out.println("Adding a new book...");
                    System.out.print("Enter book title: ");
                    String title = myObj.nextLine();
                    System.out.print("Enter book author: ");
                    String author = myObj.nextLine();
                    System.out.println("Book added: " + title + " by " + author);
                }
                case "listBooks" -> {
                    System.out.println("Listing all books...");
                    System.out.println("1. " + BOOK_1.getTitle() + " by " + BOOK_1.getAuthor());
                    System.out.println("2. " + BOOK_2.getTitle() + " by "+ BOOK_2.getAuthor());
                }
                case "search" -> {
                    System.out.println("Searching for a book...");
                    System.out.print("Enter book title to search: ");
                    String searchTitle = myObj.nextLine();
                    boolean found = false;
                }
                default -> System.out.println(input);
            }
            input = myObj.nextLine();
        }
    }
}
