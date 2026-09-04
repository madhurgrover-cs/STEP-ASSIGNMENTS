public class A5_EmployeeStaticInfo {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public A5_EmployeeStaticInfo(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        A5_EmployeeStaticInfo e1 = new A5_EmployeeStaticInfo("Alice", 50000);
        A5_EmployeeStaticInfo e2 = new A5_EmployeeStaticInfo("Bob", 60000);
        A5_EmployeeStaticInfo e3 = new A5_EmployeeStaticInfo("Charlie", 55000);

        A5_EmployeeStaticInfo.printCompanyInfo();
    }
}
