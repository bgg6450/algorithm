package practice.transformation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <P>1.시작점 설정 후 백업 - 안하면 데이터 유실</P>
 * <P>2.땡겨오기 방식으로 shift - shift 순서 유의</P>
 * <P>3.시작점 덮어쓰기</P>
 */
public class BoundaryShifting {

    static int R, C;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println("--- [Original] ---");
        printMap();

        rotateCounterClockwise(0, 0, R - 1, C - 1);
        System.out.println("\n--- [Shift Counter-Clockwise] ---");
        printMap();

        rotateClockwise(0, 0, R - 1, C - 1);
        System.out.println("\n--- [Shift Clockwise] ---");
        printMap();
    }

    private static void rotateCounterClockwise(int r1, int c1, int r2, int c2) {
        int temp = map[r2][c1];
        for (int i = r2; i > r1; i--) map[i][c1] = map[i - 1][c1]; // left
        for (int i = c1; i < c2; i++) map[r1][i] = map[r1][i + 1]; // up
        for (int i = r1; i < r2; i++) map[i][c2] = map[i + 1][c2]; // right
        for (int i = c2; i > c1; i--) map[r2][i] = map[r2][i - 1]; // down
        map[r2][c1 + 1] = temp;
    }

    private static void rotateClockwise(int r1, int c1, int r2, int c2) {
        int temp = map[r1][c1];
        for (int i = r1; i < r2; i++) map[i][c1] = map[i + 1][c1]; // left
        for (int i = c1; i < c2; i++) map[r2][i] = map[r2][i + 1]; // down
        for (int i = r2; i > r1; i--) map[i][c2] = map[i - 1][c2]; // right
        for (int i = c2; i > c1; i--) map[r1][i] = map[r1][i - 1]; // up
        map[r1][c1 + 1] = temp;
    }

    private static void printMap() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.printf("%2d ", map[i][j]);
            }
            System.out.println();
        }
    }
}
