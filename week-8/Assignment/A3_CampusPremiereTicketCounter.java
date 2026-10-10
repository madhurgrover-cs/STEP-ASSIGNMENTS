// A3_CampusPremiereTicketCounter.java
import java.util.*;

public class A3_CampusPremiereTicketCounter {
    public static void main(String[] args) {
        Customer asha = new Customer("Asha");
        Customer ravi = new Customer("Ravi");
        Customer neha = new Customer("Neha");

        Show show7PM = new Show("7 PM show");

        Seat a1 = new RegularSeat("A1");
        Seat a2 = new RegularSeat("A2");
        Seat f5 = new PremiumSeat("F5");
        Seat r1 = new ReclinerSeat("R1");

        // 1. Asha books A1, A2, F5
        Booking bAsha = show7PM.bookSeats(asha, Arrays.asList(a1, a2, f5));

        // 2. Ravi attempts to book A2
        show7PM.bookSeats(ravi, Collections.singletonList(a2));

        // 3. Ravi books R1
        Booking bRavi = show7PM.bookSeats(ravi, Collections.singletonList(r1));

        // 4. Asha cancels booking before show starts
        show7PM.cancelBooking(bAsha);

        // 5. Neha books A2
        show7PM.bookSeats(neha, Collections.singletonList(a2));
    }
}

abstract class Seat {
    protected String seatNumber;

    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatNumber() { return seatNumber; }
    public abstract double getPrice();
}

class RegularSeat extends Seat {
    public RegularSeat(String seatNumber) { super(seatNumber); }
    @Override public double getPrice() { return 150.0; }
}

class PremiumSeat extends Seat {
    public PremiumSeat(String seatNumber) { super(seatNumber); }
    @Override public double getPrice() { return 250.0; }
}

class ReclinerSeat extends Seat {
    public ReclinerSeat(String seatNumber) { super(seatNumber); }
    @Override public double getPrice() { return 400.0; }
}

class Customer {
    private String name;
    public Customer(String name) { this.name = name; }
    public String getName() { return name; }
}

class Show {
    private String showTime;
    private Set<String> bookedSeatIds;

    public Show(String showTime) {
        this.showTime = showTime;
        this.bookedSeatIds = new HashSet<>();
    }

    public Booking bookSeats(Customer customer, List<Seat> seats) {
        if (seats == null || seats.isEmpty() || seats.size() > 6) {
            return null;
        }

        // Check availability
        for (Seat s : seats) {
            if (bookedSeatIds.contains(s.getSeatNumber())) {
                System.out.printf("Seat %s is already booked for this show.%n", s.getSeatNumber());
                return null;
            }
        }

        // Book seats
        double total = 0;
        List<String> names = new ArrayList<>();
        for (Seat s : seats) {
            bookedSeatIds.add(s.getSeatNumber());
            total += s.getPrice();
            names.add(s.getSeatNumber());
        }

        System.out.printf("Booking confirmed for %s: %s. Total: \u20B9%.2f.%n",
                customer.getName(), String.join(", ", names), total);

        return new Booking(customer, this, seats, total);
    }

    public void cancelBooking(Booking booking) {
        if (booking == null) return;
        List<String> names = new ArrayList<>();
        for (Seat s : booking.getSeats()) {
            bookedSeatIds.remove(s.getSeatNumber());
            names.add(s.getSeatNumber());
        }
        System.out.printf("%s's booking cancelled. Seats %s released.%n",
                booking.getCustomer().getName(), String.join(", ", names));
    }
}

class Booking {
    private Customer customer;
    private Show show;
    private List<Seat> seats;
    private double totalAmount;

    public Booking(Customer customer, Show show, List<Seat> seats, double totalAmount) {
        this.customer = customer;
        this.show = show;
        this.seats = seats;
        this.totalAmount = totalAmount;
    }

    public Customer getCustomer() { return customer; }
    public List<Seat> getSeats() { return seats; }
    public double getTotalAmount() { return totalAmount; }
}
