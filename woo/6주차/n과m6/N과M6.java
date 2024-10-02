import java.util.*;

public class Main {
    private static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        boolean[] v = new boolean[N];
        int[] result = new int[M];
        recursive(0, result, 0, v, M);
    }

    private static void recursive(int start, int[] result, int depth, boolean[] v, int M) {
        if (depth == M) {
            System.out.println(Arrays.toString(result).replaceAll("\\[|\\]", "").replaceAll(",", ""));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (!v[i]) {
                v[i] = true;
                result[depth] = arr[i];
                recursive(i + 1, result, depth + 1, v, M);
                v[i] = false;
            }
        }
    }
}