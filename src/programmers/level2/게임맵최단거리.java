package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {

    private static final int[] dX = {0, 0, 1, -1};
    private static final int[] dY = {1, -1, 0, 0};

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;

        return bfs(maps, n, m, visited);
    }

    private static int bfs(int[][] maps, int n, int m, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            if (x == n -1 && y == m -1) {
                return distance;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dX[i];
                int ny = y + dY[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, distance + 1});
                }
            }
        }
        return -1;
    }
}
