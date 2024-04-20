// Producrt class lending properties to book class
class Book extends Product {
    private String author;

    // Constructor
    public Book(int productID, String title, String author, double price, int quantity)
    {
        // calling attributes from the parent class
        super(productID, title, price, quantity);
        // initializing o=the personal attribute of inherited class
        this.author = author;
    }

    // encapsulations for author
    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }
}
