// A3_PremiumLoyaltyLateFeeLedger.java
import java.util.Arrays;

public class A3_PremiumLoyaltyLateFeeLedger {
    public static void main(String[] args) {
        PremiumMember p = new PremiumMember("MEM5", 2000, "Coach Riya");
        p.chargeLateFee(200);
        System.out.println("Total late fees: " + p.getTotalLateFees());

        int[] history = p.getLateFeeHistory();
        System.out.println("History before tampering: " + Arrays.toString(history));
        history[0] = 999;
        System.out.println("History after tampering returned array: " + Arrays.toString(p.getLateFeeHistory()));
    }
}

class GymMember {
    protected String memberId;
    protected int monthlyFee;
    private int[] lateFeeHistory;
    private int feeCount;
    private int totalLateFees;

    public GymMember(String memberId, int monthlyFee) {
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        this.lateFeeHistory = new int[10];
        this.feeCount = 0;
        this.totalLateFees = 0;
    }

    protected void chargeLateFee(int amount) {
        if (feeCount < lateFeeHistory.length) {
            lateFeeHistory[feeCount++] = amount;
        }
        totalLateFees += amount;
    }

    public int[] getLateFeeHistory() {
        return Arrays.copyOf(lateFeeHistory, feeCount);
    }

    public int getTotalLateFees() {
        return totalLateFees;
    }
}

class PremiumMember extends GymMember {
    private String trainerName;

    public PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    @Override
    protected void chargeLateFee(int amount) {
        super.chargeLateFee(amount / 2);
    }

    public String getTrainerName() {
        return trainerName;
    }
}
