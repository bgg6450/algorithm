package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class 아기상어2 {

    static int[] dr = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dc = {0, 0, -1, 1, -1, -1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        String[][] map = new String[row][col];
        boolean[][] visited = new boolean[row][col];
        int[][] dist = new int[row][col];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            map[i] = br.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                if (map[i][j].equals("1")) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    dist[i][j] = 0;
                }
            }
        }

        int max_distance = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int i = 0; i < dr.length; i++) {
                int nr = current[0] + dr[i];
                int nc = current[1] + dc[i];

                if (nr > -1 && nr < row && nc > -1 && nc < col && !visited[nr][nc] && map[nr][nc].equals("0")) {
                    queue.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    dist[nr][nc] = dist[current[0]][current[1]] + 1;
                    max_distance = Math.max(max_distance, dist[nr][nc]);
                }
            }
        }

        System.out.println(max_distance);
    }
}
