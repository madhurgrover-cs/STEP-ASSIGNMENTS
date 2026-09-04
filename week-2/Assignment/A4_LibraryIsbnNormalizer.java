public class A4_LibraryIsbnNormalizer {
    // Method to normalize ISBN code string
    public static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() >= 3) {
            return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
        }
        return trimmed;
    }
    
    // Method to validate and format normalized ISBN code
    public static String validateAndFormat(String code) {
        String normalized = normalizeCode(code);
        
        // Validate length
        if (normalized.length() != 13) {
            return "Invalid: wrong length";
        }
        
        // Validate publisher code (first 3 chars)
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(normalized.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }
        
        // Validate numeric body
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(normalized.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }
        
        // Format valid code
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(normalized.substring(0, 3)).append("] YEAR: ")
          .append(normalized.substring(3, 7)).append(" | CATALOG: ")
          .append(normalized.substring(7));
          
        return sb.toString();
    }
    
    public static void main(String[] args) {
        // Sample test cases
        System.out.println(validateAndFormat("  pen2026004251  "));
        System.out.println(validateAndFormat("12N2026004251"));
    }
}
