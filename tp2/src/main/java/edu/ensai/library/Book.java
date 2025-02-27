package tp2.src.main.java.edu.ensai.library;

public class Book {
    // Attributes
    private String isbn;
    private String title;
    private Author author;
    private int year;
    private int pageCount;

    // Constructor
    public Book(String isbn, String title, Author author, int year, int pageCount) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        return "Book " + title + " written by " + author.toString();
    }

    public String getIsbn() {
        return this.isbn;
    }

    public String getTitle() {
        return this.title;
    }

    public Author getAuthor() {
        return this.author;
    }

    public int getYear() {
        return this.year;
    }

    public int getPageCount() {
        return this.pageCount;
    }

}
