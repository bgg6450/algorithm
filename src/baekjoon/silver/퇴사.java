package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class 퇴사 {

    static int N;
    static int[] T;
    static int[] P;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = new int[N];
        P = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int idx, int total) {
        if (idx == N - 1) {
            if (T[idx] == 1) {
                total += P[idx];
            }
            answer = Math.max(answer, total);
            return;
        }
        int cT = T[idx];
        int cP = P[idx];
        if (idx + cT < N) {
            dfs(idx + cT - 1, total + cP);
            dfs(idx + 1, total + cP);
        } else {
            dfs(idx + 1, total + cP);
        }
    }
}
