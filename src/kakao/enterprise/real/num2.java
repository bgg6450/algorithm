package kakao.enterprise.real;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num2 {
    private static final int[] dX = {0, 0, 1, -1};
    private static final int[] dY = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[][] map = new String[N][N];
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken();
            }
        }

        int[] beginNode = getNodeByUniqueCode(N, "S", map);
        visited[beginNode[0]][beginNode[1]] = true;

        int result = bfs(beginNode, map, N, visited);

        System.out.println(result);
    }

    private static int bfs(int[] beginNode, String[][] map, int N, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{beginNode[0], beginNode[1], 1});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            int distance = current[2];

            if (map[currentX][currentY].equals("E")) {
                return distance;
            }

            for (int i = 0; i < 4; i++) {
                int nx = currentX + dX[i];
                int ny = currentY + dY[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    if (map[nx][ny].equals("0") || map[nx][ny].equals("a") || map[nx][ny].equals("b") || map[nx][ny].equals("E")) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, distance + 1});
                    }
                    if (map[nx][ny].equals("A")) {
                        int[] exitWormHoleNode = getNodeByUniqueCode(N, "a", map);
                        visited[nx][ny] = true;
                        visited[exitWormHoleNode[0]][exitWormHoleNode[1]] = true;
                        queue.add(new int[]{exitWormHoleNode[0], exitWormHoleNode[1], distance + 2});
                    }
                    if (map[nx][ny].equals("B")) {
                        int[] exitWormHoleNode = getNodeByUniqueCode(N, "b", map);
                        visited[nx][ny] = true;
                        visited[exitWormHoleNode[0]][exitWormHoleNode[1]] = true;
                        queue.add(new int[]{exitWormHoleNode[0], exitWormHoleNode[1], distance + 2});
                    }
                }
            }
        }
        return -1;
    }

    private static int[] getNodeByUniqueCode(int N, String x, String[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].equals(x)) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
