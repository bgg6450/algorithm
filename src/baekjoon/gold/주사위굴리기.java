package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class 주사위굴리기 {

    static int N;
    static int M;
    static int[] dice;
    static int K;
    static int[] current;
    static int[][] map;
    static int[] orders;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dice = new int[6];
        current = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        orders = new int[K];

        for (int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            orders[i] = Integer.parseInt(st2.nextToken());
        }

        for (int i = 0; i < K; i++) {
            int direction = orders[i];
            move(direction);
        }
    }

    static void move(int direction) {
        if (direction == 1) {
            if (current[1] + 1 < M) {
                current[1] += 1;
                dice = new int[]{dice[3], dice[1], dice[0], dice[5], dice[4], dice[2]};
                copyAndPrint();
            }
        }
        if (direction == 2) {
            if (current[1] - 1 >= 0) {
                current[1] -= 1;
                dice = new int[]{dice[2], dice[1], dice[5], dice[0], dice[4], dice[3]};
                copyAndPrint();
            }
        }
        if (direction == 3) {
            if (current[0] - 1 >= 0) {
                current[0] -= 1;
                dice = new int[]{dice[4], dice[0], dice[2], dice[3], dice[5], dice[1]};
                copyAndPrint();
            }
        }
        if (direction == 4) {
            if (current[0] + 1 < N) {
                current[0] += 1;
                dice = new int[]{dice[1], dice[5], dice[2], dice[3], dice[0], dice[4]};
                copyAndPrint();
            }
        }
    }

    static void copyAndPrint() {
        if (map[current[0]][current[1]] == 0) {
            map[current[0]][current[1]] = dice[5];
        } else {
            dice[5] = map[current[0]][current[1]];
            map[current[0]][current[1]] = 0;
        }
        System.out.println(dice[0]);
    }
}
