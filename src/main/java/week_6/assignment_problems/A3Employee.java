public class A3Employee {
    static class Employee {
        String empId;
        String empName;
        double salary;
        boolean isIntern;

        Employee(String empId, String empName, double salary) {
            this.empId = empId;
            this.empName = empName;
            this.salary = salary;
            this.isIntern = false;
        }

        Employee(String empId, String empName) {
            this(empId, empName, 0);
            this.isIntern = true;
        }

        void printProfile() {
            System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
        }
    }

    public static void main(String[] args) {
        Employee p = new Employee("E-101", "Divya", 65000);
        Employee i = new Employee("E-102", "Arjun");
        p.printProfile();
        i.printProfile();
    }
}
