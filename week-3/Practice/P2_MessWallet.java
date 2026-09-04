public class P2_MessWallet {
    private double balance;

    public P2_MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            System.out.println("Warning: Opening balance cannot be negative. Setting to 0.");
            this.balance = 0;
        } else {
            this.balance = openingBalance;
        }
    }

    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: Amount must be positive.");
        } else {
            this.balance += amount;
        }
    }

    public void deduct(double amount) {
        if (amount > this.balance) {
            System.out.println("Deduct rejected: insufficient balance");
        } else {
            this.balance -= amount;
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public static void main(String[] args) {
        P2_MessWallet wallet = new P2_MessWallet(500.0);
        wallet.topUp(200.0);
        System.out.println("Balance after top-up: " + wallet.getBalance());
        wallet.deduct(800.0);
        System.out.println("Final balance: " + wallet.getBalance());
    }
}
