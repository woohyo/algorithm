import java.util.*;

public class Main {
    private static int N;
    private static int M;
    private static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            System.out.println(countPointsInRange(start, end));
        }
    }
    private static int countPointsInRange(int start, int end) {
        int sRange = lowerBound(start);
        int eRange = upperBound(end);
        return eRange - sRange;
    }
    private static int lowerBound(int value) {
        int left = 0;
        int right = N;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }



    private static int upperBound(int value) {
        int left = 0;
        int right = N;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
