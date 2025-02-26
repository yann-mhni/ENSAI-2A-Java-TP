package tp2.src.main.java.edu.ensai.library;

import java.util.Date;

public class Loan {
    // Attributes
    private Book book;
    private Person borrowerName;
    private Date startDate;
    private Date returnDate;

    // Constructor
    public Loan(Book book, Person borrowerName, Date startDate) {
        this.book = book;
        this.borrowerName = borrowerName;
        this.startDate = startDate;
        this.returnDate = null;
    }

    public Book getBook() {
        return book;
    }

    public Person getBorrowerName() {
        return borrowerName;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

}
