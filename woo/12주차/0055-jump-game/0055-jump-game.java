import java.util.*;
class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        for (int i =0; i < nums.length - 1; i++) {
            int jp = nums[i];
            for (int j = i + 1; j <= i + jp; j++) {
                if (j >= nums.length) break;
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        return dp[nums.length - 1] < Integer.MAX_VALUE / 2;
    }
}