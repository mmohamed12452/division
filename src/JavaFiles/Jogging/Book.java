package JavaFiles.Jogging;

import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L; // Ensures version compatibility
    private String title;
    private String author;
    private int year;
    private String isbn;

    public Book(String title, String author, int year, String isbn) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Title: " + title +
                ", Author: " + author +
                ", Year: " + year +
                ", ISBN: " + isbn;

    }

    public Object getIsbn() {
        return isbn;
    }
}
