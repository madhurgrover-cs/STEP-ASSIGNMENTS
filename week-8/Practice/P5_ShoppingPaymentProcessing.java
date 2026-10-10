// P5_ShoppingPaymentProcessing.java
import java.util.*;

public class P5_ShoppingPaymentProcessing {
    public static void main(String[] args) {
        Customer custX = new Customer("Customer X");
        Customer custY = new Customer("Customer Y");
        Customer custZ = new Customer("Customer Z");

        Product prodA = new Product("Product A", 20.0);
        Product prodB = new Product("Product B", 30.0);
        Product prodC = new Product("Product C", 50.0);

        // 1. Customer X creates order with Product A (qty 2) and Product B (qty 1)
        Order orderX = new Order("Order X", custX);
        orderX.addProduct(prodA, 2);
        orderX.addProduct(prodB, 1);
        System.out.printf("Order created for %s.%n", custX.getName());

        PaymentMethod cc = new CreditCardPayment(true);
        orderX.processPayment(cc, "Credit Card");

        // 2. Customer Y creates an empty order and attempts payment
        Order orderY = new Order("Order Y", custY);
        orderY.processPayment(cc, "Credit Card");

        // 3. Customer Z creates order with Product C (qty 1) and PayPal fails
        Order orderZ = new Order("Order Z", custZ);
        orderZ.addProduct(prodC, 1);
        System.out.printf("Order created for %s.%n", custZ.getName());

        PaymentMethod paypal = new PayPalPayment(false); // configured to fail
        orderZ.processPayment(paypal, "PayPal");
    }
}

enum OrderStatus {
    Pending, Paid
}

interface PaymentMethod {
    boolean processPayment(double amount);
}

class CreditCardPayment implements PaymentMethod {
    private boolean shouldSucceed;
    public CreditCardPayment(boolean shouldSucceed) { this.shouldSucceed = shouldSucceed; }
    @Override public boolean processPayment(double amount) { return shouldSucceed; }
}

class PayPalPayment implements PaymentMethod {
    private boolean shouldSucceed;
    public PayPalPayment(boolean shouldSucceed) { this.shouldSucceed = shouldSucceed; }
    @Override public boolean processPayment(double amount) { return shouldSucceed; }
}

class BankTransferPayment implements PaymentMethod {
    private boolean shouldSucceed;
    public BankTransferPayment(boolean shouldSucceed) { this.shouldSucceed = shouldSucceed; }
    @Override public boolean processPayment(double amount) { return shouldSucceed; }
}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
}

class Customer {
    private String name;
    public Customer(String name) { this.name = name; }
    public String getName() { return name; }
}

class Order {
    private String orderId;
    private Customer customer;
    private Map<Product, Integer> items;
    private OrderStatus status;

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = new HashMap<>();
        this.status = OrderStatus.Pending;
    }

    public void addProduct(Product p, int qty) {
        items.put(p, items.getOrDefault(p, 0) + qty);
    }

    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public boolean processPayment(PaymentMethod method, String methodName) {
        if (items.isEmpty()) {
            System.out.println("Cannot process payment for an empty order.");
            return false;
        }

        System.out.printf("Payment initiated via %s for %s.%n", methodName, orderId);
        boolean success = method.processPayment(calculateTotal());
        if (success) {
            status = OrderStatus.Paid;
            System.out.printf("Payment for %s successful. Order status: %s.%n", orderId, status);
            return true;
        } else {
            System.out.printf("Payment for %s failed. Order status: %s.%n", orderId, status);
            return false;
        }
    }
}
