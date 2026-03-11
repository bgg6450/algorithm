package samsung.typeA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 벽돌깨기 {

    static int T, N, W, H;
    static int[][] map;
    static boolean[][] destroyed;
    static int[] selected;
    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st1.nextToken());

        for (int n = 0; n < T; n++) {

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st2.nextToken());
            W = Integer.parseInt(st2.nextToken());
            H = Integer.parseInt(st2.nextToken());
            map = new int[H][W];
            destroyed = new boolean[H][W];
            selected = new int[N];

            for (int i = 0; i < H; i++) {
                StringTokenizer st3 = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st3.nextToken());
                }
            }

            selectBall(0);
            System.out.println(answer);
        }
    }

    private static void selectBall(int depth) {
        if (depth == N) {
            int[][] clonedMap = cloneMap();
            for (int i = 0; i < N; i++) {
                int w = selected[i];
                destroy(w, clonedMap);
                rearrange(w, clonedMap);
            }
            int count = count(clonedMap);
            answer = Math.min(count, answer);
            destroyed = new boolean[H][W];
            return;
        }
        for (int i = 0; i < W; i++) {
            selected[depth] = i;
            selectBall(depth + 1);
        }
    }

    private static int[][] cloneMap() {
        int[][] clonedMap = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                clonedMap[i][j] = map[i][j];
            }
        }
        return clonedMap;
    }

    private static void destroy(int w, int[][] clonedMap) {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (j == w && clonedMap[i][j] != 0) {
                    int range = clonedMap[i][j];
                    destroyed[i][j] = true;
                    for (int k = 0; k < 4; k++) {
                        for (int l = 1; l < range + 1; l++) {
                            int nR = i + dR[k] * l;
                            int nC = j + dC[k] * l;
                            if (nR >= 0 && nR < H && nC >= 0 && nC < W && clonedMap[nR][nC] != 0) {
                                destroyed[nR][nC] = true;
                            }
                        }
                    }
                    break;
                }
            }
        }
    }

    private static void rearrange(int w, int[][] clonedMap) {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (destroyed[i][j]) {
                    if (j == w) {
                        clonedMap[i][j] = 0;
                    } else {
                        for (int k = i; k > 0; k--) {
                            if (clonedMap[k - 1][j] == 0) {
                                clonedMap[k][j] = 0;
                                break;
                            } else {
                                clonedMap[k][j] = clonedMap[k - 1][j];
                            }
                        }
                    }
                }
            }
        }
    }

    private static int count(int[][] clonedMap) {
        int result = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (clonedMap[i][j] != 0) {
                    result++;
                }
            }
        }
        return result;
    }
}
