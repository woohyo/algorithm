
import java.util.Scanner;
public class Main {
    private static int[][] arr;
    private static int N;
    private static int answer;
    private static boolean[] v;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        v = new boolean[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        answer = Integer.MAX_VALUE;
        makeTeam(0, 0);
        System.out.println(answer);
    }
    private static void makeTeam(int x, int depth) {
        if (depth == N / 2) {
            diff();
            return;
        }
        for (int i = x; i < N; i++) {
            if (!v[i]) {
                v[i] = true;
                makeTeam(i + 1, depth + 1);
                v[i] = false;
            }
        }
    }
    static void diff() {
        int start = 0;
        int link = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {

                if (v[i]&& v[j]) {
                    start += arr[i][j];
                    start += arr[j][i];
                }

                else if (!v[i] && !v[j]) {
                    link += arr[i][j];
                    link += arr[j][i];
                }
            }
        }

        int abs = Math.abs(start - link);
        answer = Math.min(abs, answer);
    }
}