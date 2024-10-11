import java.util.Scanner;

public class Main {
    private static int N;
    private static int answer;
    private static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        answer = Integer.MIN_VALUE;
        recursive(0, arr.clone());
        System.out.println(answer);
    }

    private static void recursive(int sum, int[] copy) {

        for (int i = 1; i < copy.length - 1; i++) {
            int[] ints = deleteArr(i, copy);
            recursive(sum + (copy[i -1] * copy[i + 1] ), ints);
        }
        answer = Math.max(sum, answer);
    }

    private static int[] deleteArr(int idx, int[] copy) {
        int[] na = new int[copy.length - 1];
        int ix = 0;
        for (int i = 0; i < copy.length; i++) {
            if (idx == i) continue;
            na[ix++] = copy[i];
        }
        return na;
    }
}
