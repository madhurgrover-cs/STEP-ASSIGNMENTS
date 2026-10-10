// A2_ThreeTiersGymMembership.java
public class A2_ThreeTiersGymMembership {
    public static void main(String[] args) {
        GymMember gm = new GymMember("MEM1", 1000);
        PremiumMember pm = new PremiumMember("MEM2", 2000, "Coach Riya");
        EliteMember em = new EliteMember("MEM3", 3000, "Coach Arjun", "L12");
        GroupClassMember gcm = new GroupClassMember("MEM4", 1500, "Zumba");

        System.out.println(gm.displayInfo());
        System.out.println(pm.displayInfo());
        System.out.println(em.displayInfo());
        System.out.println(gcm.displayInfo());

        System.out.println(classifyGeneration(em));
        System.out.println(classifyGeneration(gcm));

        pm.attendSession();
        pm.attendSession();
        pm.attendSession();

        em.attendSession();
        em.attendSession();

        gcm.attendSession();
        gcm.attendSession();
        gcm.attendSession();
        gcm.attendSession();

        GymMember[] members = {pm, em, gcm};
        System.out.println("Total sessions attended: " + getTotalSessionsAttended(members));
    }

    public static String classifyGeneration(GymMember member) {
        if (member instanceof EliteMember) {
            return "Multilevel descendant (3 generations deep)";
        }
        if (member instanceof GroupClassMember) {
            return "Hierarchical sibling (independent branch)";
        }
        if (member instanceof PremiumMember) {
            return "Direct subclass";
        }
        return "Base class";
    }

    public static int getTotalSessionsAttended(GymMember[] members) {
        int total = 0;
        for (GymMember m : members) {
            total += m.getSessionsAttended();
        }
        return total;
    }
}

class GymMember {
    protected String memberId;
    protected int monthlyFee;
    protected int sessionsAttended;

    public GymMember(String memberId, int monthlyFee) {
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        this.sessionsAttended = 0;
    }

    public void attendSession() {
        this.sessionsAttended++;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }

    public String displayInfo() {
        return "Standard Member | Sessions: " + sessionsAttended;
    }
}

class PremiumMember extends GymMember {
    protected String trainerName;

    public PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    @Override
    public String displayInfo() {
        return "Premium Member | Trainer: " + trainerName + " | Sessions: " + sessionsAttended;
    }
}

class EliteMember extends PremiumMember {
    private String lockerNumber;

    public EliteMember(String memberId, int monthlyFee, String trainerName, String lockerNumber) {
        super(memberId, monthlyFee, trainerName);
        this.lockerNumber = lockerNumber;
    }

    @Override
    public String displayInfo() {
        return "Elite Member | Trainer: " + trainerName + " | Locker: " + lockerNumber + " | Sessions: " + sessionsAttended;
    }
}

class GroupClassMember extends GymMember {
    private String className;

    public GroupClassMember(String memberId, int monthlyFee, String className) {
        super(memberId, monthlyFee);
        this.className = className;
    }

    @Override
    public String displayInfo() {
        return "Group Class Member | Class: " + className + " | Sessions: " + sessionsAttended;
    }
}
