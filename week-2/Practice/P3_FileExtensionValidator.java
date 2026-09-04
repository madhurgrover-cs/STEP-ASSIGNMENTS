public class P3_FileExtensionValidator {
    // Method to validate if a file has an accepted extension
    public static String validateFileExtension(String filename) {
        // Find the last dot in the filename
        int dotIndex = filename.lastIndexOf('.');
        
        // Check if dot exists and is not the last character
        if (dotIndex != -1 && dotIndex < filename.length() - 1) {
            // Get the substring after the last dot
            String ext = filename.substring(dotIndex + 1);
            
            // Check if the extension is accepted
            if (ext.equalsIgnoreCase("pdf") || ext.equalsIgnoreCase("docx") || ext.equalsIgnoreCase("zip")) {
                return "Accepted";
            }
        }
        
        return "Rejected — invalid file type";
    }
    
    public static void main(String[] args) {
        // Sample test cases
        System.out.println(validateFileExtension("Assignment1.PDF"));
        System.out.println(validateFileExtension("notes.txt"));
    }
}
