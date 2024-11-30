import java.util.*;

public class CustomerApplication {

    public static class Customer {
        private int id;
        private String firstName;
        private String lastName;
        private double balance;

        public Customer(int id, String firstName, String lastName, double balance) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.balance = balance;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + firstName + " " + lastName + ", Balance: $" + balance;
        }
    }

    public static class CustomerManager {
        private List<Customer> customers;

        public CustomerManager() {
            customers = new ArrayList<>();
        }

        public void addCustomer(Customer customer) {
            customers.add(customer);
        }

        public void sortCustomers() {
            customers.sort(Comparator
                    .comparing(Customer::getFirstName)
                    .thenComparing(Customer::getLastName)
                    .thenComparing(Customer::getId)
                    .thenComparing(Customer::getBalance));
        }

        public void printCustomers() {
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    public static void main(String[] args) {
        CustomerManager manager = new CustomerManager();

        manager.addCustomer(new Customer(3, "Bhanu", "Prakash", 1200.50));
        manager.addCustomer(new Customer(1, "", "abc", 1500.75));
        manager.addCustomer(new Customer(2, "abc3", "abc", 2000.00));
        manager.addCustomer(new Customer(4, "abc4", "abc", 1000.00));

        System.out.println("Before Sorting:");
        manager.printCustomers();

        manager.sortCustomers();

        System.out.println("\nAfter Sorting:");
        manager.printCustomers();
    }
}
