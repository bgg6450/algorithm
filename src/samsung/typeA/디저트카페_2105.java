package samsung.typeA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 디저트카페_2105 {

    static int T, N;
    static int[][] map;
    static int[] dR = {-1, 1, 1, -1};
    static int[] dC = {-1, -1, 1, 1};
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            solution(br, i);
        }
    }

    private static void solution(BufferedReader br, int i) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int j = 0; j < N; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int k = 0; k < N; k++) {
                map[j][k] = Integer.parseInt(st.nextToken());
            }
        }
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < N; k++) {
                boolean[][] visited = new boolean[N][N];
                visited[j][k] = true;
                dfs(new int[]{j, k}, new int[]{j, k, 0}, new int[4], visited, 0);
            }
        }
        System.out.println(String.format("#%d %d", i, answer));
        answer = -1;
    }

    private static void dfs(int[] origin, int[] current, int[] moved, boolean[][] visited, int count) {
        int currentR = current[0];
        int currentC = current[1];
        int currentD = current[2];

        int nR = currentR + dR[currentD];
        int nC = currentC + dC[currentD];

        int nnR = currentR + dR[currentD + 1];
        int nnC = currentC + dC[currentD + 1];

        if (nR >= 0 && nR < N && nC >= 0 && nC < N && !visited[nR][nC]) {
            visited[nR][nC] = true;
            moved[currentD] += 1;
            dfs(origin, new int[]{nR, nC, currentD}, moved, visited, count + map[currentR][currentC]);
            moved[currentD] -= 1;
            visited[nR][nC] = false;
        }
        if (currentD < 4 && nnR >= 0 && nnR < N && nnC >= 0 && nnC < N && !visited[nnR][nnC]) {
            visited[nnR][nnC] = true;
            moved[currentD] += 1;
            dfs(origin, new int[]{nnR, nnC, currentD + 1}, moved, visited, count + map[currentR][currentC]);
            moved[currentD] -= 1;
            visited[nnR][nnC] = false;
        }
        if (isCompleted(origin, current, moved)) {
            answer = Math.max(answer, count);
        }
    }


    private static boolean isCompleted(int[] origin, int[] current, int[] moved) {
        if (origin[0] == current[0] && origin[1] == current[1]) {
            for (int i = 0; i < N; i++) {
                if (moved[i] == 0) {
                    return false;
                }
                if (moved[0] == moved[2] && moved[1] == moved[3]) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
