package ch.bzz;
import java.util.ArrayList;
import java.util.Scanner;  // Import the Scanner class


public class LibraryAppMain {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter something:");

        ArrayList<String> books = new ArrayList<String>();

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
                    books.add(title + " by " + author);
                    System.out.println("Book added: " + title + " by " + author);
                }
                case "list" -> {
                    System.out.println("Listing all books...");
                    if (books.isEmpty()) {
                        System.out.println("No books in the library.");
                    } else {
                        for (String book : books) {
                            System.out.println(book);
                        }
                    }
                }
                case "search" -> {
                    System.out.println("Searching for a book...");
                    System.out.print("Enter book title to search: ");
                    String searchTitle = myObj.nextLine();
                    boolean found = false;
                    for (String book : books) {
                        if (book.toLowerCase().contains(searchTitle.toLowerCase())) {
                            System.out.println("Found: " + book);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("No books found with title: " + searchTitle);
                    }
                }
                default -> System.out.println("Invalid input. Type 'help' for a list of commands.");
            }
            input = myObj.nextLine();
        }
    }
}
