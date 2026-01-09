package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
6 3 15
0 0 1 0 0 0
0 0 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 1 0
0 0 0 1 0 0
6 5
2 2 5 6
5 4 1 6
4 2 3 5
 */
class 스타트택시_2try {

    static int N;
    static int M;
    static int[][] map;
    static int[][] countMap;
    static boolean[][] visited;
    static int[][] customers;
    static boolean[] visitedCustomers;
    static int[][] destinations;
    static int currentR;
    static int currentC;
    static int fuel;
    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());
        fuel = Integer.parseInt(st1.nextToken());
        map = new int[N][N];
        countMap = new int[N][N];
        visited = new boolean[N][N];
        customers = new int[M][2];
        visitedCustomers = new boolean[M];
        destinations = new int[M][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        StringTokenizer st3 = new StringTokenizer(br.readLine());
        currentR = Integer.parseInt(st3.nextToken()) - 1;
        currentC = Integer.parseInt(st3.nextToken()) - 1;

        for (int i = 0; i < M; i++) {
            StringTokenizer st4 = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                if (j == 0) {
                    customers[i][0] = Integer.parseInt(st4.nextToken()) - 1;
                }
                if (j == 1) {
                    customers[i][1] = Integer.parseInt(st4.nextToken()) - 1;
                }
                if (j == 2) {
                    destinations[i][0] = Integer.parseInt(st4.nextToken()) - 1;
                }
                if (j == 3) {
                    destinations[i][1] = Integer.parseInt(st4.nextToken()) - 1;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            int nextIdx = nextCustomerIdx();
            visitedCustomers[nextIdx] = true;
            int distance = getDistance(customers[nextIdx][0], customers[nextIdx][1]);
            if (fuel >= distance) {
                fuel = (fuel - distance) + (distance * 2);
                currentR = destinations[nextIdx][0];
                currentC = destinations[nextIdx][1];
            }
            else {
                System.out.println(-1);
                break;
            }
        }
        System.out.println(fuel);
    }

    static int nextCustomerIdx() {
        int idx = 0;
        int result = Integer.MAX_VALUE;
        int[] idxs = new int[3];

        for (int i = 0; i < M; i ++) {
            if (!visitedCustomers[i]) {
                int destR = destinations[i][0];
                int destC = destinations[i][1];
                int distance = getDistance(destR, destC);
                result = Math.min(result, distance);

                if (distance == result) {
                    if (idxs[0] == i) {
                        if (idxs[1] == customers[i][0]) {
                            if (idxs[2] > customers[i][1]) {
                                idxs[0] = distance;
                                idxs[1] = customers[i][0];
                                idxs[2] = customers[i][1];
                                idx = i;
                            }
                        } else if (idxs[1] > customers[i][0]) {
                            idxs[0] = distance;
                            idxs[1] = customers[i][0];
                            idxs[2] = customers[i][1];
                            idx = i;
                        }
                    } else {
                        idxs[0] = distance;
                        idxs[1] = customers[i][0];
                        idxs[2] = customers[i][1];
                    }
                }
            }
        }
        return idx;
    }

    static int getDistance(int destR, int destC) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{currentR, currentC});
        visited[currentR][currentC] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cR = current[0];
            int cC = current[1];
            for (int i = 0; i < 4; i++) {
                int nR = cR + dR[i];
                int nC = cC + dC[i];
                if (nR >= 0 && nR < N && nC >= 0 && nC < N && !visited[nR][nC] && map[nR][nC] == 0) {
                    queue.add(new int[]{nR, nC});
                    visited[nR][nC] = true;
                    countMap[nR][nC] += 1;
                }
            }
        }

        return countMap[destR][destC];
    }
}
