// P2_SubclassTicketAccess.java
public class P2_SubclassTicketAccess {
    public static void main(String[] args) {
        System.out.println(AccessChecker.classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));
        System.out.println(AccessChecker.classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));
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
}

class MovieTicket {
}
class PremiumMovieTicket extends MovieTicket {
}
