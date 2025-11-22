package kakao.enterprise.real;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 자원채취 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String firstInput = br.readLine();
        int N = Integer.parseInt(firstInput.split(" ")[0]);
        int K = Integer.parseInt(firstInput.split(" ")[1]);

        String input = br.readLine();

        String[][] map = new String[N][N];
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] row = input.split("\n")[i].split("");
            System.arraycopy(row, 0, map[i], 0, N);
        }

        int[] startNode = getBeginNode(N, map);

        bfs(startNode, visited, K, map, N);

        for (String[] row : map) {
            StringBuilder sb = new StringBuilder();
            for (String chr : row) {
                sb.append(chr);
            }
            sb.append('\n');
            System.out.println(sb);
        }
    }

    private static void bfs(int[] startNode, boolean[][] visited, int K, String[][] map, int N) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startNode[0], startNode[1], 0});
        visited[startNode[0]][startNode[1]] = true;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            int count = current[2];
            int distance = 1;

            if (count == K) {
                break;
            }

            List<int[]> targetNodes = getTargetNodes(currentX, currentY, distance);
            for (int[] targetNode : targetNodes) {
                int nx = targetNode[0];
                int ny = targetNode[1];
                if (!visited[nx][ny] && map[nx][ny].equals("0") && nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    visited[nx][ny] = true;
                    map[nx][ny] = "X";
                    queue.offer(new int[]{nx, ny, count + 1});
                }
            }
        }
    }

    private static int[] getBeginNode(int N, String[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].equals("B")) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private static List<int[]> getTargetNodes(int currentX, int currentY, int distance) {
        List<int[]> targetNodes = new ArrayList<>();
        for (int y = -distance; y < distance+1; y++) {
            for (int x = -distance; x < distance+1; x++) {
                if (Math.abs(currentX - x) + Math.abs(currentY - y) == distance) {
                    targetNodes.add(new int[]{currentX + x, currentY + y});
                }
            }
        }
        return targetNodes;
    }
}
