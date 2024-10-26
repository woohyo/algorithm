import java.util.Scanner;

public class Main {
    private static char[][] map;
    private static char[][] sel;
    private static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1}; // 상 하 좌 우 좌상 우상 좌하 우하
    private static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    private static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new char[N][N];
        sel = new char[N][N];
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            map[i] =s.toCharArray();
        }


        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            sel[i] = s.toCharArray();
        }
        boolean check = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (sel[i][j] == 'x') {
                    boolean check1 = check(i, j);
                    if (check1 || check) {
                        check = true;
                    }
                }
            }
        }
        if (check) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '*') {
                        sel[i][j] = '*';
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(new String(sel[i]));
        }
    }

    private static boolean check(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == '*') {
                cnt++;
            }
        }
        if (map[x][y] == '*') {
            sel[x][y] = '*';
            return true;
        } else {
            sel[x][y] = (char) (cnt + '0');
            return false;
        }
    }
}