public class P5_ReverseCustomerName {
    public static void main(String[] args) {
        String name = "Sunil";
        String reversed = reverseCustomerName(name);
        
        System.out.println("Original: " + name + ", Reversed: " + reversed);
    }
    
    public static String reverseCustomerName(String customerName) {
        StringBuilder sb = new StringBuilder(customerName);
        return sb.reverse().toString();
    }
}
