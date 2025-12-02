package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {

    static int[] dr = {-1, 1, 0, 0, 0, 0};
    static int[] dc = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        dh[4] *= h;
        dh[5] *= h;

        String[][] tomatoes = new String[r*h][c];
        for (int i = 0; i < r*h; i++) {
            tomatoes[i] = br.readLine().split(" ");
        }

        boolean[][] visited = new boolean[r][c];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < r*h; i ++) {
            for (int j = 0; j < c; j++) {
                if (tomatoes[i][j].equals("1")) {
                    int k = i / r;
                    queue.offer(new int[]{i + (k-1)*h, j});
                    visited[i + (k - 1) * h][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cr = current[0];
            int cc = current[1];

            for (int i = 0; i < dr.length; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                int nh = cr + dh[i];

                if (nr >= 0 && nr < r && nc >= 0 && nc < c && nh >= 0 && nh < h) {
                    if (tomatoes[nr][nc].equals("0")) {
                        queue.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                    if (tomatoes[nh][nc].equals("0")) {
                        queue.offer(new int[]{nh, nc});
                        visited[nh][nc] = true;
                    }
                }
            }
        }
    }
}
