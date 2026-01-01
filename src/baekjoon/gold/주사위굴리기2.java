package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 주사위굴리기2 {

    static int R;
    static int C;
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int direction = 0;
    static int result = 0;
    static int cR = 0;
    static int cC = 0;

    static int[] drMove = {0, 1, 0, -1};
    static int[] dcMove = {1, 0, -1, 0};
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[] dice = {2, 4, 1, 3, 5, 6};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st1.nextToken());
        C = Integer.parseInt(st1.nextToken());
        N = Integer.parseInt(st1.nextToken());
        map = new int[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            move();
            calcScore();
            switchDirection();
        }

        System.out.println(result);
    }

    static void move() {
        int nr = cR + drMove[direction];
        int nc = cC + dcMove[direction];
        if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
            direction = (direction + 2) % 4;
            nr = cR + drMove[direction];
            nc = cC + dcMove[direction];
        }

        // 한 칸 이동
        cR = nr;
        cC = nc;

        // 주사위 회전
        // dice: [북,서,위,동,남,아래]
        if (direction == 0) { // E
            dice = new int[]{dice[0], dice[5], dice[1], dice[2], dice[4], dice[3]};
        } else if (direction == 1) { // S
            dice = new int[]{dice[5], dice[1], dice[0], dice[3], dice[2], dice[4]};
        } else if (direction == 2) { // W
            dice = new int[]{dice[0], dice[2], dice[3], dice[5], dice[4], dice[1]};
        } else { // N
            dice = new int[]{dice[2], dice[1], dice[4], dice[3], dice[5], dice[0]};
        }
    }

    static void calcScore() {
        int count = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{cR, cC});
        visited[cR][cC] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentR = current[0];
            int currentC = current[1];

            for (int j = 0; j < 4; j++) {
                int nr1 = currentR + dr[j];
                int nc1 = currentC + dc[j];

                if (nr1 >= 0 && nr1 < R && nc1 >= 0 && nc1 < C && !visited[nr1][nc1] && map[nr1][nc1] == map[cR][cC]) {
                    visited[nr1][nc1] = true;
                    queue.add(new int[]{nr1, nc1});
                    count++;
                }
            }
        }
        visited = new boolean[R][C];
        result += count * map[cR][cC];
    }

    static void reverseDirection() {
        if (direction == 0) {
            direction = 2;
        }
        if (direction == 1) {
            direction = 3;
        }
        if (direction == 2) {
            direction = 0;
        }
        if (direction == 3) {
            direction = 1;
        }
    }

    static void switchDirection() {
        if (getBottomNum() > map[cR][cC]) {
            direction = ((direction + 1) % 4 + 4) % 4;
        }
        if (getBottomNum() < map[cR][cC]) {
            direction = ((direction + 3) % 4 + 4) % 4;
        }
    }

    static int getBottomNum() {
        return dice[5];
    }
}
