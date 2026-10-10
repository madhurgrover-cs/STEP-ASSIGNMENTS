// P5_MembershipRenewalAudit.java
import java.util.ArrayList;
import java.util.List;

public class P5_MembershipRenewalAudit {
    public static void main(String[] args) {
        LibraryMember m1 = new LibraryMember(3);
        System.out.println("Member Number: " + m1.memberNumber);
        System.out.println("Enrolled Members: " + LibraryMember.getMembersEnrolled());

        System.out.println("isValidRenewalCode(\"R12A\"): " + isValidRenewalCode("R12A"));
        System.out.println("isValidRenewalCode(\"R1A\"): " + isValidRenewalCode("R1A"));
        System.out.println("isValidRenewalCode(\"X12A\"): " + isValidRenewalCode("X12A"));

        m1.borrowBook();
        m1.borrowBook("Fiction");
        System.out.println("Books borrowed: " + m1.getBooksBorrowed());

        LibraryMember[] batch = {
            new FacultyMember(5, "Physics"),
            null,
            new LibraryMember(3)
        };
        System.out.println(processNightlyAudit(batch));
    }

    public static boolean isValidRenewalCode(String code) {
        if (code == null || code.length() != 4) {
            return false;
        }
        if (code.charAt(0) != 'R') {
            return false;
        }
        if (!Character.isDigit(code.charAt(1)) || !Character.isDigit(code.charAt(2))) {
            return false;
        }
        if (!Character.isUpperCase(code.charAt(3))) {
            return false;
        }
        return true;
    }

    public static String processNightlyAudit(LibraryMember[] members) {
        if (members == null) return "0 processed | 0 null skipped | 0 faculty | 0 regular";
        int processed = 0;
        int nullSkipped = 0;
        int faculty = 0;
        int regular = 0;

        for (LibraryMember m : members) {
            if (m == null) {
                nullSkipped++;
            } else {
                processed++;
                if (m instanceof FacultyMember) {
                    faculty++;
                } else {
                    regular++;
                }
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | " + faculty + " faculty | " + regular + " regular";
    }
}

class LibraryMember {
    private static int counter = 100;
    private static int membersEnrolled = 0;

    public final String memberNumber;
    protected int borrowLimit;
    protected int booksBorrowed;
    protected List<String> genres;

    public LibraryMember(int borrowLimit) {
        this.memberNumber = "LIB-" + (++counter);
        membersEnrolled++;
        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;
        this.genres = new ArrayList<>();
    }

    public void borrowBook() {
        this.booksBorrowed++;
    }

    public void borrowBook(String genre) {
        this.genres.add(genre);
        borrowBook();
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public static int getMembersEnrolled() {
        return membersEnrolled;
    }
}

class FacultyMember extends LibraryMember {
    private String department;

    public FacultyMember(int borrowLimit, String department) {
        super(borrowLimit);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}
