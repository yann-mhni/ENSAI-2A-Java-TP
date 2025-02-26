package tp2.src.main.java.edu.ensai.library;

public class Book {
    public String isbn;
    public String title;
    public Author author;
    public int year;
    public int pageCount;

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
}
