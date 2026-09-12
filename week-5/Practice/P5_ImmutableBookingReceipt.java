// P5_ImmutableBookingReceipt.java
import java.util.Arrays;

public class P5_ImmutableBookingReceipt {
    public static void main(String[] args) {
        String[] seats = {"A1", "A2"};
        BookingReceipt receipt1 = new BookingReceipt("B001", seats);
        GroupBookingReceipt receipt2 = new GroupBookingReceipt("B002", new String[]{"C1", "C2", "C3"}, 3);
        BookingReceipt[] receipts = {receipt1, null, receipt2};
        System.out.println(NightlySettlementProcessor.processNightlySettlement(receipts));
    }
}

class BookingReceipt {
    private final String bookingId;
    private final String[] seatNumbers;

    public BookingReceipt(String bookingId, String[] seatNumbers) {
        this.bookingId = bookingId;
        this.seatNumbers = Arrays.copyOf(seatNumbers, seatNumbers.length);
    }

    public String[] getSeatNumbers() {
        return Arrays.copyOf(seatNumbers, seatNumbers.length);
    }

    public String getBookingId() {
        return bookingId;
    }

    public BookingReceipt withUpdatedSeat(int index, String newSeat) {
        String[] newSeats = getSeatNumbers();
        if (index >= 0 && index < newSeats.length) {
            newSeats[index] = newSeat;
        }
        return new BookingReceipt(this.bookingId, newSeats);
    }
}

class GroupBookingReceipt extends BookingReceipt {
    private final int groupSize;

    public GroupBookingReceipt(String bookingId, String[] seatNumbers, int groupSize) {
        super(bookingId, seatNumbers);
        this.groupSize = groupSize;
    }

    public int getGroupSize() {
        return groupSize;
    }
}

class NightlySettlementProcessor {
    public static String processNightlySettlement(BookingReceipt[] receipts) {
        int processed = 0, nullSkipped = 0, group = 0, individual = 0;
        for (BookingReceipt r : receipts) {
            if (r == null) {
                nullSkipped++;
            } else {
                processed++;
                if (r instanceof GroupBookingReceipt) {
                    group++;
                } else {
                    individual++;
                }
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | " + group + " group | " + individual + " individual";
    }
}
