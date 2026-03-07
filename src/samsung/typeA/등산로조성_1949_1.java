package samsung.typeA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 등산로조성_1949_1 {

    static int T;
    static int N;
    static int K;
    static int[][] map;
    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st1.nextToken());

        for (int i = 0; i < T; i++) {

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st2.nextToken());
            K = Integer.parseInt(st2.nextToken());
            map = new int[N][N];
            answer = Integer.MIN_VALUE;
            int highest = 1;
            boolean[][] visited = new boolean[N][N];

            for (int j = 0; j < N; j++) {
                StringTokenizer st3 = new StringTokenizer(br.readLine());
                for (int l = 0; l < N; l++) {
                    map[j][l] = Integer.parseInt(st3.nextToken());
                    highest = Math.max(highest, map[j][l]);
                }
            }

            int[][] clonedMap = new int[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    clonedMap[j][k] = map[j][k];
                    for (int l = 1; l < K+1; l++) {
                        clonedMap[j][k] -= l;
                        bfs(highest, visited, clonedMap);
                        clonedMap[j][k] += l;
                    }
                }
            }

            System.out.println(String.format("#%d %d", i+1, answer));
        }
    }

    private static void bfs(int highest, boolean[][] visited, int[][] clonedMap) {
        int result = 1;
        Queue<int[]> queue = new LinkedList<>();
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < N; k++) {
                if (clonedMap[j][k] == highest) {
                    queue.add(new int[]{j, k});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentR = current[0];
            int currentC = current[1];
            for (int k = 0; k < 4; k++) {
                int nR = currentR + dR[k];
                int nC = currentC + dC[k];
                if (nR >= 0 && nR < N && nC >= 0 && nC < N && !visited[nR][nC] && clonedMap[nR][nC] < clonedMap[currentR][currentC]) {
                    queue.add(new int[]{nR, nC});
                    visited[nR][nC] = true;
                    result++;
                }
            }
        }
        answer = Math.max(result, answer);
    }
}
