import java.util.Scanner;

public class Main {
    private static int N;
    private static int answer;
    private static boolean[] v;

    private static int K;
    private static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        arr = new int[N];
        answer = 0;
        v = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int power = 500;
        recursive(power, 0, 0);
        System.out.println(answer);
    }

    private static void recursive(int power, int idx, int depth) {
        if (depth == N) {
            if (power >= 500) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!v[i] && power + arr[i] - K >= 500) {
                v[i] = true;
                recursive(power + arr[i] - K, i, depth  +1);
                v[i] = false;
            }
        }
    }
}
