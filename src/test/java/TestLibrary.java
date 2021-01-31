import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestLibrary {

    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;
    private Book book5;

    private Library library;
    private Library library2;

    private Borrower borrower;

    @Before
    public void setUp() throws Exception {
        book1 = new Book("The strange case of Dr Jekyll and Mr Hyde", "RL Stevenson", "Classics");
        book2 = new Book("Collected ghost stories", "MR James", "Horror");
        book3 = new Book("Da vinci code", "Dan Brown", "Mystery");
        book4 = new Book("The moons a balloon", "David Niven", "Biography");
        book5 = new Book("Silent spring", "Rachel Carson", "Environment");

        library = new Library(1);
        library2 = new Library(6);

        borrower = new Borrower("Christopher Lee");
    }

    @Test
    public void hasCapacity() {
        assertEquals(true, library.hasCapacity());
    }

    //Test to check if stock is full before adding a book.
    @Test
    public void canAddBook_whenStockNotFull() {
        library.addBook(book3);
        assertEquals(1, library.bookCount());
    }

    @Test
    public void notAddBook_whenStockFull() {
        library.addBook(book2);
        assertEquals(1, library.bookCount());
    }

    @Test
    public void BookIsAvailable() {
        assertEquals(false, library.checkInStock(book3));
    }

    @Test
    public void BookNotAvailable() {
        library.addBook(book3);
        assertEquals(true, library.checkInStock(book3));
    }

    @Test
    public void canLendBookCheck() {
        // arrange
        library.addBook(book3);
        // act
        library.loanBook(book3, borrower);
        // assert
        assertEquals(1, borrower.bookCount());
        assertEquals(0, library.bookCount());
        assertEquals(false, library.checkInStock(book3));
    }

    @Test
    public void canUpdateBooksByGenre_whenBookAdded() {
        //arrange
        library2.addBook(book1);
        library2.addBook(book2);
        library2.addBook(book3);
        library2.addBook(book4);
        library2.addBook(book5);
        assertEquals(1, library2.checkGenreFrequency("Classics"));
        assertEquals(1, library2.checkGenreFrequency("Mystery"));
        assertEquals(1, library2.checkGenreFrequency("Horror"));
        assertEquals(1, library2.checkGenreFrequency("Biography"));
        assertEquals(1, library2.checkGenreFrequency("Environment"));


    }

}