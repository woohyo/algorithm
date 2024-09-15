import java.util.*;
class Solution {
    private int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    private int[] dy = {0, 0, -1, 1};
    int answer;

    public int solution(int[][] board) {
        answer = Integer.MAX_VALUE;
        int[][][] minCost = new int[board.length][board[0].length][4];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                Arrays.fill(minCost[i][j], Integer.MAX_VALUE);
            }
        }
        for (int i = 0; i < 4; i++) {
            dfs(board, 0, 0, 0, i, minCost);
        }
        return answer;
    }

    private void dfs(int[][] board, int x, int y, int money, int direct, int[][][] minCost) {
        if (money >= answer || money > minCost[x][y][direct]) return;
        minCost[x][y][direct] = money;
        if (x == board.length - 1 && y == board[0].length - 1) {
            answer = Math.min(answer, money);
            return;
        }


        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && board[nx][ny] == 0) {
                int newMoney = money;
                if (direct == i) {
                    newMoney += 100;
                } else {
                    newMoney += 600;
                }

                dfs(board, nx, ny, newMoney, i, minCost);
            }
        }
    }
}