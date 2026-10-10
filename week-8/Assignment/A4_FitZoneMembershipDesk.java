// A4_FitZoneMembershipDesk.java
public class A4_FitZoneMembershipDesk {
    public static void main(String[] args) {
        Member asha = new Member("Asha");
        Member ravi = new Member("Ravi");

        MembershipPlan quarterly = new QuarterlyPlan();
        MembershipPlan monthly = new MonthlyPlan();

        // 1. Asha buys Quarterly membership
        Membership memAsha = new Membership(asha, quarterly);
        System.out.printf("Quarterly membership created for %s. Fee: \u20B9%.2f. Status: %s.%n",
                asha.getName(), memAsha.getFee(), memAsha.getStatus());

        // 2. Ravi buys Monthly membership
        Membership memRavi = new Membership(ravi, monthly);
        System.out.printf("Monthly membership created for %s. Fee: \u20B9%.2f. Status: %s.%n",
                ravi.getName(), memRavi.getFee(), memRavi.getStatus());

        // 3. Asha checks in
        memAsha.checkIn();

        // 4. Asha freezes her membership
        memAsha.freeze();

        // 5. Asha attempts to check in
        memAsha.checkIn();

        // 6. Ravi's membership expires
        memRavi.expire();

        // 7. Ravi attempts to freeze his membership
        memRavi.freeze();
    }
}

enum GymStatus {
    Active, Frozen, Expired
}

interface MembershipPlan {
    String getName();
    double calculateFee();
}

class MonthlyPlan implements MembershipPlan {
    public String getName() { return "Monthly"; }
    public double calculateFee() { return 1000.0; }
}

class QuarterlyPlan implements MembershipPlan {
    public String getName() { return "Quarterly"; }
    public double calculateFee() { return 3 * 1000.0 * 0.90; } // 10% off
}

class AnnualPlan implements MembershipPlan {
    public String getName() { return "Annual"; }
    public double calculateFee() { return 12 * 1000.0 * 0.75; } // 25% off
}

class Member {
    private String name;
    public Member(String name) { this.name = name; }
    public String getName() { return name; }
}

class Membership {
    private Member member;
    private MembershipPlan plan;
    private GymStatus status;
    private double fee;

    public Membership(Member member, MembershipPlan plan) {
        this.member = member;
        this.plan = plan;
        this.fee = plan.calculateFee();
        this.status = GymStatus.Active;
    }

    public GymStatus getStatus() { return status; }
    public double getFee() { return fee; }

    public boolean checkIn() {
        if (status == GymStatus.Active) {
            System.out.printf("%s checked in successfully.%n", member.getName());
            return true;
        } else {
            System.out.printf("Check-in denied: %s's membership is %s.%n", member.getName(), status);
            return false;
        }
    }

    public boolean freeze() {
        if (status == GymStatus.Expired) {
            System.out.println("Cannot freeze an Expired membership.");
            return false;
        }
        if (status == GymStatus.Active) {
            status = GymStatus.Frozen;
            System.out.printf("%s's membership frozen. Status: %s.%n", member.getName(), status);
            return true;
        }
        return false;
    }

    public boolean unfreeze() {
        if (status == GymStatus.Frozen) {
            status = GymStatus.Active;
            return true;
        }
        return false;
    }

    public void expire() {
        status = GymStatus.Expired;
        System.out.printf("%s's membership expired. Status: %s.%n", member.getName(), status);
    }
}
