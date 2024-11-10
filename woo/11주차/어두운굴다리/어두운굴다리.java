import java.util.*;

public class Main {
    private static int N;
    private static int M;
    private static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = sc.nextInt();
        }
        int answer = 0;
        int left = 1;
        int right = N;
        while (left <= right) {
            int mid = (left + right) /2;
            if (canLight(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    private static boolean canLight(int mid) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - mid <= temp) {
                temp = arr[i] + mid;
            } else {
                return false;
            }
        }

        return N - temp <= 0;
    }
}
