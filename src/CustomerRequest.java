//to manage customer requests
public class CustomerRequest {
    private int bookID;
    private String title;
    private String author;
//constrcutor
    public CustomerRequest(int bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
    }
//required methods to handle requests
    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
//ovveride usage
    @Override
    public String toString() {
        return "CustomerRequest{" +
                "bookID=" + bookID +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
