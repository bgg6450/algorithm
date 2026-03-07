package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 치킨배달_2 {

    static int N;
    static int M;
    static int[][] map;
    static List<int[]> chickenLocation = new ArrayList<>();
    static List<int[]> homeLocation = new ArrayList<>();
    static int[][] selected;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());
        map = new int[N][N];
        selected = new int[M][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
                if (map[i][j] == 2) {
                    chickenLocation.add(new int[]{i, j});
                }
                if (map[i][j] == 1) {
                    homeLocation.add(new int[]{i, j});
                }
            }
        }

        combination(0, 0);
        System.out.println(answer);
    }

    private static void combination(int start, int depth) {
        if (depth == M) {
            int result = 0;
            for (int[] homeLoc : homeLocation) {
                int dist = Integer.MAX_VALUE;
                for (int[] chickenLoc : selected) {
                    dist = Math.min(getChickenDistance(homeLoc, chickenLoc), dist);
                }
                result += dist;
            }
            answer = Math.min(result, answer);
            return;
        }
        for (int i = start; i < chickenLocation.size(); i++) {
            selected[depth] = chickenLocation.get(i);
            combination(i + 1, depth + 1);
            selected[depth] = new int[2];
        }
    }

    private static int getChickenDistance(int[] loc1, int[] loc2) {
        return Math.abs(loc1[0] - loc2[0]) + Math.abs(loc1[1] - loc2[1]);
    }
}
