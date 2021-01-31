import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBorrower {

    Book book;
    Borrower borrower;

    @Before
    public void setUp() throws Exception {
        book = new Book("War and Peace", "Leo Tolstoy", "Classics");
        borrower = new Borrower("Napoleon Bonapart");
    }

    @Test
    public void borrowerName() {
        assertEquals("Napoleon Bonapart", borrower.getName());
    }


    @Test
    public void booksOnLoan() {
        assertEquals(0, borrower.bookCount());
    }

    @Test
    public void AddBookToLoan() {
        borrower.addBook(book);
        assertEquals(1, borrower.bookCount());
    }

}
