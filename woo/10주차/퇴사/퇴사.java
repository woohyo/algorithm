import java.util.*;

public class Main {
    private static int N;
    private static int[] dp;
    private static List<Node> nodes;
    private static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new int[N + 1];
        nodes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int t = sc.nextInt();
            int p = sc.nextInt();
            nodes.add(new Node(p, t, i));
        }

        for (int i = 0; i < N; i++) {
            Node node = nodes.get(i);
            if (node.canWork()) {
                dp[node.idx + node.t] = Math.max(dp[node.idx + node.t], dp[i] + node.p);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        answer = dp[N];
        System.out.println(answer);

        sc.close();
    }

    static class Node {
        int p;
        int t;
        int idx;

        public Node(int p, int t, int idx) {
            this.p = p;
            this.t = t;
            this.idx = idx;
        }

        public boolean canWork() {
            return idx + t <= N;
        }
    }
}
