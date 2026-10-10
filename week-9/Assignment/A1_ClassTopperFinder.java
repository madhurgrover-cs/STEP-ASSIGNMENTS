// A1_ClassTopperFinder.java
public class A1_ClassTopperFinder {
    static class Result {
        int rowIndex;
        int total;

        public Result(int rowIndex, int total) {
            this.rowIndex = rowIndex;
            this.total = total;
        }

        @Override
        public String toString() {
            return "(" + rowIndex + ", " + total + ")";
        }
    }

    public static Result findTopper(int[][] marks) {
        if (marks == null || marks.length == 0) {
            return new Result(0, 0);
        }

        int bestIndex = -1;
        int bestTotal = -1;

        for (int i = 0; i < marks.length; i++) {
            int currentTotal = 0;
            for (int j = 0; j < marks[i].length; j++) {
                currentTotal += marks[i][j];
            }
            if (currentTotal > bestTotal) {
                bestTotal = currentTotal;
                bestIndex = i;
            }
        }

        return new Result(bestIndex, bestTotal);
    }

    public static void main(String[] args) {
        int[][] marks = {
            {78, 85, 90},
            {88, 92, 79},
            {65, 70, 95}
        };

        System.out.println(findTopper(marks)); // (1, 259)
    }
}
