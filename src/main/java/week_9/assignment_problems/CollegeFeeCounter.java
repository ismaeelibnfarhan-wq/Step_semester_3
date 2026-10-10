package week_9.assignment_problems;

import java.util.Scanner;

interface BusCommuter {
    double getTransportFee();
}

abstract class Student {
    protected String name;

    public Student(String name) {
        this.name = name;
    }

    public abstract double calculateTuition();

    public void printFee() {
        double fee = calculateTuition();
        if (this instanceof BusCommuter) {
            fee += ((BusCommuter) this).getTransportFee();
        }
        System.out.printf("%s: %.2f%n", name, fee);
    }

    public double getTotalFee() {
        double fee = calculateTuition();
        if (this instanceof BusCommuter) {
            fee += ((BusCommuter) this).getTransportFee();
        }
        return fee;
    }
}

class DayScholar extends Student implements BusCommuter {
    public DayScholar(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 40000.0;
    }

    @Override
    public double getTransportFee() {
        return 12000.0;
    }
}

class Hosteller extends Student {
    public Hosteller(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 40000.0 + 60000.0;
    }
}

class ScholarshipStudent extends Student implements BusCommuter {
    public ScholarshipStudent(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 20000.0; // half of normal tuition 40000
    }

    @Override
    public double getTransportFee() {
        return 12000.0;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Student[] students = new Student[n];
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();

            if (type.equalsIgnoreCase("DAY_SCHOLAR")) {
                students[i] = new DayScholar(name);
            } else if (type.equalsIgnoreCase("HOSTELLER")) {
                students[i] = new Hosteller(name);
            } else if (type.equalsIgnoreCase("SCHOLAR")) {
                students[i] = new ScholarshipStudent(name);
            }
        }
        scanner.close();

        for (Student s : students) {
            s.printFee();
            totalCollected += s.getTotalFee();
        }
        System.out.printf("Total Collected: %.2f%n", totalCollected);
    }
}
