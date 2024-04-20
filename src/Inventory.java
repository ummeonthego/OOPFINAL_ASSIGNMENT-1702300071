import java.util.*; //importing Util class for scanner and ArrayList


class Inventory {
    private ArrayList<Book> books; // arrayList containing objects of Book class

    // defconstructor for inventory
    public Inventory() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    // updat product quant
    public void updateQuantity(int productID, int quantity) {
        for (Book book : books) {
            if (book.getProductID() == productID) {
                book.setQuantity(quantity);
                return;
            }
        }
        //error
        System.out.println("Book ID " + productID + " not found.");
    }

    // displaying current state of inventory from csv file
    public void displayBooks() {
        // message to sow if te inventory is empty
        if (books.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        // print table header
        System.out.println("---------------------------------------------------------------");
        System.out.printf("| %-8s | %-30s | %-20s | %-8s | %-8s |\n", "Book ID", "Title", "Author", "Price", "Quantity");
        System.out.println("---------------------------------------------------------------");

        // print each book informations iterating through te arraylist
        for (Book book : books) {
            System.out.printf("| %-8d | %-30s | %-20s | %-8.2f | %-8d |\n", book.getProductID(), book.getTitle(), book.getAuthor(), book.getPrice(), book.getQuantity());
        }

        // print table footer
        System.out.println("---------------------------------------------------------------");
    }

    // getter for Book arraylist
    public ArrayList<Book> getBooks() {
        return books;
    }
}
