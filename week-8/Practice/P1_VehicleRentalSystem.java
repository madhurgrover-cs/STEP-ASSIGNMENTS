// P1_VehicleRentalSystem.java
public class P1_VehicleRentalSystem {
    public static void main(String[] args) {
        Customer c1 = new Customer("Customer 1");
        Customer c2 = new Customer("Customer 2");
        Customer c3 = new Customer("Customer 3");

        Vehicle sedanA = new Sedan("Sedan A", 50.0);
        Vehicle suvB = new SUV("SUV B", 80.0);

        // 1. Customer 1 rents Sedan A for 3 days
        Rental r1 = sedanA.rent(c1, 3);
        if (r1 != null) {
            System.out.printf("%s rented successfully by %s. Rental charge: $%.2f.%n",
                    sedanA.getName(), c1.getName(), r1.calculateTotalCharge());
        }

        // 2. Customer 2 attempts to rent Sedan A for 2 days
        Rental r2 = sedanA.rent(c2, 2);
        if (r2 == null) {
            System.out.printf("%s is currently unavailable.%n", sedanA.getName());
        }

        // 3. Customer 1 returns Sedan A
        sedanA.returnVehicle(c1);
        System.out.printf("%s returned by %s.%n", sedanA.getName(), c1.getName());

        // 4. Customer 3 rents SUV B for 5 days
        Rental r3 = suvB.rent(c3, 5);
        if (r3 != null) {
            System.out.printf("%s rented successfully by %s. Rental charge: $%.2f.%n",
                    suvB.getName(), c3.getName(), r3.calculateTotalCharge());
        }
    }
}

abstract class Vehicle {
    protected String name;
    protected double dailyRate;
    protected boolean isAvailable;
    protected Rental activeRental;

    public Vehicle(String name, double dailyRate) {
        this.name = name;
        this.dailyRate = dailyRate;
        this.isAvailable = true;
        this.activeRental = null;
    }

    public String getName() { return name; }
    public double getDailyRate() { return dailyRate; }
    public boolean isAvailable() { return isAvailable; }

    public abstract double calculateCharge(int days);

    public Rental rent(Customer customer, int days) {
        if (!isAvailable) {
            return null;
        }
        isAvailable = false;
        activeRental = new Rental(this, customer, days);
        return activeRental;
    }

    public boolean returnVehicle(Customer customer) {
        if (!isAvailable && activeRental != null && activeRental.getCustomer().equals(customer)) {
            isAvailable = true;
            activeRental = null;
            return true;
        }
        return false;
    }
}

class Sedan extends Vehicle {
    public Sedan(String name, double dailyRate) {
        super(name, dailyRate);
    }

    @Override
    public double calculateCharge(int days) {
        return dailyRate * days;
    }
}

class SUV extends Vehicle {
    public SUV(String name, double dailyRate) {
        super(name, dailyRate);
    }

    @Override
    public double calculateCharge(int days) {
        return dailyRate * days;
    }
}

class Truck extends Vehicle {
    public Truck(String name, double dailyRate) {
        super(name, dailyRate);
    }

    @Override
    public double calculateCharge(int days) {
        return dailyRate * days;
    }
}

class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return name.equals(customer.name);
    }
}

class Rental {
    private Vehicle vehicle;
    private Customer customer;
    private int durationDays;

    public Rental(Vehicle vehicle, Customer customer, int durationDays) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.durationDays = durationDays;
    }

    public Vehicle getVehicle() { return vehicle; }
    public Customer getCustomer() { return customer; }
    public int getDurationDays() { return durationDays; }

    public double calculateTotalCharge() {
        return vehicle.calculateCharge(durationDays);
    }
}
