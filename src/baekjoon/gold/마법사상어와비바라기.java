package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class 마법사상어와비바라기 {

    static int N;
    static int[][] maps;
    static boolean[][] clouds;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        maps = new int[N][N];
        int[][] moves = new int[M][2];
        clouds = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                moves[i][j] = Integer.parseInt(st3.nextToken());
            }
        }

        clouds[N - 1][0] = true;
        clouds[N - 1][1] = true;
        clouds[N - 2][0] = true;
        clouds[N - 2][1] = true;

        for (int i = 0; i < M; i++) {
            int direction = moves[i][0];
            int distance = moves[i][1];
            move(direction, distance);
            fill();
            newCloud();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result += maps[i][j];
            }
        }

        System.out.println(result);
    }

    static void move(int direction, int distance) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (clouds[i][j]) {
                    if (direction == 1) {
                        clouds[i][j] = false;
                        clouds[i][next(j - distance)] = true;
                        maps[i][next(j - distance)] += 1;
                    }
                    if (direction == 2) {
                        clouds[i][j] = false;
                        clouds[next(i - distance)][next(j - distance)] = true;
                        maps[next(i - distance)][next(j - distance)] += 1;
                    }
                    if (direction == 3) {
                        clouds[i][j] = false;
                        clouds[next(i - distance)][j] = true;
                        maps[next(i - distance)][j] += 1;
                    }
                    if (direction == 4) {
                        clouds[i][j] = false;
                        clouds[next(i - distance)][next(j + distance)] = true;
                        maps[next(i - distance)][next(j + distance)] += 1;
                    }
                    if (direction == 5) {
                        clouds[i][j] = false;
                        clouds[i][next(j + distance)] = true;
                        maps[i][next(j + distance)] += 1;
                    }
                    if (direction == 6) {
                        clouds[i][j] = false;
                        clouds[next(i + distance)][next(j + distance)] = true;
                        maps[next(i + distance)][next(j + distance)] += 1;
                    }
                    if (direction == 7) {
                        clouds[i][j] = false;
                        clouds[next(i + distance)][j] = true;
                        maps[next(i + distance)][j] += 1;
                    }
                    if (direction == 8) {
                        clouds[i][j] = false;
                        clouds[next(i + distance)][next(j - distance)] = true;
                        maps[next(i + distance)][next(j - distance)] += 1;
                    }
                }
            }
        }
    }

    static int next(int distance) {
        if (distance < 0) {
            return N - (Math.abs(distance) % N) - 1;
        }
        return Math.abs(distance) % N;
    }

    static void fill() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (clouds[i][j]) {
                    if (i - 1 >= 0 && j - 1 >= 0) {
                        if (maps[i-1][j-1] != 0) {
                            maps[i][j] += 1;
                        }
                    }
                    if (i - 1 >= 0 && j + 1 < N) {
                        if (maps[i-1][j+1] != 0) {
                            maps[i][j] += 1;
                        }
                    }
                    if (i + 1 < N && j - 1 >= 0) {
                        if (maps[i+1][j-1] != 0) {
                            maps[i][j] += 1;
                        }
                    }
                    if (i + 1 < N && j + 1 < N) {
                        if (maps[i+1][j+1] != 0) {
                            maps[i][j] += 1;
                        }
                    }
                }
            }
        }
    }

    static void newCloud() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!clouds[i][j] && maps[i][j] >= 2) {
                    maps[i][j] -= 2;
                    clouds[i][j] = true;
                }
            }
        }
    }
}
