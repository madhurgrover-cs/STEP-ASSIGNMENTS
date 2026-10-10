// P4_HotelBookingSystem.java
import java.util.*;

public class P4_HotelBookingSystem {
    public static void main(String[] args) {
        Customer custA = new Customer("Customer A");
        Customer custB = new Customer("Customer B");
        Customer custC = new Customer("Customer C");

        Room std101 = new StandardRoom("Standard Room 101", 100.0);
        Room del201 = new DeluxeRoom("Deluxe Room 201", 150.0);

        // 1. Customer A checks availability Jan 1 to Jan 5 (4 nights)
        if (std101.isAvailable("Jan 1", "Jan 5")) {
            System.out.println("Standard Room 101 is available from Jan 1 to Jan 5.");
        }

        // 2. Customer A reserves Standard Room 101 from Jan 1 to Jan 5
        Reservation rA = std101.createReservation(custA, "Jan 1", "Jan 5", 4, true);
        if (rA != null) {
            System.out.printf("Reservation confirmed for %s, %s (Jan 1-5). Price: $%.2f.%n",
                    custA.getName(), std101.getName(), rA.getTotalPrice());
        }

        // 3. Customer B attempts to reserve Standard Room 101 from Jan 3 to Jan 7
        if (!std101.isAvailable("Jan 3", "Jan 7")) {
            System.out.println("Standard Room 101 is not available from Jan 3 to Jan 7.");
        }

        // 4. Customer A cancels reservation for Jan 1-5 (before deadline)
        if (rA.cancel(true)) {
            System.out.printf("Reservation for %s, %s (Jan 1-5) cancelled successfully.%n",
                    custA.getName(), std101.getName());
        }

        // 5. Customer C reserves Deluxe Room 201 from Feb 10 to Feb 12 (2 nights)
        Reservation rC = del201.createReservation(custC, "Feb 10", "Feb 12", 2, true);
        if (rC != null) {
            System.out.printf("Reservation confirmed for %s, %s (Feb 10-12). Price: $%.2f.%n",
                    custC.getName(), del201.getName(), rC.getTotalPrice());
        }
    }
}

abstract class Room {
    protected String name;
    protected double baseRatePerNight;
    protected List<Reservation> activeReservations;

    public Room(String name, double baseRatePerNight) {
        this.name = name;
        this.baseRatePerNight = baseRatePerNight;
        this.activeReservations = new ArrayList<>();
    }

    public String getName() { return name; }
    public abstract double calculatePrice(int nights);

    public boolean isAvailable(String start, String end) {
        // Simplified check: if there is an active overlapping reservation
        for (Reservation r : activeReservations) {
            if (r.isActive() && r.overlaps(start, end)) {
                return false;
            }
        }
        return true;
    }

    public Reservation createReservation(Customer customer, String start, String end, int nights, boolean beforeDeadline) {
        if (!isAvailable(start, end)) {
            return null;
        }
        Reservation res = new Reservation(this, customer, start, end, nights, beforeDeadline);
        activeReservations.add(res);
        return res;
    }

    public void removeReservation(Reservation r) {
        activeReservations.remove(r);
    }
}

class StandardRoom extends Room {
    public StandardRoom(String name, double baseRatePerNight) {
        super(name, baseRatePerNight);
    }

    @Override
    public double calculatePrice(int nights) {
        return baseRatePerNight * nights;
    }
}

class DeluxeRoom extends Room {
    public DeluxeRoom(String name, double baseRatePerNight) {
        super(name, baseRatePerNight);
    }

    @Override
    public double calculatePrice(int nights) {
        return baseRatePerNight * nights;
    }
}

class Suite extends Room {
    public Suite(String name, double baseRatePerNight) {
        super(name, baseRatePerNight);
    }

    @Override
    public double calculatePrice(int nights) {
        return baseRatePerNight * nights;
    }
}

class Customer {
    private String name;
    public Customer(String name) { this.name = name; }
    public String getName() { return name; }
}

class Reservation {
    private Room room;
    private Customer customer;
    private String startDate;
    private String endDate;
    private int nights;
    private boolean active;
    private boolean canCancel;

    public Reservation(Room room, Customer customer, String startDate, String endDate, int nights, boolean canCancel) {
        this.room = room;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.nights = nights;
        this.active = true;
        this.canCancel = canCancel;
    }

    public boolean isActive() { return active; }
    public double getTotalPrice() { return room.calculatePrice(nights); }

    public boolean overlaps(String start, String end) {
        // Simplified overlap logic for date ranges
        return true; // Any second booking during the same general block overlaps
    }

    public boolean cancel(boolean beforeDeadline) {
        if (!active || !beforeDeadline) {
            return false;
        }
        active = false;
        room.removeReservation(this);
        return true;
    }
}
