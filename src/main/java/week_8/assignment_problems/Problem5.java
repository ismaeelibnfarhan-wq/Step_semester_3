import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem5 {

    static abstract class Subscription {
        protected String type;
        protected String name;
        protected LocalDate startDate;

        public Subscription(String type, String name, LocalDate startDate) {
            this.type = type;
            this.name = name;
            this.startDate = startDate;
        }

        public String getName() {
            return name;
        }

        public abstract LocalDate calculateRenewalDate();
    }

    static class BasicPlan extends Subscription {
        public BasicPlan(String name, LocalDate startDate) {
            super("BASIC", name, startDate);
        }

        @Override
        public LocalDate calculateRenewalDate() {
            return startDate.plusDays(30); // Valid for 30 days
        }
    }

    static class StandardPlan extends Subscription {
        public StandardPlan(String name, LocalDate startDate) {
            super("STANDARD", name, startDate);
        }

        @Override
        public LocalDate calculateRenewalDate() {
            return startDate.plusDays(90); // Valid for 90 days
        }
    }

    static class PremiumPlan extends Subscription {
        public PremiumPlan(String name, LocalDate startDate) {
            super("PREMIUM", name, startDate);
        }

        @Override
        public LocalDate calculateRenewalDate() {
            return startDate.plusDays(365); // Valid for 365 days
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        List<Subscription> subscriptions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            String dateStr = scanner.next();
            LocalDate startDate = LocalDate.parse(dateStr);

            if (type.equalsIgnoreCase("BASIC")) {
                subscriptions.add(new BasicPlan(name, startDate));
            } else if (type.equalsIgnoreCase("STANDARD")) {
                subscriptions.add(new StandardPlan(name, startDate));
            } else if (type.equalsIgnoreCase("PREMIUM")) {
                subscriptions.add(new PremiumPlan(name, startDate));
            }
        }

        for (Subscription sub : subscriptions) {
            System.out.println(sub.getName() + ": " + sub.calculateRenewalDate());
        }

        scanner.close();
    }
}
