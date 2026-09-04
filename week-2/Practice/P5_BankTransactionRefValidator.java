public class P5_BankTransactionRefValidator {
    // Method to normalize reference string
    public static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() >= 3) {
            return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
        }
        return trimmed;
    }
    
    // Method to validate and format normalized reference
    public static String validateAndFormat(String reference) {
        String normalized = normalizeReference(reference);
        
        // Validate length
        if (normalized.length() != 14) {
            return "Invalid: wrong length";
        }
        
        // Validate bank code (first 3 chars)
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(normalized.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        
        // Validate numeric body
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(normalized.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }
        
        // Format valid reference
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(normalized.substring(0, 3)).append("] DATE: ")
          .append(normalized.substring(3, 5)).append("/")
          .append(normalized.substring(5, 7)).append("/")
          .append(normalized.substring(7, 9)).append(" | SEQ: ")
          .append(normalized.substring(9));
          
        return sb.toString();
    }
    
    public static void main(String[] args) {
        // Sample test cases
        System.out.println(validateAndFormat("  hdf03022600042  "));
        System.out.println(validateAndFormat("12F03022600042"));
    }
}
