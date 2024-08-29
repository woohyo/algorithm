import java.util.*;

public class Main {

    static int n, m;
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0}; //행 n [n][m]
    static int[] dy = {0, 1, 0, -1}; //열 m

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        maze = new int[n][m];
        visited = new boolean[n][m];

        // 미로구조 생성
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }
        System.out.println(bfs(0, 0, 1));
    }

    static int bfs(int x, int y, int cnt) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, cnt));
        visited[x][y] = true;
        int answer = 0;

        while (!queue.isEmpty()) {
            Node currNode = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = currNode.x + dx[i];
                int ny = currNode.y + dy[i];

                if(0 <= nx && nx < n && 0 <= ny && ny < m){
                    if(maze[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        cnt = currNode.cnt + 1;
                        if(nx == n - 1 && ny == m - 1) answer = cnt;
                        queue.add(new Node(nx, ny, cnt));
                    }
                }

            }//for
        }//while
        return answer;
    }

    static class Node {
        int x, y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
