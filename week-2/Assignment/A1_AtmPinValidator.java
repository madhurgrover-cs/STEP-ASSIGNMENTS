public class A1_AtmPinValidator {
    // Method to validate ATM PIN length
    public static void checkPinLength(String pin) {
        if (pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }
    
    public static void main(String[] args) {
        // Sample test cases
        checkPinLength("482");
        checkPinLength("4820");
    }
}
