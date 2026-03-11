package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 뱀 {

    static int N, K, L;
    static int[][] map;
    static boolean isRight = true; // 오른쪽
    static int direction = 0; // 동쪽
    static int[] dR = {0, -1, 0, 1};
    static int[] dC = {1, 0, -1, 0};
    static int T = 0;
    static Map<Integer, Boolean> directions = new HashMap<>();
    static Deque<int[]> snake = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N][N];
        map[0][0] = 1;
        snake.addLast(new int[]{0, 0});

        sepApple(br);

        L = Integer.parseInt(br.readLine());

        addDirections(br);

        while (true) {
            setDirection();

            int[] head = snake.getLast();
            int[] tail = snake.getFirst();
            int nhR = head[0] + dR[direction];
            int nhC = head[1] + dC[direction];

            if (nhR >= N || nhR < 0 || nhC >= N || nhC < 0 || map[nhR][nhC] == 1) {
                break;
            }
            if (map[nhR][nhC] == 2) {
                snake.addLast(new int[]{nhR, nhC});
                map[nhR][nhC] = 1;
            } else if (map[nhR][nhC] == 0) {
                snake.addLast(new int[]{nhR, nhC});
                snake.removeFirst();
                map[nhR][nhC] = 1;
                map[tail[0]][tail[1]] = 0;
            }
            T++;
        }

        System.out.println(T+1);
    }

    private static void setDirection() {
        if (directions.get(T) != null) {
            isRight = directions.get(T);
            if (!isRight) {
                direction = (direction + 1) % 4;
            } else {
                direction = (direction + 3) % 4;
            }
        }
    }

    private static void addDirections(BufferedReader br) throws IOException {
        for (int i = 0; i < L; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken());
            String c = st2.nextToken();
            directions.put(x, c.equals("D"));
        }
    }

    private static void sepApple(BufferedReader br) throws IOException {
        for (int i = 0; i < K; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st1.nextToken()) - 1;
            int c = Integer.parseInt(st1.nextToken()) - 1;
            map[r][c] = 2;
        }
    }
}
