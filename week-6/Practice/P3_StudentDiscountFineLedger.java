// P3_StudentDiscountFineLedger.java
import java.util.Arrays;

public class P3_StudentDiscountFineLedger {
    public static void main(String[] args) {
        StudentMember s = new StudentMember("STU5", 3, "CSE");
        s.chargeFine(100);
        System.out.println("Total fine: " + s.getTotalFine());

        int[] history = s.getFineHistory();
        System.out.println("History before tampering: " + Arrays.toString(history));
        history[0] = 999;
        System.out.println("History after tampering returned array: " + Arrays.toString(s.getFineHistory()));
    }
}

class LibraryMember {
    protected String memberId;
    protected int borrowLimit;
    private int[] fineHistory;
    private int fineCount;
    private int totalFine;

    public LibraryMember(String memberId, int borrowLimit) {
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        this.fineHistory = new int[10];
        this.fineCount = 0;
        this.totalFine = 0;
    }

    protected void chargeFine(int amount) {
        if (fineCount < fineHistory.length) {
            fineHistory[fineCount++] = amount;
        }
        totalFine += amount;
    }

    public int[] getFineHistory() {
        return Arrays.copyOf(fineHistory, fineCount);
    }

    public int getTotalFine() {
        return totalFine;
    }
}

class StudentMember extends LibraryMember {
    private String course;

    public StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    @Override
    protected void chargeFine(int amount) {
        super.chargeFine(amount / 2);
    }

    public String getCourse() {
        return course;
    }
}
