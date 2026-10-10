// A5_CampusNoticeBroadcaster.java
import java.util.*;

public class A5_CampusNoticeBroadcaster {
    public static void main(String[] args) {
        NoticeBoard board = new NoticeBoard();

        Student asha = new Student("Asha", "CSE");
        asha.addChannel(new EmailChannel());
        asha.addChannel(new AppChannel());

        Student ravi = new Student("Ravi", "ECE");
        ravi.addChannel(new SmsChannel());

        board.registerStudent(asha);
        board.registerStudent(ravi);

        // 1. Post 'Lab Closed Tomorrow' for CSE
        board.postNotice("Lab Closed Tomorrow", Collections.singletonList("CSE"));

        // 2. Post 'Fee Deadline Extended' for CSE and ECE
        board.postNotice("Fee Deadline Extended", Arrays.asList("CSE", "ECE"));

        // 3. Post 'Sports Day' with no target department
        board.postNotice("Sports Day", Collections.emptyList());
    }
}

interface NotificationChannel {
    void send(String studentName, String message);
}

class EmailChannel implements NotificationChannel {
    @Override
    public void send(String studentName, String message) {
        System.out.printf("[Email \u2192 %s] %s.%n", studentName, message);
    }
}

class SmsChannel implements NotificationChannel {
    @Override
    public void send(String studentName, String message) {
        System.out.printf("[SMS \u2192 %s] %s.%n", studentName, message);
    }
}

class AppChannel implements NotificationChannel {
    @Override
    public void send(String studentName, String message) {
        System.out.printf("[App \u2192 %s] %s.%n", studentName, message);
    }
}

class Student {
    private String name;
    private String department;
    private List<NotificationChannel> channels;

    public Student(String name, String department) {
        this.name = name;
        this.department = department;
        this.channels = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public List<NotificationChannel> getChannels() { return channels; }

    public void addChannel(NotificationChannel ch) {
        channels.add(ch);
    }

    public void notifyStudent(String message) {
        for (NotificationChannel ch : channels) {
            ch.send(name, message);
        }
    }
}

class NoticeBoard {
    private List<Student> students;

    public NoticeBoard() {
        this.students = new ArrayList<>();
    }

    public void registerStudent(Student s) {
        students.add(s);
    }

    public boolean postNotice(String title, List<String> targetDepartments) {
        if (title == null || title.trim().isEmpty() || targetDepartments == null || targetDepartments.isEmpty()) {
            System.out.println("Cannot post notice: At least one target department is required.");
            return false;
        }

        System.out.printf("Notice '%s' posted to %s.%n", title, String.join(", ", targetDepartments));

        for (Student s : students) {
            if (targetDepartments.contains(s.getDepartment())) {
                s.notifyStudent(title);
            }
        }
        return true;
    }
}
