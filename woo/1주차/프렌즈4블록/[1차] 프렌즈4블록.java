import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        boolean isCheck = true;
        char[][] boardArr = new char[m][n];
        for (int i = 0; i < m; i++) {
            boardArr[i] = board[i].toCharArray();
        }

        while (isCheck) {
            List<int[]> list = isCheck(boardArr, m, n);
            isCheck = !list.isEmpty();
            if (isCheck) {
                mask(list, boardArr);
                fall(boardArr, m, n);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (boardArr[i][j] == '-') answer++;
            }
        }
        return answer;
    }

    private List<int[]> isCheck(char[][] board, int m, int n) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                char root = board[i][j];
                if (root == '-') continue;
                if (board[i][j + 1] == root && board[i + 1][j] == root && board[i + 1][j + 1] == root) {
                    list.add(new int[]{i, j});
                    list.add(new int[]{i, j + 1});
                    list.add(new int[]{i + 1, j});
                    list.add(new int[]{i + 1, j + 1});
                }
            }
        }
        return list;
    }

    private void mask(List<int[]> list, char[][] board) {
        for (int[] coords : list) {
            int x = coords[0];
            int y = coords[1];
            board[x][y] = '-';
        }
    }

    private void fall(char[][] board, int m, int n) {
        for (int j = 0; j < n; j++) {
            for (int i = m - 1; i > 0; i--) {
                if (board[i][j] == '-') {
                    for (int k = i - 1; k >= 0; k--) {
                        if (board[k][j] != '-') {
                            board[i][j] = board[k][j];
                            board[k][j] = '-';
                            break;
                        }
                    }
                }
            }
        }
    }
}