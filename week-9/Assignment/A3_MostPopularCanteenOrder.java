// A3_MostPopularCanteenOrder.java
import java.util.*;

public class A3_MostPopularCanteenOrder {
    static class Result {
        String item;
        int count;

        public Result(String item, int count) {
            this.item = item;
            this.count = count;
        }

        @Override
        public String toString() {
            return "(\"" + item + "\", " + count + ")";
        }
    }

    public static Result mostPopular(String[] orders) {
        if (orders == null || orders.length == 0) {
            return new Result("", 0);
        }

        // Pass 1: Count frequencies
        Map<String, Integer> counts = new HashMap<>();
        for (String item : orders) {
            counts.put(item, counts.getOrDefault(item, 0) + 1);
        }

        // Pass 2: Find max count in original encounter order
        int maxCount = 0;
        String bestItem = "";
        for (String item : orders) {
            int c = counts.get(item);
            if (c > maxCount) {
                maxCount = c;
                bestItem = item;
            }
        }

        return new Result(bestItem, maxCount);
    }

    public static void main(String[] args) {
        String[] orders1 = {"dosa", "idli", "vada", "dosa", "idli", "dosa", "tea"};
        System.out.println(mostPopular(orders1)); // ("dosa", 3)

        String[] orders2 = {"tea", "coffee", "coffee", "tea"};
        System.out.println(mostPopular(orders2)); // ("tea", 2)
    }
}
