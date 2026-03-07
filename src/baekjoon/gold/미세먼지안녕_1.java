package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 미세먼지안녕_1 {

    static int R;
    static int C;
    static int T;
    static int[][] map;
    static List<int[]> filterLocations = new ArrayList<>(2);
    static List<int[]> dustLocations = new ArrayList<>();
    static boolean[][] isDust;
    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st1.nextToken());
        C = Integer.parseInt(st1.nextToken());
        T = Integer.parseInt(st1.nextToken());
        map = new int[R][C];
        isDust = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
                if (map[i][j] == -1) {
                    filterLocations.add(new int[]{i, j});
                }
                else if (map[i][j] != 0) {
                    dustLocations.add(new int[]{i, j});
                    isDust[i][j] = true;
                }
            }
        }

        spread(dustLocations.size());
    }

    private static void spread(int N) {
        for (int i = 0; i < N; i++) {
            int cR = dustLocations.get(i)[0];
            int cC = dustLocations.get(i)[1];
            for (int j = 0; j < 4; j++) {
                int nR = cR + dR[j];
                int nC = cC + dC[j];
                if (nR >= 0 && nR < R && nC >= 0 && nC < C && map[nR][nC] != -1) {
                    map[cR][cC] -= map[cR][cC] / 5;
                    map[nR][nC] += map[nR][nC] / 5;
                    dustLocations.add(new int[]{nR, nC});
                }
            }
        }
    }

    private static void rotate() {
        int[] counterClockwiseFilter = filterLocations.get(0);
        int[] clockwiseFilter = filterLocations.get(1);
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (c == 0 && r < counterClockwiseFilter[0] - 1) {
                    map[r + 1][c] = map[r][c];
                }
                if (r == 0 && c > 0 && c < C) {
                    map[r][c - 1] = map[r][c];
                }
                if (c == C - 1 && r <= counterClockwiseFilter[0] - 1 && r > 0) {
                    map[r - 1][c] = map[r][c];
                }
            }
        }
    }
}
