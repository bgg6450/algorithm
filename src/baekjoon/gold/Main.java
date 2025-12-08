package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 11 10
 * 7 4 0
 * 1 1 1 1 1 1 1 1 1 1
 * 1 0 0 0 0 0 0 0 0 1
 * 1 0 0 0 1 1 1 1 0 1
 * 1 0 0 1 1 0 0 0 0 1
 * 1 0 1 1 0 0 0 0 0 1
 * 1 0 0 0 0 0 0 0 0 1
 * 1 0 0 0 0 0 0 1 0 1
 * 1 0 0 0 0 0 1 1 0 1
 * 1 0 0 0 0 0 1 1 0 1
 * 1 0 0 0 0 0 0 0 0 1
 * 1 1 1 1 1 1 1 1 1 1
 *
 * 57
 *
 * 로봇 청소기
 */
class Main {

    static int[] dR = {-1, 0, 1, 0};
    static int[] dC = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int R = Integer.parseInt(input1[0]);
        int C = Integer.parseInt(input1[1]);

        String[] input2 = br.readLine().split(" ");
        int initR = Integer.parseInt(input2[0]);
        int initC = Integer.parseInt(input2[1]);
        int initD = Integer.parseInt(input2[2]);

        String[][] map = new String[R][C];
        boolean[][] cleaned = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().split(" ");
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{initR, initC, initD});
        cleaned[initR][initC] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentR = current[0];
            int currentC = current[1];
            int currentD = current[2];

            if (isNotCleaned(currentR, currentC, cleaned)) {
                int nD = currentD == 0 ? 3 : currentD - 1;
                int nR = currentR + dR[nD];
                int nC = currentC + dC[nD];

                queue.add(new int[]{nR, nC, nD});

            }
        }
    }

    static boolean isNotCleaned(int currentR, int currentC, boolean[][] cleaned) {
        for (int i = 0; i < 4; i++) {
            int nR = currentR + dR[i];
            int nC = currentC + dC[i];
            if (!cleaned[nR][nC]) {
                return true;
            }
        }
        return false;
    }
}
