package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class 연구소 {

    static int[][] map;
    static int row;
    static int col;
    static int result = Integer.MIN_VALUE;
    static List<int[]> emptySpaces = new ArrayList<>();
    static List<int[]> viruses = new ArrayList<>();
    static int[][] addedWalls;
    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st1.nextToken());
        col = Integer.parseInt(st1.nextToken());

        map = new int[row][col];
        addedWalls = new int[3][2];

        for (int i = 0; i < row; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
                if (map[i][j] == 0) {
                    emptySpaces.add(new int[]{i, j});
                }
                if (map[i][j] == 2) {
                    viruses.add(new int[]{i, j});
                }
            }
        }
        comb(0, 0);
        System.out.println(result);
    }

    static void comb(int start, int depth) {
        if (depth == 3) {
            calc();
            return;
        }
        for (int i = start; i < emptySpaces.size(); i++) {
            addedWalls[depth] = emptySpaces.get(i);
            comb(i + 1, depth + 1);
        }
    }

    static void calc() {
        int[][] newMap = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                newMap[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < 3; i++) {
            int r = addedWalls[i][0];
            int c = addedWalls[i][1];
            newMap[r][c] = 2;
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int[] virus : viruses) {
            queue.add(virus);
        }
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int crrR = current[0];
            int crrC = current[1];

            for (int i = 0; i < 4; i++) {
                int nR = crrR + dR[i];
                int nC = crrC + dC[i];
                if (nR >= 0 && nR < row && nC >= 0 && nC < col && newMap[nR][nC] == 0) {
                    queue.add(new int[]{nR, nC});
                    newMap[nR][nC] = 2;
                }
            }
        }
        int safeArea = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (newMap[i][j] == 0) {
                    safeArea += 1;
                }
            }
        }
        result = Math.max(result, safeArea);
    }
}
