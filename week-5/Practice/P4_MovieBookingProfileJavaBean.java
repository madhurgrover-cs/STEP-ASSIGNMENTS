// P4_MovieBookingProfileJavaBean.java
public class P4_MovieBookingProfileJavaBean {
    public static void main(String[] args) {
        MovieBookingProfile profile = new MovieBookingProfile("John Doe");
        profile.setConfirmed(true);
        profile.setOtp("1234");
        System.out.println(profile.getName() + ", Confirmed: " + profile.isConfirmed());
    }
}

class MovieBookingProfile {
    private String name;
    private boolean confirmed;
    private String otpHash;

    public MovieBookingProfile() {
    }

    public MovieBookingProfile(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public void setOtp(String otp) {
        this.otpHash = otp + "_hash";
    }
}
