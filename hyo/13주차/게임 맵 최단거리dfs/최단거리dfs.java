import java.util.*;


public class 최단거리dfs {

    int [] dr = {1, 0, -1, 0}; // 행 방향
    int [] dc = {0, 1, 0, -1}; // 열 방향

    int minDistance = Integer.MAX_VALUE;

    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        dfs(0, 0,  maps, 1, visited);
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    public void dfs(int r, int c, int[][] maps, int distance, boolean[][] visited) {
        int rl = maps.length; // 행의 길이
        int cl = maps[0].length; // 열의 길이

        if(r == rl - 1 && c == cl - 1) {
            minDistance = Math.min(minDistance, distance);;
            return;
        }

        visited[r][c] = true;

        for(int i = 0; i < dr.length; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr >= 0 && nr < rl && nc >= 0 && nc < cl) {
                if(maps[nr][nc] == 1) {
                    if (!visited[nr][nc]) {
                        dfs(nr, nc, maps, distance + 1, visited);
                    }
                }
            }
        }

        visited[r][c] = false; // 방문 상태 복구
    }

}
