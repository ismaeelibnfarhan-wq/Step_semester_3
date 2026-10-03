import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem3 {

    static abstract class Room {
        protected String type;
        protected int units;

        public Room(String type, int units) {
            this.type = type;
            this.units = units;
        }

        public String getType() {
            return type;
        }

        public abstract double calculateBill();
    }

    static class SingleRoom extends Room {
        public SingleRoom(int units) {
            super("SINGLE", units);
        }

        @Override
        public double calculateBill() {
            return units * 8.0; // ₹8 per unit
        }
    }

    static class SharedRoom extends Room {
        private int occupants;

        public SharedRoom(int units, int occupants) {
            super("SHARED", units);
            this.occupants = occupants;
        }

        @Override
        public double calculateBill() {
            // ₹6 per unit, divided equally by the number of occupants
            return (units * 6.0) / occupants;
        }
    }

    static class AcRoom extends Room {
        public AcRoom(int units) {
            super("AC", units);
        }

        @Override
        public double calculateBill() {
            // ₹10 per unit, plus a fixed charge of ₹200
            return (units * 10.0) + 200.0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int units = scanner.nextInt();

            if (type.equalsIgnoreCase("SINGLE")) {
                rooms.add(new SingleRoom(units));
            } else if (type.equalsIgnoreCase("SHARED")) {
                int occupants = scanner.nextInt();
                rooms.add(new SharedRoom(units, occupants));
            } else if (type.equalsIgnoreCase("AC")) {
                rooms.add(new AcRoom(units));
            }
        }

        double grandTotal = 0.0;
        for (Room room : rooms) {
            double bill = room.calculateBill();
            System.out.printf("%s: %.2f%n", room.getType(), bill);
            grandTotal += bill;
        }
        System.out.printf("Total: %.2f%n", grandTotal);
        scanner.close();
    }
}
