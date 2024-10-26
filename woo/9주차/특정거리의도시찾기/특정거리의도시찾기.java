import java.util.*;
public class Main {
    private static int N;
    private static int M;
    private static int K;
    private static int X;
    private static List<Integer>[] edge;
    private static boolean[] v;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        X = sc.nextInt();
        edge = new ArrayList[N];
        v = new boolean[N];
        for (int i = 0; i < N; i++) {
            edge[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            edge[from - 1].add(to - 1);
        }
        Queue<Node> queue = new LinkedList<>();
        Map<Integer, Integer> dis = new HashMap<>();
        queue.add(new Node(X - 1, 0));
        v[X - 1] = true;
        dis.put(X- 1, 0);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            Integer minDis = dis.getOrDefault(poll.idx, Integer.MAX_VALUE);
            for (int i = 0; i < edge[poll.idx].size(); i++) {
                Integer nextNode = edge[poll.idx].get(i);
                if (!v[nextNode] || minDis > poll.dis) {
                    queue.add(new Node(nextNode, poll.dis + 1));
                    v[nextNode] = true;
                }
            }
            dis.put(poll.idx, Math.min(minDis, poll.dis));
        }
        Set<Integer> set = dis.keySet();
        List<Integer> result = new ArrayList<>();
        for (Integer key : set) {
            Integer i = dis.get(key);
            if (i == K) {
                result.add(key + 1);
            }
        }
        if (result.isEmpty()) {
            System.out.println(-1);
        } else  {
            Collections.sort(result);
            for (Integer i : result) {
                System.out.println(i);
            }
        }
    }

    static class Node {
        int idx;
        int dis;

        public Node(int idx, int dis) {
            this.idx = idx;
            this.dis = dis;
        }
    }
}