// P2_WarehouseGridSummary.java
public class P2_WarehouseGridSummary {
    static class Result {
        int totalItems;
        int maxRow;
        int maxCol;

        public Result(int totalItems, int maxRow, int maxCol) {
            this.totalItems = totalItems;
            this.maxRow = maxRow;
            this.maxCol = maxCol;
        }

        @Override
        public String toString() {
            return "(" + totalItems + ", (" + maxRow + ", " + maxCol + "))";
        }
    }

    public static Result warehouseSummary(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return new Result(0, 0, 0);
        }

        int total = 0;
        int maxCount = -1;
        int bestRow = 0;
        int bestCol = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                int val = grid[r][c];
                total += val;
                if (val > maxCount) {
                    maxCount = val;
                    bestRow = r;
                    bestCol = c;
                }
            }
        }
        return new Result(total, bestRow, bestCol);
    }

    public static void main(String[] args) {
        int[][] grid = {
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        };

        System.out.println(warehouseSummary(grid)); // (49, (2, 1))
    }
}
