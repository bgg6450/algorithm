package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 연산자끼워넣기_2 {

    static int N;
    static String[] numbers;
    static String[] codes;
    static String[] visited;
    static int maxResult = Integer.MIN_VALUE;
    static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = br.readLine().split(" ");
        codes = br.readLine().split(" ");
        visited = new String[N-1];
        permutation(0);
        System.out.println(maxResult);
        System.out.println(minResult);
    }

    public static void permutation(int depth) {
        if (depth == N-1) {
            int result = Integer.parseInt(numbers[0]);
            for (int j = 1; j < N; j++) {
                result = calc(result, Integer.parseInt(numbers[j]), Integer.parseInt(visited[j-1]));
            }
            maxResult = Math.max(maxResult, result);
            minResult = Math.min(minResult, result);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (Integer.parseInt(codes[i]) != 0) {
                visited[depth] = String.valueOf(i);
                codes[i] = String.valueOf(Integer.parseInt(codes[i]) - 1);
                permutation(depth + 1);
                codes[i] = String.valueOf(Integer.parseInt(codes[i]) + 1);
                visited[depth] = null;
            }
        }
    }

    public static int calc(int result, int number, int code) {
        if (code == 0) {
            return result + number;
        }
        if (code == 1) {
            return result - number;
        }
        if (code == 2) {
            return result * number;
        }
        if (code == 3) {
            if (result < 0 && number > 0) {
                return ((result * -1) / number) * -1;
            }
            return result / number;
        }
        return 0;
    }
}
