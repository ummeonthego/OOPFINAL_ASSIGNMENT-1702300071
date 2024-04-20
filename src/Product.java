// the initial class //inheritor
class Product {
    // required attributes
    private int productID;
    private String title;
    private double price;
    private int quantity;

    //constructer for prod class
    public Product(int productID, String title, double price, int quantity) {
        this.productID = productID;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    // encapsulations for productID
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    // encapsulations for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // encapsulations for price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // encapsulations for quantity
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}