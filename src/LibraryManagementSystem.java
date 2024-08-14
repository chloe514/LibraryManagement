public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Creating a library instance
        Library library = new Library();

        // Creating user instances
        User user1 = new User("Alice", "12345");
        User user2 = new User("Bob", "67890");

        // Adding users to the library
        library.addUser(user1);
        library.addUser(user2);

        // Adding books to the library
        library.addBook(new Book("Book One", "Author A", 2001, 300, "Fiction"));
        library.addBook(new Book("Book Two", "Author B", 2002, 150, "Science"));
        library.addBook(new Book("Book Three", "Author A", 2003, 400, "History"));
        library.addBook(new Book("Book Four", "Author C", 2001, 500, "Non-Fiction"));

        // Finding and displaying books by a specific author
        System.out.println("Books by Author A:");
        library.findBooksByAuthor("Author A").forEach(System.out::println);

        // Finding and displaying books published in a specific year
        System.out.println("\nBooks published in 2001:");
        library.findBooksByYear(2001).forEach(System.out::println);

        // Finding and displaying the book with the most pages
        System.out.println("\nBook with the most pages:");
        library.findBookWithMostPages().ifPresent(System.out::println);

        // Finding and displaying books with more than 200 pages
        System.out.println("\nBooks with more than 200 pages:");
        library.findBooksWithMoreThanPages(200).forEach(System.out::println);

        // Printing all book titles sorted alphabetically
        System.out.println("\nAll book titles sorted alphabetically:");
        library.getAllBookTitlesSorted().forEach(System.out::println);

        // Loaning and returning books
        System.out.println("\nLoaning 'Book One' to Alice:");
        library.loanBook("Book One", user1);
        System.out.println("Alice's borrowed books:");
        user1.getBorrowedBooks().forEach(System.out::println);

        System.out.println("\nReturning 'Book One' from Alice:");
        library.returnBook("Book One", user1);
        System.out.println("Alice's borrowed books after returning:");
        user1.getBorrowedBooks().forEach(System.out::println);

        // Calculating late fees
        System.out.println("\nCalculating late fees for Alice:");
        long lateFees = library.calculateLateFees(user1, 1.0);
        System.out.println("Late fees: " + lateFees);
    }
}



