import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem3 {

    static abstract class Delivery {
        protected String type;
        protected double weight;
        protected double distance;

        public Delivery(String type, double weight, double distance) {
            this.type = type;
            this.weight = weight;
            this.distance = distance;
        }

        public String getType() {
            return type;
        }

        public abstract double calculateFee();
    }

    static class StandardDelivery extends Delivery {
        public StandardDelivery(double weight, double distance) {
            super("STANDARD", weight, distance);
        }

        @Override
        public double calculateFee() {
            // Base fee $5, plus $0.50 per kg, plus $0.10 per km
            return 5.0 + (weight * 0.50) + (distance * 0.10);
        }
    }

    static class ExpressDelivery extends Delivery {
        public ExpressDelivery(double weight, double distance) {
            super("EXPRESS", weight, distance);
        }

        @Override
        public double calculateFee() {
            // Base fee $20 ($5 standard base + $15 express fee), plus $1.00 per kg, plus $0.20 per km
            return 20.0 + (weight * 1.00) + (distance * 0.20);
        }
    }

    static class InternationalDelivery extends Delivery {
        private double customsFee;

        public InternationalDelivery(double weight, double distance, double customsFee) {
            super("INTERNATIONAL", weight, distance);
            this.customsFee = customsFee;
        }

        @Override
        public double calculateFee() {
            // Base fee $35 ($20 express base + $15 international fee), plus $2.00 per kg, plus $0.50 per km, plus CustomsFee
            return 35.0 + (weight * 2.00) + (distance * 0.50) + customsFee;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        List<Delivery> deliveries = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double distance = scanner.nextDouble();

            if (type.equalsIgnoreCase("STANDARD")) {
                deliveries.add(new StandardDelivery(weight, distance));
            } else if (type.equalsIgnoreCase("EXPRESS")) {
                deliveries.add(new ExpressDelivery(weight, distance));
            } else if (type.equalsIgnoreCase("INTERNATIONAL")) {
                double customsFee = scanner.nextDouble();
                deliveries.add(new InternationalDelivery(weight, distance, customsFee));
            }
        }

        double totalFee = 0.0;
        for (Delivery delivery : deliveries) {
            double fee = delivery.calculateFee();
            System.out.printf("%s: %.2f%n", delivery.getType(), fee);
            totalFee += fee;
        }
        System.out.printf("Total: %.2f%n", totalFee);
        scanner.close();
    }
}
