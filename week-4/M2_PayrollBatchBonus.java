/**
 * M2. Payroll Batch Bonus Round
 * Scenario: Using `this` keyword to resolve field and parameter naming clash.
 */
public class M2_PayrollBatchBonus {
    public static void main(String[] args) {
        String[] names = {"Arun", "Meena", "Karthik"};
        double[] salaries = {30000, 45000, 38000};
        double bonus = 5000;
        
        Employee[] employees = new Employee[names.length];
        for (int i = 0; i < names.length; i++) {
            employees[i] = new Employee(names[i], salaries[i]);
            employees[i].raiseSalary(bonus);
            System.out.println(employees[i].name + " | Final Salary: " + employees[i].salary);
        }
    }
}

class Employee {
    String name;
    double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void raiseSalary(double bonus) {
        this.salary += bonus;
    }
}
