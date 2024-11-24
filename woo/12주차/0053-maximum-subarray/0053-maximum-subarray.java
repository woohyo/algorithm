class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] = nums[i - 1] + nums[i];
            }
        }
        int answer = Integer.MIN_VALUE;
        for (int n: nums) {
            answer = Math.max(answer, n);
        }
        return answer;
    }
}