// A3_BookCirculationGuard.java
public class A3_BookCirculationGuard {
    public static void main(String[] args) {
        BookInventory inventory = new BookInventory(5);
        inventory.checkOut();
        System.out.println("Available: " + inventory.getCopiesAvailable());
        inventory.checkIn();
        System.out.println("Available: " + inventory.getCopiesAvailable());
    }
}

class BookInventory {
    private int copiesTotal;
    private int copiesAvailable;

    public BookInventory(int copiesTotal) {
        if (copiesTotal <= 0) {
            System.out.println("construction rejected");
        } else {
            this.copiesTotal = copiesTotal;
            this.copiesAvailable = copiesTotal;
        }
    }

    public void checkOut() {
        if (copiesAvailable > 0) {
            copiesAvailable--;
        }
    }

    public void checkIn() {
        if (copiesAvailable < copiesTotal) {
            copiesAvailable++;
        }
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }
}
