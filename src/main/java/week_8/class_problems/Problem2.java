import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem2 {

    static abstract class LibraryItem {
        protected String title;
        protected LocalDate borrowDate;

        public LibraryItem(String title, LocalDate borrowDate) {
            this.title = title;
            this.borrowDate = borrowDate;
        }

        public String getTitle() {
            return title;
        }

        public abstract LocalDate calculateDueDate();
    }

    static class Book extends LibraryItem {
        public Book(String title, LocalDate borrowDate) {
            super(title, borrowDate);
        }

        @Override
        public LocalDate calculateDueDate() {
            return borrowDate.plusDays(14); // 14 days borrowing period
        }
    }

    static class Dvd extends LibraryItem {
        public Dvd(String title, LocalDate borrowDate) {
            super(title, borrowDate);
        }

        @Override
        public LocalDate calculateDueDate() {
            return borrowDate.plusDays(7); // 7 days borrowing period
        }
    }

    static class Magazine extends LibraryItem {
        public Magazine(String title, LocalDate borrowDate) {
            super(title, borrowDate);
        }

        @Override
        public LocalDate calculateDueDate() {
            return borrowDate.plusDays(3); // 3 days borrowing period
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) {
            return;
        }

        String firstLine = scanner.nextLine().trim();
        while (firstLine.isEmpty() && scanner.hasNextLine()) {
            firstLine = scanner.nextLine().trim();
        }
        int n = Integer.parseInt(firstLine);

        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        List<LibraryItem> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextLine()) {
                break;
            }
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                i--;
                continue;
            }

            int firstSpace = line.indexOf(' ');
            if (firstSpace == -1) {
                continue;
            }
            String type = line.substring(0, firstSpace).trim();
            String title = line.substring(firstSpace + 1).trim();

            if (title.startsWith("\"") && title.endsWith("\"") && title.length() >= 2) {
                title = title.substring(1, title.length() - 1);
            }

            if (type.equalsIgnoreCase("BOOK")) {
                items.add(new Book(title, currentDate));
            } else if (type.equalsIgnoreCase("DVD")) {
                items.add(new Dvd(title, currentDate));
            } else if (type.equalsIgnoreCase("MAGAZINE")) {
                items.add(new Magazine(title, currentDate));
            }
        }

        for (LibraryItem item : items) {
            System.out.println(item.getTitle() + ": " + item.calculateDueDate());
        }

        scanner.close();
    }
}
