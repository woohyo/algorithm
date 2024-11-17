import java.util.*;
public class Main {
    private static int N;
    private static int M;
    private static int[] a;
    private static int[] b;
    private static Set<Integer> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        a = new int[N];
        b = new int[M];
        list = new HashSet<>();
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            b[i] = sc.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < N; i++) {
            bst(b, a[i]);
        }
        for (int i = 0; i < M; i++) {
            bst(a, b[i]);
        }
        System.out.println(list.size());
    }
    private static void bst(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        list.add(target);
    }
}