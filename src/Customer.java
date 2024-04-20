public class Customer {

    // instance variables for Customer class
    private int customerID;
    private String name;
    private String email;

    // default constructor
    public Customer() {
    }
    // parameterized constructor
    public Customer(int customerID, String name, String email) {
        this.customerID = customerID;
        this.name = name;
        this.email = email;
    }

    // Getters and setters for customerID
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    // Getters and setters for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getters and setters for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
