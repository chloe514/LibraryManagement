import java.time.LocalDate;

public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private int pages;
    private String category;
    private boolean isOnLoan;
    private LocalDate loanDate;

    // Constructor
    public Book(String title, String author, int publicationYear, int pages, String category) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.pages = pages;
        this.category = category;
        this.isOnLoan = false; // Initially, the book is not on loan
        this.loanDate = null;  // No loan date initially
    }

    // Getters and Setters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPublicationYear() { return publicationYear; }
    public int getPages() { return pages; }
    public String getCategory() { return category; }
    public boolean isOnLoan() { return isOnLoan; }
    public LocalDate getLoanDate() { return loanDate; }

    // Method to mark the book as loaned
    public void loan() { this.isOnLoan = true; this.loanDate = LocalDate.now(); }

    // Method to mark the book as returned
    public void returnBook() { this.isOnLoan = false; this.loanDate = null; }

    @Override
    public String toString() {
        return title + " by " + author + " (" + publicationYear + "), " + pages + " pages, " + category + (isOnLoan ? " [On Loan]" : "");
    }
}




