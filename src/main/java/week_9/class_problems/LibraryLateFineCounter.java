package week_9.class_problems;

import java.util.Scanner;

abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public abstract double calculateFine();

    public void printFine() {
        System.out.printf("%s: %.2f%n", title, calculateFine());
    }
}

class BookItem extends LibraryItem {
    public BookItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 2.0;
    }
}

class DvdItem extends LibraryItem {
    public DvdItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        double fine = daysLate * 5.0;
        return Math.min(fine, 50.0);
    }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 1.0;
    }
}

public class LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        LibraryItem[] items = new LibraryItem[n];
        double totalFines = 0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String title = scanner.next();
            int daysLate = scanner.nextInt();

            if (type.equalsIgnoreCase("BOOK")) {
                items[i] = new BookItem(title, daysLate);
            } else if (type.equalsIgnoreCase("DVD")) {
                items[i] = new DvdItem(title, daysLate);
            } else if (type.equalsIgnoreCase("MAGAZINE")) {
                items[i] = new MagazineItem(title, daysLate);
            }
        }
        scanner.close();

        for (LibraryItem item : items) {
            item.printFine();
            totalFines += item.calculateFine();
        }
        System.out.printf("Total Fines: %.2f%n", totalFines);
    }
}
