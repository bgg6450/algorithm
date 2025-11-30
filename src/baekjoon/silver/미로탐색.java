package baekjoon.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        String[][] map = new String[row][col];
        for (int i = 0 ; i < row; i ++) {
            map[i] = br.readLine().split("");
        }

        boolean[][] visited = new boolean[row][col];
        visited[0][0] = true;

        int[][] count = new int[row][col];
        count[0][0] = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int i = 0; i < 4; i++) {
                int X = currentX + dx[i];
                int Y = currentY + dy[i];
                if (0 <= X && X < row && 0 <= Y && Y < col && !visited[X][Y] && map[X][Y].equals("1")) {
                    visited[X][Y] = true;
                    count[X][Y] = count[currentX][currentY] + 1;
                    queue.add(new int[]{X, Y});
                }
            }
        }
        System.out.println(count[row - 1][col - 1]);
    }
}
