// P3_SeatBookingGuard.java
public class P3_SeatBookingGuard {
    public static void main(String[] args) {
        CineScreen screen = new CineScreen(10);
        screen.bookSeat();
        System.out.println("Available: " + screen.getSeatsAvailable());
        screen.cancelBooking();
        System.out.println("Available: " + screen.getSeatsAvailable());
    }
}

class CineScreen {
    private int seatsTotal;
    private int seatsAvailable;

    public CineScreen(int seatsTotal) {
        if (seatsTotal <= 0) {
            System.out.println("construction rejected");
        } else {
            this.seatsTotal = seatsTotal;
            this.seatsAvailable = seatsTotal;
        }
    }

    public void bookSeat() {
        if (seatsAvailable > 0) {
            seatsAvailable--;
        }
    }

    public void cancelBooking() {
        if (seatsAvailable < seatsTotal) {
            seatsAvailable++;
        }
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }
}
