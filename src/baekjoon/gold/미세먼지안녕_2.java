package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 미세먼지안녕_2 {

    static int R;
    static int C;
    static int T;
    static int N;
    static int[][] map;
    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};
    static List<int[]> filters = new ArrayList<>(2);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st1.nextToken());
        C = Integer.parseInt(st1.nextToken());
        T = Integer.parseInt(st1.nextToken());
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
                if (map[i][j] == -1) {
                    filters.add(new int[]{i, j});
                }
            }
        }
        N = filters.get(0)[0];

        for (int i = 0; i < T; i++) {
            int[][] nextMap = new int[R][C];
            spread(nextMap);
            rotate(nextMap);
            map = nextMap;
        }

        count();
    }

    private static void spread(int[][] nextMap) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int nR = i + dR[k];
                        int nC = j + dC[k];
                        if (nR >= 0 && nR < R && nC >= 0 && nC < C && map[nR][nC] != -1) {
                            count++;
                            nextMap[nR][nC] += map[i][j] / 5;
                        }
                    }
                    nextMap[i][j] += (map[i][j] - (map[i][j] / 5 * count));
                }
            }
        }
    }

    private static void rotate(int[][] nextMap) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if ((i > N + 1 && j == 0) || (j == C - 1 && i <= N && i > 0)) {
                    if (map[i - 1][j] != -1) {
                        nextMap[i - 1][j] = map[i][j];
                    }
                }
                if ((j == 0 && i < N) || (j == C - 1 && i >= N + 1 && i < R - 1)) {
                    if (map[i + 1][j] != -1) {
                        nextMap[i + 1][j] = map[i][j];
                    }
                }
                if ((j < C - 1 && j > 0) && (i == 0 || i == R - 1)) {
                    if (map[i][j] == -1) {
                        nextMap[i][j + 1] = 0;
                    } else {
                        nextMap[i][j + 1] = map[i][j];
                    }
                }
                if ((j <= C - 1 && j > 0) && (i == N || i == N + 1)) {
                    nextMap[i][j - 1] = map[i][j];
                }
            }
        }

    }

    private static void count() {
        int result = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != -1) {
                    result += map[i][j];
                }
            }
        }
        System.out.println(result);
    }
}
