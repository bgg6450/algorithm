package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class 퇴사 {

    static int[] Ti;
    static int[] Pi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st1.nextToken());
        Ti = new int[N + 1];
        Pi = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            Ti[i] = Integer.parseInt(st2.nextToken());
            Pi[i] = Integer.parseInt(st2.nextToken());
        }

        for (int i = N; i > 0; i--) {
            dp(i);
        }
    }

    static int dp(int idx) {
        int next = idx + Ti[idx];
        if (next <= idx) {
            return Math.max(dp(next) + Pi[idx], dp(idx + 1));
        }
        return Pi[idx];
    }
}
