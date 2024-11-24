import java.util.*;
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        Arrays.sort(coins);
        for (int i =0; i < coins.length; i++) {
            int j = coins[i];
            int cnt = 1;
            while (j <= amount) {
                dp[j] = cnt;
                cnt++;
                j += coins[i];
            }
        }
        for (int i = 0; i <= amount; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            for (int j =0; j < coins.length; j++) {
                long a = (long) coins[j] + i ;
                if (a > amount) break;
                dp[i + coins[j]] = Math.min(dp[i + coins[j]], dp[i] + 1);
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[amount];
    }
}