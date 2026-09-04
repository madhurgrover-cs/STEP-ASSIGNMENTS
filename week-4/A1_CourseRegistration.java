/**
 * A1. Constructor Chaining via this() – Student Course Registration
 * Scenario: At the start of a new semester, students register for courses. Some have a preferred elective; others haven't decided yet and default to "General Elective".
 */
public class A1_CourseRegistration {
    public static void main(String[] args) {
        CourseRegistration[] students = new CourseRegistration[5];
        String[] names = {"Ananya", "Rohan", "Priya", "Arjun", "Sneha"};
        String[] courses = {"DSA", "OS", "DBMS", "Networks", "AI"};
        String[] electives = {"ML", "", "Cloud", "", "Cyber Sec"};

        for (int i = 0; i < 5; i++) {
            if (electives[i].isEmpty()) {
                students[i] = new CourseRegistration(names[i], courses[i]);
            } else {
                students[i] = new CourseRegistration(names[i], courses[i], electives[i]);
            }
        }

        for (CourseRegistration student : students) {
            System.out.println(student.studentName + " | " + student.courseName + " | " + student.elective);
        }
    }
}

class CourseRegistration {
    String studentName;
    String courseName;
    String elective;

    public CourseRegistration(String studentName, String courseName, String elective) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.elective = elective;
    }

    public CourseRegistration(String studentName, String courseName) {
        this(studentName, courseName, "General Elective");
    }
}
