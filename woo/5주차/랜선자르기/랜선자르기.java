import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();
        int[] nums = new int[K];
        for (int i = 0; i < K; i++) {
            int i1 = sc.nextInt();
            nums[i] = i1;
        }
        Arrays.sort(nums);
        long ans = 0;
        long left = 1;
        long right = nums[nums.length - 1];
        while (left <= right) {
            long mid = (left + right) / 2;
            long complete = 0;
            if (mid == 0) break;
            for (int i = 0; i < K; i++) {
                complete += nums[i] / mid;
            }
            if (N > complete) {

                right = mid - 1;
            } else {
                left = mid + 1;
                ans = mid;
            }
        }
        System.out.println(ans);
    }
}