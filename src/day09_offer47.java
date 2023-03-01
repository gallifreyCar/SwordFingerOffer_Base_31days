class Solution47 {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i != 0 && j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                }
                if (j != 0 && i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                }
                if (j != 0 && i != 0) {
                    grid[i][j] = Math.max(grid[i - 1][j] + grid[i][j], grid[i][j - 1] + grid[i][j]);
                }
            }
        }

        return grid[m - 1][n - 1];
    }

    //    用滚动数组优化
    public int maxValue2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[j] = Math.max(dp[j], dp[j - 1]) + grid[i - 1][j - 1];

            }
        }

        return dp[n];
    }
}

public class day09_offer47 {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1},
        };
        Solution47 solution47 = new Solution47();
        System.out.println(solution47.maxValue2(grid));
    }
}
