import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private int capacity;
    private ArrayList<Book> booksInStock;
    private HashMap<String, Integer> booksByGenre;

    public Library(int capacity) {
        this.capacity = capacity;
        this.booksInStock = new ArrayList<>();
        this.booksByGenre = new HashMap<>();
    }
    //Add a capacity to the library
    public int getCapacity() {
        return capacity;
    }

    public boolean hasCapacity() {
        return capacity > booksInStock.size();
    }
    //Method to count number of books in the library
    public int bookCount() {
        return this.booksInStock.size();
    }

    //Method to add a book to the library stock.
    public void addBook(Book book) {
        if(hasCapacity()){
            this.booksInStock.add(book);
            this.addToGenreHashmap(book);
        }
    }

    public void addToGenreHashmap(Book book){

        String genre = book.getGenre();

        //if the genre already exists in the hashmap, extract the existing count and assign it to the variable 'counter'
        if(this.booksByGenre.containsKey(genre)){
            int counter = booksByGenre.get(genre);

            // add one to the counter
            counter++;

            //put the key and new value back into the hashmap
            this.booksByGenre.put(genre, counter);

        } else {

            this.booksByGenre.put(genre, 1);
        }
    }

    public void loanBook(Book book, Borrower borrower) {
        // check if book is in stock
        if(this.booksInStock.contains(book)){
            // if it is, remove book from library stock
            this.booksInStock.remove(book);
            // add/transfer book to borrower
            borrower.addBook(book);
        }
    }

    public boolean checkInStock(Book book) {
//        return this.collection.contains(book);
        for(Book individualBook:this.booksInStock){
            if(individualBook == book){
                return true;
            }
        }
        return false;
    }

    //library can check books by genre
    public int checkGenreFrequency(String genre) {
        return this.booksByGenre.get(genre);
    }
}

