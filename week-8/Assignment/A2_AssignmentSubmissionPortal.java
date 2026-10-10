// A2_AssignmentSubmissionPortal.java
public class A2_AssignmentSubmissionPortal {
    public static void main(String[] args) {
        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");

        Assignment codingLab = new CodingAssignment("Linked List Lab", 50, 10);
        Assignment writtenEssay = new WrittenAssignment("Design Essay", 50, 12);

        // 1. Asha submits 'Linked List Lab' on Mar 10 (on time)
        Submission subAsha = codingLab.submit(asha, 10);

        // 2. Ravi submits 'Design Essay' on Mar 14 (2 days late)
        Submission subRavi = writtenEssay.submit(ravi, 14);

        // 3. Faculty grades Asha with 45 marks
        subAsha.grade(45);

        // 4. Faculty grades Ravi with 40 marks
        subRavi.grade(40);

        // 5. Asha attempts to resubmit
        boolean resubmitAttempt = codingLab.attemptResubmit(asha, subAsha, 11);
        if (!resubmitAttempt) {
            System.out.printf("Cannot resubmit: '%s' has already been graded.%n", codingLab.getTitle());
        }
    }
}

enum SubmissionStatus {
    Submitted, Graded
}

abstract class Assignment {
    protected String title;
    protected int maxMarks;
    protected int dueDay; // e.g., 10 for Mar 10

    public Assignment(String title, int maxMarks, int dueDay) {
        this.title = title;
        this.maxMarks = maxMarks;
        this.dueDay = dueDay;
    }

    public String getTitle() { return title; }
    public int getMaxMarks() { return maxMarks; }
    public int getDueDay() { return dueDay; }

    public abstract double calculateLatePenaltyPercentage(int lateDays);

    public Submission submit(Student student, int submissionDay) {
        int lateDays = Math.max(0, submissionDay - dueDay);
        Submission s = new Submission(this, student, submissionDay, lateDays);
        if (lateDays == 0) {
            System.out.printf("%s's submission for '%s' received (on time). Status: %s.%n",
                    student.getName(), title, s.getStatus());
        } else {
            System.out.printf("%s's submission for '%s' received (%d days late). Status: %s.%n",
                    student.getName(), title, lateDays, s.getStatus());
        }
        return s;
    }

    public boolean attemptResubmit(Student student, Submission existingSubmission, int newDay) {
        if (existingSubmission.getStatus() == SubmissionStatus.Graded) {
            return false;
        }
        return true;
    }
}

class CodingAssignment extends Assignment {
    public CodingAssignment(String title, int maxMarks, int dueDay) {
        super(title, maxMarks, dueDay);
    }

    @Override
    public double calculateLatePenaltyPercentage(int lateDays) {
        return lateDays * 0.10; // 10% per day
    }
}

class WrittenAssignment extends Assignment {
    public WrittenAssignment(String title, int maxMarks, int dueDay) {
        super(title, maxMarks, dueDay);
    }

    @Override
    public double calculateLatePenaltyPercentage(int lateDays) {
        return lateDays * 0.20; // 20% per day
    }
}

class Student {
    private String name;
    public Student(String name) { this.name = name; }
    public String getName() { return name; }
}

class Submission {
    private Assignment assignment;
    private Student student;
    private int submissionDay;
    private int lateDays;
    private SubmissionStatus status;
    private int finalMarks;

    public Submission(Assignment assignment, Student student, int submissionDay, int lateDays) {
        this.assignment = assignment;
        this.student = student;
        this.submissionDay = submissionDay;
        this.lateDays = lateDays;
        this.status = SubmissionStatus.Submitted;
    }

    public SubmissionStatus getStatus() { return status; }

    public void grade(int rawMarks) {
        if (status == SubmissionStatus.Graded) {
            return;
        }
        status = SubmissionStatus.Graded;
        double penaltyRate = assignment.calculateLatePenaltyPercentage(lateDays);
        finalMarks = (int) Math.round(rawMarks * (1.0 - penaltyRate));

        if (penaltyRate > 0) {
            int penaltyPercent = (int) Math.round(penaltyRate * 100);
            System.out.printf("%s graded: %d/%d after %d%% late penalty. Status: %s.%n",
                    student.getName(), finalMarks, assignment.getMaxMarks(), penaltyPercent, status);
        } else {
            System.out.printf("%s graded: %d/%d. Status: %s.%n",
                    student.getName(), finalMarks, assignment.getMaxMarks(), status);
        }
    }
}
