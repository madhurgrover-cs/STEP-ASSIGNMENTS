public class A3_EmployeeOverloading {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    public A3_EmployeeOverloading(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    public A3_EmployeeOverloading(String empId, String empName) {
        this(empId, empName, 0.0);
        this.isIntern = true;
    }

    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }

    public static void main(String[] args) {
        A3_EmployeeOverloading e1 = new A3_EmployeeOverloading("E-101", "Divya", 65000.0);
        A3_EmployeeOverloading e2 = new A3_EmployeeOverloading("E-102", "Arjun");

        e1.printProfile();
        e2.printProfile();
    }
}
