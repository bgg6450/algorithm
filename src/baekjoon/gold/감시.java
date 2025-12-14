package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class 감시 {

    static int R;
    static int C;
    static int[][] map;
    static List<int[]> cctvs = new ArrayList<>();
    static List<Integer> cctvTypes = new ArrayList<>();
    static int result = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st1.nextToken());
        C = Integer.parseInt(st1.nextToken());
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6) {
                    cctvs.add(new int[]{map[i][j], i, j, 0});
                    cctvTypes.add(map[i][j]);
                }
            }
        }
        comb(0, new int[cctvTypes.size()][4]);

        System.out.println(result);
    }

    static void comb(int depth, int[][] directions) {
        if (depth == cctvTypes.size()) {
            calc(directions);
            return;
        }
        if (cctvTypes.get(depth) != 2) {
            for (int i = 0; i < 4; i++) {
                directions[depth][0] = cctvTypes.get(depth);
                directions[depth][1] = i;
                directions[depth][2] = cctvs.get(depth)[1];
                directions[depth][3] = cctvs.get(depth)[2];
                comb(depth + 1, directions);
            }
        }
        if (cctvTypes.get(depth) == 2) {
            for (int i = 0; i < 2; i++) {
                directions[depth][0] = cctvTypes.get(depth);
                directions[depth][1] = i;
                directions[depth][2] = cctvs.get(depth)[1];
                directions[depth][3] = cctvs.get(depth)[2];
                comb(depth + 1, directions);
            }
        }
    }

    static void calc(int[][] directions) {
        for (int i = 0; i < directions.length; i++) {
            int type = directions[i][0];
            int direction = directions[i][1];
            int r = directions[i][2];
            int c = directions[i][3];

            mark(type, direction, r, c);
        }
        int count = 0;
        for (int j = 0; j < R; j++) {
            for (int k = 0; k < C; k++) {
                if (map[j][k] == 0) {
                    count++;
                }
                if (map[j][k] == -1) {
                    map[j][k] = 0;
                }
            }
        }
        result = Math.min(count, result);
    }

    static void mark(int cctvType, int direction, int crrR, int crrC) {
        if (cctvType == 1) {
            if (direction == 0) {
                markRight(crrR, crrC + 1);
            }
            if (direction == 1) {
                markDown(crrR + 1, crrC);
            }
            if (direction == 2) {
                markLeft(crrR, crrC - 1);
            }
            if (direction == 3) {
                markUp(crrR - 1, crrC);
            }
        }
        if (cctvType == 2) {
            if (direction == 0) {
                markLeft(crrR, crrC - 1);
                markRight(crrR, crrC + 1);
            }
            if (direction == 1) {
                markUp(crrR - 1, crrC);
                markDown(crrR + 1, crrC);
            }
        }
        if (cctvType == 3) {
            if (direction == 0) {
                markUp(crrR - 1, crrC);
                markRight(crrR, crrC + 1);
            }
            if (direction == 1) {
                markRight(crrR, crrC + 1);
                markDown(crrR + 1, crrC);
            }
            if (direction == 2) {
                markDown(crrR + 1, crrC);
                markLeft(crrR, crrC - 1);
            }
            if (direction == 3) {
                markLeft(crrR, crrC - 1);
                markUp(crrR - 1, crrC);
            }
        }
        if (cctvType == 4) {
            if (direction == 0) {
                markLeft(crrR, crrC - 1);
                markUp(crrR - 1, crrC);
                markRight(crrR, crrC + 1);
            }
            if (direction == 1) {
                markUp(crrR - 1, crrC);
                markRight(crrR, crrC + 1);
                markDown(crrR + 1, crrC);
            }
            if (direction == 2) {
                markRight(crrR, crrC + 1);
                markDown(crrR + 1, crrC);
                markLeft(crrR, crrC - 1);
            }
            if (direction == 3) {
                markDown(crrR + 1, crrC);
                markLeft(crrR, crrC - 1);
                markUp(crrR - 1, crrC);
            }
        }
        if (cctvType == 5) {
            markUp(crrR - 1, crrC);
            markRight(crrR, crrC + 1);
            markDown(crrR + 1, crrC);
            markLeft(crrR, crrC - 1);
        }
    }

    static void markRight(int crrR, int crrC) {
        if (crrC == C) {
            return;
        }
        if (map[crrR][crrC] == 6) {
            return;
        }
        if (map[crrR][crrC] > 0 && map[crrR][crrC] < 6 || map[crrR][crrC] == -1) {
            markRight(crrR, crrC + 1);
        }
        if (map[crrR][crrC] == 0) {
            map[crrR][crrC] = -1;
            markRight(crrR, crrC + 1);
        }
    }

    static void markLeft(int crrR, int crrC) {
        if (crrC == -1) {
            return;
        }
        if (map[crrR][crrC] == 6) {
            return;
        }
        if (map[crrR][crrC] > 0 && map[crrR][crrC] < 6 || map[crrR][crrC] == -1) {
            markLeft(crrR, crrC - 1);
        }
        if (map[crrR][crrC] == 0) {
            map[crrR][crrC] = -1;
            markLeft(crrR, crrC - 1);
        }
    }

    static void markUp(int crrR, int crrC) {
        if (crrR == -1) {
            return;
        }
        if (map[crrR][crrC] == 6) {
            return;
        }
        if (map[crrR][crrC] > 0 && map[crrR][crrC] < 6 || map[crrR][crrC] == -1) {
            markUp(crrR - 1, crrC);
        }
        if (map[crrR][crrC] == 0) {
            map[crrR][crrC] = -1;
            markUp(crrR - 1, crrC);
        }
    }

    static void markDown(int crrR, int crrC) {
        if (crrR == R) {
            return;
        }
        if (map[crrR][crrC] == 6) {
            return;
        }
        if (map[crrR][crrC] > 0 && map[crrR][crrC] < 6 || map[crrR][crrC] == -1) {
            markDown(crrR + 1, crrC);
        }
        if (map[crrR][crrC] == 0) {
            map[crrR][crrC] = -1;
            markDown(crrR + 1, crrC);
        }
    }
}
