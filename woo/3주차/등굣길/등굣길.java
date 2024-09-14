import java.util.Arrays;

class Solution {
    private int[][] dp;
    int I = 1_000_000_007;

    public int solution(int m, int n, int[][] puddles) {
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int[] puddle : puddles) {
            dp[puddle[1] - 1][puddle[0] - 1] = 0;
        }

        return findPaths(n - 1, m - 1);
    }

    private int findPaths(int y, int x) {
        if (y == 0 && x == 0) {
            return 1;
        }

        if (y < 0 || x < 0 || dp[y][x] == 0) {
            return 0;
        }

        if (dp[y][x] != -1) {
            return dp[y][x];
        }

        dp[y][x] = (findPaths(y - 1, x) + findPaths(y, x - 1)) % I;
        return dp[y][x];
    }
}
