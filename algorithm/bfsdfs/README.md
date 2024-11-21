# BFS (Breadth-First Search, 너비 우선 탐색)

그래프 시작 노드에서 가까운 노드부터 차례로 탐색하는 방식으로, Queue(큐) 자료구조를 사용하여 구현한다. <br>
탐색 과정에서 각 노드가 레벨 순서 기반으로 방문되므로 먼저 방문한 노드가 항상 최단 거리에 위치하게 되는데,
이러한 특성으로 모든 간선의 가중치가 동일할 때 최단 경로를 찾는 데 효과적인 알고리즘이다.


<br><br>
***
# DFS (Depth-First Search, 깊이 우선 탐색)

한 노드에서 출발하여 끝까지 탐색한 후, 돌아가면서 탐색을 반복하는 방식으로, Stack(스택) 자료구조나 재귀(Recursion)를 사용하여 구현한다. 
특정 경로를 우선적으로 탐색하거나, 모든 경로를 탐색해야 하는 문제에 효과적인 알고리즘이다.


<br><br>
***
# BFS와 DFS를 사용할 때의 조건
- 그래프가 인접 행렬 또는 인접 리스트 형태로 표현되어야 한다.
- 무한 루프를 방지하기 위한 방문 여부 체크가 중요하다.


<br><br>
***
# BFS와 DFS 구현 방식

## BFS 구현
- Queue를 사용한다.
- 시작 노드를 큐에 넣고, 큐에서 하나씩 꺼내어 인접 노드를 방문한다.


```java

public class BFSExample {
    // BFS 메서드: 시작 노드부터 너비 우선 탐색을 수행
    public static void bfs(int start, List<List<Integer>> graph) {
        // 방문 여부를 저장하는 배열
        boolean[] visited = new boolean[graph.size()];
        // BFS에 사용할 큐를 선언
        Queue<Integer> queue = new LinkedList<>();

        // 시작 노드를 큐에 추가하고 방문 처리
        queue.add(start);
        visited[start] = true;

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            // 큐에서 현재 노드를 꺼냄
            int current = queue.poll();

            // 현재 노드와 연결된 모든 이웃 노드 탐색
            for (int neighbor : graph.get(current)) {
                // 이웃 노드가 아직 방문되지 않았다면
                if (!visited[neighbor]) {
                    // 큐에 추가하고 방문 표시
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        // 그래프를 각 노드가 연결된 인접 리스트로 생성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 9; i++) { // 노드 수만큼 빈 리스트 추가
            graph.add(new ArrayList<>());
        }

        // 그래프 간선 추가
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);
        graph.get(2).add(1);
        graph.get(2).add(7);
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);
        graph.get(4).add(3);
        graph.get(4).add(5);
        graph.get(5).add(3);
        graph.get(5).add(4);
        graph.get(6).add(7);
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);
        graph.get(8).add(1);
        graph.get(8).add(7);
        
        bfs(1, graph); // 시작 노드: 1
    }
}

```

<br><br>

## DFS 구현
- 재귀 또는 Stack을 사용.
- 한 경로를 끝까지 탐색한 후, 다른 경로를 탐색한다.


```java

public class DFSExample {
    // DFS 메서드: 깊이 우선 탐색
    public static void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        // 현재 노드를 방문 처리
        visited[node] = true;

        // 현재 노드와 연결된 모든 이웃 노드를 탐색
        for (int neighbor : graph.get(node)) {
            // 이웃 노드가 아직 방문되지 않았다면 재귀 호출
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }

    public static void main(String[] args) {
        // 그래프를 각 노드가 연결된 인접 리스트로 생성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 9; i++) { // 노드 수만큼 빈 리스트 추가
            graph.add(new ArrayList<>());
        }

        // 그래프 간선 추가
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);
        graph.get(2).add(1);
        graph.get(2).add(7);
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);
        graph.get(4).add(3);
        graph.get(4).add(5);
        graph.get(5).add(3);
        graph.get(5).add(4);
        graph.get(6).add(7);
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);
        graph.get(8).add(1);
        graph.get(8).add(7);
        
        // 방문 여부를 저장하는 배열
        boolean[] visited = new boolean[graph.size()];
        
        dfs(1, graph, visited); // 시작 노드: 1
    }
}

```


<br><br>
***
# BFS와 DFS의 차이점 비교

<table class="table">
<tbody>
<tr>
<td><strong>특성</strong></td>
<td><strong>BFS</strong></td>
<td><strong>DFS</strong></td>
</tr>
<tr>
<td><strong>자료구조</strong></td>
<td>Queue</td>
<td>Stack 또는 재귀</td>
</tr>
<tr>
<td><strong>탐색 방식</strong></td>
<td>가까운 노드부터 탐색</td>
<td>한 경로를 끝까지 탐색</td>
</tr>
<tr>
<td><strong>적합한 문제</strong></td>
<td>최단 경로 문제, 레벨 순서 기반 탐색 (최소 단계로 해결해야하는 문제) </td>
<td>특정 조건을 만족하는 경로 탐색, 모든 경우의 수 탐색</td>
</tr>
<tr>
<td><strong>시간 복잡도</strong></td>
<td>O(V + E)</td>
<td>O(V + E)</td>
</tr>
</tbody>
</table>
** V는 노드 수(노드 탐색 비용), E는 간선 수(간선 탐색 비용). <br>
** 그래프의 모든 노드를 한 번씩 방문하고, 방문 중 각 노드의 모든 인접 노드를 확인하며 간선을 한 번씩 탐색.


