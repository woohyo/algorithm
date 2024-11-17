import java.util.*;

public class Main {
    private static int N;
    private static int[][] map;
    private static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    private static int[] dy = {0, 0, -1, 1};
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                recursive(0, i, j, 0, new boolean[N][N]);
            }
        }

        System.out.println(answer);
    }

    private static void recursive(int cnt, int x, int y, int cost, boolean[][] v) {
        if (cnt == 3) {
            answer = Math.min(answer, cost);
            return;
        }

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (check(v, i, j)) {
                    int sumCost = calculateCost(i, j);
                    markFlower(v, i, j, true);
                    recursive(cnt + 1, i, j, cost + sumCost, v);
                    markFlower(v, i, j, false);
                }
            }
        }
    }

    private static boolean check(boolean[][] v, int x, int y) {
        if (v[x][y]) return false;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (v[nx][ny]) return false;
        }
        return true;
    }

    private static int calculateCost(int x, int y) {
        int cost = map[x][y];
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            cost += map[nx][ny];
        }
        return cost;
    }

    private static void markFlower(boolean[][] v, int x, int y, boolean flag) {
        v[x][y] = flag;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            v[nx][ny] = flag;
        }
    }
}
