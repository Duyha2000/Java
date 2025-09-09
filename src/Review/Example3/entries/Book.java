package Review.Example3.entries;

public class Book {
    private String isbn;
    private String title;
    private boolean isBorrowed;

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
        this.isBorrowed = false;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
}
