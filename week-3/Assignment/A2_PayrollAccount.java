public class A2_PayrollAccount {
    private double basicSalary;
    private double bonus;

    public A2_PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Warning: Basic salary cannot be negative. Setting to 0.");
            this.basicSalary = 0;
        } else {
            this.basicSalary = basicSalary;
        }
    }

    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Bonus rejected: Amount must be positive.");
        } else {
            this.bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Tax rejection: Percentage must be between 0 and 100.");
        } else {
            this.basicSalary -= this.basicSalary * (percent / 100);
            System.out.println("Tax deducted: " + (int)percent + "%");
        }
    }

    public double getNetSalary() {
        return basicSalary + bonus;
    }

    public static void main(String[] args) {
        A2_PayrollAccount account = new A2_PayrollAccount(50000.0);
        account.creditBonus(5000.0);
        account.deductTax(10.0);
        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}
