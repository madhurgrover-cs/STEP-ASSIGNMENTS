// A5_GymMembershipSettlement.java
import java.util.ArrayList;
import java.util.List;

public class A5_GymMembershipSettlement {
    public static void main(String[] args) {
        GymMember m1 = new GymMember(1000);
        System.out.println("Membership Number: " + m1.membershipNumber);
        System.out.println("Members Enrolled: " + GymMember.getMembersEnrolled());

        System.out.println("isValidReferralCode(\"G45B\"): " + isValidReferralCode("G45B"));
        System.out.println("isValidReferralCode(\"G4B\"): " + isValidReferralCode("G4B"));
        System.out.println("isValidReferralCode(\"X45B\"): " + isValidReferralCode("X45B"));

        m1.payFee(500);
        m1.payFee(500, "UPI");
        System.out.println("Total fees paid: " + m1.getFeesPaid());

        GymMember[] batch = {
            new GroupClassMember(1500, "Zumba"),
            null,
            new GymMember(1000)
        };
        System.out.println(processWeeklyCheckIn(batch));
    }

    public static boolean isValidReferralCode(String code) {
        if (code == null || code.length() != 4) {
            return false;
        }
        if (code.charAt(0) != 'G') {
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

    public static String processWeeklyCheckIn(GymMember[] members) {
        if (members == null) return "0 processed | 0 null skipped | 0 group | 0 individual";
        int processed = 0;
        int nullSkipped = 0;
        int group = 0;
        int individual = 0;

        for (GymMember m : members) {
            if (m == null) {
                nullSkipped++;
            } else {
                processed++;
                if (m instanceof GroupClassMember) {
                    group++;
                } else {
                    individual++;
                }
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | " + group + " group | " + individual + " individual";
    }
}

class GymMember {
    private static int counter = 2000;
    private static int membersEnrolled = 0;

    public final String membershipNumber;
    protected int monthlyFee;
    protected int feesPaid;
    protected List<String> paymentModes;

    public GymMember(int monthlyFee) {
        this.membershipNumber = "GYM-" + (++counter);
        membersEnrolled++;
        this.monthlyFee = monthlyFee;
        this.feesPaid = 0;
        this.paymentModes = new ArrayList<>();
    }

    public void payFee(int amount) {
        this.feesPaid += amount;
    }

    public void payFee(int amount, String mode) {
        this.paymentModes.add(mode);
        payFee(amount);
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public static int getMembersEnrolled() {
        return membersEnrolled;
    }
}

class GroupClassMember extends GymMember {
    private String className;

    public GroupClassMember(int monthlyFee, String className) {
        super(monthlyFee);
        this.className = className;
    }

    public String getClassName() {
        return className;
    }
}
