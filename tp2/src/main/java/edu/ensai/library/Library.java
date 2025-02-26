package tp2.src.main.java.edu.ensai.library;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Library {

    // Attributes
    public List<Book> books;
    public List<Loan> activeLoans;
    public List<Loan> completedLoans;

    // Constructor
    public Library() {
        this.books = new ArrayList<>();
        this.activeLoans = new ArrayList<>();
        this.completedLoans = new ArrayList<>();
    }

    /**
     * Checks if the specified book is currently loaned out.
     * 
     * @param book The book to check for an active loan.
     * @return true if the book is currently loaned out, false otherwise.
     */
    public boolean isLoaned(Book book) {
        for (Loan loan : activeLoans) {
            if (loan.getBook().equals(book)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Loans a book to a borrower if the book is not already loaned out.
     * 
     * @param book         The book to be loaned.
     * @param borrowerName The name of the borrower.
     * @return true if the book is successfully loaned, false otherwise.
     */
    public boolean loanBook(Book book, Person borrowerName) {
        if (isLoaned(book)) {
            return false;
        }

        Loan newLoan = new Loan(book, borrowerName, new Date());
        activeLoans.add(newLoan);

        return true;
    }

    /**
     * Returns a book that was previously loaned out.
     * 
     * @param book The book to be returned.
     * @return true if the book was successfully returned, false if the book was not
     *         loaned.
     */
    public boolean returnBook(Book book) {
        for (Loan loan : activeLoans) {
            if (loan.getBook().equals(book)) {
                loan.setReturnDate(new Date());
                activeLoans.remove(loan);
                completedLoans.add(loan);
                return true;
            }
        }
        return false;
    }
}