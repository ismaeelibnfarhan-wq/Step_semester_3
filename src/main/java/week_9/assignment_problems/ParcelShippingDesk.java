package week_9.assignment_problems;

import java.util.Scanner;

interface Insurable {
    double calculateInsurance(double declaredValue);
}

abstract class Parcel {
    protected double weightKg;
    protected double declaredValue;

    public Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    public abstract double calculateCharge();
    public abstract String getTypeName();

    public void printReport() {
        double charge = calculateCharge();
        double insurance = 0.0;
        if (this instanceof Insurable) {
            insurance = ((Insurable) this).calculateInsurance(declaredValue);
        }
        double total = charge + insurance;
        System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", getTypeName(), charge, insurance, total);
    }

    public double getTotal() {
        double charge = calculateCharge();
        double insurance = 0.0;
        if (this instanceof Insurable) {
            insurance = ((Insurable) this).calculateInsurance(declaredValue);
        }
        return charge + insurance;
    }
}

class StandardParcel extends Parcel {
    public StandardParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 40.0 + (10.0 * weightKg);
    }

    @Override
    public String getTypeName() {
        return "STANDARD";
    }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 80.0 + (15.0 * weightKg);
    }

    @Override
    public String getTypeName() {
        return "EXPRESS";
    }

    @Override
    public double calculateInsurance(double declaredValue) {
        return 0.02 * declaredValue;
    }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public double calculateCharge() {
        // Standard charge plus handling fee of 50
        return 40.0 + (10.0 * weightKg) + 50.0;
    }

    @Override
    public String getTypeName() {
        return "FRAGILE";
    }

    @Override
    public double calculateInsurance(double declaredValue) {
        return 0.02 * declaredValue;
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Parcel[] parcels = new Parcel[n];
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double declaredValue = scanner.nextDouble();

            if (type.equalsIgnoreCase("STANDARD")) {
                parcels[i] = new StandardParcel(weight, declaredValue);
            } else if (type.equalsIgnoreCase("EXPRESS")) {
                parcels[i] = new ExpressParcel(weight, declaredValue);
            } else if (type.equalsIgnoreCase("FRAGILE")) {
                parcels[i] = new FragileParcel(weight, declaredValue);
            }
        }
        scanner.close();

        for (Parcel p : parcels) {
            p.printReport();
            grandTotal += p.getTotal();
        }
        System.out.printf("Grand Total: %.2f%n", grandTotal);
    }
}
