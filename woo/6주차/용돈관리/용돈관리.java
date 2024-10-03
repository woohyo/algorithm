
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        int min = 0;
        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();
            arr[i] = n;
            min = Math.max(n, min);
        }
        int max = Arrays.stream(arr).sum();
        int answer = 0;

        while (min <= max) {
            int mid = (min + max) / 2;
            int cnt = 1;
            int nowMoney = mid;

            for (int i : arr) {
                if (nowMoney < i) {
                    cnt++;
                    nowMoney = mid;
                }
                nowMoney -= i;
            }

            if (cnt <= M) {
                answer = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(answer);
    }

}