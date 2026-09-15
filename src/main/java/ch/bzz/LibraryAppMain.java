package ch.bzz;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;  // Import the Scanner class

public class LibraryAppMain {
    private static final Book BOOK_1 = new Book(1, "978-3-8362-9544-4", "Java ist auch eine Insel", "Christian Ullenboom", 2023);
    private static final Book BOOK_2 = new Book(2, "978-3-8362-9544-4", "Grundkurs Java", "Dietmar Abts", 2024);

    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter something:");
        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream("config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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
                    try (Connection con = DriverManager
                            .getConnection("jdbc:postgresql://localhost:5432/" + appProps.getProperty("DB_URL"), appProps.getProperty("DB_USER"), appProps.getProperty("DB_PASSWORD"))) {
                        System.out.println("Connection established successfully.");
                        try (Statement stmt = con.createStatement()) {
                            String selectSql = "SELECT * FROM books";
                            try (ResultSet resultSet = stmt.executeQuery(selectSql)) {
                                System.out.println("Listing all books from database...");
                                while (resultSet.next()) {
                                    String title = resultSet.getString("title");
                                    System.out.println("Book title: " + title);
                                }
                            }
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
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
