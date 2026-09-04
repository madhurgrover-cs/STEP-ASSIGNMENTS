public class A4_WarehouseInventory {
    public static void main(String[] args) {
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};
        
        System.out.print("A={20,15,30}, B={25,10,30} -> ");
        analyzeInventory(sectionA, sectionB);
    }
    
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0;
        int maxVal = -1;
        String maxSection = "";
        int maxIndex = -1;
        
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > maxVal) {
                maxVal = sectionA[i];
                maxSection = "Section A";
                maxIndex = i + 1; // 1-based index
            }
        }
        
        int totalB = 0;
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > maxVal) {
                maxVal = sectionB[i];
                maxSection = "Section B";
                maxIndex = i + 1; // 1-based index
            }
        }
        
        String balanceStatus = (totalA == totalB) ? "Balanced" : "Not Balanced";
        
        System.out.printf("A Total: %d | B Total: %d | %s | Highest: %d (%s, Item %d)\n", 
                totalA, totalB, balanceStatus, maxVal, maxSection, maxIndex);
    }
}
