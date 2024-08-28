import java.util.*;


public class 최단거리 {

        int [] dx = {1, 0, -1, 0}; // 행 방향
        int [] dy = {0, 1, 0, -1}; // 열 방향


        public int solution(int[][] maps) {
            return bfs(0, 0,  maps);
        }

        public int bfs(int n, int m, int[][] maps) {
            int answer = 0;
            int nl = maps.length; // 행의 길이
            int ml = maps[n].length; // 열의 길이
            boolean[][] visited = new boolean[nl][ml];

            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(m, n,  1));
            visited[n][m] = true;

            while (!queue.isEmpty()) {
                Node currNode = queue.poll();

                for(int i = 0; i < 4; i++) {
                    int nx = currNode.x + dx[i];
                    int ny = currNode.y + dy[i];
                    if(0 <= ny && ny < ml && 0 <= nx && nx < nl) {
                        if(maps[nx][ny] == 1 && !visited[nx][ny]) {
                            visited[nx][ny] = true;
                            answer = currNode.distance + 1;
                            // 도착 지점 도달했을 경우
                            if(ny == ml - 1 && nx == nl - 1) {
                                return answer;
                            }
                            queue.add(new Node(nx, ny, answer));
                        }
                    }
                } // for
            } // while
            return -1;
        }

        class Node {
            int x, y; // 행, 열
            int distance;

            public Node(int x, int y,  int distance) {
                this.x = x;
                this.y = y;
                this.distance = distance;
            }
        }

}
