import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        List<List<int[]>> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] r : road) {
            int from = r[0] - 1;
            int to = r[1] - 1;
            int dis = r[2];
            list.get(from).add(new int[]{to, dis});
            list.get(to).add(new int[]{from, dis});
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.sum - b.sum);
        pq.add(new Node(0, 0));
        dist[0] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            for (int[] next : list.get(node.idx)) {
                int nextIdx = next[0];
                int nextDis = next[1];
                if (dist[nextIdx] > node.sum + nextDis) {
                    dist[nextIdx] = node.sum + nextDis;
                    pq.add(new Node(nextIdx, dist[nextIdx]));
                }
            }
        }

        for (int d : dist) {
            if (d <= K) {
                answer++;
            }
        }

        return answer;
    }
}

class Node {
    int idx;
    int sum;
    public Node(int idx, int sum) {
        this.idx = idx;
        this.sum = sum;
    }
}