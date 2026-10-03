import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem2 {

    static abstract class Vehicle {
        protected String type;
        protected int hours;

        public Vehicle(String type, int hours) {
            this.type = type;
            this.hours = hours;
        }

        public String getType() {
            return type;
        }

        public abstract double calculateCharge();
    }

    static class Bike extends Vehicle {
        public Bike(int hours) {
            super("BIKE", hours);
        }

        @Override
        public double calculateCharge() {
            return hours * 10.0; // ₹10 per hour
        }
    }

    static class Car extends Vehicle {
        public Car(int hours) {
            super("CAR", hours);
        }

        @Override
        public double calculateCharge() {
            // ₹30 for the first hour, plus ₹20 for each additional hour
            if (hours <= 1) {
                return 30.0;
            }
            return 30.0 + (hours - 1) * 20.0;
        }
    }

    static class Truck extends Vehicle {
        public Truck(int hours) {
            super("TRUCK", hours);
        }

        @Override
        public double calculateCharge() {
            // ₹50 per hour, with a minimum charge of ₹100
            double charge = hours * 50.0;
            return Math.max(100.0, charge);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        List<Vehicle> vehicles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int hours = scanner.nextInt();

            if (type.equalsIgnoreCase("BIKE")) {
                vehicles.add(new Bike(hours));
            } else if (type.equalsIgnoreCase("CAR")) {
                vehicles.add(new Car(hours));
            } else if (type.equalsIgnoreCase("TRUCK")) {
                vehicles.add(new Truck(hours));
            }
        }

        double grandTotal = 0.0;
        for (Vehicle vehicle : vehicles) {
            double charge = vehicle.calculateCharge();
            System.out.printf("%s: %.2f%n", vehicle.getType(), charge);
            grandTotal += charge;
        }
        System.out.printf("Total: %.2f%n", grandTotal);
        scanner.close();
    }
}
