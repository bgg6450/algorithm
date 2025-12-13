package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

class 톱니바퀴 {

    static int[][] map;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[4][8];
        
        for (int i = 0; i < 4; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int wheelNum = Integer.parseInt(st2.nextToken());
            int direction = Integer.parseInt(st2.nextToken());
            boolean[] compared = new boolean[4];

            compare(wheelNum, direction, compared);
        }

        int result = 0;
        for (int i = 0; i < 4; i++) {
            if (map[i][0] == 1) {
                result += map[i][0] * (1 << i);
            }
        }
        System.out.println(result);
    }

    static void compare(int wheelNum, int direction, boolean[] compared) {
        if (wheelNum == 2 || wheelNum == 3) {
            if (map[wheelNum - 2][2] != map[wheelNum - 1][6] && !compared[wheelNum - 2]) {
                compared[wheelNum - 2] = true;
                rotate(wheelNum - 1, direction * -1, compared);
            }
            if (map[wheelNum - 1][2] != map[wheelNum][6] && !compared[wheelNum]) {
                compared[wheelNum] = true;
                rotate(wheelNum + 1, direction * -1, compared);
            }
        } else if (wheelNum == 1) {
            if (map[wheelNum - 1][2] != map[wheelNum][6] && !compared[wheelNum]) {
                compared[wheelNum] = true;
                rotate(wheelNum + 1, direction * -1, compared);
            }
        } else if (wheelNum == 4) {
            if (map[wheelNum -2][2] != map[wheelNum - 1][6] && !compared[wheelNum - 2]) {
                compared[wheelNum - 2] = true;
                rotate(wheelNum - 1, direction * -1, compared);
            }
        }
    }

    static void rotate(int wheelNum, int direction, boolean[] compared) {
        int[] nextWheel = new int[8];
        int[] wheel = map[wheelNum -1];

        if (direction == 1) {
            nextWheel[0] = wheel[7];
            for (int i = 0; i < 7; i++) {
                nextWheel[i+1] = wheel[i];
            }
        } else {
            nextWheel[7] = wheel[0];
            for (int i = 0; i < 7; i++) {
                nextWheel[i] = wheel[i+1];
            }
        }
        map[wheelNum - 1] = nextWheel;
        compare(wheelNum, direction, compared);
    }
}
