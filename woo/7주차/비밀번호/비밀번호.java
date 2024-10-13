import java.util.Scanner;
public class Main {
    private static int N;
    private static int answer;
    private static boolean[] v;
    private static int M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        v = new boolean[10];
        for (int i = 0; i < M; i++) {
            v[sc.nextInt()] = true;
        }
        recursive(0, 0);
        System.out.println(answer);
    }
    private static void recursive(int depth, int cnt){
        if (depth == N) {
            if (M == cnt) answer++;
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (v[i]) {
                v[i] = false;
                recursive(depth + 1, cnt + 1);
                v[i] = true;
            } else {
                recursive(depth + 1, cnt);
            }
        }
    }
}