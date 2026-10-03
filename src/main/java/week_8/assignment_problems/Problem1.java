import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem1 {

    static abstract class Customer {
        protected String type;
        protected double amount;

        public Customer(String type, double amount) {
            this.type = type;
            this.amount = amount;
        }

        public String getType() {
            return type;
        }

        public abstract double calculateFinalAmount();
    }

    static class StudentCustomer extends Customer {
        public StudentCustomer(double amount) {
            super("STUDENT", amount);
        }

        @Override
        public double calculateFinalAmount() {
            return amount * 0.90; // 10% discount
        }
    }

    static class StaffCustomer extends Customer {
        public StaffCustomer(double amount) {
            super("STAFF", amount);
        }

        @Override
        public double calculateFinalAmount() {
            return amount * 0.95; // 5% discount
        }
    }

    static class GuestCustomer extends Customer {
        public GuestCustomer(double amount) {
            super("GUEST", amount);
        }

        @Override
        public double calculateFinalAmount() {
            return amount + 10.0; // ₹10 service charge
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        List<Customer> customers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();

            if (type.equalsIgnoreCase("STUDENT")) {
                customers.add(new StudentCustomer(amount));
            } else if (type.equalsIgnoreCase("STAFF")) {
                customers.add(new StaffCustomer(amount));
            } else if (type.equalsIgnoreCase("GUEST")) {
                customers.add(new GuestCustomer(amount));
            }
        }

        double grandTotal = 0.0;
        for (Customer customer : customers) {
            double finalAmount = customer.calculateFinalAmount();
            System.out.printf("%s: %.2f%n", customer.getType(), finalAmount);
            grandTotal += finalAmount;
        }
        System.out.printf("Total: %.2f%n", grandTotal);
        scanner.close();
    }
}
