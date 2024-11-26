# 최단거리 알고리즘
최단 경로 문제는 다음과 같이 분류할 수 있습니다.
- 모든 간선이 양수인 경우.
- 음수 간선이 있는 경우.
  1) 음수 간선 순환은 없는 경우
  2) 음수 간선 순환이 있는 경우

제일 메인이 되는 다익스트라 알고리즘을 중점으로 진행

## 📕 다익스트라 알고리즘
다익스트라 알고리즘(Dijkstra's Algorithm)은 그래프에서 단일 출발점에서 다른 모든 정점까지의 최단 경로를 찾는 알고리즘입니다.  

### 특징
1. 가중치 그래프: 그래프의 간선에 비용(가중치)이 정의된 경우 사용됩니다.
2. 비음수 가중치: 간선의 가중치는 음수일 수 없습니다. 음수 가중치가 있는 경우 Bellman-Ford 알고리즘을 사용해야 합니다.
3. 최단 경로: 출발점에서 다른 모든 정점까지의 최단 거리를 계산합니다.
4. 그리디 알고리즘: 현재 최적의 선택을 기반으로 진행하며, 이를 반복하여 전체 문제를 해결합니다.

**🔑키포인트**
특정 출발점이 있고 모두 양수인 가중치가 있는 최단거리를 구하고 싶다 -> 다익스트라! 

![dijkstra.png](https://github.com/woohyo/algorithm/raw/main/image/dijkstra.png)

### 동작 과정
1. 출발 노드 확정
2. 거리 초기화
3. 간선 확인 및 거리 갱신
4. 최단거리인 노드 방문
5. 2~4 반복

거리 + 경로 까지 구하기 위해선 배열이 2개 필요
```
A B C D E F

A B C D E F
```

```java
public class Dijkstra {
    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static int[] dijkstra(List<List<Edge>> graph, int start, int n) {
        int[] distances = new int[n];
        boolean[] visited = new boolean[n]; // 방문 여부 확인
        Arrays.fill(distances, Integer.MAX_VALUE); // 모든 거리를 무한대로 초기화
        distances[start] = 0;

        for (int i = 0; i < n; i++) {
            // 아직 방문하지 않은 노드 중 최단 거리를 가진 노드를 선택
            int currentNode = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (currentNode == -1 || distances[j] < distances[currentNode])) {
                    currentNode = j;
                }
            }

            // 더 이상 처리할 노드가 없으면 종료
            if (distances[currentNode] == Integer.MAX_VALUE) break;

            visited[currentNode] = true;

            // 현재 노드의 이웃 노드들에 대해 거리 갱신
            for (Edge edge : graph.get(currentNode)) {
                int newDist = distances[currentNode] + edge.weight;
                if (newDist < distances[edge.to]) {
                    distances[edge.to] = newDist;
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        int n = 6; // 노드 개수: A(0), B(1), C(2), D(3), E(4), F(5)
        List<List<Edge>> graph = new ArrayList<>();

        // 그래프 초기화
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 추가
        graph.get(0).add(new Edge(1, 10)); // A -> B (10)
        graph.get(0).add(new Edge(2, 8));  // A -> C (8)
        graph.get(0).add(new Edge(3, 13)); // A -> D (13)
        graph.get(1).add(new Edge(4, 5));  // B -> E (5)
        graph.get(2).add(new Edge(4, 43)); // C -> E (43)
        graph.get(2).add(new Edge(5, 12)); // C -> F (12)
        graph.get(2).add(new Edge(1, 1)); // C -> B (1)
        graph.get(3).add(new Edge(2, 23)); // D -> C (23)
        graph.get(3).add(new Edge(5, 7));  // D -> F (7)
        graph.get(4).add(new Edge(5, 3)); // E -> F (3)

        // 다익스트라 실행
        int startNode = 0; // A의 인덱스 (0)
        int[] shortestPaths = dijkstra(graph, startNode, n);

        // 결과 출력
        System.out.println("Shortest paths from node A:");
        for (int i = 0; i < n; i++) {
            System.out.println((char) ('A' + i) + ": " + (shortestPaths[i] == Integer.MAX_VALUE ? "Infinity" : shortestPaths[i]));
        }
    }
}
```

```java
public static int[] dijkstra(List<List<Edge>> graph, int start, int n) {
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE); // 모든 거리를 무한대로 초기화
        distances[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0}); // {노드 인덱스, 거리}

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentDistance = current[1];

            // 이미 더 짧은 경로가 있으면 스킵
            if (currentDistance > distances[currentNode]) continue;

            for (Edge edge : graph.get(currentNode)) {
                int newDist = distances[currentNode] + edge.weight;

                if (newDist < distances[edge.to]) {
                    distances[edge.to] = newDist;
                    pq.add(new int[]{edge.to, newDist});
                }
            }
        }

        return distances;
    }
```

## 📗벨만 포드 알고리즘
벨만 포드알고리즘은 다익스트라 알고리즘과 유사함
### 특징
벨만 포드 최단 경로 알고리즘은 음의 간선이 포함된 상황에서도 사용할 수 있다.
- 또한 음순 간선의 순환을 감지할 수있다.
- 벨만 포드의 기본 시간 복잡도는 다익스트라 알고리즘에 비해 느리다.

![bf.png](https://github.com/woohyo/algorithm/raw/main/image/bf.png)

### 동작과정 
1. 출발 노드 설정
2. 최단거리 테이블 초기화
3. N - 1번 반복
   1. 전체 간선 E 개 확인
   2. 각 간선을 거쳐 다른 노드로 가는 비용을 계산하여 최단거리 테이블 갱신
4. 음수 간선 순환 체크하고 싶다면 3번 한번더 수행
   - 이때 최단 거리 테이블이 갱신되면 음수 간선 순환

다익스트라 문제
1. https://www.acmicpc.net/problem/1753
<br> input 값은 참고 바꿔도 상관없음

```java
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
```

2. https://leetcode.com/problems/network-delay-time/description/