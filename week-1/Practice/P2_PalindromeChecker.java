public class P2_PalindromeChecker {
    public static void main(String[] args) {
        String test1 = "madam";
        String test2 = "hello";
        
        System.out.println("Input: " + test1);
        System.out.println("Iterative: " + (isPalindromeIterative(test1) ? "Palindrome" : "Not Palindrome"));
        System.out.println("Recursive: " + (isPalindromeRecursive(test1) ? "Palindrome" : "Not Palindrome"));
        System.out.println("Array Reversal: " + (isPalindromeArrayReversal(test1) ? "Palindrome" : "Not Palindrome"));
        
        System.out.println("\nInput: " + test2);
        System.out.println("Iterative: " + (isPalindromeIterative(test2) ? "Palindrome" : "Not Palindrome"));
        System.out.println("Recursive: " + (isPalindromeRecursive(test2) ? "Palindrome" : "Not Palindrome"));
        System.out.println("Array Reversal: " + (isPalindromeArrayReversal(test2) ? "Palindrome" : "Not Palindrome"));
    }
    
    public static boolean isPalindromeIterative(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    
    public static boolean isPalindromeRecursive(String str) {
        if (str.length() <= 1) return true;
        if (str.charAt(0) != str.charAt(str.length() - 1)) return false;
        return isPalindromeRecursive(str.substring(1, str.length() - 1));
    }
    
    public static boolean isPalindromeArrayReversal(String str) {
        char[] arr = str.toCharArray();
        char[] reversed = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return new String(arr).equals(new String(reversed));
    }
}
