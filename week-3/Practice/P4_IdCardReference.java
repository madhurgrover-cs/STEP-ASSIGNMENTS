public class P4_IdCardReference {
    String name;
    int booksIssued;

    public P4_IdCardReference(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public static void main(String[] args) {
        P4_IdCardReference ravi = new P4_IdCardReference("Ravi", 0);
        P4_IdCardReference duplicate = ravi;
        duplicate.booksIssued = 3;

        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));

        P4_IdCardReference separate = new P4_IdCardReference("Ravi", 3);
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}
