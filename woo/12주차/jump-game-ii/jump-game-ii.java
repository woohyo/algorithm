import java.util.*;
class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int c = nums[i];
            int size = c + i < nums.length ? c + i : nums.length - 1;
            for (int j = i + 1; j <= size; j++) {
                dp[j] = Math.min(dp[i] + 1, dp[j]);
            }
        }
        return dp[nums.length-1];
    }
}