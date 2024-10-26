import java.util.*;

public class Main {
    private static int V;
    private static int E;
    private static int K;
    private static List<List<Edge>> graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        K = sc.nextInt() - 1;
        graph = new ArrayList<>();
        int[] dis = new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[K] = 0;
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            graph.get(from -1 ).add(new Edge(to - 1, weight));
        }
        PriorityQueue<Edge> q = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        q.add(new Edge(K, 0));
        while (!q.isEmpty()) {
            Edge poll = q.poll();
            List<Edge> edges = graph.get(poll.vertex);
            for (Edge edge : edges) {
                if (dis[edge.vertex] > edge.weight + poll.weight) {
                    dis[edge.vertex] = edge.weight + poll.weight;
                    q.add(new Edge(edge.vertex, edge.weight + poll.weight));
                }
            }
        }
        for (int di : dis) {
            if (di == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(di);
            }
        }
    }


    static class Edge {
        int vertex;
        int weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}