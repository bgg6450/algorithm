package baekjoon.silver;

import java.util.Scanner;

class 스타트와링크_2 {

    static int N;
    static int[][] map;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        visited = new boolean[N];
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        comb(0, 0);
        System.out.println(result);
    }

    static void comb(int start, int depth) {
        if (depth == N/2) {
            calc();
            return;
        }

        for (int i = start; i < N; i++) {
            visited[i] = true;
            comb(i + 1, depth + 1);
            visited[i] = false;
        }
    }

    static void calc() {
        int a = 0;
        int b = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i+1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    a += map[i][j] + map[j][i];
                }

                if (!visited[i] && !visited[j]) {
                    b += map[i][j] + map[j][i];
                }
            }
        }
        result = Math.min(Math.abs(a - b), result);
    }
}
