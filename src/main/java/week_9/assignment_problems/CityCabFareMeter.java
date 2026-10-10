package week_9.assignment_problems;

import java.util.Scanner;

interface NightService {
    double applyNightService(double fare);
}

abstract class Cab {
    protected double km;
    protected String time;

    public Cab(double km, String time) {
        this.km = km;
        this.time = time;
    }

    public abstract double getRatePerKm();
    public abstract String getCabName();

    public boolean supportsNight() {
        return this instanceof NightService;
    }

    public void processTrip() {
        if (time.equalsIgnoreCase("NIGHT") && !supportsNight()) {
            System.out.printf("%s: night service not available%n", getCabName());
            return;
        }

        double baseFare = km * getRatePerKm();
        double fare = Math.max(baseFare, 100.0);

        if (time.equalsIgnoreCase("NIGHT") && supportsNight()) {
            fare = ((NightService) this).applyNightService(fare);
        }

        System.out.printf("%s: %.2f%n", getCabName(), fare);
    }

    public boolean isCompleted() {
        if (time.equalsIgnoreCase("NIGHT") && !supportsNight()) {
            return false;
        }
        return true;
    }

    public double getFare() {
        if (!isCompleted()) return 0.0;
        double baseFare = km * getRatePerKm();
        double fare = Math.max(baseFare, 100.0);
        if (time.equalsIgnoreCase("NIGHT") && supportsNight()) {
            fare = ((NightService) this).applyNightService(fare);
        }
        return fare;
    }
}

class MiniCab extends Cab {
    public MiniCab(double km, String time) {
        super(km, time);
    }

    @Override
    public double getRatePerKm() {
        return 10.0;
    }

    @Override
    public String getCabName() {
        return "MINI";
    }
}

class SedanCab extends Cab implements NightService {
    public SedanCab(double km, String time) {
        super(km, time);
    }

    @Override
    public double getRatePerKm() {
        return 14.0;
    }

    @Override
    public String getCabName() {
        return "SEDAN";
    }

    @Override
    public double applyNightService(double fare) {
        return fare * 1.20;
    }
}

class SuvCab extends Cab implements NightService {
    public SuvCab(double km, String time) {
        super(km, time);
    }

    @Override
    public double getRatePerKm() {
        return 18.0;
    }

    @Override
    public String getCabName() {
        return "SUV";
    }

    @Override
    public double applyNightService(double fare) {
        return fare * 1.20;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Cab[] cabs = new Cab[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String cabType = scanner.next();
            double km = scanner.nextDouble();
            String time = scanner.next();

            if (cabType.equalsIgnoreCase("MINI")) {
                cabs[i] = new MiniCab(km, time);
            } else if (cabType.equalsIgnoreCase("SEDAN")) {
                cabs[i] = new SedanCab(km, time);
            } else if (cabType.equalsIgnoreCase("SUV")) {
                cabs[i] = new SuvCab(km, time);
            }
        }
        scanner.close();

        for (Cab c : cabs) {
            c.processTrip();
            if (c.isCompleted()) {
                total += c.getFare();
            }
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
