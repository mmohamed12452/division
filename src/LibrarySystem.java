import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// Question 4: Library Management System
// === BOOK CLASS ===
class Book {
    private String isbn;
    private String title;
    private String author;
    private int year;
    private boolean isAvailable;

    public Book(String isbn, String title, String author, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.isAvailable = true; // New books are available by default
    }

    // Getters and Setters
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    @Override
    public String toString() {
        return title + " by " + author + " (" + year + ") - " + (isAvailable ? "Available" : "Borrowed");
    }
}

// === MAIN LIBRARY SYSTEM CLASS ===
public class LibrarySystem {

    // Collections as required by the prompt
    private ArrayList<Book> bookList = new ArrayList<>();
    private HashSet<String> uniqueAuthors = new HashSet<>();
    private HashMap<String, Book> isbnMap = new HashMap<>();

    // 1. Add Book
    public void addBook(Book book) {
        bookList.add(book);
        uniqueAuthors.add(book.getAuthor());
        isbnMap.put(book.getIsbn(), book);
    }

    // 2. Search by Title (returns list of matching books)
    public List<Book> searchByTitle(String title) {
        List<Book> results = new ArrayList<>();
        for (Book b : bookList) {
            if (b.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(b);
            }
        }
        return results;
    }

    // 3. Search by Author (returns list of books by author)
    public List<Book> searchByAuthor(String author) {
        List<Book> results = new ArrayList<>();
        for (Book b : bookList) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                results.add(b);
            }
        }
        return results;
    }

    // 4. Borrow Book
    public boolean borrowBook(String isbn) {
        Book book = isbnMap.get(isbn);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            return true;
        }
        return false;
    }

    // 5. Return Book
    public boolean returnBook(String isbn) {
        Book book = isbnMap.get(isbn);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            return true;
        }
        return false;
    }

    // 6. Get Available Books sorted by title
    public List<Book> getAvailableBooks() {
        List<Book> available = new ArrayList<>();
        for (Book b : bookList) {
            if (b.isAvailable()) {
                available.add(b);
            }
        }
        // Sorting using custom Comparator by title
        Collections.sort(available, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getTitle().compareToIgnoreCase(b2.getTitle());
            }
        });
        return available;
    }

    // 7. Get Books by Year
    public List<Book> getBooksByYear(int year) {
        List<Book> results = new ArrayList<>();
        for (Book b : bookList) {
            if (b.getYear() == year) {
                results.add(b);
            }
        }
        return results;
    }

    // Getter for unique authors display
    public HashSet<String> getUniqueAuthors() {
        return uniqueAuthors;
    }

    // === MAIN METHOD ===
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        System.out.println("=== LIBRARY SYSTEM ===");

        // Adding 10 books (including the ones from sample output questionaire bryson)
        library.addBook(new Book("978-0134685991", "Effective Java", "Joshua Bloch", 2008));
        library.addBook(new Book("978-0132350884", "Java Concurrency", "Brian Goetz", 2006));
        library.addBook(new Book("978-0451524935", "1984", "George Orwell", 1949));
        library.addBook(new Book("978-0141439518", "Pride and Prejudice", "Jane Austen", 1813));
        library.addBook(new Book("978-0486280615", "Adventures of Huckleberry Finn", "Mark Twain", 1884));
        library.addBook(new Book("978-0747532699", "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 1997));
        library.addBook(new Book("978-0451526342", "Animal Farm", "George Orwell", 1945));
        library.addBook(new Book("978-0060850524", "Brave New World", "Aldous Huxley", 1932));
        library.addBook(new Book("978-0345339683", "The Hobbit", "J.R.R. Tolkien", 1937));
        library.addBook(new Book("978-0131103627", "The C Programming Language", "Dennis Ritchie", 1988));

        System.out.println("Added 10 books\n");

        // Show unique authors using HashSet
        System.out.println("Unique authors: " + library.getUniqueAuthors());
        System.out.println();

        // Demonstrate Search by Title
        String searchTitle = "Java";
        System.out.println("Search for '" + searchTitle + "': Found " + library.searchByTitle(searchTitle).size() + " books");
        int count = 1;
        for (Book b : library.searchByTitle(searchTitle)) {
            System.out.println(count++ + ". " + b);
        }
        System.out.println();

        // Demonstrate Borrowing a book
        String targetIsbn = "978-0134685991";
        System.out.println("Borrowing book '" + targetIsbn + "'...");
        if (library.borrowBook(targetIsbn)) {
            System.out.println("Book borrowed successfully!\n");
        } else {
            System.out.println("Book borrowing failed.\n");
        }

        // Demonstrate Available books sorted by title (Notice 'Effective Java' will be gone)
        System.out.println("Available books sorted by title:");
        int availCount = 1;
        for (Book b : library.getAvailableBooks()) {
            System.out.println(availCount++ + ". " + b.getTitle() + " by " + b.getAuthor());
        }
        System.out.println();

        // Demonstrate Search by Author
        System.out.println("Books by George Orwell:");
        for (Book b : library.searchByAuthor("George Orwell")) {
            System.out.println("- " + b);
        }
        System.out.println();

        // Demonstrate Search by Year
        System.out.println("Books published in 1937:");
        for (Book b : library.getBooksByYear(1937)) {
            System.out.println("- " + b);
        }
        System.out.println();

        // Demonstrate Returning a book
        System.out.println("Returning book '" + targetIsbn + "'...");
        if (library.returnBook(targetIsbn)) {
            System.out.println("Book returned successfully!\n");
        }
    }
}
