import java.util.*;

public class Main {
    private static int N;
    private static boolean[] v;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        v = new boolean[N];
        recursive(1, 0, new int[N]);
    }

    private static void recursive(int num, int idx, int[] a) {
        if (idx == N) {
            System.out.println(Arrays.toString(a).replaceAll("[\\[\\],]", ""));
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!v[i - 1]) {
                v[i - 1] = true;
                a[idx] = i;
                recursive(num, idx + 1, a);
                v[i - 1] = false;
            }
        }
    }
}