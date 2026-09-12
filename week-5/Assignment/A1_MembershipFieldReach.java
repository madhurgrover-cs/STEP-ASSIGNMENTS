// A1_MembershipFieldReach.java
public class A1_MembershipFieldReach {
    public static void main(String[] args) {
        String[][] attempts = {
            {"private", "SAME_CLASS"},
            {"private", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"public", "DIFFERENT_PACKAGE"}
        };
        System.out.println(AccessChecker.summarizeByModifier(attempts));
    }
}

class AccessChecker {
    static String classifyAccess(String fieldModifier, String accessorContext) {
        if ("public".equals(fieldModifier)) return "ALLOWED";
        if ("private".equals(fieldModifier)) {
            return "SAME_CLASS".equals(accessorContext) ? "ALLOWED" : "DENIED";
        }
        if ("protected".equals(fieldModifier) || "default".equals(fieldModifier)) {
            return ("SAME_CLASS".equals(accessorContext) || "SAME_PACKAGE".equals(accessorContext)) ? "ALLOWED" : "DENIED";
        }
        return "DENIED";
    }

    static String summarizeByModifier(String[][] attempts) {
        int privA = 0, privD = 0, defA = 0, defD = 0, proA = 0, proD = 0, pubA = 0, pubD = 0;
        for (String[] a : attempts) {
            String res = classifyAccess(a[0], a[1]);
            if ("private".equals(a[0])) { if ("ALLOWED".equals(res)) privA++; else privD++; }
            if ("default".equals(a[0])) { if ("ALLOWED".equals(res)) defA++; else defD++; }
            if ("protected".equals(a[0])) { if ("ALLOWED".equals(res)) proA++; else proD++; }
            if ("public".equals(a[0])) { if ("ALLOWED".equals(res)) pubA++; else pubD++; }
        }
        return "private: " + privA + " allowed / " + privD + " denied | " +
               "default: " + defA + " allowed / " + defD + " denied | " +
               "protected: " + proA + " allowed / " + proD + " denied | " +
               "public: " + pubA + " allowed / " + pubD + " denied";
    }
}

class LibraryMember {
    private int membershipPin;
    String branchCode;
    protected double finesOwed;
    public String displayName;
}
