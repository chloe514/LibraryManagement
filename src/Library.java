import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;
    private List<User> users;

    // Constructor
    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to remove a book from the library by title
    public void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    // Method to find all books published in a specific year
    public List<Book> findBooksByYear(int year) {
        return books.stream()
                .filter(book -> book.getPublicationYear() == year)
                .collect(Collectors.toList());
    }

    // Method to find all books by a specific author
    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    // Method to find the book with the most pages
    public Optional<Book> findBookWithMostPages() {
        return books.stream().max(Comparator.comparingInt(Book::getPages));
    }

    // Method to find all books with more than n pages
    public List<Book> findBooksWithMoreThanPages(int pages) {
        return books.stream()
                .filter(book -> book.getPages() > pages)
                .collect(Collectors.toList());
    }

    // Method to get all book titles sorted alphabetically
    public List<String> getAllBookTitlesSorted() {
        return books.stream()
                .map(Book::getTitle)
                .sorted()
                .collect(Collectors.toList());
    }

    // Method to find all books in a specific category
    public List<Book> findBooksByCategory(String category) {
        return books.stream()
                .filter(book -> book.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    // Method to loan a book to a user
    public void loanBook(String title, User user) {
        books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title) && !book.isOnLoan())
                .findFirst()
                .ifPresent(book -> {
                    book.loan();
                    user.borrowBook(book);
                });
    }

    // Method to return a book from a user
    public void returnBook(String title, User user) {
        books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title) && book.isOnLoan())
                .findFirst()
                .ifPresent(book -> {
                    book.returnBook();
                    user.returnBook(book);
                });
    }

    // Method to add a user to the library
    public void addUser(User user) {
        users.add(user);
    }

    // Method to get all users
    public List<User> getUsers() {
        return users;
    }

    // Method to calculate late fees for a user
    public long calculateLateFees(User user, double feePerDay) {
        return (long) user.getBorrowedBooks().stream()
                .filter(Book::isOnLoan)
                .mapToDouble(book -> {
                    long daysOnLoan = ChronoUnit.DAYS.between(book.getLoanDate(), LocalDate.now());
                    return daysOnLoan > 14 ? (daysOnLoan - 14) * feePerDay : 0;
                })
                .sum();
    }
}
