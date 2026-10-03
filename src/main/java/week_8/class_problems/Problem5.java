import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem5 {

    static abstract class Transport {
        protected String type;
        protected double distance;

        public Transport(String type, double distance) {
            this.type = type;
            this.distance = distance;
        }

        public String getType() {
            return type;
        }

        public abstract double calculateFare();
    }

    static class BusTransport extends Transport {
        public BusTransport(double distance) {
            super("BUS", distance);
        }

        @Override
        public double calculateFare() {
            // Base fare $2, plus $0.10 per km. Max fare $10.
            double fare = 2.0 + (distance * 0.10);
            return Math.min(10.0, fare);
        }
    }

    static class TrainTransport extends Transport {
        public TrainTransport(double distance) {
            super("TRAIN", distance);
        }

        @Override
        public double calculateFare() {
            // Base fare $3, plus $0.15 per km.
            return 3.0 + (distance * 0.15);
        }
    }

    static class MetroTransport extends Transport {
        private double peakHourFactor;

        public MetroTransport(double distance, double peakHourFactor) {
            super("METRO", distance);
            this.peakHourFactor = peakHourFactor;
        }

        @Override
        public double calculateFare() {
            // Base fare $1.50, plus $0.20 per km, multiplied by PeakHourFactor
            return (1.50 + (distance * 0.20)) * peakHourFactor;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        List<Transport> journeys = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double distance = scanner.nextDouble();

            if (type.equalsIgnoreCase("BUS")) {
                journeys.add(new BusTransport(distance));
            } else if (type.equalsIgnoreCase("TRAIN")) {
                journeys.add(new TrainTransport(distance));
            } else if (type.equalsIgnoreCase("METRO")) {
                double peakHourFactor = scanner.nextDouble();
                journeys.add(new MetroTransport(distance, peakHourFactor));
            }
        }

        double grandTotal = 0.0;
        for (Transport transport : journeys) {
            double fare = transport.calculateFare();
            System.out.printf("%s: %.2f%n", transport.getType(), fare);
            grandTotal += fare;
        }
        System.out.printf("Total: %.2f%n", grandTotal);
        scanner.close();
    }
}
