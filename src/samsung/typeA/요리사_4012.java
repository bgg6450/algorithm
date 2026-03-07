package samsung.typeA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 요리사_4012 {

    static int N;
    static int n;
    static int[][] map;
    static boolean[] isSelected;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());

        for (int i = 0; i < N; i++) {
            answer = Integer.MAX_VALUE;
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st2.nextToken());
            map = new int[n][n];
            isSelected = new boolean[n];

            for (int j = 0; j < n; j++) {
                StringTokenizer st3 = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    map[j][k] = Integer.parseInt(st3.nextToken());
                }
            }
            combination(0, 0);
            System.out.println(String.format("#%d %d", i+1, answer));
        }
    }

    private static void combination(int start, int depth) {
        if (depth == n/2) {
            int result1 = 0;
            int result2 = 0;
            for (int j = 0; j < n; j++) {
                if (isSelected[j]) {
                    for (int k = 0; k < n; k++) {
                        if (isSelected[k]) {
                            result1 += map[j][k];
                        }
                    }
                } else {
                    for (int l = 0; l < n; l++) {
                        if (!isSelected[l]) {
                            result2 += map[j][l];
                        }
                    }
                }
            }
            answer = Math.min(Math.abs(result1 - result2), answer);
            return;
        }
        for (int i = start; i < n; i++) {
            isSelected[i] = true;
            combination(i + 1, depth + 1);
            isSelected[i] = false;
        }
    }
}
