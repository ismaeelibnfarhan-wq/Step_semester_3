package week_9.assignment_problems;

import java.util.Scanner;

abstract class Ticket {
    protected int count;
    protected static final double CONVENIENCE_FEE = 20.0;

    public Ticket(int count) {
        this.count = count;
    }

    public abstract double calculateBasePrice();
    public abstract String getSeatName();

    public double calculateTotalAmount() {
        return (calculateBasePrice() + CONVENIENCE_FEE) * count;
    }

    public void printBooking() {
        System.sout.printf("%s: %.2f%n", getSeatName(), calculateTotalAmount());
    }
}

class RegularTicket extends Ticket {
    public RegularTicket(int count) {
        super(count);
    }

    @Override
    public double calculateBasePrice() {
        return 150.0;
    }

    @Override
    public String getSeatName() {
        return "REGULAR";
    }
}

class PremiumTicket extends Ticket {
    public PremiumTicket(int count) {
        super(count);
    }

    @Override
    public double calculateBasePrice() {
        return 250.0;
    }

    @Override
    public String getSeatName() {
        return "PREMIUM";
    }
}

class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) {
        super(count);
    }

    @Override
    public double calculateBasePrice() {
        return 400.0;
    }

    @Override
    public String getSeatName() {
        return "RECLINER";
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Ticket[] tickets = new Ticket[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String seat = scanner.next();
            int count = scanner.nextInt();
            if (seat.equalsIgnoreCase("REGULAR")) {
                tickets[i] = new RegularTicket(count);
            } else if (seat.equalsIgnoreCase("PREMIUM")) {
                tickets[i] = new PremiumTicket(count);
            } else if (seat.equalsIgnoreCase("RECLINER")) {
                tickets[i] = new ReclinerTicket(count);
            }
        }
        scanner.close();

        for (Ticket t : tickets) {
            t.printBooking();
            total += t.calculateTotalAmount();
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
