import java.util.*;

public class Main {
    private static int K;
    private static int[] tree;
    private static List<List<Integer>> answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        int size = (int) (Math.pow(2, K) - 1);
        tree = new int[size];
        answer = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            answer.add(new ArrayList<>());
        }
        for (int i = 0; i < size; i++) {
            tree[i] = sc.nextInt();
        }
        recursive(0, size - 1, 0);

        for (List<Integer> list : answer) {
            StringBuilder sb = new StringBuilder();
            for (Integer i : list) {
                sb.append(i);
                sb.append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }

    private static void recursive(int start, int end, int depth) {
        if (depth >= K || start > end) {
            return;
        }

        int mid = (start + end) / 2;
        answer.get(depth).add(tree[mid]);

        recursive(start, mid - 1, depth + 1);
        recursive(mid + 1, end, depth + 1);
    }
}