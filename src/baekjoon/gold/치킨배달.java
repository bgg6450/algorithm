package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class 치킨배달 {

    static int M;
    static List<int[]> chickenMap = new ArrayList<>();
    static int[][] chickenIdxMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());

        int[][] map = new int[N + 1][N + 1];
        int[][] distMap = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
                if (map[i][j] == 2) {
                    chickenMap.add(new int[]{i, j});
                }
            }
        }

        chickenIdxMap = new int[chickenMap.size()][3];
        comb(0, 0);

        for (int i = 0; i < chickenMap.size(); i++) {
            for (int j = 0; j < 3; j++) {
                int idx = chickenIdxMap[i][j];
                int[] coor = chickenMap.get(idx);
                for (int k = 1; k < N + 1; k++) {
                    for (int l = 1; l < N + 1; l++) {
                        if (map[k][l] == 1) {
                            int dist = distMap[k][l] == 0 ? distance(coor, new int[]{k, l}) :
                                    Math.min(distance(coor, new int[]{k, l}), distMap[k][l]);
                            distMap[k][l] = dist;
                        }
                    }
                }
            }
        }

        int result = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                result += distMap[i][j];
            }
        }

        System.out.println(result);
    }

    public static void comb(int start, int depth) {
        if (depth == M) {
            return;
        }
        for (int i = start; i < chickenMap.size(); i++) {
            chickenIdxMap[depth][i] = chickenMap.indexOf(chickenMap.get(i));
            comb(i+1, depth+1);
        }
    }

    static int distance(int[] coor1, int[] coor2) {
        return Math.abs(coor1[0] - coor2[0]) + Math.abs(coor1[1] - coor2[1]);
    }
}
