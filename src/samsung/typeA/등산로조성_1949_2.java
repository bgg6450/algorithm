package samsung.typeA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 등산로조성_1949_2 {

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
            answer = 1;
            int highest = 1;
            boolean[][] visited = new boolean[N][N];

            for (int j = 0; j < N; j++) {
                StringTokenizer st3 = new StringTokenizer(br.readLine());
                for (int l = 0; l < N; l++) {
                    map[j][l] = Integer.parseInt(st3.nextToken());
                    highest = Math.max(highest, map[j][l]);
                }
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[j][k] == highest) {
                        visited[j][k] = true;
                        dfs(1, new int[]{j, k}, false, visited);
                        visited[j][k] = false;
                    }
                }
            }
            System.out.println(String.format("#%d %d", i+1, answer));
        }
    }

    private static void dfs(int depth, int[] current, boolean isFlattened, boolean[][] visited) {
        int currentR = current[0];
        int currentC = current[1];
        for (int i = 0; i < 4; i++) {
            int nR = currentR + dR[i];
            int nC = currentC + dC[i];
            if (nR >= 0 && nR < N && nC >= 0 && nC < N && !visited[nR][nC]) {
                if (map[nR][nC] < map[currentR][currentC]) {
                    visited[nR][nC] = true;
                    dfs(depth + 1, new int[]{nR, nC}, isFlattened, visited);
                    visited[nR][nC] = false;
                } else if (!isFlattened) {
                    for (int j = 1; j < K+1; j++) {
                        if (map[nR][nC] - j < map[currentR][currentC]) {
                            map[nR][nC] -= j;
                            visited[nR][nC] = true;
                            dfs(depth + 1, new int[]{nR, nC}, true, visited);
                            visited[nR][nC] = false;
                            map[nR][nC] += j;
                        }
                    }
                }
            }
        }
        answer = Math.max(answer, depth);
    }
}
