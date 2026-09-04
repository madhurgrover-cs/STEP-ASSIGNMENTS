public class P2_CSVStudentRecordParser {
    // Method to parse a CSV string for student record
    public static void parseStudentRecord(String csvLine) {
        // Split the CSV string by comma
        String[] fields = csvLine.split(",");
        
        // Validate if exactly 3 fields exist
        if (fields.length == 3) {
            System.out.println("Name: " + fields[0] + " | Roll No: " + fields[1] + " | Dept: " + fields[2]);
        } else {
            System.out.println("Invalid Record");
        }
    }
    
    public static void main(String[] args) {
        // Sample test cases
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");
        parseStudentRecord("Ananya Verma,CSE");
    }
}
