// A4_LibraryMemberJavaBean.java
public class A4_LibraryMemberJavaBean {
    public static void main(String[] args) {
        LibraryMember member = new LibraryMember();
        member.setMembershipId("M001");
        member.setMembershipId("M002"); // Should be ignored
        member.setName("Alice");
        member.setPremiumMember(true);
        member.setSecurityAnswer("secret");
        
        System.out.println("ID: " + member.getMembershipId());
        System.out.println("Name: " + member.getName());
        System.out.println("Premium: " + member.isPremiumMember());
    }
}

class LibraryMember {
    private String membershipId;
    private boolean idSet = false;
    private String name;
    private boolean premiumMember;
    private String securityAnswer;

    public LibraryMember() {}

    public void setMembershipId(String id) {
        if (!idSet) {
            this.membershipId = id;
            this.idSet = true;
        }
    }

    public String getMembershipId() {
        return membershipId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPremiumMember() {
        return premiumMember;
    }

    public void setPremiumMember(boolean premiumMember) {
        this.premiumMember = premiumMember;
    }

    public void setSecurityAnswer(String answer) {
        this.securityAnswer = answer;
    }
}
