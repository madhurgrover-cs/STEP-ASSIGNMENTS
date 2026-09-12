// A2_ReferenceDeskSubclassReach.java
public class A2_ReferenceDeskSubclassReach {
    public static void main(String[] args) {
        String[][] attempts = {
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"}
        };
        System.out.println(AccessChecker.firstDeniedAttempt(attempts));
    }
}

class AccessChecker {
    static String classifyAccess(String fieldModifier, String accessorContext) {
        if ("public".equals(fieldModifier)) return "ALLOWED";
        if ("private".equals(fieldModifier) || "default".equals(fieldModifier)) {
            if (accessorContext.startsWith("SUBCLASS_DIFFERENT_PACKAGE")) return "DENIED";
            if ("SAME_CLASS".equals(accessorContext)) return "ALLOWED";
            if ("default".equals(fieldModifier) && "SAME_PACKAGE".equals(accessorContext)) return "ALLOWED";
            return "DENIED";
        }
        if ("protected".equals(fieldModifier)) {
            if ("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE".equals(accessorContext)) return "ALLOWED";
            if ("SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE".equals(accessorContext)) return "DENIED";
            if ("SAME_CLASS".equals(accessorContext) || "SAME_PACKAGE".equals(accessorContext)) return "ALLOWED";
            return "DENIED";
        }
        return "DENIED";
    }

    static String firstDeniedAttempt(String[][] attempts) {
        for (int i = 0; i < attempts.length; i++) {
            if ("DENIED".equals(classifyAccess(attempts[i][0], attempts[i][1]))) {
                return attempts[i][0] + " via " + attempts[i][1] + " (attempt #" + (i + 1) + ")";
            }
        }
        return "None Denied";
    }
}
