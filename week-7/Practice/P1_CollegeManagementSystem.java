// P1_CollegeManagementSystem.java
public class P1_CollegeManagementSystem {
    public static void main(String[] args) {
        System.out.println("=== College Management System ===");
        Student s1 = new Student(101, "Alice Smith", "Computer Science", 3.9);
        Student s2 = new Student(102, "Bob Johnson", "Electrical Engineering", 3.7);

        Course c1 = new Course("CS201", "Data Structures & Algorithms", 4, "Dr. Alan Turing");
        Course c2 = new Course("EE101", "Circuit Theory", 3, "Dr. Nikola Tesla");

        s1.displayDetails();
        System.out.println();
        s2.displayDetails();
        System.out.println();

        c1.displayDetails();
        System.out.println();
        c2.displayDetails();
    }
}

class Student {
    private int studentId;
    private String name;
    private String department;
    private double gpa;

    public Student(int studentId, String name, String department, double gpa) {
        this.studentId = studentId;
        this.name = name;
        this.department = department;
        this.gpa = gpa;
    }

    public int getStudentId() { return studentId; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getGpa() { return gpa; }

    public void displayDetails() {
        System.out.println("--- Student Details ---");
        System.out.println("Student ID : " + studentId);
        System.out.println("Name       : " + name);
        System.out.println("Department : " + department);
        System.out.println("GPA        : " + gpa);
    }
}

class Course {
    private String courseCode;
    private String courseName;
    private int credits;
    private String instructor;

    public Course(String courseCode, String courseName, int credits, String instructor) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
        this.instructor = instructor;
    }

    public String getCourseCode() { return courseCode; }
    public String getCourseName() { return courseName; }
    public int getCredits() { return credits; }
    public String getInstructor() { return instructor; }

    public void displayDetails() {
        System.out.println("--- Course Details ---");
        System.out.println("Course Code : " + courseCode);
        System.out.println("Course Name : " + courseName);
        System.out.println("Credits     : " + credits);
        System.out.println("Instructor  : " + instructor);
    }
}
