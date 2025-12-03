package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 스타트택시
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
class 스타트택시 {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int fuel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st1.nextToken());
        int passengers = Integer.parseInt(st1.nextToken());
        fuel = Integer.parseInt(st1.nextToken());

        int[][] map = new int[row][row];
        boolean[][] visited = new boolean[row][row];
        int minDistToPassengers = 400;
        int[] visitedPassengers = new int[passengers];

        for (int i = 0; i < row; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int initRow = Integer.parseInt(st2.nextToken());
        int initCol = Integer.parseInt(st2.nextToken());

        int[][][] startEnd = new int[passengers][2][2];

        for (int i = 0; i < passengers; i++) {
            int[] r = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            startEnd[i][0][0] = r[0];
            startEnd[i][0][1] = r[1];
            startEnd[i][1][0] = r[2];
            startEnd[i][1][1] = r[3];
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{initRow, initCol, fuel});
        visited[initRow-1][initCol-1] = true;


        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0]-1;
            int currentCol = current[1]-1;

             for (int i = 0; i < passengers; i++) {
                int dstRow = startEnd[i][1][0]-1;
                int dstCol = startEnd[i][1][1]-1;
                if (minDistToPassengers == bfs(row, currentRow, currentCol, fuel, dstRow, dstCol, map)) {

                };
//                int distToPassenger = bfs(row, currentRow, currentCol, fuel, dstRow, dstCol, map);
//                if (distToPassenger > fuel) {
//                    System.out.println(-1);
//                    return;
//                }
//                fuel -= distToPassenger;
//                queue.add(new int[]{dstRow, dstCol, fuel});
//                visited[dstRow][dstCol] = true;
            }
        }
        System.out.println(fuel);
    }

    private static int bfs(int row, int startRow, int startCol, int startFuel, int dstRow, int dstCol, int[][] map) {
        Queue<int[]> innerQueue = new LinkedList<>();
        int[][] dist = new int[row][row];
        boolean[][] innerVisited = new boolean[row][row];

        innerQueue.add(new int[]{startRow, startCol, startFuel});
        dist[startRow][startCol] = 0;
        innerVisited[startRow][startCol] = true;

        while (!innerQueue.isEmpty()) {
            int[] innerCurrent = innerQueue.poll();
            for (int i = 0; i < dr.length; i++) {
                int innerNr = innerCurrent[0] + dr[i];
                int innerNc = innerCurrent[1] + dc[i];
                if (innerNr > -1 && innerNr < row && innerNc > -1 && innerNc < row && !innerVisited[innerNr][innerNc] && map[innerNr][innerNc] == 0) {
                    innerVisited[innerNr][innerNc] = true;
                    innerQueue.add(new int[]{innerNr, innerNc});
                    dist[innerNr][innerNc] = dist[startRow][startCol] + 1;
                }
            }
        }
        return dist[dstRow][dstCol];
    }
}
