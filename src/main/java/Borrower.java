import java.util.ArrayList;

public class Borrower {
    //Add a borrower with a method that takes a book and moves it to the borrower's collection.
    private String name;
    private ArrayList<Book> booksOnLoan;

    public Borrower(String borrowerName) {
        this.name = borrowerName;
        this.booksOnLoan = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int bookCount() {
        return this.booksOnLoan.size();
    }

    public void addBook(Book book) {
        this.booksOnLoan.add(book);
    }
}
