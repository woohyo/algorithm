import java.util.*;


public class Main {
    private static int[][] arr;
    private static boolean[] x; // 행 체크
    private static boolean[] y; // 열 체크
    private static boolean[] diag1; // '/' 대각선 체크
    private static boolean[] diag2; // '\' 대각선 체크
    private static int N;
    private static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        x = new boolean[N];
        y = new boolean[N];
        diag1 = new boolean[2 * N - 1];
        diag2 = new boolean[2 * N - 1];
        answer = 0;

        recursive(0);
        System.out.println(answer);
    }

    private static void recursive(int col) {
        if (col == N) {
            answer++;
            return;
        }

        for (int row = 0; row < N; row++) {
            if (!x[row] && !y[col] && !diag1[row + col] && !diag2[row - col + N - 1]) {
                x[row] = true;
                y[col] = true;
                diag1[row + col] = true;
                diag2[row - col + N - 1] = true;
                arr[row][col] = 1;

                recursive(col + 1);

                x[row] = false;
                y[col] = false;
                diag1[row + col] = false;
                diag2[row - col + N - 1] = false;
                arr[row][col] = 0;
            }
        }
    }
}