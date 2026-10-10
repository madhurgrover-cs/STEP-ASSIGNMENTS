// P2_EmployeeLeaveRequestWorkflow.java
public class P2_EmployeeLeaveRequestWorkflow {
    public static void main(String[] args) {
        Employee john = new FullTimeEmployee("John");
        Employee jane = new PartTimeEmployee("Jane");

        // John submits request
        LeaveRequest r1 = john.submitLeaveRequest("Jan 1-5");
        System.out.printf("Leave request submitted for %s (%s). Status: %s.%n",
                john.getName(), r1.getDateRange(), r1.getStatus());

        // Manager Alice reviews and approves John's request
        r1.approve();
        System.out.printf("%s's leave request (%s) approved. Status: %s.%n",
                john.getName(), r1.getDateRange(), r1.getStatus());

        // Jane submits request
        LeaveRequest r2 = jane.submitLeaveRequest("Feb 10-11");
        System.out.printf("Leave request submitted for %s (%s). Status: %s.%n",
                jane.getName(), r2.getDateRange(), r2.getStatus());

        // Manager Bob reviews and rejects Jane's request
        r2.reject();
        System.out.printf("%s's leave request (%s) rejected. Status: %s.%n",
                jane.getName(), r2.getDateRange(), r2.getStatus());

        // John attempts to change approved request back to Pending
        boolean success = r1.revertToPending();
        if (!success) {
            System.out.println("Cannot change leave request status from Approved to Pending.");
        }
    }
}

enum LeaveStatus {
    Pending, Approved, Rejected
}

abstract class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public LeaveRequest submitLeaveRequest(String dateRange) {
        return new LeaveRequest(this, dateRange);
    }
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name) { super(name); }
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name) { super(name); }
}

class Contractor extends Employee {
    public Contractor(String name) { super(name); }
}

class LeaveRequest {
    private Employee employee;
    private String dateRange;
    private LeaveStatus status;

    public LeaveRequest(Employee employee, String dateRange) {
        this.employee = employee;
        this.dateRange = dateRange;
        this.status = LeaveStatus.Pending;
    }

    public Employee getEmployee() { return employee; }
    public String getDateRange() { return dateRange; }
    public LeaveStatus getStatus() { return status; }

    public boolean approve() {
        if (status == LeaveStatus.Pending) {
            status = LeaveStatus.Approved;
            return true;
        }
        return false;
    }

    public boolean reject() {
        if (status == LeaveStatus.Pending) {
            status = LeaveStatus.Rejected;
            return true;
        }
        return false;
    }

    public boolean revertToPending() {
        if (status == LeaveStatus.Approved || status == LeaveStatus.Rejected) {
            return false;
        }
        status = LeaveStatus.Pending;
        return true;
    }
}
