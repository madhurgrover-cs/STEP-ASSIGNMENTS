// P2_ThreeBranchesMembership.java
public class P2_ThreeBranchesMembership {
    public static void main(String[] args) {
        LibraryMember lm = new LibraryMember("STU1", 3);
        StudentMember sm = new StudentMember("STU2", 3, "CSE");
        HonorsStudentMember hm = new HonorsStudentMember("STU3", 3, "ECE", 2);
        FacultyMember fm = new FacultyMember("STU4", 5, "Physics");

        System.out.println(lm.displayInfo());
        System.out.println(sm.displayInfo());
        System.out.println(hm.displayInfo());
        System.out.println(fm.displayInfo());

        System.out.println(classifyGeneration(hm));
        System.out.println(classifyGeneration(fm));

        sm.borrowBook();
        sm.borrowBook();
        hm.borrowBook();
        fm.borrowBook();
        fm.borrowBook();
        fm.borrowBook();

        LibraryMember[] mixed = {sm, hm, fm};
        System.out.println("Total books borrowed: " + getTotalBooksBorrowed(mixed));
    }

    public static String classifyGeneration(LibraryMember member) {
        if (member instanceof HonorsStudentMember) {
            return "Multilevel descendant (3 generations deep)";
        }
        if (member instanceof FacultyMember) {
            return "Hierarchical sibling (independent branch)";
        }
        if (member instanceof StudentMember) {
            return "Direct subclass";
        }
        return "Base class";
    }

    public static int getTotalBooksBorrowed(LibraryMember[] members) {
        int total = 0;
        for (LibraryMember m : members) {
            total += m.getBooksBorrowed();
        }
        return total;
    }
}

class LibraryMember {
    protected String memberId;
    protected int borrowLimit;
    protected int booksBorrowed;

    public LibraryMember(String memberId, int borrowLimit) {
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;
    }

    public void borrowBook() {
        this.booksBorrowed++;
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public String displayInfo() {
        return "General Member | Books Borrowed: " + booksBorrowed;
    }
}

class StudentMember extends LibraryMember {
    protected String course;

    public StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    @Override
    public String displayInfo() {
        return "Student Member | Course: " + course + " | Books Borrowed: " + booksBorrowed;
    }
}

class HonorsStudentMember extends StudentMember {
    private int bonusLimit;

    public HonorsStudentMember(String memberId, int borrowLimit, String course, int bonusLimit) {
        super(memberId, borrowLimit, course);
        this.bonusLimit = bonusLimit;
    }

    @Override
    public String displayInfo() {
        return "Honors Student Member | Course: " + course + " | Bonus Limit: " + bonusLimit + " | Books Borrowed: " + booksBorrowed;
    }
}

class FacultyMember extends LibraryMember {
    private String department;

    public FacultyMember(String memberId, int borrowLimit, String department) {
        super(memberId, borrowLimit);
        this.department = department;
    }

    @Override
    public String displayInfo() {
        return "Faculty Member | Department: " + department + " | Books Borrowed: " + booksBorrowed;
    }
}
