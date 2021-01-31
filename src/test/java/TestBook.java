import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBook {
    Book book;

    @Before
    public void setUp() {
        book = new Book("Illiad", "Homer", "Classics");
    }

    @Test
    public void hasTitle() {
        assertEquals("Illiad", book.getTitle());
    }

    @Test
    public void hasAuthor() {
        assertEquals("Homer", book.getAuthor());
    }

    @Test
    public void genre() {
        assertEquals("Classics", book.getGenre());
    }

}