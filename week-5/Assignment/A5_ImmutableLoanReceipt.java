// A5_ImmutableLoanReceipt.java
import java.util.Arrays;

public class A5_ImmutableLoanReceipt {
    public static void main(String[] args) {
        String[] books = {"B01", "B02"};
        LoanReceipt receipt1 = new LoanReceipt("M01", books);
        ReferenceOnlyLoanReceipt receipt2 = new ReferenceOnlyLoanReceipt("M02", new String[]{"R01"}, "Room A");
        LoanReceipt[] receipts = {receipt1, null, receipt2};
        
        System.out.println(CirculationLedger.processNightlyCirculation(receipts));
    }
}

class LoanReceipt {
    private final String memberId;
    private final String[] bookIds;

    public LoanReceipt(String memberId, String[] bookIds) {
        this.memberId = memberId;
        this.bookIds = Arrays.copyOf(bookIds, bookIds.length);
    }

    public String[] getBookIds() {
        return Arrays.copyOf(bookIds, bookIds.length);
    }

    public String getMemberId() {
        return memberId;
    }

    public LoanReceipt withCorrectedBookId(int index, String newId) {
        String[] newBooks = getBookIds();
        if (index >= 0 && index < newBooks.length) {
            newBooks[index] = newId;
        }
        return new LoanReceipt(this.memberId, newBooks);
    }
}

class ReferenceOnlyLoanReceipt extends LoanReceipt {
    private final String roomNumber;

    public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds, String roomNumber) {
        super(memberId, bookIds);
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }
}

class CirculationLedger {
    static String branchCode;
    
    static {
        branchCode = "BR-MAIN-01";
    }

    public static String processNightlyCirculation(LoanReceipt[] receipts) {
        int processed = 0, nullSkipped = 0, referenceOnly = 0, regular = 0;
        for (LoanReceipt r : receipts) {
            if (r == null) {
                nullSkipped++;
            } else {
                processed++;
                if (r instanceof ReferenceOnlyLoanReceipt) {
                    referenceOnly++;
                } else {
                    regular++;
                }
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | " + referenceOnly + " reference-only | " + regular + " regular";
    }
}
