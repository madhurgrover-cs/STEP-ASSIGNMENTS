public class P5_StudentStatic {
    String name;
    double attendance;
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    public P5_StudentStatic(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    public static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {
        P5_StudentStatic s1 = new P5_StudentStatic("Alice", 90.5);
        P5_StudentStatic s2 = new P5_StudentStatic("Bob", 85.0);

        P5_StudentStatic.printCollegeInfo();
    }
}
