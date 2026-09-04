public class P4_MaskedPhoneNumberFormatter {
    // Method to mask phone number
    public static String maskPhoneNumber(String phone) {
        // Validate phone number length
        if (phone.length() != 10) {
            return "Invalid phone number";
        }
        
        // Validate all characters are digits
        for (int i = 0; i < 10; i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }
        
        // Construct the masked string
        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX").append(" -").append(phone.substring(6));
        return sb.toString();
    }
    
    public static void main(String[] args) {
        // Sample test cases
        System.out.println(maskPhoneNumber("9876543210"));
        System.out.println(maskPhoneNumber("98765"));
    }
}
