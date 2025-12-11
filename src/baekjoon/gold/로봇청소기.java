package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class 로봇청소기 {

    static int[] dRb = {1, 0, -1, 0};
    static int[] dCb = {0, -1, 0, 1};
    static int[] dRf = {-1, 0, 1, 0};
    static int[] dCf = {0, 1, 0, -1};
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int R = Integer.parseInt(input1[0]);
        int C = Integer.parseInt(input1[1]);

        String[] input2 = br.readLine().split(" ");
        int initR = Integer.parseInt(input2[0]);
        int initC = Integer.parseInt(input2[1]);
        int initD = Integer.parseInt(input2[2]);

        String[][] map = new String[R][C];
        boolean[][] cleaned = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().split(" ");
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{initR, initC, initD});
        cleaned[initR][initC] = true;


        while (!queue.isEmpty()) {
            boolean isCleanable = false;

            int[] current = queue.poll();
            int currentR = current[0];
            int currentC = current[1];
            int currentD = current[2];

            for (int i = 0; i < 4; i++) {
                currentD = nextDirection(currentD);
                int nR = currentR + dRf[currentD];
                int nC = currentC + dCf[currentD];
                if (!map[nR][nC].equals("1") && !cleaned[nR][nC]) {
                    isCleanable = true;
                    count += 1;
                    queue.add(new int[]{nR, nC, currentD});
                    cleaned[nR][nC] = true;
                    break;
                }
            }
            if (!isCleanable) {
                int nR = currentR + dRb[currentD];
                int nC = currentC + dCb[currentD];
                if (map[nR][nC].equals("1")) {
                    System.out.println(count);
                    return;
                }
                queue.add(new int[]{nR, nC, currentD});
            }
        }
    }

    static int nextDirection(int currentD) {
        if (currentD == 0) {
            return 3;
        }
        return currentD - 1;
    }
}
