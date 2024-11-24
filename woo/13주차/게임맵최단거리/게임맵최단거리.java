import java.util.*;
class Solution {
    private int[] dx = {0, 0, 1, -1}; // 동 서 남 북
    private int[] dy = {1, -1, 0, 0};
    public int solution(int[][] maps) {
        int answer = Integer.MAX_VALUE;
        boolean[][] v = new boolean[maps.length][maps[0].length];

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1));
        v[0][0] = true;
        while (!q.isEmpty()) {
            Node poll = q.poll();
            if (poll.x == maps.length -1 && poll.y == maps[0].length - 1) {
                answer = poll.cnt;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + poll.x;
                int ny = dy[i] + poll.y;
                if (nx >= 0 && ny >= 0 && nx < maps.length && ny < maps[0].length && !v[nx][ny] && maps[nx][ny] == 1) {
                    q.add(new Node(nx, ny, poll.cnt + 1));
                    v[nx][ny] = true;
                }
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

}

class Node {
    int x;
    int y;
    int cnt;
    public Node(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}