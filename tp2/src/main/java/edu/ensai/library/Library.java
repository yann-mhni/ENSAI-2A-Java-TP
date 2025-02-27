package tp2.src.main.java.edu.ensai.library;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
     * Retrieves a list of books written by a specific author.
     *
     * @param author The author whose books are to be found.
     * @return A list of books written by the given author.
     */
    public ArrayList<Book> getBooksByAuthor(Author author) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            Author bookAuthor = book.getAuthor();
            if (bookAuthor.equals(author)) {
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Checks if all books in the library have unique ISBN.
     *
     * @return true if all ISBNs are unique, false otherwise.
     */
    public boolean areAllIsbnsUnique() {
        Set<String> isbnSet = new HashSet<>();
        for (Book book : books) {
            if (!isbnSet.add(book.getIsbn())) {
                return false;
            }
        }
        return true;
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

    /**
     * Counts the number of books currently loaned by a specific student.
     *
     * @param student The student whose active loans are to be counted.
     * @return The number of books currently loaned by the student.
     */
    public int countActiveLoansByStudent(Student student) {
        int count = 0;
        for (Loan loan : activeLoans) {
            Person bookRenter = loan.getBorrowerName();
            if (bookRenter.equals(student)) {
                count++;
            }
        }
        return count;
    }

}