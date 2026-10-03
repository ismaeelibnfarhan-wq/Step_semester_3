import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem4 {

    static abstract class Employee {
        protected String type;
        protected String name;
        protected double salary;

        public Employee(String type, String name, double salary) {
            this.type = type;
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public abstract double calculateBonus();
    }

    static class FullTimeEmployee extends Employee {
        public FullTimeEmployee(String name, double salary) {
            super("FULLTIME", name, salary);
        }

        @Override
        public double calculateBonus() {
            return salary * 0.10; // 10% of monthly salary
        }
    }

    static class PartTimeEmployee extends Employee {
        public PartTimeEmployee(String name, double salary) {
            super("PARTTIME", name, salary);
        }

        @Override
        public double calculateBonus() {
            return salary * 0.05; // 5% of monthly salary
        }
    }

    static class InternEmployee extends Employee {
        public InternEmployee(String name, double salary) {
            super("INTERN", name, salary);
        }

        @Override
        public double calculateBonus() {
            return 2000.0; // Fixed bonus of ₹2,000
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            double salary = scanner.nextDouble();

            if (type.equalsIgnoreCase("FULLTIME")) {
                employees.add(new FullTimeEmployee(name, salary));
            } else if (type.equalsIgnoreCase("PARTTIME")) {
                employees.add(new PartTimeEmployee(name, salary));
            } else if (type.equalsIgnoreCase("INTERN")) {
                employees.add(new InternEmployee(name, salary));
            }
        }

        double grandTotal = 0.0;
        for (Employee employee : employees) {
            double bonus = employee.calculateBonus();
            System.out.printf("%s: %.2f%n", employee.getName(), bonus);
            grandTotal += bonus;
        }
        System.out.printf("Total Bonus: %.2f%n", grandTotal);
        scanner.close();
    }
}
