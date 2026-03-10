package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 인구이동 {

    static int N;
    static int L;
    static int R;
    static int[][] map;
    static boolean[][] visited;
    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        L = Integer.parseInt(st1.nextToken());
        R = Integer.parseInt(st1.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        move(new int[N][N], map);
        System.out.println(answer);
    }

    private static void move(int[][] newMap, int[][] oldMap) {
        if (isSameMap(newMap, oldMap)) {
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bfs(i, j, newMap, oldMap);
            }
        }
        answer++;
        visited = new boolean[N][N];
        move(newMap, oldMap);
    }

    private static boolean isSameMap(int[][] newMap, int[][] oldMap) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (newMap[i][j] != oldMap[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void bfs(int initR, int initC, int[][] newMap, int[][] oldMap) {
        List<int[]> unions = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        int[] start = new int[]{initR, initC};
        queue.add(start);
        unions.add(start);
        visited[initR][initC] = true;
        int count = 1;
        int total = oldMap[initR][initC];
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cR = current[0];
            int cC = current[1];
            for (int i = 0; i < 4; i++) {
                int nR = cR + dR[i];
                int nC = cC + dC[i];
                int diff = Math.abs(oldMap[nR][nC] - oldMap[cR][cC]);
                if (nR >= 0 && nR < N && nC >= 0 && nC < N && diff >= L && diff <= R) {
                    int[] next = new int[]{nR, nC};
                    queue.add(next);
                    unions.add(next);
                    visited[nR][nC] = true;
                    count++;
                    total += oldMap[nR][nC];
                }
            }
        }
        int avg = total / count;
        for (int[] union : unions) {
            newMap[union[0]][union[1]] = avg;
        }
    }
}
