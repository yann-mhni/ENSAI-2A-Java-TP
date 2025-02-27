package tp2.src.main.java.edu.ensai.library;

import java.util.Date;

public class Loan {
    // Attributes
    private Book book;
    private Person borrower;
    private Date startDate;
    private Date returnDate;

    // Constructor
    public Loan(Book book, Person borrower, Date startDate) {
        this.book = book;
        this.borrower = borrower;
        this.startDate = startDate;
        this.returnDate = null;
    }

    public Book getBook() {
        return this.book;
    }

    public Person getBorrower() {
        return this.borrower;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        if (returnDate != null) {
            return "Book '" + book.getTitle() + "' borrowed by " + borrower.getName() + " from " + this.startDate
                    + " to " + this.returnDate
                    + ".";
        } else {
            return "Book '" + book.getTitle() + "' borrowed by " + borrower.getName() + " since " + this.startDate
                    + ".";
        }
    }

}
