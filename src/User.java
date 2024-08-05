import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String libraryCardNumber;
    private List<Book> borrowedBooks;

    // Constructor
    public User(String name, String libraryCardNumber) {
        this.name = name;
        this.libraryCardNumber = libraryCardNumber;
        this.borrowedBooks = new ArrayList<>(); // List to keep track of borrowed books
    }

    // Getters and Setters
    public String getName() { return name; }
    public String getLibraryCardNumber() { return libraryCardNumber; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }

    // Method to borrow a book
    public void borrowBook(Book book) { borrowedBooks.add(book); }

    // Method to return a book
    public void returnBook(Book book) { borrowedBooks.remove(book); }

    @Override
    public String toString() {
        return name + " (" + libraryCardNumber + ")";
    }
}
