public class A4_HallTicketReference {
    String studentName;
    int seatNumber;

    public A4_HallTicketReference(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public static void main(String[] args) {
        A4_HallTicketReference priya = new A4_HallTicketReference("Priya", 0);
        A4_HallTicketReference copy = priya;
        copy.seatNumber = 45;

        A4_HallTicketReference separate = new A4_HallTicketReference("Priya", 45);

        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));
        System.out.println("separate == priya: " + (separate == priya));
    }
}
