import java.util.*;

public class Main {
    private static int N;
    private static int D;
    private static int[] dp;
    private static List<Node> nodes;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        D = sc.nextInt();
        dp = new int[D + 1];
        nodes = new ArrayList<>();
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }
        for (int i = 0; i < N; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            if (to <= D && weight < to - from) {
                nodes.add(new Node(weight, to, from));
            }
        }
        for (int i = 0; i <= D; i++) {
            if (i > 0) {
                dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            }
            for (Node node : nodes) {
                if (node.from == i) {
                    dp[node.to] = Math.min(dp[node.to], dp[i] + node.weight);
                }
            }
        }

        System.out.println(dp[D]);
    }
    static class Node {
        int weight;
        int to;
        int from;

        public Node(int weight, int to, int from) {
            this.weight = weight;
            this.to = to;
            this.from = from;
        }
    }
}