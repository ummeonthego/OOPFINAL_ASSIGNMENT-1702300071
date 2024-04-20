import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookstoreManagementSystem system = new BookstoreManagementSystem();
        system.loadInventory();
        system.loadSalesHistory();
        system.loadCustomerInfo();
        system.loadRequests(); // Load customer requests

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Add new book to inventory");
            System.out.println("2. Update book quantity");
            System.out.println("3. Display available books");
            System.out.println("4. Process sale");
            System.out.println("5. Display sales history");
            System.out.println("6. Request unavailable book");
            System.out.println("7. View requests for unavailable books");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    // Option to add new book to inventory
                    System.out.print("Enter Book ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter Quantity: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    system.getInventory().addBook(new Book(id, title, author, price, quantity));
                    break;
                case 2:
                    // Option to update book quantity
                    System.out.print("Enter Book ID: ");
                    int bookID = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter New Quantity: ");
                    int newQuantity = Integer.parseInt(scanner.nextLine());
                    system.getInventory().updateQuantity(bookID, newQuantity);
                    break;
                case 3:
                    // Option to display available books
                    system.getInventory().displayBooks();
                    break;
                case 4:
                    // Option to process sale
                    System.out.print("Enter Book ID: ");
                    int saleBookID = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Quantity Sold: ");
                    int saleQuantity = Integer.parseInt(scanner.nextLine());
                    system.processSale(saleBookID, saleQuantity); // processing sale and updating sales history
                    system.saveCustomerInfo(); // saving customer info
                    break;
                case 5:
                    // Option to display sales history
                    system.getSales().displaySalesHistory();
                    break;
                case 6:
                    // Option to request unavailable book
                    System.out.print("Enter Book ID: ");
                    int requestBookID = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Title: ");
                    String requestTitle = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String requestAuthor = scanner.nextLine();
                    system.addCustomerRequest(requestBookID, requestTitle, requestAuthor);
                    break;
                case 7:
                    // Option to view requests for unavailable books
                    system.displayCustomerRequests();
                    break;
                case 8:
                    // Saving and exiting
                    system.saveInventory();
                    system.saveSalesHistory();
                    system.saveCustomerInfo();
                    system.saveRequests(); // Save customer requests
                    System.out.println("Thank you for visiting our store. Please visit again!");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 8);
        scanner.close();
    }
}
