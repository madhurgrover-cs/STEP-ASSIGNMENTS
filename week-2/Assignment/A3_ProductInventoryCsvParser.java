public class A3_ProductInventoryCsvParser {
    // Method to parse a CSV string for inventory record
    public static void parseInventoryRecord(String csvLine) {
        // Split the CSV string by comma
        String[] fields = csvLine.split(",");
        
        // Validate if exactly 3 fields exist
        if (fields.length == 3) {
            System.out.println("Product: " + fields[0] + " | SKU: " + fields[1] + " | Qty: " + fields[2]);
        } else {
            System.out.println("Invalid Record");
        }
    }
    
    public static void main(String[] args) {
        // Sample test cases
        parseInventoryRecord("Wireless Mouse,WM-2201,150");
        parseInventoryRecord("Wireless Mouse,150");
    }
}
