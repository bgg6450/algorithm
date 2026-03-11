package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 경사로 {

    static int N;
    static int L;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        L = Integer.parseInt(st1.nextToken());

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        for (int r = 0; r < N; r++) {
            int[] row = map[r];
            if (isQualified(row)) {
//                dfs();
            };
        }
    }

    private static boolean isQualified(int[] row) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> pool = new HashSet<>();
        for (int n : row) {
            pool.add(n);
            if (pool.size() > 2) {
                return false;
            }
            min = Math.min(min, n);
            max = Math.max(max, n);
            if (max - min > 1) {
                return false;
            }
        }
        return true;
    }

    private static void dfs(int[] row, boolean[] isRamp, int rampLength, int depth) {
        if (depth == N - 1) {
            return;
        }
        int current = row[depth];
        int next = row[depth + 1];

        if (Math.abs(current - next) == 1) {
            isRamp[current] = true;
            rampLength++;
        }
        else {

        }
    }
}
