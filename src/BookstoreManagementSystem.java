import java.io.*;
import java.util.*;


public class BookstoreManagementSystem {
    private Inventory inventory;
    private Sales sales;
    private List<CustomerRequest> customerRequests;
    private Customer customer;

    private static final String INVENTORY_FILE = "inventory.csv";
    private static final String SALES_FILE = "sales.csv";
    private static final String CUSTOMER_FILE = "customers.csv";
    private static final String REQUESTS_FILE = "requests.csv";

    public BookstoreManagementSystem() {
        inventory = new Inventory();
        sales = new Sales();
        customerRequests = new ArrayList<>();
        customer = new Customer();
    }

    public void addCustomerRequest(int bookID, String title, String author) {
        customerRequests.add(new CustomerRequest(bookID, title, author));
    }

    public void displayCustomerRequests() {
        if (customerRequests.isEmpty()) {
            System.out.println("No requests for unavailable books.");
        } else {
            System.out.println("Requests for unavailable books:");
            for (CustomerRequest request : customerRequests) {
                System.out.println(request);
            }
        }
    }

    public void saveRequests() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(REQUESTS_FILE))) {
            for (CustomerRequest request : customerRequests) {
                writer.println(request.getBookID() + "," + request.getTitle() + "," + request.getAuthor());
            }
        } catch (IOException e) {
            System.out.println("Error saving requests: " + e.getMessage());
        }
    }

    public void loadRequests() {
        try (BufferedReader reader = new BufferedReader(new FileReader(REQUESTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int bookID = Integer.parseInt(data[0]);
                String title = data[1];
                String author = data[2];
                customerRequests.add(new CustomerRequest(bookID, title, author));
            }
        } catch (IOException e) {
            System.out.println("Error loading requests: " + e.getMessage());
        }
    }

    public void loadInventory() {
        try (BufferedReader reader = new BufferedReader(new FileReader(INVENTORY_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int productID = Integer.parseInt(data[0]);
                String title = data[1];
                String author = data[2];
                double price = Double.parseDouble(data[3]);
                int quantity = Integer.parseInt(data[4]);
                inventory.addBook(new Book(productID, title, author, price, quantity));
            }
        } catch (IOException e) {
            System.out.println("Error loading inventory: " + e.getMessage());
        }
    }

    public void saveInventory() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(INVENTORY_FILE))) {
            for (Book book : inventory.getBooks()) {
                writer.println(book.getProductID() + "," + book.getTitle() + "," + book.getAuthor() + "," + book.getPrice() + "," + book.getQuantity());
            }
        } catch (IOException e) {
            System.out.println("Error saving inventory: " + e.getMessage());
        }
    }

    public void loadSalesHistory() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SALES_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int productID = Integer.parseInt(data[0]);
                String title = data[1];
                String author = data[2];
                double price = Double.parseDouble(data[3]);
                int quantity = Integer.parseInt(data[4]);
                sales.addSale(new Book(productID, title, author, price, quantity));
            }
        } catch (IOException e) {
            System.out.println("Error loading sales history: " + e.getMessage());
        }
    }

    public void saveSalesHistory() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(SALES_FILE))) {
            for (Book sale : sales.getSalesHistory()) {
                writer.println(sale.getProductID() + "," + sale.getTitle() + "," + sale.getAuthor() + "," + sale.getPrice() + "," + sale.getQuantity());
            }
        } catch (IOException e) {
            System.out.println("Error saving sales history: " + e.getMessage());
        }
    }

    public void saveCustomerInfo() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CUSTOMER_FILE))) {
            writer.println(customer.getCustomerID() + "," + customer.getName() + "," + customer.getEmail());
        } catch (IOException e) {
            System.out.println("Error saving customer information: " + e.getMessage());
        }
    }

    public void loadCustomerInfo() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CUSTOMER_FILE))) {
            String line;
            if ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int customerID = Integer.parseInt(data[0]);
                String name = data[1];
                String email = data[2];
                customer.setCustomerID(customerID);
                customer.setName(name);
                customer.setEmail(email);
            }
        } catch (IOException e) {
            System.out.println("Error loading customer information: " + e.getMessage());
        }
    }

    public void processSale(int productID, int quantity) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Customer ID: ");
        int customerID = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Customer Email: ");
        String email = scanner.nextLine();
        customer.setCustomerID(customerID);
        customer.setName(name);
        customer.setEmail(email);

        Book soldBook = null;
        for (Book book : inventory.getBooks()) {
            if (book.getProductID() == productID) {
                soldBook = book;
                int remainingQuantity = book.getQuantity() - quantity;
                if (remainingQuantity < 0) {
                    System.out.println("Not enough quantity in inventory.");
                    return;
                }
                book.setQuantity(remainingQuantity);
                break;
            }
        }
        if (soldBook != null) {
            soldBook.setQuantity(quantity);
            sales.addSale(soldBook);
            System.out.println("Sale processed successfully.");
        } else {
            System.out.println("Book with ID " + productID + " not found in inventory.");
        }
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
