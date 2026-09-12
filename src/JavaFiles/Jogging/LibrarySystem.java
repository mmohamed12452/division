package JavaFiles.Jogging;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibrarySystem
{
    private static final String File_Name = "book.dat";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search by ISBN");
            System.out.println("4. Delete by ISBN");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    addBook(sc);
                    break;
                case 2:
                    displayBooks();
                    break;
                case 3:
                    searchBook(sc);
                    break;
                case 4:
                    deleteBook(sc);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
            }
        }
    }

    // Read all books from file
    private static List<Book> readBooks() {
        List<Book> books = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(File_Name))) {
            while (true) {
                books.add((Book) ois.readObject());
            }
        } catch (EOFException e) {
            // End of file reached (normal)
        } catch (FileNotFoundException e) {
            // File doesn't exist yet
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }

    // Write all books to file
    private static void writeBooks(List<Book> books) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(File_Name))) {
            for (Book b : books) {
                oos.writeObject(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Add book
    private static void addBook(Scanner sc) {
        System.out.print("Enter title: ");
        String title = sc.nextLine();

        System.out.print("Enter author: ");
        String author = sc.nextLine();

        System.out.print("Enter year: ");
        int year = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();

        List<Book> books = readBooks();
        books.add(new Book(title, author, year, isbn));
        writeBooks(books);

        System.out.println("Book added successfully!");
    }

    // Display all books
    private static void displayBooks() {
        List<Book> books = readBooks();

        if (books.isEmpty()) {
            System.out.println("No books found.");
            return;
        }

        for (Book b : books) {
            System.out.println(b);
        }
    }

    // Search by ISBN
    private static void searchBook(Scanner sc) {
        System.out.print("Enter ISBN to search: ");
        String isbn = sc.nextLine();

        List<Book> books = readBooks();
        boolean found = false;

        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                System.out.println("Book found:");
                System.out.println(b);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    // Delete by ISBN
    private static void deleteBook(Scanner sc) {
        System.out.print("Enter ISBN to delete: ");
        String isbn = sc.nextLine();

        List<Book> books = readBooks();
        boolean removed = books.removeIf(b -> b.getIsbn().equals(isbn));

        if (removed) {
            writeBooks(books);
            System.out.println("Book deleted successfully!");
        } else {
            System.out.println("Book not found.");
        }
    }
}

