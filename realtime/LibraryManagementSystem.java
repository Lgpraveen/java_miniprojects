package realtime;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private int id;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(int bookId) {
        books.removeIf(book -> book.getId() == bookId);
    }
    
    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor());
            }
        }
    }

    public boolean borrowBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId && book.isAvailable()) {
                book.setAvailable(false);
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId && !book.isAvailable()) {
                book.setAvailable(true);
                return true;
            }
        }
        return false;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Adding some sample books
        library.addBook(new Book(1, "tamil", "Author 1"));
        library.addBook(new Book(2, "english", "Author 2"));
        library.addBook(new Book(3, "maths", "Author 3"));
        library.addBook(new Book(4, "science", "Author 4"));
        library.addBook(new Book(5, "social", "Author 5"));

        while (true) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Display Available Books");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    library.displayAvailableBooks();
                    break;
                case 2:
                    System.out.print("Enter the Book ID to borrow: ");
                    int borrowId = scanner.nextInt();
                    if (library.borrowBook(borrowId)) {
                        System.out.println("Book borrowed successfully!");
                    } else {
                        System.out.println("Book not available or invalid ID.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the Book ID to return: ");
                    int returnId = scanner.nextInt();
                    if (library.returnBook(returnId)) {
                        System.out.println("Book returned successfully!");
                    } else {
                        System.out.println("Invalid Book ID or book is not borrowed.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting Library Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
