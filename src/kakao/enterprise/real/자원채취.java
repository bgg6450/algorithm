package kakao.enterprise.real;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 자원채취 {

    private static final int[] dX = {0, 0, -1, 1};
    private static final int[] dY = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int N = Integer.parseInt(input.split("\n")[0].split(" ")[0]);
        int K = Integer.parseInt(input.split("\n")[0].split(" ")[1]);

        String[][] map = new String[N][N];
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String row = input.split("\n")[i + 1];
            for (int j = 0; j < N; j++) {
                map[i][j] = row.split("")[j];
            }
        }

        int[] startNode = getBegin(N, map);

        Queue<int[]> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode[0]][startNode[1]] = true;
        int count = 0;
        int distance = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            if (count == K) {
                break;
            }
            if (visited[currentX][currentY]) {}
        }


        System.out.println("Hello Goorm! Your input is " + input);
    }

    private static int[] getBegin(int N, String[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].equals("B")) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
