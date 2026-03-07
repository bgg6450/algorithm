package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 연구소_2 {

    static int N;
    static int M;
    static List<int[]> emptyLocations = new ArrayList<>();
    static List<int[]> virusLocations = new ArrayList<>();
    static int[][] map;
    static int[][] selectedLocations = new int[3][2];
    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
                if (map[i][j] == 0) {
                    emptyLocations.add(new int[]{i, j});
                }
                if (map[i][j] == 2) {
                    virusLocations.add(new int[]{i, j});
                }
            }
        }

        combination(0, 0);
        System.out.println(answer);
    }

    private static void combination(int start, int depth) {
        if (depth == 3) {
            int[][] clonedMap = cloneMap();
            for (int[] selectedLocation : selectedLocations) {
                clonedMap[selectedLocation[0]][selectedLocation[1]] = 1;
            }
            bfs(clonedMap);
            int result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (clonedMap[i][j] == 0) {
                        result++;
                    }
                }
            }
            answer = Math.max(result, answer);
            return;
        }
        for (int i = start; i < emptyLocations.size(); i++) {
            selectedLocations[depth] = emptyLocations.get(i);
            combination(i + 1, depth + 1);
        }
    }

    private static void bfs(int[][] map) {
        Queue<int[]> queue = new LinkedList<>(virusLocations);
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentR = current[0];
            int currentC = current[1];
            for (int i = 0; i < 4; i++) {
                int nR = currentR + dR[i];
                int nC = currentC + dC[i];
                if (nR >= 0 && nR < N && nC >= 0 && nC < M && map[nR][nC] == 0) {
                    queue.add(new int[]{nR, nC});
                    map[nR][nC] = 2;
                }
            }
        }
    }

    private static int[][] cloneMap() {
        int[][] clonedMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                clonedMap[i][j] = map[i][j];
            }
        }
        return clonedMap;
    }
}
