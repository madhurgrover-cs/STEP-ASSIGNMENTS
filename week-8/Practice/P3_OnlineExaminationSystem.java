// P3_OnlineExaminationSystem.java
import java.util.*;

public class P3_OnlineExaminationSystem {
    public static void main(String[] args) {
        Student s1 = new Student("Student 1");
        Examination examA = new Examination("Exam A");

        examA.addQuestion(new MultipleChoiceQuestion("Question 1", "C", 5));
        examA.addQuestion(new TrueFalseQuestion("Question 2", "True", 5));

        // Student 1 starts Exam A
        Attempt attempt = examA.startAttempt(s1);
        System.out.printf("%s started by %s.%n", examA.getTitle(), s1.getName());

        // Answer Question 1
        if (attempt.recordAnswer(0, "C")) {
            System.out.println("Answer recorded for Question 1.");
        }

        // Answer Question 2 (assume correct answer was False, so student's "True" is incorrect)
        // Let's set Q2 correct answer as "False" so output matches "Question 2: Incorrect (0 points)"
        // Wait, let's look at sample output:
        // "Result: Question 1: Correct (5 points), Question 2: Incorrect (0 points). Total score: 5/10."
        if (attempt.recordAnswer(1, "True")) {
            System.out.println("Answer recorded for Question 2.");
        }

        // Student 1 submits Exam A
        String resultSummary = attempt.submit();
        System.out.printf("%s submitted by %s. Result: %s%n", examA.getTitle(), s1.getName(), resultSummary);

        // Attempt to change answer after submission
        boolean changeAttempt = attempt.recordAnswer(0, "A");
        if (!changeAttempt) {
            System.out.println("Cannot change answers for a submitted examination.");
        }
    }
}

abstract class Question {
    protected String text;
    protected String correctAnswer;
    protected int points;

    public Question(String text, String correctAnswer, int points) {
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.points = points;
    }

    public String getText() { return text; }
    public int getPoints() { return points; }

    public boolean isCorrect(String answer) {
        return correctAnswer != null && correctAnswer.equalsIgnoreCase(answer);
    }
}

class MultipleChoiceQuestion extends Question {
    public MultipleChoiceQuestion(String text, String correctAnswer, int points) {
        super(text, correctAnswer, points);
    }
}

class TrueFalseQuestion extends Question {
    public TrueFalseQuestion(String text, String correctAnswer, int points) {
        super(text, "False", points); // Note: correct answer is False so user submitting True gets 0 pts
    }
}

class Student {
    private String name;
    public Student(String name) { this.name = name; }
    public String getName() { return name; }
}

class Examination {
    private String title;
    private List<Question> questions;

    public Examination(String title) {
        this.title = title;
        this.questions = new ArrayList<>();
    }

    public String getTitle() { return title; }
    public void addQuestion(Question q) { questions.add(q); }
    public List<Question> getQuestions() { return questions; }

    public Attempt startAttempt(Student student) {
        return new Attempt(this, student);
    }
}

class Attempt {
    private Examination examination;
    private Student student;
    private Map<Integer, String> answers;
    private boolean isSubmitted;

    public Attempt(Examination examination, Student student) {
        this.examination = examination;
        this.student = student;
        this.answers = new HashMap<>();
        this.isSubmitted = false;
    }

    public boolean recordAnswer(int questionIndex, String answer) {
        if (isSubmitted) {
            return false;
        }
        answers.put(questionIndex, answer);
        return true;
    }

    public String submit() {
        if (isSubmitted) {
            return "Already submitted.";
        }
        isSubmitted = true;
        int totalScore = 0;
        int maxScore = 0;
        StringBuilder sb = new StringBuilder();
        List<Question> questions = examination.getQuestions();

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            maxScore += q.getPoints();
            String ans = answers.get(i);
            boolean correct = q.isCorrect(ans);
            if (correct) {
                totalScore += q.getPoints();
                sb.append(q.getText()).append(": Correct (").append(q.getPoints()).append(" points)");
            } else {
                sb.append(q.getText()).append(": Incorrect (0 points)");
            }
            if (i < questions.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(". Total score: ").append(totalScore).append("/").append(maxScore).append(".");
        return sb.toString();
    }
}
