public class A1_DuplicateSeatChecker {
    public static void main(String[] args) {
        int[] seats1 = {101, 102, 103, 102, 105};
        System.out.print("{101, 102, 103, 102, 105} -> ");
        checkDuplicateSeats(seats1);
        
        int[] seats2 = {101, 102, 103, 104, 105};
        System.out.print("{101, 102, 103, 104, 105} -> ");
        checkDuplicateSeats(seats2);
    }
    
    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean found = false;
        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
        if (!found) {
            System.out.println("No Duplicate Seats Found");
        }
    }
}
