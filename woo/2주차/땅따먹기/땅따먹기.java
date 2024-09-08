class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length][4];
        init(land, dp);
        for (int i = land.length - 2; i >= 0; i--) {
            dp[i][0] = Math.max(dp[i + 1][1] + land[i][0], Math.max(dp[i + 1][2] + land[i][0], dp[i + 1][3] + land[i][0]));
            dp[i][1] = Math.max(dp[i + 1][0] + land[i][1], Math.max(dp[i + 1][2] + land[i][1], dp[i + 1][3] + land[i][1]));
            dp[i][2] = Math.max(dp[i + 1][0] + land[i][2], Math.max(dp[i + 1][1] + land[i][2], dp[i + 1][3] + land[i][2]));
            dp[i][3] = Math.max(dp[i + 1][0] + land[i][3], Math.max(dp[i + 1][1] + land[i][3], dp[i + 1][2] + land[i][3]));
        }

        for (int i =0; i < 4; i++) {
            answer = Math.max(dp[0][i], answer);
        }
        return answer;
    }

    private void init(int[][] land, int[][] dp){
        for (int i =0; i < 4; i++) {
            dp[land.length -1][i] = land[land.length - 1][i];
        }
    }
}