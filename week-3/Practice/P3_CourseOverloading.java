public class P3_CourseOverloading {
    String code;
    String title;
    int credits;
    int labCredits;

    public P3_CourseOverloading(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    public P3_CourseOverloading(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    public int totalCredits() {
        return credits + labCredits;
    }

    public static void main(String[] args) {
        P3_CourseOverloading course1 = new P3_CourseOverloading("21CSC201J", "DSA", 3, 1);
        P3_CourseOverloading course2 = new P3_CourseOverloading("21CSC205L", "OS", 4);

        System.out.println(course1.code + " total credits: " + course1.totalCredits());
        System.out.println(course2.code + " total credits: " + course2.totalCredits());
    }
}
